/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Route;
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
public class RouteP extends ConnectDB{
    
    public void addRoute(Route r, int idUser){
        
        Connection cn = getConnection();
        
        try{
            String query="INSERT INTO rout SET origin = ?, destination = ?, price =?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, r.getOrigin());
            pstm.setString(2, r.getDestination());
            pstm.setDouble(3, r.getPrice());
            pstm.setInt(4, idUser);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en addRoute: " +e.getMessage());
            
        }
        
    }
        
    public List<Route> getAllRoutes(){
        Connection cn = getConnection();
        List<Route> listR = new ArrayList<>();
        String query = "SELECT * FROM rout";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Route r = new Route();
                r.setId(rs.getInt("id"));
                r.setOrigin(rs.getString("origin"));
                r.setDestination(rs.getString("destination"));
                r.setPrice(rs.getDouble("price"));
                listR.add(r);
            }
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en Route (getAll): "+e.getMessage());
        }
        
        return listR;
        
    }
    
    public void updateRoute(Route r, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE rout SET origin = ?, destination= ?, price = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, r.getOrigin());
            pstm.setString(2, r.getDestination());
            pstm.setDouble(3, r.getPrice());
            pstm.setInt(4, idUser);
            pstm.setInt(5, r.getId());
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
                System.out.println("Error en User(updateUser): "+e.getMessage());
            
        }
        
    }

    public List<Route> getRoute(String origin, String destination){
        Connection cn = getConnection();
        List<Route> listR = new ArrayList<Route>();
        String condiciones = "";
        if (!Funciones.isNullOrEmpty(origin)){
            condiciones = " WHERE origin like ? ";
        }
        if (!Funciones.isNullOrEmpty(destination)){
            if (Funciones.isNullOrEmpty(condiciones)){
                condiciones = " WHERE destination like ? ";
            } else {
                condiciones = condiciones + " AND destination like ? ";
            }
        }
        String query = "SELECT * FROM rout " + condiciones;
        try{
            
            PreparedStatement pstm = cn.prepareCall(query);
              //Para buscar con variable directa se quita esta linea de abajo
              if (!Funciones.isNullOrEmpty(origin)){
                 pstm.setString(1, "%" + origin + "%");
              }
              if (!Funciones.isNullOrEmpty(destination)){
                  pstm.setString(2, "%" + destination + "%");
              }              
              ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Route r = new Route();
                r.setId(rs.getInt("id"));
                r.setOrigin(rs.getString("origin"));
                r.setDestination(rs.getString("destination"));
                r.setPrice(rs.getDouble("price"));
                listR.add(r);
            }
            rs.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en Rout (getRout): "+e.getMessage());
        }
        
        return listR;
        
    }
    
    public void delete(int id){
        
        Connection cn = getConnection();
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM rout WHERE id=?";        
        try{
            //set session id
            Statement stm = cn.prepareStatement(query);
            stm.execute(query_id);
            stm.close();
            //delete row
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, id);            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Driver (deleteDriver)"+e.getMessage());
        }
        
    }
}
