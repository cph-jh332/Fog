package backend;

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
