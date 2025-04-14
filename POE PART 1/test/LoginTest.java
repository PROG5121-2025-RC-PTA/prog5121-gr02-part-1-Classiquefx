/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("test_1"));
        assertFalse(login.checkUserName("test123"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Passw0rd@"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+1234567890"));
        assertFalse(login.checkCellPhoneNumber("1234567890"));
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        String result = login.registerUser("test_1");
        assertEquals("Registration successful!", result);
        
        result = login.registerUser("test");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        String storedUsername = "test_1";
        String storedPassword = "Passw0rd@";

        boolean success = login.loginUser("test_1", "Passw0rd@", storedUsername, storedPassword);
        assertTrue(success);

        success = login.loginUser("wrong_username", "wrong_password", storedUsername, storedPassword);
        assertFalse(success);
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        
        String result = login.returnLoginStatus(true, "John", "Doe");
        assertEquals("Welcome John Doe, it is great to see you again!", result);
        
        result = login.returnLoginStatus(false, "John", "Doe");
        assertEquals("Username or password incorrect, please try again.", result);
    }
}

