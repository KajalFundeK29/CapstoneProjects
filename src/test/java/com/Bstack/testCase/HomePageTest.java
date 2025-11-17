package com.Bstack.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
  @Test
  public void titleTest() {
	hp.getTitle();
	  
  }
  
  @Test
  public void urlTest() {
	  String url= hp.getAppUrl();
	  System.out.println("Application URL is: "+url);
	  
  }
  
  @Test
  public void linkStatusTest() {
	 String nxtpgUrl = hp.getLinkStatus();
	 System.out.println("Navigated to Login Page URL: "+nxtpgUrl);
	 Assert.assertTrue(nxtpgUrl.contains("signin"),"Test Failed: Navigation to SignIn page failed");
	 System.out.println("Test Passed: Navigation to SignIn page successful");
	
  }
}
  
