/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import backend.HashEncoder;
import backend.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bade
 */
public class UserMapper {

    public User loginUser(String email, String password) {
        User user = null;
        String getSalt = "select salt from user where email = ?";
        try (Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt1 = con.prepareStatement(getSalt);
            stmt1.setString(1, email);
            ResultSet rs1 = stmt1.executeQuery();
            if(rs1.next()){
               byte[] salt = rs1.getBytes("salt");
               password = HashEncoder.get_SHA_256_SecurePassword(password, salt);
            }
            con.close();
        }catch (Exception e) {
            System.out.println("e");
        }
        
        String sql = "select * from user where email = ? and password = ?";

        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("userID"), rs.getString("email"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getInt("phone"), rs.getBoolean("admin"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void createUser(User newUser, String password) {
        String sql = "insert into user (email, password, firstName, lastName, phone, salt) values (?,?,?,?,?,?)";

        try (Connection con = new DBConnector().getConnection();) {
            byte[] salt = HashEncoder.generateSalt();
            password = HashEncoder.get_SHA_256_SecurePassword(password, salt);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, newUser.getEmail());
            stmt.setString(2, password);
            stmt.setString(3, newUser.getName());
            stmt.setString(4, newUser.getLastName());
            stmt.setInt(5, newUser.getPhone());
            stmt.setBytes(6, salt);
            stmt.executeUpdate();

            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
