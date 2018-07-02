package com.kashifi.commercial;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.engcpp.individual.utils.ReportOptions;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;
import com.kashifi.commercial.AdvancedBusinessReport.advBizrptMenu;

public class AdvancedBusinessReportTest {

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

	@Test(priority=4, enabled = true)
	public void AdvancedBusinessReport() throws InterruptedException {

		if (new ProductsTab(driver).businessClick()) {

			advBizrptMenu menu = new AdvancedBusinessReport(driver).withCommrpt("YEASTIE BOYS LIMITED").submit();

			AssertJUnit.assertNotNull(menu);
			if (menu != null) {
				boolean reportOk = menu.SelectBizrpt()
						.withReportOptions(new ReportOptions()
								.withAccessPurposeCode("For investigating a case of suspected insurance fraud")
								.withPrivateCodeConsent(true).withDirectorshipAffiliationSearch(true))
						.submit();

				AssertJUnit.assertTrue(reportOk);

				login.logout();
			}
		}
	}

}
