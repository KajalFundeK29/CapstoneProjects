package com.Bstack.testCase;

import org.testng.annotations.Test;
import com.Bstack.BaseClass.BaseTest;
import org.testng.annotations.*;


public class LoginPageTest extends BaseTest {
	
	@BeforeMethod
	public void setupLoginPage() {
		hp.getLinkStatus();
	}
	
  
//Positive Test Case
  @Test(priority=0)
  public void loginTest() {
	  System.out.println("Login Page Title is: "+lp.loginpageTitle());
	  String url= lp.verifyvalidLogin();
	  System.out.println("After Login Navigated to URL: "+url);
	  lp.logoutFromApp();
  }
  
//Negative Test Case
  @Test
  public void emptyLoginTest() {

	  System.out.println("Error Message for empty Login test is:"+ lp.verifyemptyLogin());
  }
}
