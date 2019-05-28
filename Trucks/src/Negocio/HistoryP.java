/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Bus;
import Clases.History;
import Clases.TicketTransport;
import com.autobuses.clases.utils.Funciones;
import com.autobuses.clases.utils.Sesion;
import com.autobuses.persistencia.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lalon
 */
public class HistoryP extends ConnectDB {
    
    public List<History> searchHistory(String inicio, String fin, String tabla, String accion, int idBranch){
        List<History> list = new ArrayList<History>();
        Connection cn = getConnection();
        String str_where = "";
        String str_params = "";
        String queryU = "SELECT h.fecha as fecha, h.tabla as tabla, h.accion as accion, u.name as autor, bo.nombre as sucursal " + 
                        " FROM history as h ";
        String inner_user = " INNER JOIN user as u ON h.idUser = u.id " + 
                         " INNER JOIN branch_offices as bo ON u.branch = bo.id ";
        if (!Funciones.isNullOrEmpty(inicio) || !Funciones.isNullOrEmpty(fin) || !Funciones.isNullOrEmpty(tabla) ||
                !Funciones.isNullOrEmpty(accion) || idBranch > 0)
            str_where = " WHERE ";
        if (!Funciones.isNullOrEmpty(inicio) && !Funciones.isNullOrEmpty(fin))
            str_params += " h.fecha BETWEEN ? AND ? ";        
        if (!Funciones.isNullOrEmpty(tabla)){
            if (!Funciones.isNullOrEmpty(str_params))
                str_params += " AND ";
            str_params += " h.tabla = ? ";   
        }
        if (!Funciones.isNullOrEmpty(accion)){
            if (!Funciones.isNullOrEmpty(str_params))
                str_params += " AND ";
            str_params += " h.accion = ? ";
        }
        if (idBranch > 0){
            if (!Funciones.isNullOrEmpty(str_params))
                str_params += " AND ";        
            str_params += " bo.id = ? ";
        }
        queryU += inner_user + str_where + str_params;
        try{
            int idx = 1;
            PreparedStatement pstm = cn.prepareCall(queryU);
            if (!Funciones.isNullOrEmpty(inicio) && !Funciones.isNullOrEmpty(fin)){
                pstm.setString(idx, inicio);
                idx++;
                pstm.setString(idx, fin);
                idx++;
            }
            if (!Funciones.isNullOrEmpty(tabla)){
                pstm.setString(idx, tabla);
                idx++;
            }
            if (!Funciones.isNullOrEmpty(accion)){
                pstm.setString(idx, accion);
                idx++;
            }
            if (idBranch > 0){
                pstm.setInt(idx, idBranch);
                idx++;
            }
            ResultSet rs = pstm.executeQuery();        
            while(rs.next()){
                History b = new History();            
                b.setFecha(rs.getString("fecha"));
                b.setTabla(rs.getString("tabla"));
                b.setAccion(rs.getString("accion"));
                b.setAutor(rs.getString("autor"));   
                b.setSucursal(rs.getString("sucursal"));   
                list.add(b);
            }
            pstm.close();        
            
        }catch(SQLException e){
            System.out.println("Error en bus (searchBus): "+e.getMessage());
        }
                
        
        return list;

    }   
    
    public List<TicketTransport> searchRegistry(String inicio, String fin, int idBranch){
        List<TicketTransport> list = new ArrayList<TicketTransport>();
        Connection cn = getConnection();
        String str_where = "";
        String str_params = "";
        String queryU = 
                "SELECT ti.id AS id, ti.folio AS idViaje, u.name AS vendedor, ti.nombre AS nombreBoleto, " + 
                "ti.total AS precio, ti.fechaCompra AS fechaCompra, bo.nombre AS sucursalVenta, ti.estado AS estado  " + 
                " FROM tickets as ti ";
        String inner_user = " INNER JOIN `user` AS u ON ti.idUser = u.id " + 
                        " INNER JOIN `branch_offices` AS bo ON u.branch = bo.id " +
                        " WHERE estado IN (1,3) ";
        //if (!Funciones.isNullOrEmpty(inicio) || !Funciones.isNullOrEmpty(fin) || idBranch > 0)
        //    str_where = " WHERE ";
        if (!Funciones.isNullOrEmpty(inicio) && !Funciones.isNullOrEmpty(fin))
            str_params += " AND ti.fechaCompra BETWEEN ? AND ? ";         
        if (idBranch > 0){
            //if (!Funciones.isNullOrEmpty(str_params))
            //    str_params += " AND ";        
            str_params += " AND bo.id = ? ";
        }
        queryU += inner_user + str_where + str_params;
        try{
            int idx = 1;
            PreparedStatement pstm = cn.prepareCall(queryU);
            if (!Funciones.isNullOrEmpty(inicio) && !Funciones.isNullOrEmpty(fin)){
                pstm.setString(idx, inicio);
                idx++;
                pstm.setString(idx, fin);
                idx++;
            } 
            if (idBranch > 0){
                pstm.setInt(idx, idBranch);
                idx++;
            }
            ResultSet rs = pstm.executeQuery();        
            while(rs.next()){
                TicketTransport b = new TicketTransport();            
                b.setId(rs.getInt("id"));
                b.setIdViaje(rs.getString("idViaje"));
                b.setVendedor(rs.getString("vendedor"));
                b.setNombreBoleto(rs.getString("nombreBoleto"));
                b.setPrecio(rs.getDouble("precio"));
                b.setFechaCompra(rs.getString("fechaCompra"));   
                b.setSucursalVenta(rs.getString("sucursalVenta"));   
                list.add(b);
            }
            pstm.close();        
            
        }catch(SQLException e){
            System.out.println("Error en bus (searchBus): "+e.getMessage());
        }
        return list;

    }   
    
}
