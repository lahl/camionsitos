/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.persistencia;
   
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lahl_
 */
public class ConnectDB {
    private static String db = "trucksmate"; //dbtest2
    private static String user = "root";
    private static String pass = "";
    private static String url = "jdbc:mysql://localhost:3306/" + db;
    private static java.sql.Connection conn = null;
    private String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public ConnectDB(){}
    
    public static java.sql.Connection getConnection(){
        //ConnectDB.url = "jdbc:mysql://localhost/" + ConnectDB.db+timeZone;
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(ConnectDB.url,ConnectDB.user,ConnectDB.pass);
            if (conn != null) {
                System.out.println("OK base de datos " + ConnectDB.db + " listo");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return ConnectDB.conn;
    }
        
    public static boolean guardar(List<String> campos, List<String> valores, String table) throws Exception{
        boolean result = false;
        try {
            String str_campos = String.join(", ", campos);
            String str_valores = String.join(", ", valores);
            String query = "INSERT INTO " + table + " (" + str_campos + ") VALUES (" + str_valores + ")";
            //ejecutar la query
            Connection connection = null;        
            connection = getConnection();
            PreparedStatement consulta = connection.prepareStatement(query); 
            int count = consulta.executeUpdate();
            result = (count > 0);
        } catch(Exception ex){
            throw ex;
        }
        return result;
    }
    
    public static boolean actualizar(List<String> campos, List<String> valores, List<String> camp_condiciones, List<String> val_condiciones, String table) throws Exception, Exception, Exception, Exception, Exception{
        boolean result = false;
        try {            
            String str_valores = "";
            String str_condiciones = "";
            for (int i = 0; i < campos.size(); i++){
                str_valores += i == 0 ? campos.get(i) + "=" + valores.get(i) : ", " + campos.get(i) + "=" +valores.get(i);
            }
            for (int c = 0; c < camp_condiciones.size(); c ++){
                str_condiciones += c == 0 
                        ? " WHERE " + camp_condiciones.get(c) + "=" + val_condiciones.get(c) 
                        : " AND "  + camp_condiciones.get(c) + "=" + val_condiciones.get(c);
            }
            String query = "UPDATE " + table + " SET " + str_valores + str_condiciones;
            //ejecutar la query
            Connection connection = null;        
            connection = getConnection();
            PreparedStatement consulta = connection.prepareStatement(query); 
            int count = consulta.executeUpdate();
            result = (count > 0);
        } catch(Exception ex){ 
            throw ex; 
        }
        return result;
    }
}