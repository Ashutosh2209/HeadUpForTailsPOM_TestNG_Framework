package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.CommonUtil;

public class HomePage {
	private WebDriver driver;
	CommonUtil util;
	private By headTailsSearchBar = By.xpath("(//input[@name='q'])[2]");
	private By superTailsSearchBar = By.id("mainfrm");
	public HomePage(WebDriver driver) {
		this.driver=driver;
		util = new CommonUtil(driver);
	}
	
	public String homePageTitle() {
		return util.getTitle();
	}
	
	public SearchPage searchProduct(String appName, String search) {
		if(appName.equalsIgnoreCase("HeadTails"))
		util.doSendKeys(headTailsSearchBar, search);
		else
		util.doSendKeys(superTailsSearchBar, search);
		return new SearchPage(driver);
	}
}
