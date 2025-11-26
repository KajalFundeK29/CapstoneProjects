package com.Bstack.testCase;

import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Bstack.BaseClass.BaseTest;
import com.Bstack.Utility.Util;

public class AddToCartTests extends BaseTest {
	@BeforeMethod
	public void setupLoginPage() {
		hp.getLinkStatus();
		lp.verifyvalidLogin();
	}
	
	ArrayList<String> productNames = new ArrayList<String>();
	
	{
		productNames.add("Galaxy S20");
		productNames.add("iPhone 12");
		productNames.add("Pixel 4");
	}
	
	
  @Test
  public void AddToCartTest() {
	  pp.getProductList();
	  //Util.scrollToText(driver, "iPhone 12");
	  pp.selectProduct("iPhone 11");
	  System.out.println("Product Page URL: "+pp.getProductPageUrl());
	  Util.waitForSeconds(2);
	  pp.validatecartpage();
	  pp.closeCart();
	     
  }
  
  @Test
  public void  addMoreItemsTest() {
	  pp.getProductList();
	  pp.selectProduct(productNames.get(0));
	  pp.selectProduct(productNames.get(1));
	  pp.selectProduct(productNames.get(2));
	  
	  System.out.println("Products added to cart successfully!");
	  Util.waitForSeconds(2);
	  pp.validatecartpage();
	  pp.closeCart();
  }
  
  
  
  
  //checkout test
  @Test
  public void checkoutTest() {
	  pp.selectProduct("Pixel 4");
	  Util.waitForSeconds(2);
	  pp.validatecartpage();
	  pp.clickCheckout();
	  
  }
  

}
