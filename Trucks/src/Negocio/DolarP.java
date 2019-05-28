/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Dolar;
import com.autobuses.persistencia.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lalon
 */
public class DolarP extends ConnectDB {
    
    public Dolar getDolar(){
        Connection cn = getConnection();
        Dolar d = new Dolar();
        
        try{
            String query="SELECT * FROM dolar WHERE id = 1";
            PreparedStatement pstm = cn.prepareStatement(query);
            
            
            
            ResultSet rs = pstm.executeQuery();
            rs.next();
            d.setId(rs.getInt("id"));
            d.setValue(rs.getDouble("value"));
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en Dolar: " +e.getMessage());
            
        }
        return d;
    }
    
    
    public void updateDolar(double NewVal, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE dolar SET value = ?, modified=? WHERE id=1";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setDouble(1, NewVal);
            pstm.setInt(2, idUser);
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Bus(updateBus): "+e.getMessage());
            
        }
        
    }
    
}
