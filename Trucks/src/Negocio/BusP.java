/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Bus;
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
public class BusP extends ConnectDB {
    
    
    //Used in frmBus
    public void addBus(Bus bus, int idUser){
        
        Connection cn = getConnection();
        
        try{
            String query="INSERT INTO bus SET enrollment = ?, details = ?, seating = ?, photo = ?, unidNum = ?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, bus.getEnrollment());
            pstm.setString(2, bus.getDetails());
            pstm.setInt(3, bus.getSeating());
            pstm.setString(4, bus.getPhoto());
            pstm.setString(5, bus.getUnidNum());
            pstm.setInt(6, idUser);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en BUS :" +e.getMessage());
            
        }
        
    }
    
    //Used in frmBusRUD
    
    
    public List<Bus> getAllBus(){
        Connection cn = getConnection();
        List<Bus> listB = new ArrayList<Bus>();
        String query = "SELECT * FROM bus";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Bus b = new Bus();
                b.setId(rs.getInt("id"));
                b.setDetails(rs.getString("details"));
                b.setEnrollment(rs.getString("enrollment"));
                b.setPhoto(rs.getString("photo"));
                b.setSeating(rs.getInt("seating"));
                b.setUnidNum(rs.getString("unidNum"));
                
                listB.add(b);
            }
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en Bus (getAll): "+e.getMessage());
        }
        
        return listB;
        
    }
    
    //Delete Bus
    public void deleteBus(int id){
        
        Connection cn = getConnection();
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM bus WHERE id=?;";
        
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
            System.out.println("Error en Bus (deleteBus)"+e.getMessage());
        }
        
    }
    
    /**
     * Update Bus
     * @param bus 
     */
    public void updateBus(Bus bus, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE bus SET details = ?, enrollment = ?, photo = ?, seating = ?, unidNum = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, bus.getDetails());
            pstm.setString(2, bus.getEnrollment());
            pstm.setString(3, bus.getPhoto());
            pstm.setInt(4, bus.getSeating());
            pstm.setString(5, bus.getUnidNum());
            pstm.setInt(6, idUser);
            pstm.setInt(7, bus.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Bus(updateBus): "+e.getMessage());
            
        }
        
    }
    
    
    public List<Bus> searchBus(String data){
        List<Bus> listB = new ArrayList<Bus>();
        Connection cn = getConnection();
        String queryU = "SELECT * FROM bus WHERE unidNum  LIKE ?";
        
        //Buscar con variable directa
        //String queryU = "SELECT * FROM bus WHERE unidNum  LIKE '%"+data+"%'";
        
        try{

              PreparedStatement pstm = cn.prepareCall(queryU);
              //Para buscar con variable directa se quita esta linea de abajo
              pstm.setString(1, "%"+data+"%");
              ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            Bus b = new Bus();
            b.setId(rs.getInt("id"));
                b.setDetails(rs.getString("details"));
                b.setEnrollment(rs.getString("enrollment"));
                b.setPhoto(rs.getString("photo"));
                b.setSeating(rs.getInt("seating"));
                b.setUnidNum(rs.getString("unidNum"));
                
                listB.add(b);
              
                }
              pstm.close();
        
            
        }catch(SQLException e){
            System.out.println("Error en bus (searchBus): "+e.getMessage());
        }
                
        
        return listB;

    }   
}
