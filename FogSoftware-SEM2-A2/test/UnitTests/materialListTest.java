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

public class materialListTest
{
    PartGenerator pg = new PartGenerator();
    
    @Test
    public void pillarsTest(){
        int pillars = pg.getPillarAmount(780, 600);
        int expected = 11;
        assertEquals(expected, pillars);
    }
}
