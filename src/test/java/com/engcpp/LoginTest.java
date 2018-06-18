package com.engcpp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.engcpp.utils.Constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author engcpp
 * @Change by: Kashifi - Converted to the TestNG class to add it in the RegressionTest Suite 
 */
public class LoginTest {
    private Login loginPage;
    private WebDriver driver;
    
    @BeforeMethod
	public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new Login(Constants.IQC_URL, driver);
    }
    
    @AfterMethod
	public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testLogin(){
      loginPage = loginPage.withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();                 

      AssertJUnit.assertTrue(loginPage.isLoggedIn());
    }    
}