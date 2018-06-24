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

	public class AdvBizreports extends SeleniumTest{
	private String commercialrpt;
		
	  @FindBy(how= How.ID, using="companySearchInput")
	  @CacheLookup
	  private WebElement commerptInput;
	  
	  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/form/div/div[2]/div[2]/button")
	  @CacheLookup
	  private WebElement goButton;  
	  
	  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/strong/a";
	  
	  public AdvBizreports(WebDriver selenium){
	    super(selenium);
	    PageFactory.initElements(selenium, this);   
	  }  
	  
	  public AdvBizreports withCommrpt(String Commreport){
	    this.commercialrpt = Commreport;
	    return this;
	  }  

	  /* Working with the business report Menu at first step ............... */
	  
	  public AdvBizrptMenu submit(){
		
		sleep();
		commerptInput.sendKeys(this.commercialrpt);    
		goButton.click();
	      
	    waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("company-search-detail")));
	    
	    if (selenium.findElements(By.className("company-search-detail")).size()>0) {      
	      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
	      waitClickable(firstElement);
	      firstElement.click();
	      
	      return new AdvBizrptMenu(selenium);
	    }            
	    
	     return null;
	  }

	  /* Function to navigate to the Business report after selection .................  */
	  
	  /*Selecting a Standard Business Report ........ */ 
	  
	  static class AdvBizrptMenu extends SeleniumTest {    
	    @FindBy(how=How.XPATH, using=" //*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[1]/div")
	    @CacheLookup
	    private WebElement Adv_ReportLink;
	      
	    public AdvBizrptMenu(WebDriver driver){      
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }
	    
	    public AdvBizrptForm SelectBizrpt(){
	      waitFor(ExpectedConditions.visibilityOf(Adv_ReportLink));
	      Adv_ReportLink.click(); 
	      return new AdvBizrptForm(selenium);
	    }

	  }
	  	  
	  /* Final submission for extracting the Advanced Business Report ............. */
	    
	  static class AdvBizrptForm extends SeleniumTest {   
				
		// Customer Reference Input field 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[2]/input")
		@CacheLookup
		private WebElement Biz_Rpt_Custref; 
		
		// Business Report Enquiry Type 
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/div")
		@CacheLookup
		private WebElement Biz_Rpt_Enqtype;
		
		
		// Business Report Account Type 	
		@FindBy(how= How.XPATH, using=".//*[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/div")
		@CacheLookup
		private WebElement Biz_Rpt_Acctype;

		// Business Report Amount 
		@FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[5]/input")
		@CacheLookup
		private WebElement Biz_Rpt_Amount;
		
		
		// Business Report Submit Button 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[9]/button")
	    @CacheLookup
	    private WebElement Biz_Rpt_Submit;    
	  
	    /** *********  Fields needed for Advanced Reports ***************** **/
	      
	    // Check box for directors information (Advanced reports) 
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[1]/div[2]/label/input")
	    @CacheLookup
	    private WebElement BizRpt_DIR_Checkbox;    
	    
	    // Loading process ................
	    @FindBy(how= How.CLASS_NAME, using="loading-wheel")
	    @CacheLookup
	    private WebElement BizRpt_Chkbox_loader; 
		
	    
	    // Date of Birth - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[4]/div[2]/input")
	    @CacheLookup
	    private WebElement DOB_input;    
	    
	    
	    // Gender Field - Advanced Reports (Director)  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[5]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement Gender_input;    
	    
	    
		 // Director's Affiliation  
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[10]/div[2]/div[2]/div[2]/label/input")
	    @CacheLookup
	    private WebElement Dir_Aff_input;    
	    
	    
	    // Access Purpose Field   
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[1]/div[2]/div/input[1]")
	    @CacheLookup
	    private WebElement Acc_purposeinput;    
	    
	    // Privacy Code Consent    
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[2]/div[2]/label/input")
	    @CacheLookup
	    private WebElement Privacy_Cons_Chkbox;    
	    
	    
	    public AdvBizrptForm(WebDriver driver){
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }      
	      
	    public boolean submit() throws InterruptedException{	    	
	    	
	      waitFor(ExpectedConditions.visibilityOf(BizRpt_DIR_Checkbox));	
	     	      
	      Biz_Rpt_Custref.clear();
	      Biz_Rpt_Custref.sendKeys("QA");
	    
	      Biz_Rpt_Enqtype.click(); 
	      Biz_Rpt_Enqtype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/ul/li[3]/a/span")).click();
	   	
	      Biz_Rpt_Acctype.click();
	      Biz_Rpt_Acctype.findElement(By.xpath("//div[@id='home-tabs-pane-0']/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/ul/li[4]/a/span")).click();
	      	      
	      Biz_Rpt_Amount.clear();
	      Biz_Rpt_Amount.sendKeys("101");
	      
	      /* Click on one of the director's for advance reports ............. */
	      
	      BizRpt_DIR_Checkbox.click();
	      
	      	// BizRpt_DIR_Checkbox.findElement(By.name("directors.0.selected")).click();
	      
	      	// if (BizRpt_DIR_Checkbox.findElement(By.name("directors.0.selected")).isSelected() == true) 
	      	// {
	    	
	      	DOB_input.clear();
	      	DOB_input.sendKeys("01/01/1980");
    	  
	      	Gender_input.clear();
	      	Gender_input.findElement(By.xpath("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[5]/div[2]/ul/li[1]/a/span")).click();
	    	  
	    	Dir_Aff_input.click();
	    	  
	    	Acc_purposeinput.clear();
	    	Acc_purposeinput.findElement(By.xpath("//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[8]/div[2]/div/div[11]/div[2]/div[1]/div[2]/ul/li[12]/a/div/strong")).click();
	    	
	    	Privacy_Cons_Chkbox.click();;
	    	
	      
	      waitClickable(Biz_Rpt_Submit);
	      Biz_Rpt_Submit.click();
	      
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
	
	

