package com.engcpp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author engcpp
 */
public class IVALReport extends SeleniumTest {
  private String property;
          
  @FindBy(how= How.XPATH, using="//*[@id=\"propertySearchInput\"]")
  @CacheLookup
  private WebElement propertyInput;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[4]/div/div/div/form/div/div[2]/div[2]/button")
  @CacheLookup
  private WebElement goButton;  
  
  private final String ELEMENT_1_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[4]/div/div/div/div/div[2]/strong/a";
  
  public IVALReport(WebDriver selenium){
    super(selenium);
    PageFactory.initElements(selenium, this);   
  }  
  
  public IVALReport withProperty(String property){
    this.property = property;
    return this;
  }  

  public PropertyMenu submit(){
    sleep();
    
    propertyInput.sendKeys(this.property);    
    goButton.click();
    
    waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("property-search-item")));
    
    if (selenium.findElements(By.className("property-search-item")).size()>0) {      
      WebElement firstElement = findElement(By.xpath(ELEMENT_1_XPATH));
      waitClickable(firstElement);
      firstElement.click();
      
      return new PropertyMenu(selenium);
    }            
    
     return null;
  }

  static class PropertyMenu extends SeleniumTest {    
    @FindBy(how= How.XPATH, using="//*[@id=\"home-tabs-pane-0\"]/div/div[4]/div[3]/div/div[1]/div[4]/div/div/div/a")
    @CacheLookup
    private WebElement ivalLink;
      
    public PropertyMenu(WebDriver driver){      
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