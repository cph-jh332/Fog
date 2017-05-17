package UnitTests;

import backend.Material;
import backend.PartGenerator;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPartGenerator {

    PartGenerator pg = new PartGenerator(780, 600);

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Test
    public void testPillarAmount() {
        int pillars = pg.getPillarAmount();
        int expected = 11;
        assertEquals(expected, pillars);
    }

    @Test
    public void testRafterAmount() {
        int rafters = pg.getRafterAmount();
        int expected = 15;
        assertEquals(expected, rafters);
    }

    @Test
    public void testUndersternAmount() {
        int[] understern = pg.getUnderstern();
        int understern1 = understern[1];

        int expected = 4;
        assertEquals(expected, understern1);
    }

    @Test
    public void testOversternAmount() {
        int[] overstern = pg.getOverstern();
        int overstern1 = overstern[0];

        int expected = 2;
        assertEquals(expected, overstern1);
    }

    @Test
    public void testShedBoardAmount() {
        int shedBoard = pg.getShedBoards();
        int expected = 200;
        assertEquals(expected, shedBoard);
    }

    @Test
    public void testRemAmount() {
        int[] rem = pg.getRem();
        int rem1 = rem[0];

        int expected = 2;
        assertEquals(expected, rem1);
    }

    @Test
    public void testRooftileAmount() {
        int[] roofTiles = pg.getRoofTiles();
        int roofTile = roofTiles[0];

        int expected = 6;
        assertEquals(expected, roofTile);
    }

    @Test
    public void testWaterboardAmount() {
        int[] waterBoards = pg.getWaterboards();
        int waterBoard = waterBoards[0];

        int expected = 2;
        assertEquals(expected, waterBoard);
    }

    @Test
    public void testMaterialListIsCorrect() {
        ArrayList<Material> materials = pg.getMaterials();

        int firstExpected = 1;
        int lastExpected = 13;
        int firstMaterial = materials.get(0).getID();
        int lastMaterial = materials.get(12).getID();
        assertEquals(firstExpected, firstMaterial);
        assertEquals(lastExpected, lastMaterial);
    }

}
