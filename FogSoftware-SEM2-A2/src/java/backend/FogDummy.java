/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Peter
 */
public class FogDummy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //dummy(780, 800);
       // understernBrædder(450, 350);
        //oversternBrædder(780, 600);
        //perforatedBand(780,700);
        
        //waterBoard(780,600);
    }

    static void dummy(int længde, int bredde) {
        int skurstolper = 4;
        int ekstraStolpe = 1;
        int num = 2;
        while ((længde - 100) >= 310) {
            num += 2;
            længde -= 310;
        }
        int temp = num;
        num += skurstolper + ekstraStolpe;

        //bredden - stolpeafstand
        bredde -= 70;
        if (bredde > 600) {
            num += temp / 2;
        }
        System.out.println(num);

    }

    static void understernBrædder(int længde, int bredde) {
        int[] understern = new int[2];

        int temp360 = ((bredde / 360) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, * 2 front and back!
        int temp540 = ((længde / 540) + 1) * 2;
        understern[0] = temp360;
        understern[1] = temp540;
        for (int i = 0; i < understern.length; i++) {
            System.out.println(understern[i]);

        }

    }

    static void oversternBrædder(int længde, int bredde) {
        int[] overstern = new int[2];

        int temp360 = ((bredde / 360) + 1); //no boards in the back 
        int temp540 = ((længde / 540) + 1) * 2;
        overstern[0] = temp360;
        overstern[1] = temp540;
        for (int i = 0; i < overstern.length; i++) {
            System.out.println(overstern[i]);

        }

    }

    static void perforatedBand(int length, int width) {
        // int length = carportLength;
        // int width = carportWidth;

        int pyth = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));  //we find the length from front left pillar to the back right pillar c^2 = a^2 + b^2
        int band = 2;
        if (pyth > 1000) {
            band += 1;
        }
//        System.out.println(pyth);
//        System.out.println(band);
        
        
        // return band;
    }

    static void waterBoard(int length, int width) {
        // int length = carportLength;
        // int width = carportWidth;

        int[] waterBoards = new int[2];

        int temp360 = ((width / 360) + 1); //no boards in the back 
        int temp540 = ((length / 540) + 1) * 2;
        
        System.out.println(temp360);
        System.out.println(temp540);

    }

}
