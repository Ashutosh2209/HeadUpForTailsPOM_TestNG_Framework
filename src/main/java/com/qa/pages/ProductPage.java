package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.CommonUtil;

public class ProductPage {
	private WebDriver driver;
	CommonUtil util;
	private By headtailsSize = By.xpath("//label[@for='template--15764301512766__main-1-2']");
	private By headTailsPrice = By.cssSelector(".price-item.price-item--sale.price-item--last");
	private By supertailsSize = By.xpath("(//label[contains(@for,'-size-2.8kg')])[1]");
	private By superTailsPrice = By.cssSelector(".product-price-wrapper>span:first-of-type");
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		util = new CommonUtil(driver);
	}
	public String getPrice(String appName) {
		util.doClick(headtailsSize);
		driver.navigate().refresh();
		String price = util.dogetText(headTailsPrice);
		return price;
	}
	public String getSupertailsPrice() {
		util.doClick(supertailsSize);
		String price = util.dogetText(superTailsPrice);
		return price;
	}
}
