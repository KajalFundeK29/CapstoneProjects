package com.Bstatck.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Bstack.Utility.Util;

public class ProductPage {
	
	//encapsulation(private data, public method)
	private WebDriver driver;
	
	//initialize driver
	public ProductPage (WebDriver driver)// this driver is from Base Class
	{
		  this.driver=driver;
		  PageFactory.initElements(driver, this);  
	}
	
	//data member(locators)
	@FindBy (xpath ="//p[@class='shelf-item__title']")		
	private List<WebElement> productList;


	@FindBy (xpath ="//div[@class='float-cart__shelf-container']")
	private WebElement cartPage;
	
	@FindBy(xpath="//div[@class='shelf-item__del']")
	private WebElement removeItemBtn;
	@FindBy (xpath ="//span[@class=\'bag bag--float-cart-closed\']")
	private WebElement cartIcon;
	@FindBy (xpath ="//p[@class='sub-price__val']")
	private WebElement cartItemPrice;

	@FindBy (xpath ="//span[@class='bag__quantity']")
	private WebElement cartItemsCount;
	
	@FindBy (xpath ="//div[@class='buy-btn']")
	private WebElement buyNowBtn;
	
	@FindBy (xpath ="//div[@class='float-cart__close-btn']")
	private WebElement closeCartBtn;
	
	
	//method(functionality to test)
	public void getProductList()
	{
		int count=productList.size();
		System.out.println("Total products displayed: "+count);
		for(WebElement product:productList)
		{
			System.out.println(product.getText());
		}
	}
	
	public void selectProduct(String pName)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    for(WebElement product : productList)
	    {
	        if(product.getText().contains(pName))
	        {
	            // Scroll to product
	            ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", product);

	            // Small wait to ensure scrolling has completed
	            Util.waitForSeconds(1);
	            
	            //iterate to find the corresponding add to cart button
	            int index = productList.indexOf(product) + 1; // +1 because nth-child is 1-based
	            By addToCartBtnLocator = By.cssSelector("div[id='" + index + "'] div[class='shelf-item__buy-btn']");
	            WebElement addToCartbtn = driver.findElement(addToCartBtnLocator);
	            	
	           
	            // Wait until this specific button is clickable
	            wait.until(ExpectedConditions.elementToBeClickable(addToCartbtn));

	            // Click it
	            addToCartbtn.click();

	            System.out.println("Product " + pName + " is selected and added to the cart!");
	            break;
	        }
	    }
	}

	
	
	
	//get current product page url
	public String getProductPageUrl()
	{
		return driver.getCurrentUrl();
	}
	

	public void validatecartpage() {
		//check total items added to cart and price
		
		//if cartItems are 1 or more
		if (Integer.parseInt(cartItemsCount.getText()) < 1) {
			System.out.println("No items are added to the cart! Cart is empty.");
		}
		if (Integer.parseInt(cartItemsCount.getText()) >= 1) {
			System.out.println(cartItemsCount.getText()+" items added to the cart!");
		}
		
		//check price
		String price=cartItemPrice.getText();
		Util.waitForSeconds(2);
		
		if (!price.equals("$0.00")) {
		    System.out.println("Total Price of the Items in cart: " + price);
		} 
		else {
		    Assert.fail("Price is not displayed in the cart! It shows $0.00");
		}

	}
     
	
	
	public void closeCart() {
		closeCartBtn.click();
		System.out.println("Closing the cart view...");
	}
	
	public void clickCheckout() {
		buyNowBtn.click();
		System.out.println("Redirecting to Checkout Page...");
	}
	
}
