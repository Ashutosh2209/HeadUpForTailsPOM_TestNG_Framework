package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.CommonUtil;

public class SearchPage {
	private WebDriver driver;
	CommonUtil util;
	private By headTailsProduct = By.xpath("//a[normalize-space()='Pedigree Chicken & Vegetables Adult Dry Dog Food']");
	private By supertailsProduct = By.cssSelector("#searchResultsWrapper>ul>li:first-of-type");
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		util = new CommonUtil(driver);
	}
	
	public ProductPage selectProduct(String appName) {
		//driver.findElement(headTailsProduct).click();
		if(appName.equalsIgnoreCase("HeadTails"))
		util.waitForElementPresence(headTailsProduct, 20).click();
		else
			util.waitForElementPresence(supertailsProduct, 20).click();
		return new ProductPage(driver);
	}
}
