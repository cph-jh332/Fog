/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Bade
 */
public class Main
{
    public static void main(String[] args)
    {
        PartGenerator pg = new PartGenerator(7800, 6000);
        
        System.out.println(pg.getRoofTiles());
    }
}
