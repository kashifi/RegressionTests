package com.kashifi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kashifi.Bizreports;
import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.kashifi.Bizreports.BizrptMenu;
import com.engcpp.utils.Constants;

public class Std_BizReportTest {
	
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
	        //driver.quit();
	    }       
	    
	    @Test
	    public void testBizReport() throws InterruptedException{
	        
	      if (new ProductsTab(driver).businessClick()){
	        
	    	  BizrptMenu menu = new Bizreports(driver)
	          .withCommrpt("IQ Solutions")
	          .submit();
	          
	        AssertJUnit.assertNotNull(menu);
	        if (menu != null) {
	          boolean reportOk = menu.SelectBizrpt().submit();            
	          
	          AssertJUnit.assertTrue(reportOk);  

	          login.logout();          
	        }
	      }
	    }    

}
