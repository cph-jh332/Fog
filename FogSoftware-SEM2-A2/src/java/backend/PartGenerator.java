/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

 // All lengths are in millimeter //
public class PartGenerator 
{
    private int carportLength;
    private int carportWidth;

    public PartGenerator(int length, int width)
    {
        carportLength = length * 10;
        carportWidth = width * 10;
    }

    public int getRafterAmount()
    {
        int length = carportLength;
        int rafterDistance = 550;

        int rafter = 1;
        while (length > rafterDistance)
        {
            rafter++;
            length -= rafterDistance;
        }
        return rafter;
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

        return num;
    }

    // index 0 is the 6000mm long tiles and index 1 is the 3600mm long tiles //
    public int[] getRoofTiles()
    {
        int overlap = 200;
        int tileWidth = 1090;
        int[] tileLengths =
        {
            6000, 3600
        };

        int length = carportLength;
        int width = carportWidth;

        int typeChosen = 0;
        int[] tiles = new int[tileLengths.length];

        int widthCounter = 0;
        int lengthCounter = 0;

        while (lengthCounter < length)
        {
            widthCounter = 0;
            while (lengthCounter + (tileLengths[typeChosen] - overlap) > length && typeChosen < tileLengths.length - 1)
            {
                typeChosen++;
            }

            lengthCounter += tileLengths[typeChosen] - overlap;

            while (widthCounter < width)
            {
                widthCounter += tileWidth - overlap;
                tiles[typeChosen]++;
            }
        }

        return tiles;
    }

    public int[] getRafters()
    {
        int[] rafters = new int[2];
        
        
        
        return rafters;
    }
    
    public int getShedBoards()
    {
        int boardWidth = 1000;

        int circumference = 2 * carportLength + 2 * carportWidth;
        int boards = 0;

        while (circumference > 0)
        {
            circumference -= boardWidth;
            boards++;
        }

        return boards;
    }
    
    

    public int[] understernBrædder(int længde, int bredde)
    {
        int[] understern = new int[2];

        int temp360 = ((bredde / 360) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, *2 front and back!
        int temp540 = ((længde / 540) + 1) * 2;
        understern[0] = temp360;
        understern[1] = temp540;

        return understern;
    }

    public int[] oversternBrædder(int længde, int bredde)
    {
        int[] overstern = new int[2];

        int temp360 = ((bredde / 360) + 1); //no boards in the back 
        int temp540 = ((længde / 540) + 1) * 2;
        overstern[0] = temp360;
        overstern[1] = temp540;

        return overstern;
    }
}
