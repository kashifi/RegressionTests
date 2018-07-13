package com.engcpp;

import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.or;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author engcpp
 */
public class SeleniumTest {
    protected WebDriver selenium; 
    private static final long TME_SLEEP_IN_MILLI_SECS = 100;
    private static final long TME_OUT_IN_SECS = 100;
    
    public SeleniumTest(WebDriver driver){
        this.selenium = driver;
    }
    
    protected void sleep(long timeout){
      try { Thread.sleep(timeout); } catch (InterruptedException ex) {}     
    } 
    
    protected void sleep(){
        sleep(2000);
    }
    
    public List<WebElement> findElements(By by){
      try {          
          return selenium.findElements(by);      
      } catch (StaleElementReferenceException | NoSuchElementException e){
          return Collections.emptyList();
      }             
    }
    
    public WebElement findElement(By by){
      try {
          return selenium.findElement(by);      
      } catch (StaleElementReferenceException | NoSuchElementException e){
          return null;
      }        
    }    
    
    public void waitLoader() {
        while(findElement(By.className("report-loading-icon")) != null); 
    }
    
    public void waitClickable(WebElement element) {
      new WebDriverWait(selenium, TME_OUT_IN_SECS, TME_SLEEP_IN_MILLI_SECS)
        .until(and(elementToBeClickable(element), visibilityOf(element)));
    }
    
    /**
     * Look for an element based on the text inside of the element
     * @param element
     * @param text
     */
    public void waitForPresenceOf(WebElement element, String text) throws WebDriverException {
        waitFor(textToBePresentInElement(element, text));
    }
    
    /**
     * Look for an element based on its location (xpath, css-locator, etc )
     * @param locator
     */
    public void waitForPresenceOf(By locator) throws WebDriverException {
        waitFor(presenceOfElementLocated(locator));
    }
    
    public void waitFor(ExpectedCondition<?>condition) throws WebDriverException {          	
    	new WebDriverWait(selenium, TME_OUT_IN_SECS, TME_SLEEP_IN_MILLI_SECS).until(or(condition, getBrowserConditions()));

    } 
 
    private ExpectedCondition getBrowserConditions() {
    	return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					driver.getTitle();
					return false;
				} catch (Exception e) {
					System.out.println("IQ Connect platform or Network is facing degradation ......... ");
					return true;
				}
			}
    	  };
    }    
}