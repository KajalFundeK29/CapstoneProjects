package com.Bstatck.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Bstack.Utility.Util;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	// locators
	@FindBy (xpath="(//*[name()='svg'])[2]")
	private WebElement userIcon;
	@FindBy (xpath="//div[contains(text(),'demouser')]")
	private WebElement selectUsername;
	
	@FindBy (xpath="(//*[name()='svg'])[3]")
	private WebElement passwordIcon;
	
	@FindBy (xpath="//div[contains(text(),'testingisfun99')]")
	private WebElement selectPasswordDropdown;
		
	@FindBy (id="login-btn")
	private WebElement loginBtn;
	
	@FindBy(xpath="//h3[@class='api-error']")
	private WebElement invalidLoginMsg;
	
	@FindBy (xpath="//h3[@class=\'api-error\']")
	private WebElement emptyLoginMsg;
	
	@FindBy (xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	// methods
	 public String loginpageTitle() {
		 
		 return driver.getTitle();
	 }
	 
	 public String verifyvalidLogin() {
		 userIcon.click();
		 selectUsername.click();
		 passwordIcon.click();
		 selectPasswordDropdown.click();
		 loginBtn.click();
		 
		 new WebDriverWait(driver, Duration.ofSeconds(20))
			.until(ExpectedConditions.urlContains("signin=true"));
		 return driver.getCurrentUrl();
		
	 }
	  public String verifyInvalidLogin() {
		  userIcon.click();
		  Util.waitForSeconds(1);
		  selectUsername.click();
		
		  loginBtn.click();
		  new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.visibilityOf(invalidLoginMsg));
		  return invalidLoginMsg.getText();
	  }
	  
	  public String verifyemptyLogin() {
		  loginBtn.click();
		  new WebDriverWait(driver, Duration.ofSeconds(10))	
		  			.until(ExpectedConditions.visibilityOf(emptyLoginMsg));
		  return emptyLoginMsg.getText();
		  
	  }
	public void logoutFromApp() {
		logout.click();
	}
}
