package backend;

public class Material {
   private int ID,amount;
   private String name;

    public Material(int id, String name) {
        this.ID = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
   
   
}
