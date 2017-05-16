package UnitTests;

import backend.Material;
import db.DBFacade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMaterialMapper {
    
    Material material;
    DBFacade df = new DBFacade();
    
    private final String USERNAME = "bade";
    private final String PASSWORD = "3201";
    private Connection conn = null;
    
    public TestMaterialMapper()
    {
    }
    
    @Before
    public void setUp() {
        String URL = String.format("jdbc:mysql://207.154.197.204:3306/FogDB?useUnicode=true&amp;characterEncoding=utf8");
        try {
            conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try (Statement stmt = conn.createStatement()) {
                stmt.execute("drop table if exists junittest");
                stmt.execute("create table junittest as(select * from materials)");

            }

        } catch (SQLException ex) {
            conn = null;
            Logger.getLogger(TestPartGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {

        try (Statement stmt = conn.createStatement()) {
            stmt.execute("SET foreign_key_checks = 0");
            stmt.execute("drop table if exists materials");
            stmt.execute("create table materials(materialID int auto_increment primary key, materialName varchar(100))");
            stmt.execute("insert into materials(select * from junittest)");
            stmt.execute("SET foreign_key_checks = 1");

        } catch (SQLException ex) {
            conn = null;
            Logger.getLogger(TestPartGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    @Test
    public void addAndDeleteMaterialsToAndFromDB() {
        String name = "et stykke bræt";
        material = new Material(name);
        df.addNewMaterial(material);

        ArrayList<String> materials = df.getAllMaterials();

        String materialName = materials.get(materials.size() - 1);
        String expected = name;

        assertEquals(expected, materialName);

        df.deleteMaterial(name);

        materials = df.getAllMaterials();

        materialName = materials.get(materials.size() - 1);
        String notExpected = name;

        assertNotEquals(notExpected, materialName);
    }
    
    @Test
    public void materialListFromDB() {
        ArrayList<Material> materials = df.getMaterialID();

        int firstExpected = 1;
        int lastExpected = 13;
        int firstMaterial = materials.get(0).getID();
        int lastMaterial = materials.get(12).getID();
        assertEquals(firstExpected, firstMaterial);
        assertEquals(lastExpected, lastMaterial);

    }
}
