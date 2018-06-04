package com.engcpp;

import com.engcpp.utils.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author engcpp
 */
public class LoginTest {
    private Login loginPage;
    private WebDriver driver;
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new Login(Constants.IQC_URL, driver);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testLogin(){
      loginPage = loginPage.withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();                 

      Assert.assertTrue(loginPage.isLoggedIn());
    }    
}