package com.Module02Admin.TestCase;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import com.OrangeHRM.BaseClass.BaseTest;

public class LoginTestCase extends BaseTest{
	 public WebDriver driver;
	
	
  @Test
  public void verifyValidLoginTest() {
	  //login with valid credentials
	  lp.loginToOHRM("Admin", "admin123");
	  
	  //verify  current url
	  lp.getLoginPageUrl();
	  Assert.assertEquals(lp.getLoginPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","Login failed - URL does not match");
	  System.out.println(" URL matches!!");
	  
	  //verify login successful by checking page title
	  
	  Assert.assertEquals(lp.getLoginPageTitle(), "OrangeHRM","Login failed - Title does not match");
	  System.out.println("Login Sucessfull!! Title matches!!");
	  
  }
}
