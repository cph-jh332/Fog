package db;

import backend.Order;
import backend.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public void storeOrder(User user, Order order) {
        String sql = "INSERT INTO orders (userID, orderTitle) VALUES (?, ?);";


        try (Connection con = new DBConnector().getConnection();) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, /*user.getId()*/666);
            stmt.setString(2, "Carport med flat tag");
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
