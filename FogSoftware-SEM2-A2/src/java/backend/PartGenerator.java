/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

// All lengths are in millimeter //

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
    
    public ArrayList<Material> getMaterials(){
        
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
        int[] understern = getUndersternBrædder();
        materials.get(7).setAmount(understern[0]);  //540
        materials.get(8).setAmount(understern[1]);  //360
        int[] overstern = getOversternBrædder();
        materials.get(9).setAmount(overstern[0]);   //540
        materials.get(10).setAmount(overstern[1]);  //360
        int[] waterboard = getWaterboards();
        materials.get(11).setAmount(waterboard[0]); //540
        materials.get(12).setAmount(waterboard[1]); //360

        return materials;
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
        int length = carportLength - 2100; // 2100 is the length of the shed //

        int shedPillars = 6;
        int extraPillars = 1;
        int num = 2;
        while (length - 1000 >= 3100)
        {
            num += 2;
            length -= 3100;
        }
        int temp = num;
        num += shedPillars + extraPillars;

        // width - pillarDistance   will be added later!!!
//        width -= 700;
//        if (width > 6000)     
//        {
//            num += temp / 2;
//        }

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

    public int[] getUndersternBrædder()
    {
        int[] understern = new int[2];

        int temp360 = ((carportWidth / 3600) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, *2 front and back!
        int temp540 = ((carportLength / 5400) + 1) * 2;
        understern[0] = temp540;
        understern[1] = temp360;

        return understern;
    }

    public int[] getOversternBrædder()
    {
        int[] overstern = new int[2];

        int temp360 = ((carportWidth / 3600) + 1) * 2; //no boards in the back 
        int temp540 = ((carportLength / 5400) + 1);
        overstern[0] = temp540;
        overstern[1] = temp360;

        return overstern;
    }

    public int[] getWaterboards()
    {
        int temp360 = ((carportWidth / 3600) + 1) * 2; //no boards in the back
        int temp540 = ((carportLength / 5400) + 1);

        int[] waterBoards =
        {
            temp540, temp360
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