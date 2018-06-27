
package com.engcpp.individual;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engcpp.Login;
import com.engcpp.ProductsTab;
import com.engcpp.individual.ScoreplusReport.IndividualCreditMenu;
import com.engcpp.individual.utils.Individual;
import com.engcpp.individual.utils.Reference;
import com.engcpp.individual.utils.ReportOptions;
import com.engcpp.utils.Address;
import com.engcpp.utils.Constants;
import com.engcpp.utils.DriverFactory;

/**
 *
 * @author engcpp
 */
public class ScoreplusReportTest {
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
    
    @Test
    public void testIScorePlusReport() throws InterruptedException{
        
      if (new ProductsTab(driver).individualsClick()){
        
        IndividualCreditMenu menu = new ScoreplusReport(driver)
          .withIndividual(new Individual()
              .withGivenName("Papa")
              .withFamilyName("Smurf")
              .withGender("Male")
              .withDateOfBirth("10/10/1950")
              .withAmount("101")
              .withAccount("CREDIT CARD")
          
              .withAddress(new Address()
            		  .withNumber("15")
            		  .withStreet("Hopetoun")
            		  .withStreetType("Street")
            		  .withSuburb("Freemans Bay")
            		  .useLookup(true))
              .withPreviousAddresses(new Address()
            		  .withNumber("10")
            		  .withStreet("Browns bay")
            		  .withStreetType("Street")
            		  .withSuburb("Freemans Bay")
            		  .useLookup(true))
              
              .withPreviousAddresses(new Address()
            		  .withNumber("10")
            		  .withStreet("Hopetoun")
            		  .withStreetType("Street")
            		  .withSuburb("Freemans Bay")
            		  .useLookup(true))

              .withReference(new Reference("QA")))  
          .submit();
                     
        
        AssertJUnit.assertNotNull(menu);

        if (menu != null) {
          boolean reportOk = menu.chooseScoreplus()
                                 .withReportOptions(new ReportOptions()
                                    .withAccessPurposeCode("Request of credit information reports for consumer")
                                    .withPrivateCodeConsent(true)
                                    .withDirectorshipAffiliationSearch(true))
                                 .submit();
          
          AssertJUnit.assertTrue(reportOk);  

          login.logout();          
        }
      }
    }    
}
