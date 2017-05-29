package db;

import backend.Material;
import backend.Order;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

class OrderMapper {

   private int newOrderId;

   
   /**
    * This method stores an order in the database in the 2 tables orders and orderDetails.
    * 
    * 
    * @param user The user class must have an ID stored, else the database cannot store the order.
    * @param length The length of the garage
    * @param width The width of the garage
    * @param materials The arraylist with all the materials needed to construct the garage.
    * @return a boolean is returned giving true if the operation was succesful, or false
    * if the operation was not succesful.
    */
   
    public boolean storeOrder(User user, int length, int width, ArrayList<Material> materials) {
        String sqlOrder = "INSERT INTO orders (orderID, userID, orderTitle, width, length) VALUES (?, ?, ?, ?, ?);";
        String sqlOrderMat = "INSERT INTO orderDetails (orderID, materialID, amount) VALUES (?,?,?);";

        // String mats = String.join(",", materials);  //this converts the String ArrayList into one log String each element seperated by a " , "
        Connection con = new DBConnector().getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sqlOrder);
                PreparedStatement stmt2 = con.prepareStatement(sqlOrderMat)) {
            con.setAutoCommit(false);
            PreparedStatement getMaxID = con.prepareStatement("Select max(orderId) from orders");
            ResultSet rs = getMaxID.executeQuery();

            newOrderId = 1;
            if (rs.next()) {
                newOrderId = rs.getInt("max(orderId)");
                newOrderId += 1;
            }

            //PreparedStatement stmt = con.prepareStatement(sqlOrder);
            stmt.setInt(1, newOrderId);
            stmt.setInt(2, user.getId());
            stmt.setString(3, length + "x" + width + " - Carport med flat tag");
            stmt.setInt(4, width);
            stmt.setInt(5, length);
            stmt.executeUpdate();

            //  stmt = con.prepareStatement(sqlOrderMat);
            stmt2.setInt(1, newOrderId);
            for (Material m : materials) {
                stmt2.setInt(2, m.getID());
                stmt2.setInt(3, m.getAmount());
                stmt2.executeUpdate();
            }
            con.commit();
            return true;

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
/**
 * 
 * This method reutns an arraylist with all the orders specified by the parameters.
 * 
 * @param incomingSQL given a string either "sqltop10" or "sqlall" will retrieve from the database
 * either the top 10 orders, or all the orders at once.
 * @return returns an array with orders
 */
    public ArrayList getOrders(String incomingSQL) {

        ArrayList<Order> orderList = new ArrayList();

        String sql = incomingSQL;
        
        if (sql.equalsIgnoreCase("sqltop10")) {
            sql = "SELECT * FROM orders ORDER BY orderDate DESC LIMIT 10";
        }
        if (sql.equalsIgnoreCase("sqlall")) {
            sql = "SELECT * FROM orders";
        }

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order(rs.getInt("orderID"), rs.getInt("userID"), rs.getString("orderDate"), rs.getString("orderTitle"));
                orderList.add(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderList;
    }
/**
 * This method retrieves from the database all the materials from  a specific order.
 * 
 * 
 * @param orderNum The order number is needed since all the materials are bound by this ordernumber
 * @return returns an array of the materials with material id and amount.
 */
    public ArrayList<Material> getOrderDetail(int orderNum) {
        String sql = "SELECT * FROM orderDetails natural join materials WHERE orderID = " + orderNum;
        ArrayList<Material> materials = new ArrayList<>();

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Material m = new Material(rs.getInt("materialID"), rs.getString("materialName"));
                m.setAmount(rs.getInt("amount"));
                materials.add(m);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materials;

    }

    public HashMap getLengthAndWidth(int orderID) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String sql = "SELECT * FROM orders WHERE orderID = " + orderID;

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                map.put("width", width);
                map.put("length", length);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }
    
    public HashMap getProgress(int orderID){
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        String sql = "SELECT hasCalled, customerConfirmed FROM orders WHERE orderID = " + orderID;
        
        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                boolean hasCalled = rs.getBoolean("hasCalled");
                boolean customerConfirmed = rs.getBoolean("customerConfirmed");
                map.put("hasCalled", hasCalled);
                map.put("customerConfirmed", customerConfirmed);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public void updateHasCalled(int orderID, boolean hasCalled){
        String sql = "UPDATE orders SET hasCalled = ? WHERE orderID = " + orderID;
        
        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setBoolean(1, hasCalled);
            
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCustomerConfirmed(int orderID, boolean customerConfirmed){
        String sql = "UPDATE orders SET customerConfirmed = ? WHERE orderID = " + orderID;
        
        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setBoolean(1, customerConfirmed);
            
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
