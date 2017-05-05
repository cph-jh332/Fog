package UnitTests;

import backend.Material;
import backend.PartGenerator;
import db.DBFacade;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class materialListTest {
    DBFacade df = new DBFacade();
    PartGenerator pg = new PartGenerator(780, 600);
    Material material;

    @Test
    public void pillarsTest() {
        int pillars = pg.getPillarAmount();
        int expected = 11;
        assertEquals(expected, pillars);
    }

    @Test
    public void rafterAmountTest() {
        int rafters = pg.getRafterAmount();
        int expected = 15;
        assertEquals(expected, rafters);
    }

    @Test
    public void understernTest() {
        int[] understern = pg.getUndersternBrædder();
        int understern1 = understern[1];

        int expected = 4;
        assertEquals(expected, understern1);
    }

    @Test
    public void oversternTest() {
        int[] overstern = pg.getOversternBrædder();
        int overstern1 = overstern[0];

        int expected = 2;
        assertEquals(expected, overstern1);
    }

    @Test
    public void shedBoardTest() {
        int shedBoard = pg.getShedBoards();
        int expected = 200;
        assertEquals(expected, shedBoard);
    }

    @Test
    public void remTest() {
        int[] rem = pg.getRem();
        int rem1 = rem[0];

        int expected = 2;
        assertEquals(expected, rem1);
    }

    @Test
    public void roofTiles() {
        int[] roofTiles = pg.getRoofTiles();
        int roofTile = roofTiles[0];

        int expected = 6;
        assertEquals(expected, roofTile);
    }

    @Test
    public void waterBoard() {
        int[] waterBoards = pg.getWaterboards();
        int waterBoard = waterBoards[0];

        int expected = 2;
        assertEquals(expected, waterBoard);
    }

    @Test
    public void perforatedBand() {
        int perforatedBand = pg.getPerforatedBand();
        int expected = 2;
        assertEquals(expected, perforatedBand);
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

    @Test
    public void materialListFromPartGen() {
        ArrayList<Material> materials = pg.getMaterials();

        int firstExpected = 1;
        int lastExpected = 13;
        int firstMaterial = materials.get(0).getID();
        int lastMaterial = materials.get(12).getID();
        assertEquals(firstExpected, firstMaterial);
        assertEquals(lastExpected, lastMaterial);

    }
    
    @Test
    public void addAndDeleteMaterialsToAndFromDB(){
        String name = "et stykke bræt";
        material = new Material(name);
        df.addNewMaterial(material);
        
        ArrayList<String> materials = df.getAllMaterials();
        
        
        String materialName = materials.get(materials.size() - 1);
        String expected = name;
        
        assertEquals(expected,materialName);
        
        df.deleteMaterial(name);
        
        materials = df.getAllMaterials();
        
        materialName = materials.get(materials.size() - 1);
        String notExpected = name;
        
        assertNotEquals(notExpected,materialName);
        
    }


}
