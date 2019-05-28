/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.negocio;

import com.autobuses.clases.Route;
import com.autobuses.clases.Trip; 
import com.autobuses.clases.utils.Funciones;
import com.autobuses.persistencia.ConnectDB; 
import java.awt.Cursor;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lahl_
 */
public class TripNegocio extends ConnectDB {
    
    public static List<Trip> obtenerTodos() throws SQLException, ClassNotFoundException {
      List<Trip> viajes = new ArrayList<>();
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM trip" );
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            Trip viaje = new Trip(
                    resultado.getInt("id"),
                    resultado.getInt("idDriver"), 
                    resultado.getInt("idBus"), 
                    resultado.getInt("idRout"), 
                    resultado.getDate("dateDeparture"), 
                    resultado.getDate("dateArrival"), 
                    resultado.getTime("hourDeparture"),
                    resultado.getTime("hourArrival")
            );
            //DATOS DE LA TABLA DRIVER
            PreparedStatement query_driver = connection.prepareStatement("SELECT * FROM driver WHERE id = ?" );
            query_driver.setInt(1, viaje.getDriver().getId());
            ResultSet res_driver = query_driver.executeQuery();
            while(res_driver.next()){
                viaje.getDriver().setName(res_driver.getString("name"));
                viaje.getDriver().setCel(res_driver.getString("cel"));
                viaje.getDriver().setLicense(res_driver.getString("license"));
                viaje.getDriver().setBirthDate(res_driver.getDate("birthDate"));
                viaje.getDriver().setApSart(res_driver.getDate("apStart"));
                viaje.getDriver().setApEnd(res_driver.getDate("apEnd"));
                viaje.getDriver().setEmail(res_driver.getString("email"));
                viaje.getDriver().setContractDateStart(res_driver.getDate("contractDateStart"));
                viaje.getDriver().setContractDateEnd(res_driver.getDate("contractDateEnd"));
                viaje.getDriver().setAddres(res_driver.getString("addres"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_bus = connection.prepareStatement("SELECT * FROM bus WHERE id = ?" );
            query_bus.setInt(1, viaje.getBus().getId());
            ResultSet res_bus = query_bus.executeQuery();
            while(res_bus.next()){
                viaje.getBus().setEnrollment(res_bus.getString("enrollment"));
                viaje.getBus().setDetails(res_bus.getString("details"));
                viaje.getBus().setSeating(res_bus.getInt("seating"));
                viaje.getBus().setPhoto(res_bus.getString("photo"));
                viaje.getBus().setUnidNum(res_bus.getString("unidNum"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_route = connection.prepareStatement("SELECT * FROM rout WHERE id = ?" );
            query_route.setInt(1, viaje.getRoute().getId());
            ResultSet res_route = query_route.executeQuery();
            while(res_route.next()){
                viaje.getRoute().setOrigin(res_route.getString("origin"));
                viaje.getRoute().setDestination(res_route.getString("destination"));
                viaje.getRoute().setPrice(res_route.getDouble("price")); 
            }
            viajes.add(viaje);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return viajes;
   }
    //rutas 
    public static List<Route> obtenerTodosCombo() throws SQLException, ClassNotFoundException {
      List<Route> rutas = new ArrayList<>();
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM rout" );
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            Route r = new Route();
            r.setId(resultado.getInt("id"));
            r.setOrigin(resultado.getString("origin"));
            r.setDestination(resultado.getString("destination"));
            r.setPrice(resultado.getDouble("price"));    
            rutas.add(r);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return rutas;
   }
    
    public static Trip obtener(int id) throws SQLException, ClassNotFoundException {
      Trip viaje = null;
      Connection connection = null;
      try{
         connection = getConnection(); 
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM trip WHERE id = ? " );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            viaje = new Trip(
                    resultado.getInt("id"),
                    resultado.getInt("idDriver"), 
                    resultado.getInt("idBus"), 
                    resultado.getInt("idRout"), 
                    resultado.getDate("dateDeparture"), 
                    resultado.getDate("dateArrival"), 
                    resultado.getTime("hourDeparture"),
                    resultado.getTime("hourArrival")
            ); 
            //DATOS DE LA TABLA DRIVER
            PreparedStatement query_driver = connection.prepareStatement("SELECT * FROM driver WHERE id = ?" );
            query_driver.setInt(1, viaje.getDriver().getId());
            ResultSet res_driver = query_driver.executeQuery();
            while(res_driver.next()){
                viaje.getDriver().setName(res_driver.getString("name"));
                viaje.getDriver().setCel(res_driver.getString("cel"));
                viaje.getDriver().setLicense(res_driver.getString("license"));
                viaje.getDriver().setBirthDate(res_driver.getDate("birthDate"));
                viaje.getDriver().setApSart(res_driver.getDate("apStart"));
                viaje.getDriver().setApEnd(res_driver.getDate("apEnd"));
                viaje.getDriver().setEmail(res_driver.getString("email"));
                viaje.getDriver().setContractDateStart(res_driver.getDate("contractDateStart"));
                viaje.getDriver().setContractDateEnd(res_driver.getDate("contractDateEnd"));
                viaje.getDriver().setAddres(res_driver.getString("addres"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_bus = connection.prepareStatement("SELECT * FROM bus WHERE id = ?" );
            query_bus.setInt(1, viaje.getBus().getId());
            ResultSet res_bus = query_bus.executeQuery();
            while(res_bus.next()){
                viaje.getBus().setEnrollment(res_bus.getString("enrollment"));
                viaje.getBus().setDetails(res_bus.getString("details"));
                viaje.getBus().setSeating(res_bus.getInt("seating"));
                viaje.getBus().setPhoto(res_bus.getString("photo"));
                viaje.getBus().setUnidNum(res_bus.getString("unidNum"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_route = connection.prepareStatement("SELECT * FROM rout WHERE id = ?" );
            query_route.setInt(1, viaje.getRoute().getId());
            ResultSet res_route = query_route.executeQuery();
            while(res_route.next()){
                viaje.getRoute().setOrigin(res_route.getString("origin"));
                viaje.getRoute().setDestination(res_route.getString("destination"));
                viaje.getRoute().setPrice(res_route.getDouble("price")); 
            }
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return viaje;
   }
    
    public static Trip buscar(int idRout, String dateDeparture, String hourDeparture) throws SQLException, ClassNotFoundException {
      Trip viaje = null;
      Connection connection = null;
      try{
         connection = getConnection(); 
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM trip WHERE idRout = ? AND dateDeparture = ? AND hourDeparture = ? " );
         consulta.setInt(1, idRout);
         consulta.setString(2, dateDeparture);
         consulta.setString(3, hourDeparture);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            viaje = new Trip(
                    resultado.getInt("id"),
                    resultado.getInt("idDriver"), 
                    resultado.getInt("idBus"), 
                    resultado.getInt("idRout"), 
                    resultado.getDate("dateDeparture"), 
                    resultado.getDate("dateArrival"), 
                    resultado.getTime("hourDeparture"),
                    resultado.getTime("hourArrival")
            ); 
            //DATOS DE LA TABLA DRIVER
            PreparedStatement query_driver = connection.prepareStatement("SELECT * FROM driver WHERE id = ?" );
            query_driver.setInt(1, viaje.getDriver().getId());
            ResultSet res_driver = query_driver.executeQuery();
            while(res_driver.next()){
                viaje.getDriver().setName(res_driver.getString("name"));
                viaje.getDriver().setCel(res_driver.getString("cel"));
                viaje.getDriver().setLicense(res_driver.getString("license"));
                viaje.getDriver().setBirthDate(res_driver.getDate("birthDate"));
                viaje.getDriver().setApSart(res_driver.getDate("apStart"));
                viaje.getDriver().setApEnd(res_driver.getDate("apEnd"));
                viaje.getDriver().setEmail(res_driver.getString("email"));
                viaje.getDriver().setContractDateStart(res_driver.getDate("contractDateStart"));
                viaje.getDriver().setContractDateEnd(res_driver.getDate("contractDateEnd"));
                viaje.getDriver().setAddres(res_driver.getString("addres"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_bus = connection.prepareStatement("SELECT * FROM bus WHERE id = ?" );
            query_bus.setInt(1, viaje.getBus().getId());
            ResultSet res_bus = query_bus.executeQuery();
            while(res_bus.next()){
                viaje.getBus().setEnrollment(res_bus.getString("enrollment"));
                viaje.getBus().setDetails(res_bus.getString("details"));
                viaje.getBus().setSeating(res_bus.getInt("seating"));
                viaje.getBus().setPhoto(res_bus.getString("photo"));
                viaje.getBus().setUnidNum(res_bus.getString("unidNum"));
            }
            //DATOS DE LA TABLA BUS
            PreparedStatement query_route = connection.prepareStatement("SELECT * FROM rout WHERE id = ?" );
            query_route.setInt(1, viaje.getRoute().getId());
            ResultSet res_route = query_route.executeQuery();
            while(res_route.next()){
                viaje.getRoute().setOrigin(res_route.getString("origin"));
                viaje.getRoute().setDestination(res_route.getString("destination"));
                viaje.getRoute().setPrice(res_route.getDouble("price")); 
            }
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return viaje;
   }
    
    public static Trip buscarCompra(int idRout, String dateDeparture, String hourDeparture) throws SQLException, ClassNotFoundException {
      Trip viaje = null;      
      Connection connection = null;
      try{ 
         connection = getConnection(); 
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM trip WHERE idRout = ? AND dateDeparture = ? AND hourDeparture = ? " );
         consulta.setInt(1, idRout);
         consulta.setString(2, dateDeparture);
         consulta.setString(3, hourDeparture);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            viaje = new Trip(
                    resultado.getInt("id"),
                    resultado.getInt("idDriver"), 
                    resultado.getInt("idBus"), 
                    resultado.getInt("idRout"), 
                    resultado.getDate("dateDeparture"), 
                    resultado.getDate("dateArrival"), 
                    resultado.getTime("hourDeparture"),
                    resultado.getTime("hourArrival")
            ); 
         }
         consulta.close();
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return viaje;
   }
    
    public static double obtenerPrecio(int id) throws SQLException{        
        double precio = 0;
        Connection connection = null;
        try{
           connection = getConnection(); 
           PreparedStatement consulta = connection.prepareStatement("SELECT r.price as precio FROM trip as t RIGHT JOIN rout as r on t.idRout = r.id where t.id = ?" );
           consulta.setInt(1, id);
           ResultSet resultado = consulta.executeQuery();
           while(resultado.next()){
              precio = resultado.getDouble("precio");              
           }
        }catch(SQLException ex){
           throw new SQLException(ex);
        } 
        return precio;
    }
    
    public static boolean validarExistencia(int id_conductor, int id_camion, int id_ruta, String dt_salida,
            String hr_salida, String dt_llegada, String hr_llegada) throws SQLException{        
        boolean existe = false;
        Connection connection = null;
        try{
           connection = getConnection(); 
           PreparedStatement consulta = connection.prepareStatement(
                "SELECT id as id FROM trip where " + 
                "idDriver = ? AND " +
                "idBus = ? AND " +
                "idRout = ? AND " +
                "dateDeparture = ? AND " +
                "hourDeparture = ? AND " +
                "dateArrival = ? AND " +
                "hourArrival = ? " 
           );
           consulta.setInt(1, id_conductor);
           consulta.setInt(2, id_camion);
           consulta.setInt(3, id_ruta);
           consulta.setString(4, dt_salida);
           consulta.setString(5, hr_salida);
           consulta.setString(6, dt_llegada);
           consulta.setString(7, hr_llegada);
           ResultSet resultado = consulta.executeQuery();
           if (resultado.next()){
              int id = resultado.getInt("id");
              if (id > 0)
                  existe = true;
           }
        }catch(SQLException ex){
           throw new SQLException(ex);
        } 
        return existe;
    }
    
    public static boolean guardarViaje(int id_viaje, int id_conductor, int id_camion, int id_ruta, String dt_salida,
            String hr_salida, String dt_llegada, String hr_llegada) throws SQLException{        
        boolean result = false;        
        List<String> campos = new ArrayList();
        List<String> valores = new ArrayList();
        //clausulas where
        List<String> campos_condiciones = new ArrayList();
        List<String> valores_condiciones = new ArrayList();
        try{  
            if (id_viaje > 0){
                campos_condiciones.add("id");
                valores_condiciones.add(id_viaje + "");
            }                
            campos.add("idDriver");
            valores.add(id_conductor + "");            
            campos.add("idBus");
            valores.add(id_camion + "");            
            campos.add("idRout");
            valores.add(id_ruta + "");            
            campos.add("dateDeparture");
            valores.add("'" + dt_salida + "'");            
            campos.add("dateArrival");
            valores.add("'" + dt_llegada + "'");            
            campos.add("hourDeparture");
            valores.add("'" + hr_salida + "'");            
            campos.add("hourArrival");
            valores.add("'" + hr_llegada + "'");   
            if (id_viaje <= 0)
                result = guardar(campos, valores, "trip");
            else 
                result = actualizar(campos, valores, campos_condiciones, valores_condiciones, "trip");
        } catch(Exception ex){
            throw new SQLException(ex);   
        }
        return result;
    }
    
    public static List<TripTransporte> obtenerTodosTransporte(int idRuta, String fechaSalida, String horaSalida) throws SQLException, ClassNotFoundException {
      List<TripTransporte> viajes = new ArrayList<>();
      Connection connection = null;
      try{
         String str_condiciones = ""; 
         if (idRuta > 0){
             if (Funciones.isNullOrEmpty(str_condiciones)){
                 str_condiciones = str_condiciones + " WHERE ";
             } else {
                 str_condiciones = str_condiciones + " AND ";
             }
             str_condiciones = str_condiciones + " r.id = " + idRuta;
         } 
         if (!Funciones.isNullOrEmpty(fechaSalida)){
             if (Funciones.isNullOrEmpty(str_condiciones)){
                 str_condiciones = str_condiciones + " WHERE ";
             } else {
                 str_condiciones = str_condiciones + " AND ";
             }
             str_condiciones = str_condiciones + " t.dateDeparture = '" + fechaSalida + "'";
         } 
         if (!Funciones.isNullOrEmpty(horaSalida)){             
             if (Funciones.isNullOrEmpty(str_condiciones)){
                 str_condiciones = str_condiciones + " WHERE ";
             } else {
                 str_condiciones = str_condiciones + " AND ";
             }
             str_condiciones = str_condiciones + " t.hourDeparture = '" + horaSalida + "'";
         }         
         String str_query = "SELECT " +
            " t.id AS id, " +
            " concat_ws(' ', t.dateDeparture, t.hourDeparture) AS salida, " +
            " concat_ws(' ', t.dateArrival, t.hourArrival) AS llegada, " +
            " r.origin AS origen, " +
            " r.destination AS destino, " +
            " r.price AS precio,\n" +
            " b.seating AS asientos, " +
            " (SELECT COUNT(ti.id) FROM tickets AS ti WHERE ti.idTrip = t.id AND ti.estado <> 2) AS asientosOcupados, " +
            " d.name as conductor, " +
            " b.unidNum as camion " +
            " FROM trip AS t " +
            " INNER JOIN bus AS b ON t.idBus = b.id " +
            " INNER JOIN driver AS d ON t.idDriver = d.id " +
            " INNER JOIN rout AS r ON t.idRout = r.id " +
            str_condiciones;
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement(str_query);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            //DATOS DE LA TABLA VIAJE
            TripTransporte viaje = new TripTransporte(); 
            viaje.setId(resultado.getInt("id"));
            viaje.setSalida(resultado.getString("salida"));
            viaje.setLlegada(resultado.getString("llegada"));
            viaje.setOrigen(resultado.getString("origen"));
            viaje.setDestino(resultado.getString("destino"));
            viaje.setPrecio(resultado.getDouble("precio"));
            viaje.setAsientos(resultado.getInt("asientos"));
            viaje.setAsientosOcupados(resultado.getInt("asientosOcupados"));
            viaje.setAsientosDisponibles(viaje.getAsientos() - viaje.getAsientosOcupados());
            viaje.setConductor(resultado.getString("conductor"));
            viaje.setCamion(resultado.getString("camion"));
            viajes.add(viaje);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return viajes;
   }
    
    public static void delete(int id){
        
        Connection cn = getConnection();
        String query = "DELETE FROM trip WHERE id=?";
        
        try{
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, id);
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Driver (deleteDriver)"+e.getMessage());
        }
        
    }
}
