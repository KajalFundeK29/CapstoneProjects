package com.Bstack.testCase;

import org.testng.annotations.Test;
import com.Bstack.BaseClass.BaseTest;
import org.testng.Assert;

public class HomePageTest extends BaseTest {
  @Test(priority=1)
  public void titleTest() {
	hp.getTitle();
	  
  }
  
  @Test(priority=2)
  public void urlTest() {
	  String url= hp.getAppUrl();
	  System.out.println("Application URL is: "+url);
	  
  }
  
  @Test(priority=3)
  public void linkStatusTest() {
	 String nxtpgUrl = hp.getLinkStatus();
	 System.out.println("Navigated to Login Page URL: "+nxtpgUrl);
	 Assert.assertTrue(nxtpgUrl.contains("signin"),"Test Failed: Navigation to SignIn page failed");
	 System.out.println("Test Passed: Navigation to SignIn page successfull!");
	
  }
}
  
