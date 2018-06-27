package com.kashifi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kashifi.advBizreports.advBizrptMenu;
import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;

public class advBizRptTest {

	private WebDriver driver;
	private Login login;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.newChromeInstance();
		login = new Login(Constants.IQC_URL, driver).withUsername(Constants.USERNAME).withPassword(Constants.PASSWORD)
				.login();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testBizReport() throws InterruptedException {

		if (new ProductsTab(driver).businessClick()) {

			advBizrptMenu menu = new advBizreports(driver).withCommrpt("YEASTIE BOYS LIMITED").submit();

			AssertJUnit.assertNotNull(menu);
			if (menu != null) {
				boolean reportOk = menu.SelectBizrpt().submit();

				AssertJUnit.assertTrue(reportOk);

				login.logout();
			}
		}
	}

}
