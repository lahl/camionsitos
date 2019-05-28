/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.negocio;

import com.autobuses.clases.User;
import com.autobuses.persistencia.ConnectDB; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lahl_
 */
public class UserNegocio extends ConnectDB {    
    
    public static User obtener(int id) throws SQLException, ClassNotFoundException {
      User user = null;
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM " + 
                    " user WHERE id = ?" );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            user = new User(
                    id, 
                    resultado.getString("phone"), 
                    resultado.getString("username"), 
                    resultado.getString("password"), 
                    resultado.getString("branch"), 
                    resultado.getString("level"), 
                    resultado.getString("name"), 
                    resultado.getBoolean("active")
            );
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return user;
   }
    
}
