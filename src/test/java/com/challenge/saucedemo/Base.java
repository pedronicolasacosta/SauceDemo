package com.challenge.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	protected static WebDriver driver;
	
	protected Base(WebDriver driver) {
		Base.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;		
	}
	
	public void goTo(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");		
	}
}
