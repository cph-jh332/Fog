package db;

import backend.Material;
import backend.User;
import java.util.ArrayList;
import java.util.HashMap;

public class DBFacade {
    MaterialMapper mp = new MaterialMapper();
    OrderMapper om = new OrderMapper();
    UserMapper um = new UserMapper();
    
    public void addNewMaterial(Material material){
        mp.addNewMaterial(material);
    }
    
    public void deleteMaterial(String materialName){
        mp.deleteMaterial(materialName);
    }
    
    public ArrayList getAllMaterials() {
        return mp.getAllMaterials();
    }
    
    
    public ArrayList<Material> getMaterialID() {
        return mp.getMaterialID();
    }
    
     public User loginUser(String email, String password) {
        return um.loginUser(email, password);
    }

    public boolean createUser(User newUser, String password) {
        return um.createUser(newUser, password);
    }

    public void deleteUser(String email, String password) {
        um.deleteUser(email, password);
    }
    
    public boolean storeOrder(User user, int length, int width, ArrayList<Material> materials) {
        return om.storeOrder(user, length, width, materials);
    }

    public ArrayList getOrders(String incomingSQL) {
        return om.getOrders(incomingSQL);
    }

    public ArrayList<Material> getOrderDetail(int orderNum) {
        return om.getOrderDetail(orderNum);
    }


    public HashMap getLengthAndWidth(int orderID) {
        return om.getLengthAndWidth(orderID);
    }
    
    public HashMap getProgress(int orderID){
        return om.getProgress(orderID);
    }
    
    public void updateHasCalled(int orderID, boolean hasCalled){
        om.updateHasCalled(orderID, hasCalled);
    }
    
    public void updateCustomerConfirmed(int orderID, boolean costumerConfirmed){
        om.updateCustomerConfirmed(orderID, costumerConfirmed);
    }
    
    public User getUserByOrderID(int orderID){
        return um.getUserByOrder(orderID);
    }
}
