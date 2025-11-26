package com.Module02Admin.Page;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AdminPage {
	//initialize driver
	private WebDriver driver;


	//constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//ul[@class='oxd-main-menu']//a")
	private List <WebElement> dashboardMenu; 
	
	@FindBy(xpath="//ul[@class=\"oxd-main-menu\"]//li[1]")
	private WebElement adminlink;
	@FindBy(xpath="//label[text()='Username']/following::input[1]")
	private WebElement userNm;
	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchbtn;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement result;
	@FindBy (xpath="(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
	private WebElement userbyRole;
	@FindBy (xpath="//label[text()='Status']/following::div[@class='oxd-select-text-input'][1]")
	private WebElement status;
	@FindBy (xpath="//button[normalize-space()='Reset']")
	private WebElement reset;
	
	//Methods
	public boolean isDashboardMenuDisplayed() {
		return !dashboardMenu.isEmpty();
	}
	
	public int getDashboardMenuCount() {
	    return dashboardMenu.size();
	}


	public String clickAdmin(){
		adminlink.click();
		System.out.println("Redirecting to Admin page");
		return driver.getCurrentUrl();		
	}
	
	public String getdashboardMenuText() {
		String menuText = "";
		for(WebElement menu : dashboardMenu) {
			menuText += menu.getText() + " ";
		}
		return menuText.trim();
	}
	
	// method to search user by Name
	public String searchByUserName(String un) {
		 //search for un
		 userNm.sendKeys(un);
		 
		 searchbtn.click();
		 
		 return result.getText();
		 
		 
	}
	
	// method to search user by Role
	public String userByRole(String rl) {
		userbyRole.sendKeys(rl);
		searchbtn.click();
		return result.getText();
		
	}
	
	//method to search status of existing employee
	public String checkStatus(String s){
		// select enable in status
		status.sendKeys(s);
		status.click();
		searchbtn.click();
		
		return result.getText();
	}
	
	//reset
	public void reset() {
		reset.click();
	}
	
	// refresh page
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
}
