/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Clases.User;
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
public class UserP extends ConnectDB{
    
    public void addUser(User u, int idUser){
        
        Connection cn = getConnection();
        
        try{
            String query="INSERT INTO user SET name = ?, phone = ?, username = ?, " + 
                    "password = ?, branch = ?, level = ?, active =?, modified=?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, u.getName());
            pstm.setString(2, u.getPhone());
            pstm.setString(3, u.getUsername());
            pstm.setString(4, u.getPassword());
            pstm.setInt(5, u.getBranch().getId());
            pstm.setString(6, u.getLevel());            
            pstm.setBoolean(7, true);       
            pstm.setInt(8, idUser);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch(SQLException e){
            System.out.println("Erroe SQL en addUser: " +e.getMessage());
            
        }
        
    }
     
    public List<User> getAllUsers(){
        Connection cn = getConnection();
        List<User> listU = new ArrayList<User>();
        String query = "SELECT * FROM user";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));                
                u.setLevel(rs.getString("level"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setUsername(rs.getString("username"));
                u.setActive(rs.getBoolean("active"));
                
                int id_branch = rs.getInt("branch");
                if (id_branch > 0)
                    u.setBranch(new Branch_OfficeP().getBranch_Office(id_branch));
                
                listU.add(u);
            }
            
            st.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en User (getAll): "+e.getMessage());
        }
        
        return listU;
        
    }
    
    public User getUser(int id){
        Connection cn = getConnection();
        User u = null;
        String query = "SELECT * FROM user WHERE id=? AND active=1";
        try{
            
            PreparedStatement pstm = cn.prepareCall(query);
            //Para buscar con variable directa se quita esta linea de abajo
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            int id_branch = 0;
            while(rs.next()){  
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));
                u.setLevel(rs.getString("level"));   
                u.setPhone(rs.getString("phone"));                                
            }
            if (id_branch > 0)
                u.setBranch(new Branch_OfficeP().getBranch_Office(id_branch));
            rs.close();                        
        } catch(SQLException e) {
            System.out.println("Error en User (getUser): "+e.getMessage());
        }        
        return u;        
    }
    
    public void updateUser(User u, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE user SET name = ?, phone= ?, username = ?, active = ?, branch = ?, level= ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, u.getName());
            pstm.setString(2, u.getPhone());
            pstm.setString(3, u.getUsername());
            pstm.setBoolean(4, u.isActive());    
            pstm.setInt(5, u.getBranch().getId());
            pstm.setString(6, u.getLevel());
            pstm.setInt(7, idUser);
            pstm.setInt(8, u.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
                System.out.println("Error en User(updateUser): "+e.getMessage());
            
        }
        
    }
    
    public void updateUsertActive(User u, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE user SET active = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            boolean act;
            if(u.isActive()==true){
                act=false;
            }else{
                act=true;
            }
            pstm.setBoolean(1, act);
            pstm.setInt(2, idUser);
            pstm.setInt(3, u.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
                System.out.println("Error en User(updateUserActive): "+e.getMessage());
            
        }
        
    }
    
    public void updateUsertLevel(User u, int idUser){
        
        Connection cn = getConnection();
        String query = "UPDATE user SET level = ?, modified=? WHERE id=?";
        
        try{
            
            PreparedStatement pstm = cn.prepareStatement(query);
            String lvl;
            if(u.getLevel().equals("Admin")){
                lvl="Normal";
            }else{
                lvl="Admin";
            }
            pstm.setString(1, lvl);
            pstm.setInt(2, idUser);
            pstm.setInt(3, u.getId());            
            pstm.executeUpdate();
            pstm.close();
            
        }catch(SQLException e){
                System.out.println("Error en User(updateUserActive): "+e.getMessage());
            
        }
        
    }
    
    public List<User> getUser(String data, String categorie){
        Connection cn = getConnection();
        List<User> listU = new ArrayList<User>();
        String query = "SELECT * FROM user WHERE "+categorie+" LIKE ?";
        try{
            
            PreparedStatement pstm = cn.prepareCall(query);
              //Para buscar con variable directa se quita esta linea de abajo
              pstm.setString(1, "%"+data+"%");
              ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));                
                u.setLevel(rs.getString("level"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setUsername(rs.getString("username"));
                u.setActive(rs.getBoolean("active"));
                int id_branch = rs.getInt("branch");
                if (id_branch > 0)
                    u.setBranch(new Branch_OfficeP().getBranch_Office(id_branch));
                listU.add(u);
            }
            rs.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en User (getUser): "+e.getMessage());
        }
        
        return listU;
        
    }
    
    /*public List<String> getUserBranch(){
        Connection cn = getConnection();
        List<String> listB = new ArrayList<String>();
        String query = "SELECT * FROM user";
        try{
            
            PreparedStatement pstm = cn.prepareCall(query);
              ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                System.out.println("Tamaño: "+listB.size());
                
                if(listB.isEmpty()){
                    listB.add(rs.getString("branch"));
                        System.out.println("Branch Nueva");
                        System.out.println("Tamaño: "+listB.size());
                }
                
               boolean res=true;
                
                for(int i =0; i<=listB.size()-1;i++){
                    
                    String valB=listB.get(i); 
         
                    if(valB.equals(rs.getString("branch"))){
                        res=false;
                        System.out.println("Es igual Branch "+res);
                        
                        
                        
                    }

                }
                if(res==true){
                        System.out.println("BRanch agregada");
                        listB.add(rs.getString("branch"));
            }

                
                
            }
            rs.close();
            
            
        }catch(SQLException e){
            System.out.println("Error en User (getUser): "+e.getMessage());
        }
        
        return listB;
        
    }*/
    
    public User login(String user, String pass){
        Connection cn = getConnection();
        User u = null;
        String query = "SELECT * FROM user WHERE username=? AND active=1";
        try{
            
            PreparedStatement pstm = cn.prepareCall(query);
            //Para buscar con variable directa se quita esta linea de abajo
            pstm.setString(1, user);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){  
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));
                u.setLevel(rs.getString("level"));
                if (!u.getPassword().equals(pass)){
                    u = null;
                }
            }
            rs.close();                        
        } catch(SQLException e) {
            System.out.println("Error en User (getUser): "+e.getMessage());
        }        
        return u;        
    }
    
}
