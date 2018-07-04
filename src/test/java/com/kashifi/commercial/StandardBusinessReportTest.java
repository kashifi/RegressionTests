package com.kashifi.commercial;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;
import com.kashifi.commercial.StandardBusinessReport.bizRptMenu;

public class StandardBusinessReportTest {

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

	@Test(priority=4, enabled=true)
	public void StandardBusinessReport() throws InterruptedException {

		if (new ProductsTab(driver).businessClick()) {

			bizRptMenu menu = new StandardBusinessReport(driver).withCommrpt("IQ Solutions").submit();

			AssertJUnit.assertNotNull(menu);
			if (menu != null) {
				boolean reportOk = menu.SelectBizrpt().submit();

				AssertJUnit.assertTrue(reportOk);

				login.logout();
			}
		}
	}

}
