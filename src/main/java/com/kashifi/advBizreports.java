package com.kashifi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.engcpp.SeleniumTest;

	/**
	 * @author Kashif Iqbal (Advanced Business Reports)
	 */

	public class advBizreports extends SeleniumTest{
	private String commercialrpt;
		
	  @FindBy(how= How.ID, using="companySearchInput")
	  @CacheLookup
	  private WebElement commerptInput;
	  
	  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/form/div/div[2]/div[2]/button")
	  @CacheLookup
	  private WebElement goButton;  
	  
	  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/strong/a";
	  
	  public advBizreports(WebDriver selenium){
	    super(selenium);
	    PageFactory.initElements(selenium, this);   
	  }  
	  
	  public advBizreports withCommrpt(String Commreport){
	    this.commercialrpt = Commreport;
	    return this;
	  }  

	  /* Working with the business report Menu at first step ............... */
	  
	  public advBizrptMenu submit(){
		
		sleep();
		commerptInput.sendKeys(this.commercialrpt);    
		goButton.click();
	      
	    waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("company-search-detail")));
	    
	    if (selenium.findElements(By.className("company-search-detail")).size()>0) {      
	      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
	      waitClickable(firstElement);
	      firstElement.click();
	      
	      return new advBizrptMenu(selenium);
	    }            
	    
	     return null;
	  }

	  /* Function to navigate to the Business report after selection .................  */
	  
	  /*Selecting a Standard Business Report ........ */ 
	  
	  static class advBizrptMenu extends SeleniumTest {    
	    @FindBy(how=How.XPATH, using=" //*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[1]/div")
	    @CacheLookup
	    private WebElement Adv_ReportLink;
	      
	    public advBizrptMenu(WebDriver driver){      
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }
	    
	    public advBizrptForm SelectBizrpt(){
	      waitFor(ExpectedConditions.visibilityOf(Adv_ReportLink));
	      Adv_ReportLink.click(); 
	      return new advBizrptForm(selenium);
	    }

	  }
	  	  
	  /* Final submission for extracting the Advanced Business Report ............. */
	    
	  static class advBizrptForm extends SeleniumTest {   
				
		// Customer Reference Input field 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[2]/input")
		@CacheLookup
		private WebElement bizrptCustref; 
		
		// Business Report Enquiry Type 
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/div")
		@CacheLookup
		private WebElement bizrptEnqtype;
		
		
		// Business Report Account Type 	
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/div")
		@CacheLookup
		private WebElement bizrptAcctype;

		// Business Report Amount 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[5]/input")
		@CacheLookup
		private WebElement bizrptAmount;
		
		
		// Business Report Submit Button 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[9]/button")
	    @CacheLookup
	    private WebElement bizrptSubmit;    
	  
	    /** *********  Fields needed for Advanced Reports ***************** **/
	      
	    // Check box for directors information (Advanced reports) 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[1]/div[2]/label/input")
	    @CacheLookup
	    private WebElement bizrptDirChkbox;    
	    
	    // Loading process ................
	    @FindBy(how= How.CLASS_NAME, using="loading-wheel")
	    @CacheLookup
	    private WebElement bizrptChkboxLOAD; 
		
	    
	    // Date of Birth - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[4]/div[2]/input")
	    @CacheLookup
	    private WebElement inputDOB;    
	    
	    
	    // Gender Field - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[5]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement inputGender;    
	    
	    
		 // Director's Affiliation  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[10]/div[2]/div[2]/div[2]/label/input")
	    @CacheLookup
	    private WebElement dirAff;    
	    
	    
	    // Access Purpose Field   
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement accPurpose;    
	    
	    // Privacy Code Consent    
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[2]/div[2]/label/input")
	    @CacheLookup
	    private WebElement privacyConsChkbox;    
	    
	    
	    public advBizrptForm(WebDriver driver){
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }      
	      
	    public boolean submit() throws InterruptedException{	    	
	    	
	      waitFor(ExpectedConditions.visibilityOf(bizrptDirChkbox));	
	     	      
	      bizrptCustref.clear();
	      bizrptCustref.sendKeys("QA");
	    
	      bizrptEnqtype.click(); 
	      bizrptEnqtype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/ul/li[3]/a/span")).click();
	   	
	      bizrptAcctype.click();
	      bizrptAcctype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/ul/li[4]/a/span")).click();
	      	      
	      bizrptAmount.clear();
	      bizrptAmount.sendKeys("101");
	      
	      /* Click on one of the director's for advance reports ............. */
	      
	      bizrptDirChkbox.click();
	      
	      	// BizRpt_DIR_Checkbox.findElement(By.name("directors.0.selected")).click();
	      
	      	// if (BizRpt_DIR_Checkbox.findElement(By.name("directors.0.selected")).isSelected() == true) 
	      	// {
	    	
	      inputDOB.clear();
	      inputDOB.sendKeys("01/01/1980");
    	  
	      inputGender.clear();
	      inputGender.findElement(By.xpath("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[5]/div[2]/ul/li[1]/a/span")).click();
	    	  
	      dirAff.click();
	    	  
	      accPurpose.clear();
	      accPurpose.findElement(By.xpath("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[1]/div[2]/ul/li[12]/a/div/strong")).click();
	    	
	      privacyConsChkbox.click();
	      
	      waitClickable(bizrptSubmit);
	      bizrptSubmit.click();
	      
	      waitLoader();
	      waitForPresenceOf(By.className("report-card-header"));
	      waitForPresenceOf(By.className("report-card-header-data"));
	      waitForPresenceOf(By.cssSelector("div.report-card-header-title"));
	          waitForPresenceOf(By.className("home-tab-title"));
	          System.out.println("Consumer Credit Report is also available now and can be downloaded ..... !!! ");
	          System.out.println("Advanced Business Report has been successfully generated ........... ");
	          
	      return selenium.findElements(By.className("workspace-hub-tiles")).size()>0;
	      
	    }
    }  
}
	
	

