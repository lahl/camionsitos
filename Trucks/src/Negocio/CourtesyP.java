/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Courtesy;
import com.autobuses.clases.utils.Sesion;
import com.autobuses.persistencia.ConnectDB;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author lalon
 */
public class CourtesyP extends ConnectDB {

    
    public List<Courtesy> getAll(){
        
        List<Courtesy> ListC = new ArrayList<Courtesy>();
        Connection cn = getConnection();
        String query = "SELECT * FROM courtesy";
        try{
            
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Courtesy c = new Courtesy();
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("code"));
                c.setAvlb(rs.getBoolean("available"));
                ListC.add(c);
            }
            st.close();
        
        
        }catch(Exception e){
            System.out.println("Error en getAll: "+e.getMessage());
            
        }
        
        return ListC;
    }
    
    public void delCourtesy(Courtesy cour){
        
        Connection cn = getConnection();
        try{
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM courtesy WHERE id = ?";
        //set session id
        Statement stm = cn.prepareStatement(query);
        stm.execute(query_id);
        stm.close();
        //delete row
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setInt(1, cour.getId());
        
        preparedStmt.executeUpdate();        
        
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
            
    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ups, ocurrio un error, selecciona el elemento que quieres borrar, (Solo uno)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void genCourtesy(Courtesy c, int idUser){
        
        Connection cn = getConnection();
        try{
        String query = "INSERT INTO courtesy SET code = ?, available = ?, modified=?";
        
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setString(1, c.getCode());
        preparedStmt.setBoolean(2, c.isAvlb());
        preparedStmt.setInt(3, idUser);
        preparedStmt.executeUpdate();        
        
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
            
    
        }
    }
          
    public String genCode() {
     String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
}
}
