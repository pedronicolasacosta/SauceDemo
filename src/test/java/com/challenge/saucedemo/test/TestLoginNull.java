package com.challenge.saucedemo.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.saucedemo.LoginPage;
import com.challenge.saucedemo.POM;

public class TestLoginNull extends LoginPage {
	
	public TestLoginNull() {
		super(driver);
	}

	@Before
	public void setUp() {	
		String user = "";
		String pw = "secret_sauce";
		this.login(user, pw);
	}
	
	@Test
	public void loginTest() {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		POM pom = PageFactory.initElements(driver, POM.class);
		ewait.until(ExpectedConditions.visibilityOf(pom.div_errorMsg));
		assertEquals("Epic sadface: Username is required", pom.div_errorMsg.getText());
	}
	
	@After
	public void tearDown() throws IOException
	{
		driver.quit();
	}
}
