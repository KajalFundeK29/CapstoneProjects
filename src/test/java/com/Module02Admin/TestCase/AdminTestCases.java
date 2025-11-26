package com.Module02Admin.TestCase;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.OrangeHRM.BaseClass.BaseTest;
import com.OrangeHRM.Util.Utility;

public class AdminTestCases extends BaseTest{
	

	@BeforeMethod
	public void setupAdmin() {
		lp.loginToOHRM("Admin", "admin123");
		lp.getLoginPageTitle();
		
	}
	 
	
  @Test(priority=1)
  public void dashboardMenuTest() {
	  System.out.println("Dashboard Menu is displayed: "+ap.isDashboardMenuDisplayed());
	  
	  //get menu texts
	  String Menu = ap.getdashboardMenuText();
	  System.out.print("Dashboard Menu Texts: "+Menu);
	  
	  //verify Menu count
	
	 Assert.assertEquals(ap.getDashboardMenuCount(), 12,"Menu count does not match");
	 System.out.println("\nMenu count matches!! Count:12 ");
	  
	 //click on Admin
	 Assert.assertEquals(ap.clickAdmin(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers","Test Fail: Url doen't Matched!");
	 System.out.println("Test Pass!! Url Matched!! ");
	 
  }
  
  @Test(priority=2)
  public void searchByUsername() {
	  System.out.println("search by UserName test!");
	  // click Admin
	  ap.clickAdmin();
	  
	  //assertion for Username
	  String actresult= ap.searchByUserName("Admin");
	  String exptPartresult = "Records Found";
	  Assert.assertTrue(actresult.contains(exptPartresult),
	          "Test Failed! Expected text to contain: " + exptPartresult);
	  System.out.println("Test Pass!! "+actresult);
	  
	  //reset
	  ap.reset();
	  //refresh page
	  ap.refreshPage();
  }
  
  @Test(priority=3)
  public void searchUserByRoleTest() {
	  System.out.println("search by Role test!");
	  ap.clickAdmin();
	  String result= ap.userByRole("A");
	  Utility.staticWait(10);
	  System.out.println(result);
	  
	  //assertion for result
	  String expectedPartial = "Records Found";
	  Assert.assertTrue(result.contains(expectedPartial),
	          "Test Failed! Expected text to contain: " + expectedPartial);
	  System.out.println("Test Pass!!");
	  //reset
	  ap.reset();
	  ap.refreshPage();
	  System.out.println("Page Refereshed!");
	  
	 
  }
  
  @Test(priority=4)
  public void userStatusTest() {
	  System.out.println("search status test!");
	  //click admin 
	  ap.clickAdmin();
	  ap.reset();
	  System.out.println("Reset");
	   //check status for Enable
	  String actresult= ap.checkStatus("E");
	  Utility.staticWait(10);
	  System.out.println(actresult);
	  
	  //assertion for result
	  String exptPartial ="Records Found";
	  Assert.assertTrue(actresult.contains(exptPartial),
	          "Test Failed! Expected text to contain: " + exptPartial);
	  System.out.println("Test Pass!! ");
	  
	  //reset
	  ap.reset();
	  
	  
  }
  
  
}
