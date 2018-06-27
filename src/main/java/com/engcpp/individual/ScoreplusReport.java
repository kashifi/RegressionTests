package com.engcpp.individual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.engcpp.SeleniumTest;
import com.engcpp.individual.utils.Individual;
import com.engcpp.individual.utils.Reference;
import com.engcpp.individual.utils.ReportOptions;
import com.engcpp.utils.Address;

/**
 *
 * @author engcpp
 */
public class ScoreplusReport extends SeleniumTest{
  private Individual individual;
          
  @FindBy(how= How.XPATH, using="//*[@id=\"givenName\"]")
  @CacheLookup
  private WebElement givenNameInput;

  @FindBy(how= How.XPATH, using="//*[@id=\"familyName\"]")
  @CacheLookup
  private WebElement familyNameInput;
    
  @FindBy(how= How.XPATH, using="//*[@id=\"dateOfBirthInput\"]")
  @CacheLookup
  private WebElement dobInput;  
  
  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[2]/div/div/div/form/div/div[2]/div[2]/button")
  @CacheLookup
  private WebElement goButton;  
  
  
  public ScoreplusReport(WebDriver selenium){
    super(selenium);
    PageFactory.initElements(selenium, this);   
  }  
  
  public ScoreplusReport withIndividual(Individual individual){
    this.individual = individual;
    return this;
  }  

  public IndividualCreditMenu submit(){
    waitClickable(goButton);
    
    givenNameInput.sendKeys(this.individual.getGivenName());
    familyNameInput.sendKeys(this.individual.getFamilyName());
    dobInput.sendKeys(this.individual.getDateOfBirth());
    goButton.click();
          
    IndividualCreditMenu menu = new IndividualCreditMenu(selenium)
      .withIndividual(individual);
        
    return menu.isLoaded()? menu : null;
  }

  public static class IndividualCreditMenu extends SeleniumTest {    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[1]/div/div/div/a[1]")
    @CacheLookup
    private WebElement scoreplusLink;
    
  //*[@id="app"]/div/div/div[1]/div[2]/div[1]/div[2]/div/ul/li[1]/div/div[2]/div/div/a[1]
    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[1]/div/div/div/a[2]")
    @CacheLookup
    private WebElement mojOverdueFinesLink;          
    
    private Individual individual;
    
    public IndividualCreditMenu(WebDriver driver){      
      super(driver);
      PageFactory.initElements(selenium, this);
    }
    
    public boolean isLoaded(){
      String panel = "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]";
      return this.selenium.findElements(By.xpath(panel)).size()>0;
    } 
    
    public IndividualForm chooseMojOverdueFines(){
      mojOverdueFinesLink.click(); 
      return new IndividualForm(selenium).withIndividual(individual);
    }
    
    public IndividualForm chooseScoreplus(){
      scoreplusLink.click(); 
      return new IndividualForm(selenium).withIndividual(individual);
    }
    
    public IndividualCreditMenu withIndividual(Individual individual){
       this.individual = individual;
       return this;
    }    
  }      
  
  public static class IndividualForm extends SeleniumTest {    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[2]/button")
    @CacheLookup
    private WebElement submitButton;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[3]/div[4]/div[2]/div/input[1]")
    private WebElement gender;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"licenceNumber\"]")
    private WebElement driverLicence;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"licenceVersion\"]")
    private WebElement licenceVersion;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"employer\"]")
    private WebElement employeer;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"amount\"]")
    private WebElement amount;    
    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[7]/div[2]/div[2]/div/input[1]")
    private WebElement accountType;        
    
    private Individual individual;
    
    private ReportOptions options;
       
    
    public IndividualForm(WebDriver driver){
      super(driver);
      PageFactory.initElements(selenium, this);
    }      

    public IndividualForm withReportOptions(ReportOptions options){
       this.options = options;
       return this;
    }   
    
    public IndividualForm withIndividual(Individual individual){
       this.individual = individual;       
       return this;
    }
    
    public boolean submit(){
      try {
    	    waitFor(ExpectedConditions.visibilityOfAllElements(gender));
            if (individual.getGender() != null )                
                gender.sendKeys(individual.getGender());
            
            if (individual.getDriverLicence() != null)
                driverLicence.sendKeys(individual.getDriverLicence());
            
            if (individual.getLicenceVersion() != null)
                licenceVersion.sendKeys(individual.getLicenceVersion());
            
            if (individual.getEmployer() != null)
                employeer.sendKeys(individual.getEmployer());
            
            if (individual.getAmount() != null)
                amount.sendKeys(individual.getAmount());
            
            if (individual.getAccount() != null)
                accountType.sendKeys(individual.getAccount());

           
             fillAddress(new AddressForm(selenium,
            		 new AddressXpath()
            		 .withFindAddress("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/div/input[1]")
            		 .withStreetName("//*[@id=\"addressStName\"]")
            		 .withNumber("//*[@id=\"addressStNo\"]")
            		 .withStreetSuburb("//*[@id=\"addressSuburb\"]")
            		 .withStreetType("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[6]/div[2]/div/input[1]")
            		 .withCity("//*[@id=\"addressCity\"]")
            		 .withELEMENT_1_XPATH("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/ul/li[1]/a")), individual.getAddress());                                       
           
             if (individual.getPreviousAddresses().length > 0 )
               fillAddress(new AddressForm(selenium,
            		 new AddressXpath()
              		 .withFindAddress("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[5]/div[2]/div[2]/div[1]/div[1]/div/input[1]")
              		 .withStreetName("//*[@id=\"addressStName\"]")
              		 .withNumber("//*[@id=\"addressStNo\"]")
              		 .withStreetSuburb("//*[@id=\"addressSuburb\"]")
              		 .withStreetType("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[6]/div[2]/div/input[1]")
              		 .withCity("//*[@id=\"addressCity\"]")
              		 .withELEMENT_1_XPATH("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[5]/div[2]/div[2]/div[1]/div[1]/ul/li[1]/a")), individual.getPreviousAddresses()[0]);
            
             if (individual.getPreviousAddresses().length > 1 )
                 fillAddress(new AddressForm(selenium,
                		 new AddressXpath()
                  		 .withFindAddress("//*[@id=\"home-tabs-pane-0\"]/div/div/div[3]/div[2]/div/div/div/form/div/div[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div/input[1]")
                  		 .withStreetName("//*[@id=\"addressStName\"]")
                  		 .withNumber("//*[@id=\"addressStNo\"]")
                  		 .withStreetSuburb("//*[@id=\"addressSuburb\"]")
                  		 .withStreetType("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[6]/div[2]/div/input[1]")
                  		 .withCity("//*[@id=\"addressCity\"]")
                  		 .withELEMENT_1_XPATH("//*[@id=\"home-tabs-pane-0\"]/div/div/div[3]/div[2]/div/div/div/form/div/div[1]/div[5]/div[2]/div[2]/div[2]/div[1]/ul/li[1]/a")), individual.getPreviousAddresses()[1]);

            
            new ReportReferenceForm(selenium)
                 .withRefernece(individual.getReference());

            new ReportOptionsForm(selenium)
                 .withReportOptions(options);
            
            waitClickable(submitButton);
            submitButton.click();     
            
            // Check if the report is loaded by verifying if specific parts of the report are loaded ... 
            // * Idea: We can check specific sub-reports
            
          waitLoader();
  	      waitForPresenceOf(By.className("report-card-header"));
  	      waitForPresenceOf(By.className("report-card-header-data"));
  	      waitForPresenceOf(By.cssSelector("div.report-card-header-title"));
  	        
  	      //waitForPresenceOf(By.className("report-card-header"));
            return true;
      }catch (Exception e){
            return false;
      }
    }
    
    void fillAddress(AddressForm addressForm, Address address){	  
  	  if (address.isLookup())	  
  		 addressForm.searchAddress(address.getStreet());
        else
      	 addressForm.withAddress(address);	  
    }    
  }   
  
  
  static class ReportReferenceForm extends SeleniumTest {
      
    @FindBy(how= How.XPATH, using="//*[@id=\"jointAccount\"]")
    private WebElement jointAccountInput;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"guarantor\"]")
    private WebElement guarantorInput;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"clientReference\"]")
    private WebElement referenceInput;
    
    public ReportReferenceForm(WebDriver driver){
        super(driver);
        PageFactory.initElements(selenium, this);
    }    
    
    public boolean  withRefernece(Reference reference){
      try {
         if (reference.isJointAccount())
             jointAccountInput.click();

          if (reference.isGuarantor())
              guarantorInput.click(); 

          referenceInput.sendKeys(reference.getName());
        
          return true;
      } catch (Exception e){
          return false;
      }  
    }    
  }
  
  static class ReportOptionsForm extends SeleniumTest {
      
    @FindBy(how= How.XPATH, using="//*[@value=\"propertyOwnershipVerification\"]")
    private WebElement propertyOwnership;
    
    @FindBy(how= How.XPATH, using="//*[@value=\"mojFinesSearch\"]")
    private WebElement mojFinesSearch;
    
    @FindBy(how= How.XPATH, using="//*[@value=\"licenceCheck\"]")
    private WebElement licenceCheck;
    
    @FindBy(how= How.XPATH, using="//*[@value=\"directorshipAffiliationSearch\"]")
    private WebElement directorshipAffiliation;
    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[10]/div[2]/div[2]/div/div/div/div/input[1]")
    private WebElement accessPurposeCode;

    @FindBy(how= How.XPATH, using="//*[@id=\"consent\"]")
    private WebElement privacyCodeConsent;    
  
  
    public ReportOptionsForm(WebDriver driver){
        super(driver);
        PageFactory.initElements(selenium, this);
    }
  
    public boolean withReportOptions(ReportOptions iro){
      try { 

            waitClickable(propertyOwnership);
            waitClickable(mojFinesSearch);
            waitClickable(licenceCheck);
            waitClickable(directorshipAffiliation);
            waitClickable(privacyCodeConsent);
          
            if (iro.isPropertyOwnershipVerification())
                propertyOwnership.click();

            if (iro.isMojOverdueFineSearch())
               mojFinesSearch.click();        

            if (iro.isLicenceCheck())
                licenceCheck.click();

            if (iro.isDirectorshipAffiliationSearch())
                directorshipAffiliation.click();

            accessPurposeCode.sendKeys(iro.getAccessPurposeCode());
           
            if (iro.isPrivateCodeConsent())  
            	sleep();
            	privacyCodeConsent.click();
            
            return true;
        } catch (Exception e){
            return false;
        }
    }
  }

  static class AddressForm extends SeleniumTest {      	 
    //@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/div/input[1]")
    
    private WebElement findAddress;

    //@FindBy(how= How.XPATH, using="//*[@id=\"addressStNo\"]")    
    private WebElement number;

    //@FindBy(how= How.XPATH, using="//*[@id=\"addressStName\"]")    
    private WebElement streetName;

    //@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[2]/div[1]/div[6]/div[2]/div/input[1]")    
    private WebElement streetType;        
    
    //@FindBy(how= How.XPATH, using="//*[@id=\"addressSuburb\"]")    
    private WebElement streetSuburb;
    
    //@FindBy(how= How.XPATH, using="//*[@id=\"addressCity\"]")    
    private WebElement city;
    
    private static String ELEMENT_1_XPATH;
    //private static String ELEMENT_1_XPATH = "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/ul/li[1]/a";
        
    public AddressForm(WebDriver driver, AddressXpath xpath) {
        super(driver);
        
        findAddress = driver.findElement(By.xpath(xpath.findAddress));
        number = driver.findElement(By.xpath(xpath.number));
        streetName = driver.findElement(By.xpath(xpath.streetName));
        streetType = driver.findElement(By.xpath(xpath.streetType));
        streetSuburb = driver.findElement(By.xpath(xpath.streetSuburb));
        city = driver.findElement(By.xpath(xpath.city));
        ELEMENT_1_XPATH = xpath.ELEMENT_1_XPATH;
     
    }
    
    public boolean withAddress(Address address) {
      try {
        
        if (address.getNumber() != null)
            number.sendKeys(address.getNumber());
        
        if (address.getStreet() != null)
            streetName.sendKeys(address.getStreet());
        
        if (address.getSuburb() != null)
            streetSuburb.sendKeys(address.getSuburb());
        
        if (address.getStreetType() != null)
            streetType.sendKeys(address.getStreetType());
        
        if (address.getCity() != null)
            city.sendKeys(address.getCity());
        
      } catch (Exception e){
        return false;
      }
        
      return true;
    }
    
    public boolean searchAddress(String address) {      
      
      findAddress.sendKeys(address);
      sleep();     
      //waitForPresenceOf(By.xpath("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/ul"));
                 
      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
      
      if (firstElement == null)
          return false;
      
      waitClickable(firstElement);
      firstElement.click();             
      
      return true;
    }             
  }
 
  static class AddressXpath{
	    private String findAddress;

	    private String number;

	    private String streetName;

	    private String streetType;        

	    private String streetSuburb;
	    
	    private String city;
	    
	    private String ELEMENT_1_XPATH;

		public String getFindAddress() {
			return findAddress;
		}

		public AddressXpath withFindAddress(String findAddress) {
			this.findAddress = findAddress;
			return this;
		}

		public String getNumber() {
			return number;
		}

		public AddressXpath withNumber(String number) {
			this.number = number;
			return this;
		}

		public String getStreetName() {
			return streetName;
		}

		public AddressXpath withStreetName(String streetName) {
			this.streetName = streetName;
			return this;
		}

		public String getStreetType() {
			return streetType;
		}

		public AddressXpath withStreetType(String streetType) {
			this.streetType = streetType;
			return this;
		}

		public String getStreetSuburb() {
			return streetSuburb;
		}

		public AddressXpath withStreetSuburb(String streetSuburb) {
			this.streetSuburb = streetSuburb;
			return this;
		}

		public String getCity() {
			return city;
		}

		public AddressXpath withCity(String city) {
			this.city = city;
			return this;
		}

		public String getELEMENT_1_XPATH() {
			return ELEMENT_1_XPATH;
		}

		public AddressXpath withELEMENT_1_XPATH(String eLEMENT_1_XPATH) {
			ELEMENT_1_XPATH = eLEMENT_1_XPATH;
			return this;
		}	    	   
  }
  
}
