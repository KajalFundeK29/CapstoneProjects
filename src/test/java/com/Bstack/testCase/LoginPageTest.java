package com.Bstack.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class LoginPageTest extends BaseTest {
	public WebDriver driver;
	
	@BeforeClass
	public void setupLoginPage() {
		hp.getLinkStatus();
	}
	
  @Test
  public void loginPgTitleTest() {
	  String title= lp.loginpageTitle();
	  System.out.println("Login Page Title is: "+title);
	  
  }
  
  public void loginTest() {
	  String url= lp.clickLogin("demouser", "testingisfun99");
	  System.out.println("After Login Navigated to URL: "+url);
  }
}
