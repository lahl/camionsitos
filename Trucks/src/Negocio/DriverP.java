/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Bus;
import Clases.Driver;
import com.autobuses.clases.utils.Sesion;
import com.autobuses.persistencia.ConnectDB;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lalon
 */
public class DriverP extends ConnectDB
{
    
    
    public void addDriver(Driver d, int idUser)
    {
        Connection cn = getConnection();
        try
        {
            String query = "INSERT INTO driver SET name = ?, cel = ?, license = ?, birthDate = ?, apStart = ?, apEnd = ?, "
                    + "email = ?, contractDateStart = ?, contractDateEnd = ?, addres = ?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, d.getName());
            pstm.setString(2, d.getCel());
            pstm.setString(3, d.getLicense());
            
            Date bd = new Date();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            
            String gbd = formatter.format(d.getBirthDate());
            pstm.setString(4, gbd);
            
            String gas = formatter.format(d.getApStart());
            pstm.setString(5, gas);
            
            String gae = formatter.format(d.getApEnd());
            pstm.setString(6, gae);
            
            pstm.setString(7, d.getEmail());
            
            String gcds = formatter.format(d.getContractDateStart());
            pstm.setString(8, gcds);
            
            String gcde = formatter.format(d.getContractDateEnd());
            pstm.setString(9, gcde);
            
            pstm.setString(10, d.getAddres());
            
            pstm.setInt(11, idUser);
            
            pstm.execute();
            pstm.close();
    
            
        }catch(SQLException e)
        {
            System.out.println("Error en driver(addDriver): "+e.getMessage());
        }
        
    }
    
    public List<Driver> getAllDrivers() throws ParseException{
        Connection cn = getConnection();
        List<Driver> listD = new ArrayList<Driver>();
        String query = "SELECT * FROM driver";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Driver d = new Driver();
                d.setId(rs.getInt("id"));
                d.setAddres(rs.getString("addres"));

                
                Date ape=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("apEnd"));
                
                SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
                Date date1=formatter1.parse(rs.getString("apEnd"));
                
                d.setApEnd(ape);
                
                Date aps=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("apStart"));
                d.setApStart(aps);
                
                Date bd=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("birthDate"));
                d.setBirthDate(bd);
                
                Date cde=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("contractDateEnd"));
                d.setContractDateEnd(cde);
                
                Date cds=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("contractDateStart"));  
                d.setContractDateStart(cds);
                
                d.setCel(rs.getString("cel"));
                d.setEmail(rs.getString("email"));
                d.setLicense(rs.getString("license"));
                d.setName(rs.getString("name"));
                
                listD.add(d);
            }
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en driver (getAll): "+e.getMessage());
        }
        
        return listD;
        
    }
    
    //Delete Bus
    public void deleteDriver(int id){
        
        Connection cn = getConnection();
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM driver WHERE id=?";        
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
    
    /**
     * Update Bus
     * @param bus 
     */
    public void updateDriver(Driver d, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE driver SET name = ?, cel = ?, license = ?, birthDate = ?, apStart = ?, apEnd = ?, "
                    + "email = ?, contractDateStart = ?, contractDateEnd = ?, addres = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            
            pstm.setString(1, d.getName());
            pstm.setString(2, d.getCel());
            pstm.setString(3, d.getLicense());
            
            Date bd = new Date();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            
            String gbd = formatter.format(d.getBirthDate());
            pstm.setString(4, gbd);
            
            String gas = formatter.format(d.getApStart());
            pstm.setString(5, gas);
            
            String gae = formatter.format(d.getApEnd());
            pstm.setString(6, gae);
            
            pstm.setString(7, d.getEmail());
            
            String gcds = formatter.format(d.getContractDateStart());
            pstm.setString(8, gcds);
            
            String gcde = formatter.format(d.getContractDateEnd());
            pstm.setString(9, gcde);
            
            pstm.setString(10, d.getAddres());
            
            pstm.setInt(11, idUser);
            
            pstm.setInt(12, d.getId());
            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Driver(updateDriver): "+e.getMessage());
            
        }
        
    }
    
    
    public List<Driver> searchDriver(String data){
        List<Driver> listD = new ArrayList<Driver>();
        Connection cn = getConnection();
        String queryU = "SELECT * FROM driver WHERE name  LIKE ?";
        
        //Buscar con variable directa
        //String queryU = "SELECT * FROM bus WHERE unidNum  LIKE '%"+data+"%'";
        
        try{

              PreparedStatement pstm = cn.prepareCall(queryU);
              //Para buscar con variable directa se quita esta linea de abajo
              pstm.setString(1, "%"+data+"%");
              ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            Driver d = new Driver();
                d.setId(rs.getInt("id"));
                d.setAddres(rs.getString("addres"));
                d.setApEnd(rs.getDate("apEnd"));
                d.setApStart(rs.getDate("apStart"));
                d.setBirthDate(rs.getDate("birthDate"));
                d.setCel(rs.getString("cel"));
                d.setContractDateEnd(rs.getDate("contractDateEnd"));
                d.setContractDateStart(rs.getDate("contractDateStart"));
                d.setEmail(rs.getString("email"));
                d.setLicense(rs.getString("license"));
                d.setName(rs.getString("name"));
                
                listD.add(d);
              
                }
              pstm.close();
        
            
        }catch(SQLException e){
            System.out.println("Error en driver (searchDriver): "+e.getMessage());
        }
                
        
        return listD;

    }
    
}
