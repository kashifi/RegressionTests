package com.engcpp;

import org.junit.After;
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
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromium-browser");

        driver = new ChromeDriver();
        driver.get("https://iqconnect.test.equifax.co.nz/");
        loginPage = new Login(driver);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testLogin(){
        loginPage.login();
    }    
}