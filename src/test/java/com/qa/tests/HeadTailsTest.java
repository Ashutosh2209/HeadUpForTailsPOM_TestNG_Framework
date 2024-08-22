package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.Constants;


public class HeadTailsTest extends BaseTest {
	public static String orginalHeadTailsPrice;
	@Test(priority=1)
	public void headTailsTitleValidation() {
		String actualTitle = homePage.homePageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, Constants.HEAD_TAILS_TITLE);
	}
	
	@Test(priority=2)
	public void getPriceValidation() {
		homePage.searchProduct(Constants.HEAD_TAILS_APPNAME,"pedigree adult food");
		searchPage.selectProduct(Constants.HEAD_TAILS_APPNAME);
		String headTailsPrice = productPage.getPrice(Constants.HEAD_TAILS_APPNAME);
		
		orginalHeadTailsPrice = headTailsPrice.replace('₹', ' ').trim();
		System.out.println(orginalHeadTailsPrice);
		Assert.assertEquals(orginalHeadTailsPrice, "602.60");
	}
}
