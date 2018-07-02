package com.engcpp;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;

/**
 *
 * @author engcpp
 * @Change by: Kashifi - Converted to the TestNG class to add it in the
 *         RegressionTest Suite
 */
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

	@Test(priority=0, enabled=true)
	public void Login_Logout() {
		loginPage = loginPage.withUsername(Constants.USERNAME).withPassword(Constants.PASSWORD).login();

		AssertJUnit.assertTrue(loginPage.isLoggedIn());
	}
}