package com.engcpp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.engcpp.IVALReport.PropertyMenu;
import com.engcpp.utils.Constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author engcpp
 * 
 * @ Changed by: Kashifi - Converted to the TESTNG class from the JUnit  
 */
public class IVALReportsTest {
    private WebDriver driver;    
    private Login login;
    
    @BeforeMethod
	public void setUp() {
      driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      login = new Login(Constants.IQC_URL, driver)
        .withUsername(Constants.USERNAME)
        .withPassword(Constants.PASSWORD)
        .login();
    }
    
    @AfterMethod
	public void tearDown() {
        driver.quit();
    }       
    
    @Test
    public void testIVALReport() throws InterruptedException{
        
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
