package com.challenge.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {
	
	protected LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String user, String pw) {	
		driver = chromeDriverConnection();
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		POM pom = PageFactory.initElements(driver, POM.class);	
		goTo(driver);
			
		ewait.until(ExpectedConditions.visibilityOf(pom.txt_username));
		pom.txt_username.clear();
		pom.txt_username.sendKeys(user);
		ewait.until(ExpectedConditions.visibilityOf(pom.txt_password));
		pom.txt_password.clear();
		pom.txt_password.sendKeys(pw);
		ewait.until(ExpectedConditions.visibilityOf(pom.btn_login));
		pom.btn_login.submit();
		
	}
}
