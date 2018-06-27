package com.engcpp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author engcpp
 */
public class ProductTabTest {
    private Login loginPage;
    private WebDriver driver;    
    
    @BeforeMethod
	public void setUp() {
    
    driver = DriverFactory.newChromeInstance();
    loginPage = new Login(Constants.IQC_URL, driver)   
        .withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();
            
    }
    
    @AfterMethod
	public void tearDown() {
        driver.quit();
    }       
    
    @Test
    public void testPropertyTab(){
      ProductsTab tab = new ProductsTab(driver);        
      AssertJUnit.assertTrue(tab.propertyClick());        
    }
    
    @Test
    public void testBusinessTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      AssertJUnit.assertTrue(tab.businessClick());        
    }
    
    @Test(enabled = false)
    public void testVehicleTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      AssertJUnit.assertTrue(tab.vehicleClick());        
    }  

    @Test
    public void testIndividualTab(){            
      ProductsTab tab = new ProductsTab(driver);        
      AssertJUnit.assertTrue(tab.individualsClick());        
    }
 
}
