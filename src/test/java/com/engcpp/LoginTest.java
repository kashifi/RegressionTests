package com.engcpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author engcpp
 */
public class LoginTest {
    private Login loginPage;
    private WebDriver driver;
    
    @Before
    public void setUp() {   
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
/*
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        capabilities.setCapability("chrome.binary", "chromedriver.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
*/       
        driver = new ChromeDriver();
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