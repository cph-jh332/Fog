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
       dummy(780,800);
    }
    static void dummy(int længde, int bredde)
    {
        int skurstolper = 4;
        int ekstraStolpe = 1;
        int num = 2;
        while((længde -100) >= 310){
            num += 2;
            længde -= 310;
        }
        int temp = num;
        num += skurstolper + ekstraStolpe;
        
        
        //bredden - stolpeafstand
        bredde -= 70;
        if(bredde>600){
            num += temp/2;
        }
        System.out.println(num);
    }
}
