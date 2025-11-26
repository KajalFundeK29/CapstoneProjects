package com.OrangeHRM.Util;

	import java.io.File;
	import java.io.IOException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Screenshot {
		
		public static void captureScreenshot(WebDriver driver) {
			  // Wait for page to fully load
            Utility.staticWait(1000);

			
			// take screenshot logic
			TakesScreenshot ts =(TakesScreenshot)driver;
			File temp= ts.getScreenshotAs(OutputType.FILE);
			File dest= new File(System.getProperty("user.dir")+"/Screenshot/testlogin"+System.currentTimeMillis()+".png");
		
			try {
				FileHandler.copy(temp, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Placeholder for screenshot capture logic
			System.out.println("Screenshot captured!");
		}

	}



