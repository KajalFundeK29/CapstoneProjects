package com.Bstack.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Bstatck.pages.*;
import com.Bstatck.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	
	
  @BeforeTest
  public void setup() {
	  driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	  driver.get("https://bstackdemo.com/");
	  hp= new HomePage(driver);
	  lp= new LoginPage(driver);
  }
 
  @AfterTest
 public void afterTest() {
	  driver.quit();	
	
  }
}
