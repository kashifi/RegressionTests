package com.engcpp;

import com.engcpp.IVALReport.PropertyMenu;
import com.engcpp.utils.Constants;

import java.util.concurrent.TimeUnit;

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
public class IVALReportsTest {
    private WebDriver driver;    
    private Login login;
    
    @Before
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
    
    @After
    public void tearDown() {
        driver.quit();
    }       
    
    @Test
    public void testIVALReport() throws InterruptedException{
        
      if (new ProductsTab(driver).propertyClick()){
        
        PropertyMenu menu = new IVALReport(driver)
          .withProperty("Bucklands")
          .submit();
        
        Assert.assertNotNull(menu);
        //*[@id="home-tabs-pane-1"]/div/div/div[2]/div[2]/div/div/div
        if (menu != null) {
          boolean reportOk = menu.chooseIval().submit();            
          
          Assert.assertTrue(reportOk);  

          login.logout();          
        }
      }
    }    
}
