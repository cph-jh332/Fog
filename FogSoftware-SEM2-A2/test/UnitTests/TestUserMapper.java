package UnitTests;

import backend.User;
import db.DBFacade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUserMapper {

    DBFacade userMapper = new DBFacade();
    User user;

    public TestUserMapper() {

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
    public void testGetUserFromDB() {
        String userName = "test@test.dk";
        String password = "test";
         user = userMapper.loginUser(userName, password);
         String name = user.getFirstName();
         String expected = "test";
         assertEquals(expected,name);

    }
    
    @Test
    public void testCreateUserInDB(){
        String email = "junit@junit.dk";
        String password = "junit";
        String firstName = "mr junit";
        String lastName = "test";
        int phone = 404;
        String streetName = "tester";
        String city = "testby";
        int zipCode = 2810;
        user = new User(email,firstName,lastName,phone,streetName, city, zipCode);
        
        userMapper.createUser(user, password);
        
        firstName = userMapper.loginUser(email, password).getFirstName(); 
        String expected = "mr junit";
        assertEquals(expected, firstName);
        
    }
    
    @Test
    public void testDeleteUserFromDB(){
        String email = "junit@junit.dk";
        String password = "junit";
        
        userMapper.deleteUser(email, password);
        
        user = userMapper.loginUser(email, password);
        
        assertNull(user);
        
    }
}
