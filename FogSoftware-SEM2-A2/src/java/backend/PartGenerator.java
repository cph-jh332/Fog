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

    private int carportLength;
    private int carportWidth;

    public PartGenerator(int length, int width)
    {
        carportLength = length;
        carportWidth = width;
    }

    // Length in millimeter //
    public int getRafterAmount()
    {
        int length = carportLength;
        int rafterDistance = 550;

        length -= 275; // udhæng bagved
        int spær = 1;
        while (length > rafterDistance)
        {
            spær++;
            length -= rafterDistance;
        }
        return spær;
    }

    public int getPillarAmount()
    {
        int length = carportLength;
        int width = carportWidth;
        
        int shedPillars = 4;
        int extraPillars = 1;
        int num = 2;
        while ((length - 1000) >= 3100)
        {
            num += 2;
            length -= 3100;
        }
        int temp = num;
        num += shedPillars + extraPillars;

        // width - pillarDistance
        width -= 700;
        if (width > 6000)
        {
            num += temp / 2;
        }

        return shedPillars;
    }

    // index 0 is the 6000mm long tiles and index 1 is the 3600mm long tiles //
    public int[] getRoofTiles()
    {
        int length = carportLength;
        int width = carportWidth;
        
        int tileWidth = 1090;
        int[] tileLengths =
        {
            6000, 3600
        };
        int typeChosen = 0;

        int[] tiles = new int[tileLengths.length];

        int widthCounter = 0;
        int lengthCounter = 0;

        while (lengthCounter < length)
        {
            while (lengthCounter + tileLengths[typeChosen] > length && typeChosen < tileLengths.length)
            {
                typeChosen++;
            }
            
            lengthCounter += tileLengths[typeChosen];
            
            while (widthCounter < width)
            {
                widthCounter += tileWidth;
                tiles[typeChosen]++;
            }
        }

        return tiles;
    }
}
