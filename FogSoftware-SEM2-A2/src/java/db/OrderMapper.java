package db;

import backend.Order;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public void storeOrder(User user, Order order, ArrayList<String> materials) {
        String sqlOrder = "INSERT INTO orders (userID, orderTitle) VALUES (?, ?);";
        String sqlOrderMat = "INSERT INTO orderMaterials (material) VALUES (?);";

        String mats = String.join(",", materials);  //this converts the String ArrayList into one log String each element seperated by a " , "

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sqlOrder);
            stmt.setInt(1, /*user.getId()*/ 666);
            stmt.setString(2, order.getOrder_title() + " - Carport med flat tag");
            stmt.executeUpdate();
            stmt = con.prepareStatement(sqlOrderMat);
            stmt.setString(1, mats);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList getOrderMat(int orderNum) {
        String sql = "SELECT material FROM orderMaterials WHERE orderID = " + orderNum;
        ArrayList<String> materials = new ArrayList<>();

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String material = rs.getString("material");
            String[] material1 = material.split(",");

            materials = new ArrayList<>(Arrays.asList(material1));

        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materials;

    }

}
