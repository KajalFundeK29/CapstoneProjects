package com.Bstatck.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// locators
	@FindBy (xpath="//div[contains(text(),'Select Username')]")
	private WebElement username;
	
	@FindBy (xpath="//div[contains(text(),'Select Password')]")
	private WebElement password;	
	@FindBy (id="login-btn")
	private WebElement loginBtn;
	
	// methods
	
	 public String loginpageTitle() {
		 return driver.getTitle();
	 }
	 
	 public String clickLogin(String un, String ps) {
		 username.sendKeys(un);
		 password.sendKeys(ps);
		 loginBtn.click();
		 new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.urlContains("signin=true"));
		 return driver.getCurrentUrl();
	 }
	 
	
}
