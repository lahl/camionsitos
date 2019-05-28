/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Discount;
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
public class DiscountP extends ConnectDB {
    
    public void addDisc(Discount dis, int idUser){
        
        Connection cn = getConnection();
        
        try{
            String query="INSERT INTO discount SET name = ?, porcentage = ?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, dis.getName());
            pstm.setDouble(2, dis.getPorcentage());
            pstm.setInt(3, idUser);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en Discount: " +e.getMessage());
            
        }
        
    }
    

    public List<Discount> getAllDiscount(){
        Connection cn = getConnection();
        List<Discount> listB = new ArrayList<Discount>();
        String query = "SELECT * FROM discount";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Discount b = new Discount();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setPorcentage(rs.getDouble("porcentage"));

                listB.add(b);
            }
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en Discount (getAll): "+e.getMessage());
        }
        
        return listB;
        
    }
    
    //Delete Bus
    public void delDiscount(int id){
        
        Connection cn = getConnection();
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM discount WHERE id=?";        
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
            System.out.println("Error en Discount (delDiscount)"+e.getMessage());
        }
        
    }
    
    /**
     * Update Bus
     * @param bus 
     */
    public void updateDiscount(Discount dis, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE discount SET name = ?, porcentage = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, dis.getName());
            pstm.setDouble(2, dis.getPorcentage());
            pstm.setInt(3, idUser);
            pstm.setInt(4, dis.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
                System.out.println("Error en Discount(updateDiscount): "+e.getMessage());
            
        }
        
    }    
    
    
}
