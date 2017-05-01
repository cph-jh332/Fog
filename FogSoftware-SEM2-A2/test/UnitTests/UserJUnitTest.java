/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import backend.User;
import db.UserMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dixie
 */
public class UserJUnitTest {

    UserMapper userMapper = new UserMapper();
    User user;

    public UserJUnitTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getUser() {
        String userName = "test@test.dk";
        String password = "test";
         user = userMapper.loginUser(userName, password);
         String name = user.getFirstName();
         String expected = "test";
         assertEquals(expected,name);

    }
    @Test
    public void createUser(){
        String email = "junit@junit.dk";
        String password = "junit";
        String firstName = "mr junit";
        String lastName = "test";
        int phone = 404;
        user = new User(email,firstName,lastName,phone);
        userMapper.createUser(user, password);
        
        firstName = userMapper.loginUser(email, password).getFirstName(); 
        String expected = "mr junit";
        assertEquals(expected,firstName);
        
    }
    @Test
    public void deleteUser(){
        String email = "junit@junit.dk";
        String password = "junit";
        
        userMapper.deleteUser(email, password);
        
        user = userMapper.loginUser(email, password);
        
        
        
        
        assertNull(user);
        
    }
    
    
    
}
