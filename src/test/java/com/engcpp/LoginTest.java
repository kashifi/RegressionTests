package com.engcpp;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.utils.Configuration;
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

	@Test(priority=1, enabled=true)
	public void Login_Logout() {
		Configuration config = Configuration.newInstance();
		loginPage = loginPage.withUsername(config.read(Configuration.USERNAME)).withPassword(config.read(Configuration.PASSWORD)).login();

		AssertJUnit.assertTrue(loginPage.isLoggedIn());
	}
}