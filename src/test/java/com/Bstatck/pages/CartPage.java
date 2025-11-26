
package com.Bstatck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Bstack.Utility.Util;

public class CartPage {
	private WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    //Locators
	@FindBy (xpath ="//span[@class=\'bag bag--float-cart-closed\']")
	private WebElement cartIcon;
	@FindBy (xpath ="//div[@class='buy-btn']")
	private WebElement buyNowBtn;
	@FindBy (xpath ="//input[@id='firstNameInput']")
	private WebElement firstNameInput;
	@FindBy (xpath ="//input[@id='lastNameInput']")
	private WebElement lastNameInput;
	@FindBy (xpath ="//input[@id='addressLine1Input']")
	private WebElement addressInput;
	@FindBy (xpath ="//input[@id='provinceInput']")
	private WebElement stateInput;
	@FindBy (xpath ="//input[@id='postCodeInput']")
	private WebElement postalCodeInput;
	@FindBy (xpath ="//button[@id='checkout-shipping-continue']")
	private WebElement submitbtn;
	@FindBy (xpath ="//legend[@id='confirmation-message']")
	private WebElement orderSuccessMsg;
	@FindBy (xpath ="//a[@id='downloadpdf']")
	private WebElement orderreceiptLink;
	@FindBy (xpath ="//button[@class='button button--tertiary optimizedCheckout-buttonSecondary']")
	private WebElement continueToShopBtn;
	@FindBy (xpath ="//span[@id='signin']")
	private WebElement logoutBtn;
		
	
	public void openCart() {
		cartIcon.click();
	}
	
	public void checkout() {
		// checkout
		buyNowBtn.click();
		System.out.println("Proceeded to checkout successfully!");
		//wait for checkout page to load
		Util.waitForSeconds(2);
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("checkout"),"Checkout page is not displayed!");
		System.out.println("Checkout Page URL: "+url);
		
	}
	
	//method to fill shipping details
	public void fillShippingDetails(String firstName, String lastName, String address, String state, String postalCode) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		addressInput.sendKeys(address);
		stateInput.sendKeys(state);
		postalCodeInput.sendKeys(postalCode);
		submitbtn.click();
		System.out.println("Shipping details filled and submitted successfully!");
	}
	
	public void verifyOrderSuccess() {
		String successMsg = orderSuccessMsg.getText();
		Assert.assertTrue(successMsg.contains("Your Order has been successfully placed."), "Order success message is not displayed!");
		System.out.println("Order placed successfully! Message: " + successMsg);
	}
	public void downloadOrderReceipt() {
		orderreceiptLink.click();
		System.out.println("Order receipt downloaded successfully!");
	}
	public void continueShopping() {
		continueToShopBtn.click();
		System.out.println("Continuing to shop...");
	}
	public void logout() {
		logoutBtn.click();
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("login"),"User is not logged out successfully!");
		System.out.println("User logged out successfully! Login Page URL: "+url);
		
	}
	
}
