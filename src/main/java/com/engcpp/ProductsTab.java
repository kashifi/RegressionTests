package com.engcpp;

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
public class ProductsTab extends SeleniumTest {
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[1]/div[1]")
	@CacheLookup
	private WebElement individualButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[1]/div[2]")
	@CacheLookup
	private WebElement businessButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[1]/div[3]")
	@CacheLookup
	private WebElement propertyButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[1]/div[1]/div[4]")
	@CacheLookup
	private WebElement vehicleButton;

	private static final String ACTIVE = "active";

	public ProductsTab(WebDriver selenium) {
		super(selenium);
		PageFactory.initElements(selenium, this);
	}

	public boolean individualsClick() {
		waitClickable(individualButton);
		individualButton.click();
		String cssClass = getCssClass(individualButton);
		return cssClass.contains(ACTIVE);
	}

	public boolean businessClick() {
		waitClickable(businessButton);
		businessButton.click();
		String cssClass = getCssClass(businessButton);
		return cssClass.contains(ACTIVE);
	}

	public boolean propertyClick() {
		waitClickable(propertyButton);
		propertyButton.click();
		String cssClass = getCssClass(propertyButton);
		return cssClass.contains(ACTIVE);
	}

	public boolean vehicleClick() {
		waitClickable(vehicleButton);
		vehicleButton.click();
		String cssClass = getCssClass(vehicleButton);
		return cssClass.contains(ACTIVE);
	}

	private String getCssClass(WebElement we) {
		return we.getAttribute("class");
	}
}