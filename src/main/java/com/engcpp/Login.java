/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engcpp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author engcpp
 */
public class Login extends LoadableComponent<Login>{
    private WebDriver selenium;
    private final String URL = "https://iqconnect.test.equifax.co.nz/#/login";
        
    @FindBy(how= How.CLASS_NAME, using="btn btn-default")
    @CacheLookup
    private WebElement loginButton; 
    
    private String username;
    private String password;
    
    public Login(WebDriver selenium){
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);        
        selenium.get(URL);
    }    
    
    public Login withUsername(String username){
        this.username = username;
        return this;
    }
    
    public Login withPassword(String password){
        this.password = password;
        return this;
    }    
    
    public void login(){
      if (isLoggedIn())
          return;
        
      WebElement usernameInput = selenium.findElement(By.name("email"));
      WebElement passwordInput = selenium.findElement(By.name("password"));
      WebElement submitButton  = selenium.findElement(By.tagName("submit"));
       
      usernameInput.sendKeys(username);
      passwordInput.sendKeys(password);
      submitButton.submit();   
      /*
      (new WebDriverWait(selenium, 10)).until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver d) {
            return isLoggedIn();
         }
      }); 
      */
    }
    
    public void logout(){
      if (isLoggedIn())
        selenium.get(URL+"#/logout");
    }
    
    private boolean isLoggedIn(){
      return selenium.findElements(By.className("userprofile-username")).size()>0;
    }
    
    @Override
    protected void load() {
        selenium.get(URL);
    }  
    
    @Override
    protected void isLoaded() throws Error{
        String url = selenium.getCurrentUrl();
        if (!url.equals(URL))
            throw new Error("The wrong page has loaded");   
    }    
      
}