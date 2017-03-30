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
        understernBrædder(780,600);
        oversternBrædder(780,600);
    }




    static void dummy(int længde, int bredde){
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
    static void understernBrædder(int længde, int bredde){
        int[] understern = new int[2] ;
        
        int temp360 = ((bredde / 360) + 1) * 2; //+1 because the costumer needs 1 extra for mistakes per length, *2 front and back!
        int temp540 = ((længde / 540) + 1) * 2;
        understern[0] = temp360; 
        understern[1] = temp540; 
        for (int i = 0; i < understern.length; i++) {
            System.out.println(understern[i]);
            
        }
        
        
        
        
    }
    static void oversternBrædder(int længde, int bredde){
        int[] overstern = new int[2];
        
        int temp360 = ((bredde / 360) + 1); //no boards in the back 
        int temp540 = ((længde / 540) + 1) * 2;
        overstern[0] = temp360; 
        overstern[1] = temp540;
        for (int i = 0; i < overstern.length; i++) {
            System.out.println(overstern[i]);
            
        }
        
    }
}
