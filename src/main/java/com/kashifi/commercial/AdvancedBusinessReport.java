package com.kashifi.commercial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.engcpp.SeleniumTest;
import com.engcpp.individual.utils.ReportOptions;;;

	/**
	 * @author Kashif Iqbal 
	 * @category - Advanced Business Reports
	 */

	public class AdvancedBusinessReport extends SeleniumTest{
	private String commercialrpt;
		
	  @FindBy(how= How.ID, using="companySearchInput")
	  @CacheLookup
	  private WebElement commerptInput;
	  
	  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/form/div/div[2]/div[2]/button")
	  @CacheLookup
	  private WebElement goButton;  
	  
	  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/strong/a";
	  
	  public AdvancedBusinessReport(WebDriver selenium){
	    super(selenium);
	    PageFactory.initElements(selenium, this);   
	  }  
	  
	  public AdvancedBusinessReport withCommrpt(String Commreport){
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
	    private WebElement advRptLink;
	      
	    public advBizrptMenu(WebDriver driver){      
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }
	    
	    public advBizrptForm SelectBizrpt(){
	      waitFor(ExpectedConditions.visibilityOf(advRptLink));
	      advRptLink.click(); 
	      return new advBizrptForm(selenium);
	    }

	  }
	  
	  static class ReportOptionsForm extends SeleniumTest {
	      
		   @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[10]/div[2]/div[1]/div[2]/label/input")
		    private WebElement mojFinesSearch;
		    
		    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[10]/div[2]/div[2]/div[2]/label/input")
		    private WebElement directorshipAffiliation;
		    
		    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]")
		    private WebElement accessPurposeCode;
		    
		    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[11]/div[2]/div[2]/div[2]/label/input")
		    private WebElement privacyCodeConsent;    
		  
		    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]")		    
		    private WebElement bodyElement;
		    
		    public ReportOptionsForm(WebDriver driver){
		        super(driver);
		        PageFactory.initElements(selenium, this);
		    }
		  
		    public boolean withReportOptions(ReportOptions iro){
		      try { 

		            waitClickable(mojFinesSearch);
		            waitClickable(directorshipAffiliation);
		            waitClickable(privacyCodeConsent);
		          
		        //   if (iro.isMojOverdueFineSearch())
		        //       mojFinesSearch.click();        

		            if (iro.isDirectorshipAffiliationSearch())
		               directorshipAffiliation.click();		           
		            		            
		            if (iro.isPrivateCodeConsent())  
		               	privacyCodeConsent.click();
		            
		            if (iro.getAccessPurposeCode()!=null) {
		               accessPurposeCode.sendKeys(iro.getAccessPurposeCode());
		     	      WebElement option = selenium.findElement(By.partialLinkText(iro.getAccessPurposeCode()));
		    	      waitClickable(option);
		    	      option.click();
		    	      		               
		            }		            
		            
		            return true;
		        } catch (Exception e){
		            return false;
		        }
		    }
		  }
	  	  
	  /****************** Advanced Business report Web Elements and form  ............. */
	    
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
		
		// For QA:::::::::         "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[9]/button"
		
		// Business Report Submit Button 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[9]/button")
	    @CacheLookup
	    private WebElement bizrptSubmit;   
	    
	  
	    /** *********  Fields needed for Advanced Reports ***************** **/
	     // For QA:::  //*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[1]/div[2]/label/input
	    
	    // Check box for directors information (Advanced reports) 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[1]/div[2]/label/input")
	    @CacheLookup
	    private WebElement bizrptDirChkbox;    
	      
	    // Loading process ................
	    @FindBy(how= How.CLASS_NAME, using="loading-wheel")
	    @CacheLookup
	    private WebElement bizrptChkboxLOAD; 
		
	    
	    // For QA:: "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[4]/div[2]/input"
	    
	    // Date of Birth - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[4]/div[2]/input")
	    @CacheLookup
	    private WebElement inputDOB;    
	    
	    
	    // For QA::: "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[5]/div[2]/div/input[1]"
	    
	    // Gender Field - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[5]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement inputGender;    
	    
	    // For QA::::::    "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[10]/div[2]/div[2]/div[2]/label/input"
		 // Director's Affiliation  
	  //  @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[10]/div[2]/div[2]/div[2]/label/input")
	   // @CacheLookup
	   // private WebElement dirAff;    
	       
	    /*
	     * 
	     * For QA
	     // Access Purpose Field   
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement accPurpose;    
	    
	    */
	    
	    // For CTA
	    // Access Purpose Field   
	    //*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]
	 /*
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement accPurpose;  
	    
	    // For QA::: "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[2]/div[2]/label/input"
	    // Privacy Code Consent    
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[7]/div[2]/div/div[11]/div[2]/div[2]/div[2]/label/input")
	    @CacheLookup
	    private WebElement privacyConsChkbox;    
	    
	   */ 
	    public advBizrptForm(WebDriver driver){
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }      
	    
	    private ReportOptions options;
	    
	    public advBizrptForm withReportOptions(ReportOptions options){
	        this.options = options;
	        return this;
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
	    	
	      inputDOB.clear();
	      inputDOB.sendKeys("01/01/1980");
    	
	      inputGender.sendKeys("Male");
	      WebElement genderOption = selenium.findElement(By.partialLinkText("Male"));
	      waitClickable(genderOption);
	      genderOption.click();
	      
	      /* Calling the function for Report options to be select ............ and ACT accordingly */
	      
	      new ReportOptionsForm(selenium)
          .withReportOptions(options);
	      
	      /* ************** Finally clicking the Submit button ...............*/
	      
	      waitClickable(bizrptSubmit);
	      bizrptSubmit.click();
	      
	      /* ************** Waiting for the report elements to be loaded ...............*/
	      
	      try {
			waitLoader();	      
			  waitForPresenceOf(By.className("report-card-header"));
			  waitForPresenceOf(By.className("report-card-header-data"));
			  waitForPresenceOf(By.cssSelector("div.report-card-header-title"));
			      waitForPresenceOf(By.className("home-tab-title"));
			      System.out.println("Consumer Credit Report is also available now and can be downloaded ..... !!! ");
			      System.out.println("Advanced Business Report has been successfully generated ........... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	          
	      return selenium.findElements(By.className("workspace-hub-tiles")).size()>0;
	      
	    }
    }  
}
	
	

