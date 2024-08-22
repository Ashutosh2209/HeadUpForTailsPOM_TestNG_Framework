package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		String appName = prop.getProperty("application");
		if(appName.equalsIgnoreCase("HeadTails")) {
			driver.get(prop.getProperty("url1"));
		}else {
			driver.get(prop.getProperty("url2"));
		}
		
		return driver;
	}
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\test\\resource\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
