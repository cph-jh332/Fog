package db;

import backend.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialMapper {
    
    public void addNewMaterial(String name) {
        String sql = "INSERT INTO materials (materialList) VALUES (?)";
        
        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAllMaterials() {
        
        ArrayList<String> list = new ArrayList();
        
        String sql = "SELECT * FROM materials";
        
        try (Connection con = new DBConnector().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String materialType = rs.getString("materialName");
                list.add(materialType);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
