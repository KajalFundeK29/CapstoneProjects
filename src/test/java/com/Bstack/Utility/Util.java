package com.Bstack.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Util {
	
	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void navigateBack(WebDriver driver) {
		driver.navigate().back();
		
	}

	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
		// TODO Auto-generated method stub
		
	}
    
	//to scroll down by pixels
	
	public static void scrollByPixels(WebDriver driver, int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
		
	}
 
}
