package com.OrangeHRM.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Module02Admin.Page.AdminPage;
import com.Module02Admin.Page.LoginPage;


public class BaseTest {
	public WebDriver driver;
	
	public LoginPage lp;
	public AdminPage ap;
	
	
  @BeforeMethod
  public void setup() {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
	  
	    
	  lp = new LoginPage(driver);
	  ap = new AdminPage(driver);
	  
  }
  
@AfterMethod
  public void tearDown() {
	  driver.quit();
  }
	   
}
