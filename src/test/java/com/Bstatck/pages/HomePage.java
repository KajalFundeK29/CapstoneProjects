package com.Bstatck.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	//encapsulation(private data, public method)
	private WebDriver driver;
	
	
	//initialize driver
	public HomePage(WebDriver driver)// this driver is from Base Class
	{
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
		  
	}
	
	//data member(locator)
	
		@FindBy (xpath ="//span[@id='signin']")
		private WebElement signInbtn;
			
	//method(functionality to test)
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
		
	public void getTitle()
	{
		String title=  driver.getTitle();
		Assert.assertEquals(title, "StackDemo");
		System.out.println("Title verified");
	}
	
	
	public String getLinkStatus()
	{
		signInbtn.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.urlContains("signin"));
		 return driver.getCurrentUrl();
		
	}
}
