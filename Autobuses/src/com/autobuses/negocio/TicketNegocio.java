/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.negocio;
 
import com.autobuses.clases.Discount;
import com.autobuses.clases.Ticket;
import com.autobuses.clases.Trip;
import com.autobuses.clases.User;
import com.autobuses.clases.utils.Funciones;
import com.autobuses.enumeradores.EstadoBoleto;
import com.autobuses.enumeradores.LugarCompra;
import com.autobuses.enumeradores.Sexo;
import com.autobuses.persistencia.ConnectDB; 
import static com.autobuses.persistencia.ConnectDB.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author lahl_
 */
public class TicketNegocio extends ConnectDB {    
    
    public static Ticket obtener(int id) throws SQLException, ClassNotFoundException {
      Ticket ticket = null;
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM " + 
                    " tickets WHERE id = ?" );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            ticket = new Ticket(
                    id,
                    resultado.getInt("idTrip"),
                    resultado.getInt("idUser"),
                    resultado.getInt("idDiscount"),
                    resultado.getString("codigoCortesia"),
                    resultado.getString("descuentoNom"),
                    resultado.getString("folio"),
                    resultado.getString("nombre"),
                    resultado.getString("telefono"),
                    resultado.getInt("genero"), 
                    resultado.getDouble("subtotal"), 
                    resultado.getDouble("total"), 
                    resultado.getInt("asiento"), 
                    resultado.getDate("fechaCompra"), 
                    resultado.getInt("lugarCompra"),
                    resultado.getInt("estado"),
                    resultado.getDate("fechaPago")
            );
            if (ticket.getTrip().getId() > 0)
                ticket.setTrip(TripNegocio.obtener(ticket.getTrip().getId()));
            if (ticket.getUser().getId() > 0)
                ticket.setUser(UserNegocio.obtener(ticket.getUser().getId()));
            if (ticket.getDiscount().getId() > 0)
                ticket.setDiscount(DiscountNegocio.obtener(ticket.getDiscount().getId()));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return ticket;
   }
    
    public static List<Ticket> obtener_asientos(int idTrip) throws SQLException, ClassNotFoundException {
      List<Ticket> tickets = new ArrayList<Ticket>();
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM " + 
                    " tickets WHERE idTrip = ? AND estado IN (1,3)" ); //estado { 1 vendido, 3 reservado }
         consulta.setInt(1, idTrip);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            Ticket ticket = new Ticket(
                    idTrip,
                    resultado.getInt("idTrip"),
                    resultado.getInt("idUser"),
                    resultado.getInt("idDiscount"),
                    resultado.getString("codigoCortesia"),
                    resultado.getString("descuentoNom"),
                    resultado.getString("folio"),
                    resultado.getString("nombre"),
                    resultado.getString("telefono"),
                    resultado.getInt("genero"), 
                    resultado.getDouble("subtotal"), 
                    resultado.getDouble("total"), 
                    resultado.getInt("asiento"), 
                    resultado.getDate("fechaCompra"), 
                    resultado.getInt("lugarCompra"),
                    resultado.getInt("estado"),
                    resultado.getDate("fechaPago")
            );
            if (ticket.getTrip().getId() > 0)
                ticket.setTrip(TripNegocio.obtener(ticket.getTrip().getId()));
            if (ticket.getUser().getId() > 0)
                ticket.setUser(UserNegocio.obtener(ticket.getUser().getId()));
            if (ticket.getDiscount().getId() > 0)
                ticket.setDiscount(DiscountNegocio.obtener(ticket.getDiscount().getId()));
            //AGREGAR BOLETO A LA LISTA
            tickets.add(ticket);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return tickets;
   }
    
    public static String obtenerFolioSiguiente() throws SQLException, ClassNotFoundException {
      int folio = 0;
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT folio FROM tickets ORDER BY id DESC LIMIT 1"); 
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            String strFolio = resultado.getString("folio");
            folio = strFolio.equals("") ? 1 : Integer.parseInt(strFolio) + 1;
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return folio + "";
   }
    
    public static boolean pagar(int idTrip, int idUser, int idDiscount, String codigoCortesia, String nombre, 
            String telefono, Sexo genero, double subtotal, double total, int asiento, LugarCompra lugar, 
            EstadoBoleto estado, double totalPagado, double cambio, double total_original) throws SQLException{
        boolean result = false;
        List<String> campos = new ArrayList();
        List<String> valores = new ArrayList();
        try{
            if (idTrip > 0){
                campos.add("idTrip");
                valores.add(idTrip + "");
            }
            if (idUser > 0){
                campos.add("idUser");
                valores.add(idUser + "");
            }
            if (idDiscount > 0){
                campos.add("idDiscount");
                valores.add(idDiscount + "");
            }
            if (!Funciones.isNullOrEmpty(codigoCortesia)){
                campos.add("codigoCortesia");
                valores.add("'" + codigoCortesia + "'");
            }            
            campos.add("folio");
            valores.add("'" + obtenerFolioSiguiente() + "'");
            if (!Funciones.isNullOrEmpty(nombre)){
                campos.add("nombre");
                valores.add("'" + nombre + "'");
            }
            if (!Funciones.isNullOrEmpty(telefono)){
                campos.add("telefono");
                valores.add("'" + telefono + "'");
            }
            campos.add("genero");
            valores.add(genero.getValor() + "");
            campos.add("subtotal");
            valores.add(subtotal + "");            
            campos.add("total");
            valores.add(total + "");             
            campos.add("totalPagado");
            valores.add(totalPagado + ""); 
            campos.add("totalCambio");
            valores.add(cambio + ""); 
            campos.add("totalOriginal");
            valores.add(total_original + "");             
            campos.add("asiento");
            valores.add(asiento + ""); 
            if (estado == EstadoBoleto.VENDIDO || estado == EstadoBoleto.RESERVADO || estado == EstadoBoleto.CORTESIA){
                DateFormat df_fecha_compra = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dt_fecha_compra = new Date();
                String fechaCompra = df_fecha_compra.format(dt_fecha_compra);
                campos.add("fechaCompra");
                valores.add("'" + fechaCompra + "'");
            }
            campos.add("lugarCompra");
            valores.add(lugar.getValor() + "");
            campos.add("estado");
            valores.add(estado.getValor() + "");
            if (estado == EstadoBoleto.VENDIDO || estado == EstadoBoleto.CORTESIA){
                DateFormat df_fecha_pago = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dt_fecha_pago = new Date();
                String fechaPago = df_fecha_pago.format(dt_fecha_pago);
                campos.add("fechaPago");
                valores.add("'" + fechaPago + "'");
            }
            result = guardar(campos, valores, "tickets");
        } catch(Exception ex){
            throw new SQLException(ex);   
        }
        return result;
    }
    
    public static Boolean validarBoleto(int idTrip, int asiento) throws SQLException{
        Boolean ocupado = false;
        Connection connection = null;
        try{
           connection = getConnection();
           PreparedStatement consulta = connection.prepareStatement("SELECT id as id FROM tickets WHERE idTrip = ? " + 
                   "AND asiento = ? AND estado <> 2" );
           consulta.setInt(1, idTrip);
           consulta.setInt(2, asiento);
           ResultSet resultado = consulta.executeQuery();
           if (resultado.next()){
                int result = resultado.getInt("id");
                if (result > 0)
                    ocupado = true;
           }
        }catch(SQLException ex){
           throw new SQLException(ex);
        } 
        return ocupado;
    }
    
}
