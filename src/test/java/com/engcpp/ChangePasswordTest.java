package com.engcpp;

/**
* @author Kashifi
* 
*/

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;

public class ChangePasswordTest {
	
public class LoginTest {
	private Login loginPage;
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.newChromeInstance();
		loginPage = new Login(Constants.IQC_URL, driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void changePassword() {
		loginPage = loginPage
				.withUsername(Constants.USERNAME)
				.withPassword(Constants.PASSWORD)
				.login();
	
	}
}
	

}
