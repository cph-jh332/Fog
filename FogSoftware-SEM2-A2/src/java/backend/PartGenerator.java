package backend;

import db.DBFacade;
import java.util.ArrayList;

public class PartGenerator 
{
    private final int carportLength;
    private final int carportWidth;
    private final DBFacade df = new DBFacade();
    
    public PartGenerator(int length, int width)
    {
        carportLength = length * 10;
        carportWidth = width * 10;
    }
    /**
     * Returns an array with Material class that has the material ID
     * and the material amount. The ID is retrieved from the database.
     * 
     *  @return an ArrayList with Materials
     * 
     */
    
    
    public ArrayList<Material> getMaterials()
    {
        ArrayList<Material> materials = df.getMaterialID();
        
        materials.get(0).setAmount(getRafterAmount());
        materials.get(1).setAmount(getPillarAmount());
        int[] tiles = getRoofTiles();
        materials.get(2).setAmount(tiles[0]);   //600
        materials.get(3).setAmount(tiles[1]);   //360
        int[] rem = getRem();
        materials.get(4).setAmount(rem[0]);     //600
        materials.get(5).setAmount(rem[1]);     //480
        materials.get(6).setAmount(getShedBoards());
        int[] understern = getUnderstern();
        materials.get(7).setAmount(understern[0]);  //540
        materials.get(8).setAmount(understern[1]);  //360
        int[] overstern = getOverstern();
        materials.get(9).setAmount(overstern[0]);   //540
        materials.get(10).setAmount(overstern[1]);  //360
        int[] waterboard = getWaterboards();
        materials.get(11).setAmount(waterboard[0]); //540
        materials.get(12).setAmount(waterboard[1]); //360
        
        return materials;
    }
    
    public int getRafterAmount()
    {
        int rafterDistance = 550;
        return (carportLength / rafterDistance) + 1;
    }

    public int getPillarAmount()
    {
        int length = carportLength - 2100; // 2100 is the length of the shed //

        int shedPillars = 6;
        int extraPillars = 1;
        int pillars = 2;
        while (length - 1000 >= 3100)
        {
            pillars += 2;
            length -= 3100;
        }
        
        pillars += shedPillars + extraPillars;
        
        return pillars;
    }

    // index 0 is the 6000mm long tiles and index 1 is the 3600mm long tiles //
    public int[] getRoofTiles()
    {
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
        float extraPercentage = 0.35f; // 0.35 is the fraction that Fog adds as extra

        int circumference = (2 * 2100) + (2 * (carportWidth - 700));
        int boards = circumference / boardWidth;

        return (int)Math.ceil(boards * (1 + extraPercentage));
    }

    public int[] getUnderstern()
    {
        int[] understern = new int[2];

        // The suffix is the length of the boards //
        int understern360 = ((carportWidth / 3600) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, *2 front and back!
        int understern540 = ((carportLength / 5400) + 1) * 2;
        understern[0] = understern540;
        understern[1] = understern360;

        return understern;
    }

    public int[] getOverstern()
    {
        int[] overstern = new int[2];

        // The suffix is the length of the boards //
        int overstern360 = ((carportWidth / 3600) + 1) * 2; //no boards in the back 
        int overstern540 = ((carportLength / 5400) + 1);
        overstern[0] = overstern540;
        overstern[1] = overstern360;

        return overstern;
    }

    public int[] getWaterboards()
    {
        // The suffix is the length of the boards //
        int waterboard360 = ((carportWidth / 3600) + 1) * 2; //no boards in the back
        int waterboard540 = ((carportLength / 5400) + 1);

        int[] waterBoards =
        {
            waterboard540, waterboard360
        };
        return waterBoards;
    }
}