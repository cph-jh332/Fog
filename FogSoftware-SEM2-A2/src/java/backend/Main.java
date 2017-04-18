/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import db.OrderMapper;
import db.UserMapper;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        UserMapper um = new UserMapper();
        User user = new User("test@joe.dk", "Tester", "Testensen", 22003300);
        um.createUser(user, "");
        System.out.println(um.loginUser(user.getEmail(), "") == null);
    }
}
