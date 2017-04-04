package UnitTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import backend.PartGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class materialListTest {

    PartGenerator pg = new PartGenerator(780, 600);

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
    public void waterBoard(){
        int[] waterBoards = pg.getWaterboards();
        int waterBoard = waterBoards[0];
        
        int expected = 2;
        assertEquals(expected, waterBoard);
    }
    
    @Test
    public void perforatedBand(){
        int perforatedBand = pg.getPerforatedBand();
        int expected = 2;
        assertEquals(expected, perforatedBand);
    }
}
