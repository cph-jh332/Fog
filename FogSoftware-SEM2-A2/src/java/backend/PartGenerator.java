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

        return num;
    }

    // index 0 is the 6000mm long tiles and index 1 is the 3600mm long tiles //
    public int[] getRoofTiles()
    {
        //int overlap = 200;
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
            while (lengthCounter + (tileLengths[typeChosen]) > length && typeChosen < tileLengths.length - 1)
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

    // Hardcoded sludge at it's best //
    public int[] getRem()
    {
        int[] rafterLengths =
        {
            6000, 4800
        };
        
        int[] rafters = new int[rafterLengths.length];
        rafters[1] = 1;
        
        int length = carportLength - 2400;
        while (length > 0)
        {
            if (length >= 5400)
            {
                rafters[0] += 2;
                length -= 6000;
            }
            else if (length >= 4800)
            {
                rafters[1] += 2;
                length -= 4800;
            }
            else if (length / 2 < 3000) // a 6000 rafter divided by 2 //
            {
                rafters[0] += 1;
                length -= 3000;
            }
            else
            {
                rafters[1] += 1;
                length -= 2400;
            }
        }

        return rafters;
    }

    public int getShedBoards()
    {
        int boardWidth = 100;

        int circumference = (2 * 2100) + (2 * (carportWidth - 700));
        int boards = circumference / boardWidth;

        return (int)Math.ceil(boards * 1.35); // 0.35 is the fraction that Fog adds as extra
    }

    public int[] understernBrædder()
    {
        int[] understern = new int[2];

        int temp360 = ((carportWidth / 3600) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, *2 front and back!
        int temp540 = ((carportLength / 5400) + 1) * 2;
        understern[0] = temp360;
        understern[1] = temp540;

        return understern;
    }

    public int[] oversternBrædder()
    {
        int[] overstern = new int[2];

        int temp360 = ((carportWidth / 3600) + 1); //no boards in the back 
        int temp540 = ((carportLength / 5400) + 1) * 2;
        overstern[0] = temp360;
        overstern[1] = temp540;

        return overstern;
    }

    public int[] waterBoard()
    {
        int temp360 = ((carportWidth / 3600) + 1); //no boards in the back 
        int temp540 = ((carportLength / 5400) + 1) * 2;

        int[] waterBoards =
        {
            temp360, temp540
        };
        return waterBoards;
    }

    public int getPerforatedBand()
    {
        int pyth = (int) Math.sqrt(Math.pow(carportWidth, 2) + Math.pow(carportLength, 2));  //we find the length from front left pillar to the back right pillar c^2 = a^2 + b^2
        int band = 2;
        if (pyth > 10000)
        {
            band += 1;
        }
        
        return band;
    }
}
