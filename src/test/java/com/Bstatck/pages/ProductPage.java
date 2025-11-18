package com.Bstatck.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//encapsulation(private data, public method)
	private WebDriver driver;
	
	
	//initialize driver
	public ProductPage (WebDriver driver)// this driver is from Base Class
	{
		  this.driver=driver;
		  PageFactory.initElements(driver, this);  
	}
	
	//data member(locator)
	@FindBy (xpath ="//div[@class='shelf-container']//div[@class='shelf-item']")		
	private List<WebElement> productList;
	
	@FindBy (xpath ="//div[@id='3']//div[@class='shelf-item__buy-btn']")
	private WebElement addToCartBtn;
	
	@FindBy (xpath ="//span[@class=\'bag bag--float-cart-closed\']")
	private WebElement cartIcon;
	
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
		for(WebElement product:productList)
		{
			if(product.getText().contains(pName))
			{
				product.click();
				break;
			}
		}
		
		System.out.println("Product "+pName+" is selected");
	}
	
	public String getProductPageUrl()
	{
		return driver.getCurrentUrl();
	}
	

	
}
