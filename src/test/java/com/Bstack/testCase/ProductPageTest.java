package com.Bstack.testCase;

import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
  @Test
  public void AddToCartTest() {
	  pp.getProductList();
	  pp.selectProduct("Galaxy S20");
	  System.out.println("Product Page URL: "+pp.getProductPageUrl());
	     
  }
  
}
