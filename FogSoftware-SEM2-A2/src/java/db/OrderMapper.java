package db;

import backend.Order;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public void storeOrder(User user, Order order) {
        String sql = "INSERT INTO orders (userID, orderTitle) VALUES (?, ?);";

        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, /*user.getId()*/ 666);
            stmt.setString(2, order.getOrder_title() + " - Carport med flat tag");
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList getOrders() {
        
        ArrayList<Order> orderList = new ArrayList();
        String sql = "SELECT * FROM orders";

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

}
