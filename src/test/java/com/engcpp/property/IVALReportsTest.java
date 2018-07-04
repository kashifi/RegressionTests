package com.engcpp.property;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.engcpp.property.IVALReport.PropertyMenu;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author engcpp
 */
public class IVALReportsTest {
    private WebDriver driver;    
    private Login login;
    
    @BeforeMethod
	public void setUp() {
      driver = DriverFactory.newChromeInstance();
    	
      login = new Login(Constants.IQC_URL, driver)
        .withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();
    }
    
    @AfterMethod
	public void tearDown() {
        driver.quit();
    }       
    
    @Test(priority=2, enabled=true)
    public void iVALPropertyReport() throws InterruptedException{
        
      if (new ProductsTab(driver).propertyClick()){
        
       PropertyMenu menu = new IVALReport(driver)
         .withProperty("Bucklands")
          .submit();
        
        AssertJUnit.assertNotNull(menu);

        if (menu != null) {
          boolean reportOk = menu.chooseIval().submit();            
          
          AssertJUnit.assertTrue(reportOk);  

          login.logout();          
        }
      }
    }    
}
