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
public class PartGenerator
{
    // Længde i millimeter //
    public int spærAmount(int length)
    {
        length -= 275;
        int spær = 1;
        while (length > 550)
        {
            spær++;
            length -= 550;
        }
        return spær;
    }
    
    
}
