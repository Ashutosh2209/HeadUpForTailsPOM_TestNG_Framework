package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.Constants;


public class SuperTailsTest extends BaseTest{
	
	@Test(priority=1)
	public void superTailsTitleValidtion() {
		String actualTitle = homePage.homePageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, Constants.SUPER_TAILS_TITLE);
	}
	
	@Test(priority=2)
	public void getPriceValidation() {
		homePage.searchProduct(Constants.SUPER_TAILS_APPNAME, "pedigree adult food");
		searchPage.selectProduct(Constants.SUPER_TAILS_APPNAME);
		String superTailsPrice = productPage.getSupertailsPrice();
		String originalSuperTailsPrice = superTailsPrice.replace("₹", " ").trim();
		System.out.println(originalSuperTailsPrice);
		int price1 = Integer.parseInt(originalSuperTailsPrice);
		float p = Float.parseFloat(HeadTailsTest.orginalHeadTailsPrice);
		int price2 = Math.round(p);
		try {
			Assert.assertTrue(price1<price2);
			System.out.println("Super Tails product price is cheaper and price is "+price1);
		}catch(AssertionError e) {
			System.out.println("Head Tails product price is cheaper and price is "+price2);
		}
		
	}
}
