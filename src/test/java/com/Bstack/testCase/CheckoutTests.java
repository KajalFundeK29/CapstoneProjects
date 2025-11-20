package com.Bstack.testCase;

import com.Bstack.BaseClass.BaseTest;
import org.testng.annotations.*;


public class CheckoutTests extends BaseTest {
	@BeforeMethod
	public void setupLoginPage() {
		hp.getLinkStatus();
		lp.verifyvalidLogin();
		
	}
	
  @Test
  //Place order with valid details  test
 public void placeOrder () {
	  
	  pp.selectProduct("iPhone 12");
	  System.out.println("Products added to cart successfully!");
	
	  
	  cp.checkout();
	  cp.fillShippingDetails("John", "Doe", "123 Main St", "California", "90001");
	  cp.verifyOrderSuccess();
	  cp.downloadOrderReceipt();
	  cp.continueShopping();
  }
    
}
