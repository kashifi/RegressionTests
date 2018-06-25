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
import com.kashifi.stdBizReport.bizRptForm;
import com.kashifi.stdBizReport.bizRptMenu;


public class scorePlus extends SeleniumTest{

	private String consRpt;
	// private static String enq_opt = "Non Credit Enquiry";
	// private static String acc_opt = "Other Non-Credit";
	
	  @FindBy(how= How.ID, using="companySearchInput")
	  @CacheLookup
	  private WebElement commRptInput;
	  
	  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/form/div/div[2]/div[2]/button")
	  @CacheLookup
	  private WebElement goButton;  
	  
	  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/strong/a";
	  
	  public scorePlus(WebDriver selenium){
	    super(selenium);
	    PageFactory.initElements(selenium, this);   
	  }  
	  
	  public scorePlus withConsrpt(String Consreport){
	    this.consRpt = Consreport;
	    return this;
	  }  

	  /* Working with the business report menu at first step ............... */
	  
	  public consRptMenu submit(){
		sleep();
	    
		commRptInput.sendKeys(this.consRpt);    
	    goButton.click();
	      
	    waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("company-search-detail")));
	    
	    if (selenium.findElements(By.className("company-search-detail")).size()>0) {      
	      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
	      waitClickable(firstElement);
	      firstElement.click();
	      
	      return new consRptMenu(selenium);
	    }            
	    
	     return null;
	  }

	  /* Function to navigate to the Business report after selection .................  */
	  
	  /*Selecting a Standard Business Report ........ */ 
	  
	  static class consRptMenu extends SeleniumTest {    
	    @FindBy(how=How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[2]")
	    @CacheLookup
	    private WebElement Std_ReportLink;
	      
	    public consRptMenu(WebDriver driver){      
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }
	    
	    public bizRptForm SelectBizrpt(){
	      waitFor(ExpectedConditions.visibilityOf(Std_ReportLink));
	      Std_ReportLink.click(); 
	      return new bizRptForm(selenium);
	    }
	  }
	  	  
	  /* Final submission for extracting the report ............. */
	    
	  static class bizRptForm extends SeleniumTest {   
				
		// Customer Reference Input field 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[2]/input")
		@CacheLookup
		private WebElement bizRptCustref; 
		
		// Business Report Enquiry Type 
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/div")
		@CacheLookup
		private WebElement bizRptEnqtype;
		
		
		// Business Report Account Type 	
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/div")
		@CacheLookup
		private WebElement bizRptAcctype;

		// Business Report Amount 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[5]/input")
		@CacheLookup
		private WebElement bizRptAmount;
		
		// Business Report Submit Button 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[6]/button")
	    @CacheLookup
	    private WebElement bizRptSubmit;    
	    
	    public bizRptForm(WebDriver driver){
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }      
	      
	    public boolean submit() throws InterruptedException{	    	
	      
	    	bizRptCustref.clear();
	    	bizRptCustref.sendKeys("QA");
	    
	      //  waitFor(ExpectedConditions.visibilityOf(Biz_Rpt_Enqtype));
	      // waitFor(ExpectedConditions.visibilityOf(Biz_Rpt_Acctype));
	     
	    	bizRptEnqtype.click(); 
	    	bizRptEnqtype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/ul/li[3]/a/span")).click();
	    	Thread.sleep(2000);
	      
	      // Select drpEnqType = new Select(Biz_Rpt_Enqtype);
	      // drpEnqType.selectByValue("Non Credit Enquiry");
	      //   drpEnqType.selectByIndex(3);
	      
	   //  if (Biz_Rpt_Enqtype.getText() == enq_opt) 
	    //   {
	    	
	    	bizRptAcctype.click();
	    	bizRptAcctype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/ul/li[4]/a/span")).click();
	    	// }
	     // else
	      //{
	   // 	  System.out.println("Enquiry Type is not selected Properly ......");
	     // }
	      	      
	    	bizRptAmount.clear();
	    	bizRptAmount.sendKeys("101");
	      
	      waitFor(ExpectedConditions.visibilityOf(bizRptSubmit));
	      waitClickable(bizRptSubmit);
	      bizRptSubmit.click();
	      	      
	      waitLoader();
	      waitForPresenceOf(By.className("report-card-header"));
	      waitForPresenceOf(By.className("report-card-header-data"));
	      waitForPresenceOf(By.cssSelector("div.report-card-header-title"));
	      	      
	      return selenium.findElements(By.className("workspace-hub-tiles")).size()>0;
	    }
    }  
	
}
