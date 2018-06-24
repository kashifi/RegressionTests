package com.engcpp;

import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author engcpp
 */
public class SeleniumTest {
    protected WebDriver selenium; 
    private static final long TME_SLEEP_IN_MILLI_SECS = 2000;
    private static final long TME_OUT_IN_SECS = 50;
    
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
    
    public void waitForPresenceOf(By locator) {
        waitFor(presenceOfElementLocated(locator));
    }
    
    public void waitFor(ExpectedCondition<?>condition) {      
      new WebDriverWait(selenium, TME_OUT_IN_SECS, TME_SLEEP_IN_MILLI_SECS)
        .until(condition);
    }     
}
