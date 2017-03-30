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

    private int rafterDistance = 550;

    // Længde i millimeter //
    public int getRafterAmount(int length)
    {
        length -= 275; // udhæng bagved
        int spær = 1;
        while (length > rafterDistance)
        {
            spær++;
            length -= rafterDistance;
        }
        return spær;
    }

    public int getPillarAmount(int length, int width)
    {
        int shedPillars = 4;
        int extraPillars = 1;
        int num = 2;
        while ((length - 100) >= 310)
        {
            num += 2;
            length -= 310;
        }
        int temp = num;
        num += shedPillars + extraPillars;

        // width - pillarDistance
        width -= 70;
        if (width > 600)
        {
            num += temp / 2;
        }
        
        return shedPillars;
    }
}
