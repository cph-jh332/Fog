/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author craci
 */
public class OrderProgressCalc {
    public int orderProgress(boolean hasCalled, boolean customerConfirmed){
        int progress = 0;
        
        if(hasCalled && customerConfirmed){
            progress = 100;
        } else if(hasCalled || customerConfirmed){
            progress = 50;
        }
        
        return progress;
    }
}
