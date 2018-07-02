package com.engcpp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author engcpp
 */
public class Login extends SeleniumTest {
	private final String LOGIN_URL;
	private final String MAIN_URL;

	@FindBy(how = How.TAG_NAME, using = "button")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "formHorizontalEmail")
	@CacheLookup
	private WebElement usernameInput;

	@FindBy(how = How.ID, using = "formHorizontalPassword")
	@CacheLookup
	private WebElement passwordInput;

	private String username;
	private String password;

	public Login(String mainUrl, WebDriver selenium) {
		super(selenium);
		MAIN_URL = mainUrl;
		LOGIN_URL = MAIN_URL + "/#/login";

		PageFactory.initElements(selenium, this);
		selenium.get(LOGIN_URL);
	}

	public Login withUsername(String username) {
		this.username = username;
		return this;
	}

	public Login withPassword(String password) {
		this.password = password;
		return this;
	}

	public Login login() {
		if (isLoggedIn())
			return this;
		
		waitForPresenceOf(By.id("formHorizontalEmail"));
		waitForPresenceOf(By.id("formHorizontalPassword"));
		//waitClickable(usernameInput);
		//waitClickable(passwordInput);
		
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		waitClickable(loginButton);
		loginButton.click();
		waitLoader();
		System.out.println("Successfully Logged IN .......... ");
		return this;
	}

	public void logout() {
		
		selenium.get(MAIN_URL + "/#/logout");
		while (isLoggedIn());
		//sleep();
		System.out.println("Successfully Logged OUT .......... ");
	}

	public boolean isLoggedIn() {
		return findElements(By.xpath("//*[@id=\"app\"]/div/nav")).size() > 0;
	}
}