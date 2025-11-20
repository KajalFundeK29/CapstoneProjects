package com.Bstack.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.Bstack.Utility.*;
import com.Bstatck.pages.*;


  public class BaseTest {

    public WebDriver driver;
    public HomePage hp;
  	public LoginPage lp;
  	public ProductPage pp;
  	public CartPage cp;

      @BeforeMethod
      public void setup() {
    	  
          String browser = ConfigReader.getProperty("browser");
          driver = WebDriverFactory.createDriver(browser);
          driver.manage().window().maximize();
          //implicit wait
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	
          driver.get(ConfigReader.getProperty("url"));
         
          hp= new HomePage(driver);
    	  lp= new LoginPage(driver);
    	  pp=new ProductPage(driver);
    	  cp=new CartPage(driver);
      }

      
	  @AfterMethod
      public void tearDown() {
         
              driver.quit();
          
      }
  }
