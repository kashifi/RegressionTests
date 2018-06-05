package com.kashifi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.engcpp.IVALReport;
import com.engcpp.SeleniumTest;

	/**
	 *
	 * @author Kashif Iqbal
	 */

	public class Bizreports extends SeleniumTest {
	private String commercialrpt;
	          
	  @FindBy(how= How.ID, using="companySearchInput")
	  @CacheLookup
	  private WebElement commerptInput;
	  
	  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/form/div/div[2]/div[2]/button")
	  @CacheLookup
	  private WebElement goButton;  
	  
	  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/strong/a";
	  
	  public Bizreports(WebDriver selenium){
	    super(selenium);
	    PageFactory.initElements(selenium, this);   
	  }  
	  
	  public Bizreports withCommrpt(String Commreport){
	    this.commercialrpt = Commreport;
	    return this;
	  }  

	  /* Working with the business report menu at first step ............... */
	  
	  public BizrptMenu submit(){
	    sleep();
	    
	    commerptInput.sendKeys(this.commercialrpt);    
	    goButton.click();
	    
	    /**********  Standard Business Report:   //*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[2]/div
	     ********** Advanced Business Report: //*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[1]/div
	     ****  Customer Ref: //*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[2]/input
	     *  Enq Type: 		//*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[3]/div[2]/div/input[1]
	     *  Acct Type: 		//*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[4]/div[2]/div/input[1]
	     *  Amount: 		//*[@id="home-tabs-pane-0"]/div/div[4]/div[3]/div[2]/div/div/div/form/div[5]/input
	     *  
	     *  */
	    
	    waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("company-search-detail")));
	    
	    if (selenium.findElements(By.className("company-search-detail")).size()>0) {      
	      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
	      waitClickable(firstElement);
	      firstElement.click();
	      
	      return new BizrptMenu(selenium);
	    }            
	    
	     return null;
	  }

	  /* Function to navigate to the Business report after selection .................  */
	  
	  /*Selecting a Standard Business Report ........ */ 
	  
	  static class BizrptMenu extends SeleniumTest {    
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[3]/div/div/div/a[2]/div")
	    @CacheLookup
	    private WebElement ReportLink;
	      
	    public BizrptMenu(WebDriver driver){      
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }
	    
	    public boolean isLoaded(){
	      String panel = "//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[1]";
	      return this.selenium.findElements(By.xpath(panel)).size()>0;
	    } 
	    
	    public IVALForm chooseIval(){
	      ivalLink.click(); 
	      return new IVALForm(selenium);
	    }
	  }
	  
	  /* Final submission for extracting the report ............. */ 
	  
	  static class IVALForm extends SeleniumTest {    
	    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div[2]/div/div/div/form/div/div[2]/button")
	    @CacheLookup
	    private WebElement ivalSubmit;    
	    
	    public IVALForm(WebDriver driver){
	      super(driver);
	      PageFactory.initElements(selenium, this);
	    }      
	      
	    public boolean submit(){
	      waitClickable(ivalSubmit);
	      ivalSubmit.click();     
	      
	      waitLoader();
	      waitForPresenceOf(By.className("report-card-header"));
	      waitForPresenceOf(By.className("report-page-content"));
	      waitForPresenceOf(By.className("report-disclaimer"));
	      
	      return selenium.findElements(By.className("report-property-section")).size()>0;
	    }        
	  }  
	}
	
	

}
