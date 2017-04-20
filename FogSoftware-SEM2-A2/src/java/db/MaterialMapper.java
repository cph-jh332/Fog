package db;

import backend.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialMapper {
    
    public void createNewMaterial() {
        
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
