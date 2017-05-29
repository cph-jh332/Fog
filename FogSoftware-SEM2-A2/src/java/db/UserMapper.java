package db;

import backend.HashEncoder;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper {

    public User loginUser(String email, String password) {
        User user = null;
        String getSalt = "select salt from user where email = ?";
        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt1 = con.prepareStatement(getSalt);
            stmt1.setString(1, email);
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                byte[] salt = rs1.getBytes("salt");
                password = HashEncoder.get_SHA_256_SecurePassword(password, salt);
            }
            con.close();
        } catch (Exception e) {
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
                        rs.getString("firstName"), rs.getString("lastName"), rs.getInt("phone"), rs.getBoolean("admin"), rs.getString("streetName"), rs.getString("city"), rs.getInt("zipCode"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean createUser(User newUser, String password) {
        String sql = "insert into user (email, password, firstName, lastName, phone, salt, streetName, city, zipCode) values (?,?,?,?,?,?,?,?,?)";

        try (Connection con = new DBConnector().getConnection();) {
            byte[] salt = HashEncoder.generateSalt();
            password = HashEncoder.get_SHA_256_SecurePassword(password, salt);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, newUser.getEmail());
            stmt.setString(2, password);
            stmt.setString(3, newUser.getFirstName());
            stmt.setString(4, newUser.getLastName());
            stmt.setInt(5, newUser.getPhone());
            stmt.setBytes(6, salt);
            stmt.setString(7, newUser.getStreetName());
            stmt.setString(8, newUser.getCity());
            stmt.setInt(9, newUser.getZipCode());
            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void deleteUser(String email, String password) {
        String getSalt = "select salt from user where email = ?";
        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt1 = con.prepareStatement(getSalt);
            stmt1.setString(1, email);
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                byte[] salt = rs1.getBytes("salt");
                password = HashEncoder.get_SHA_256_SecurePassword(password, salt);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("e");
        }

        String sql = "DELETE FROM user WHERE email = ? AND password = ?";
        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1, email);
            stmt2.setString(2, password);
            stmt2.executeUpdate();

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User getUserByOrder(int orderID) {
        User user = null;
        int userID = 0;
        String getUserID = "select userID from orders where orderID = ?";
        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt1 = con.prepareStatement(getUserID);
            stmt1.setInt(1, orderID);
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                userID = rs1.getInt("userID");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("e");
        }

        String sql = "select * from user where userID = ?";

        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("userID"), rs.getString("email"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getInt("phone"), rs.getBoolean("admin"), rs.getString("streetName"), rs.getString("city"), rs.getInt("zipCode"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
