/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.negocio;
 
import com.autobuses.persistencia.ConnectDB; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

/**
 *
 * @author lahl_
 */
public class CourtesyNegocio extends ConnectDB {    
    
   public static Boolean validarCodigoCortesia(String cortesia) throws SQLException, ClassNotFoundException {
      Boolean activo = false;
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT COUNT(*) as total FROM courtesy WHERE code = ? and available = 1");
         consulta.setString(1, cortesia);
         ResultSet resultado = consulta.executeQuery();
         if (resultado.next()){
            int result = resultado.getInt("total");
            if (result > 0)
                activo = true;
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return activo;
   }
    
}
