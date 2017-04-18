/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import db.OrderMapper;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        // Main partly for testing
        PartGenerator pg = new PartGenerator(7800, 6000);
        OrderMapper om = new OrderMapper();

        int[] roofTiles = pg.getRoofTiles();

        //System.out.println(roofTiles[0] + ", " + roofTiles[1]);
        
        ArrayList<Order> orderList = om.getOrders();

        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).getOrder_id());
            System.out.println(orderList.get(i).getUser_id());
            System.out.println(orderList.get(i).getOrder_date());
            System.out.println(orderList.get(i).getOrder_title());
        }
        
        
        
        
    }
}
