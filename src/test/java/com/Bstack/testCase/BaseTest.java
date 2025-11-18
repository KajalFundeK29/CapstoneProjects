package com.Bstack.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.Bstack.Utility.*;
import com.Bstatck.pages.*;


  public class BaseTest {

      protected WebDriver driver;
      public HomePage hp;
  	public LoginPage lp;
  	public ProductPage pp;

      @BeforeMethod
      public void setup() {
          String browser = ConfigReader.getProperty("browser");
          driver = WebDriverFactory.createDriver(browser);
          driver.get(ConfigReader.getProperty("url"));
          hp= new HomePage(driver);
    	  lp= new LoginPage(driver);
    	  pp=new ProductPage(driver);
      }

      @AfterMethod
      public void tearDown() {
          if (driver != null) {
              driver.quit();
          }
      }
  }
