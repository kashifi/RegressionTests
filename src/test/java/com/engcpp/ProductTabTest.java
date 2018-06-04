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
public class ProductTabTest {
    private Login loginPage;
    private WebDriver driver;    
    
    @Before
    public void setUp() {
      driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
      
      loginPage = new Login(Constants.IQC_URL, driver)   
        .withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();
            
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }       
    
    @Test
    public void testPropertyTab(){
      ProductsTab tab = new ProductsTab(driver);        
      Assert.assertTrue(tab.propertyClick());        
    }
    
    @Test
    public void testBusinessTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      Assert.assertTrue(tab.businessClick());        
    }
    
    @Test
    public void testVehicleTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      Assert.assertTrue(tab.vehicleClick());        
    }  

    @Test
    public void testIndividualTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      Assert.assertTrue(tab.individualsClick());        
    }
 
}
