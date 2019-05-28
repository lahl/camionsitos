/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.negocio;

import com.autobuses.clases.Discount; 
import com.autobuses.persistencia.ConnectDB; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lahl_
 */
public class DiscountNegocio extends ConnectDB {    
    
    public static List<Discount> obtenerTodos() throws SQLException, ClassNotFoundException {
      Connection connection = null;
      List<Discount> lista = new ArrayList();
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM discount " );
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            Discount discount = new Discount(
                    resultado.getInt("id"), 
                    resultado.getString("name"), 
                    resultado.getDouble("porcentage")
            );
            lista.add(discount);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return lista;
   }    
   public static Discount obtener(int id) throws SQLException, ClassNotFoundException {
      Discount discount = null;
      Connection connection = null;
      try{
         connection = getConnection();
         PreparedStatement consulta = connection.prepareStatement("SELECT * FROM " + 
                    " user WHERE id = ?" );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            discount = new Discount(
                    id, 
                    resultado.getString("name"), 
                    resultado.getDouble("porcentage")
            );
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } 
      return discount;
   }
    
}
