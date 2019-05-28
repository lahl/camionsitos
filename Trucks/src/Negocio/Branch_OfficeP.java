/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.Branch_Office; 
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
public class Branch_OfficeP extends ConnectDB {    
    //Used in frmBranch_Office
    public void addBranch_Office(Branch_Office branch, int idUser){
        
        Connection cn = getConnection();
        
        try{
            String query="INSERT INTO branch_offices SET nombre = ?, telefono = ?, celular = ?, correo = ?, direccion = ?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, branch.getNombre());
            pstm.setString(2, branch.getTelefono());
            pstm.setString(3, branch.getCelular());
            pstm.setString(4, branch.getCorreo());
            pstm.setString(5, branch.getDireccion());
            pstm.setInt(6, idUser);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en Branch Office :" +e.getMessage());
            
        }
        
    }
    
    //Used in frmBranch_officeRUD    
    public List<Branch_Office> getAllBranch_Office(){
        Connection cn = getConnection();
        List<Branch_Office> listB = new ArrayList<Branch_Office>();
        String query = "SELECT * FROM branch_offices";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Branch_Office b = new Branch_Office();
                b.setId(rs.getInt("id"));
                b.setNombre(rs.getString("nombre"));
                b.setTelefono(rs.getString("telefono"));
                b.setCelular(rs.getString("celular"));
                b.setCorreo(rs.getString("correo"));
                b.setDireccion(rs.getString("direccion"));                
                listB.add(b);
            }
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en Branch Office (getAll): "+e.getMessage());
        }
        
        return listB;
        
    }    
    //Delete Branch_Office
    public void deleteBranch_Office(int id){
        
        Connection cn = getConnection();
        String query_id = "SET @user_id = " + Sesion.getId() + ";";
        String query = "DELETE FROM branch_offices WHERE id=?;";
        
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
            System.out.println("Error en Branch_Office (deleteBranch_Office)"+e.getMessage());
        }
        
    }    
    /**
     * Update Branch_Office
     * @param Branch_Office 
     */
    public void updateBranch_Office(Branch_Office branch, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE branch_offices SET nombre = ?, telefono = ?, celular = ?, correo = ?, direccion = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, branch.getNombre());
            pstm.setString(2, branch.getTelefono());
            pstm.setString(3, branch.getCelular());
            pstm.setString(4, branch.getCorreo());
            pstm.setString(5, branch.getDireccion());
            pstm.setInt(6, idUser);
            pstm.setInt(7, branch.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
            System.out.println("Error en Branch_Office(updateBranch_Office): "+e.getMessage());
            
        }
        
    }
    
    public List<Branch_Office> searchBranch_Office(String data){
        List<Branch_Office> listB = new ArrayList<Branch_Office>();
        Connection cn = getConnection();
        String queryU = "SELECT * FROM branch_offices WHERE unidNum  LIKE ?";
        
        //Buscar con variable directa
        //String queryU = "SELECT * FROM Branch_Office WHERE unidNum  LIKE '%"+data+"%'";
        
        try{

              PreparedStatement pstm = cn.prepareCall(queryU);
              //Para buscar con variable directa se quita esta linea de abajo
              pstm.setString(1, "%"+data+"%");
              ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            Branch_Office b = new Branch_Office();
            b.setId(rs.getInt("id"));
            b.setNombre(rs.getString("nombre"));
            b.setTelefono(rs.getString("telefono"));
            b.setCelular(rs.getString("celular"));
            b.setCorreo(rs.getString("correo"));
            b.setDireccion(rs.getString("direccion"));                
            listB.add(b);              
        }
        pstm.close();
        
            
        }catch(SQLException e){
            System.out.println("Error en Branch_Office (searchBranch_Office): "+e.getMessage());
        }
                
        
        return listB;

    }   
    
    public Branch_Office getBranch_Office(int id){
        Branch_Office b = new Branch_Office();
        Connection cn = getConnection();
        String queryU = "SELECT * FROM branch_offices WHERE id = ?";
        
        //Buscar con variable directa
        //String queryU = "SELECT * FROM Branch_Office WHERE unidNum  LIKE '%"+data+"%'";
        
        try{

              PreparedStatement pstm = cn.prepareCall(queryU);
              //Para buscar con variable directa se quita esta linea de abajo
              pstm.setInt(1, id);
              ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            b.setId(rs.getInt("id"));
            b.setNombre(rs.getString("nombre"));
            b.setTelefono(rs.getString("telefono"));
            b.setCelular(rs.getString("celular"));
            b.setCorreo(rs.getString("correo"));
            b.setDireccion(rs.getString("direccion"));                              
        }
        pstm.close();
        
            
        }catch(SQLException e){
            System.out.println("Error en Branch_Office (searchBranch_Office): "+e.getMessage());
        }        
        return b;

    }   
}
