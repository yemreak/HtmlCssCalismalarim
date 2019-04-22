package userpackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YEmre
 */
public class UserOperations {
    
    /**
     * Tablodaki en son (yüksek) id'i döndürür.
     * @return ID
     */
    public static int getId(){
        int maxId = -1;
        
        try {
            
            String sql = "SELECT Max(ID) FROM users";
            PreparedStatement state= DataConnect.getConnection().prepareStatement(sql);
            ResultSet set = state.executeQuery();
            
            if (set.next())
                maxId = set.getInt(1);
       
        } catch (SQLException e){
            UserBean.msg = e.toString();
        }
        
        return maxId;
    }
    
    /**
     * Kullanıcı adı kontrolü
     * @param username Kullanıcı adı
     * @return Uygunluk
     */
    public static boolean isNewUsername(String username){
        if (username != null && username.length() > 0){
            try {

                String sql = "SELECT username FROM users WHERE username = ?";
                PreparedStatement statement = DataConnect.getConnection().prepareStatement(sql);

                statement.setString(1, username);
                ResultSet set = statement.executeQuery();

                if (!set.next()){
                    DataConnect.close();
                    return true;      
                }

                DataConnect.close();

            } catch (SQLException e){
                UserBean.msg = e.toString();
            }
        }
        return false;
    }
    
    /**
     * Şifre kontrolü
     * @param password Şifre
     * @param repassword Şifre tekrarı
     * @return Uygunluk
     */
    public static boolean checkPassword(String password, String repassword){
        return password != null && password.length() > 0 && password.equals(repassword);
    }
    
    /**
     * Mail kontrolü
     * @param email E-mail
     * @return Uygunluk
     */
    public static boolean isNewEmail(String email){
        if (email != null && email.length() > 0){
            try {
                String sql = "SELECT username FROM users WHERE email = ?";
                PreparedStatement statement = DataConnect.getConnection().prepareStatement(sql);

                statement.setString(1, email);
                ResultSet set = statement.executeQuery();

                if (!set.next())
                    return true;

                DataConnect.close();

            } catch (SQLException e){
                UserBean.msg = e.toString();
            }
        }
        return false;
    }
    
    /**
     * Üye kaydı oluşturma
     * @param username Kullanıcı Adı
     * @param password Şifre
     * @param email Mail
     */
    public static void createUser(String username, String password, String email){
        if (username.length() > 0 && email.length() > 0 && password.length() > 0)
        try {
            String sql = "INSERT INTO users (id, username, password, email) VALUES (?,?,?,?)";
            
            PreparedStatement statement = DataConnect.getConnection().prepareStatement(sql);
            
            statement.setInt(1,  getId() + 1);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            
            statement.executeUpdate();
       
            DataConnect.close();
            
            
        } catch (SQLException e){
            UserBean.msg = e.toString();
        }
    }
    
    public static boolean checkUserName(String username){
        if (username != null && username.length() > 0){
            try {
                String sql = "SELECT username FROM users WHERE username = ?";
                
                PreparedStatement statement = DataConnect.getConnection().prepareStatement(sql);
                statement.setString(1, username);
                
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()){
                    DataConnect.close();
                    return true;
                }
                
                DataConnect.close();
                
            } catch (SQLException e){
                UserBean.msg = e.toString();
            }
        }
        return false;
    }
    
    
    public static boolean checkPassword(String password){
        if (password != null && password.length() > 0){
            try {
                String sql = "SELECT password FROM users WHERE password = ?";
                
                PreparedStatement statement = DataConnect.getConnection().prepareStatement(sql);
                statement.setString(1, password);
                
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()){
                    DataConnect.close();
                    return true;
                }
                
                DataConnect.close();
                
            } catch (SQLException e) {
                UserBean.msg = e.toString();
            }
        }
        return false;
    }
}
