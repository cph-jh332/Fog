package db;

import backend.Material;
import backend.Order;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

class OrderMapper {

    int newOrderId;

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

    public ArrayList<Material> getMaterialID() {
        String sql = "SELECT materialID FROM materials";
        ArrayList<Material> materials = new ArrayList<>();

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Material m = new Material(rs.getInt("materialID"), "test");
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

}
