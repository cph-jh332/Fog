/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Dixie
 */
public class Material {
   private int ID,amount;
   private String name;

    public Material(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    public Material(String name){
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
   
   
   
}
