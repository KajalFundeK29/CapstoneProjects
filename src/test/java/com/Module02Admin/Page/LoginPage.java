package com.Module02Admin.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy (xpath ="//input[@placeholder='Username']")
	private WebElement usernameInput;
	@FindBy (xpath ="//input[@placeholder='Password']")
	private WebElement passwordInput;
	@FindBy (xpath ="//button[@type='submit']")
	private WebElement loginButton;
	
	//methods
	
	public void loginToOHRM(String un, String ps) {
		usernameInput.sendKeys(un);
		passwordInput.sendKeys(ps);
		loginButton.click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
}
