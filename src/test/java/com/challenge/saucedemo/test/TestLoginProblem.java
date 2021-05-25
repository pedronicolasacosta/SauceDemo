package com.challenge.saucedemo.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.saucedemo.LoginPage;
import com.challenge.saucedemo.POM;

public class TestLoginProblem extends LoginPage {
	
	public TestLoginProblem() {
		super(driver);
	}

	@Before
	public void setUp() {	
		String user = "problem_user";
		String pw = "secret_sauce";
		this.login(user, pw);
	}
	
	@Test
	public void testLoginProblem() {
		assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

		WebDriverWait ewait = new WebDriverWait(driver, 10);
		POM pom = PageFactory.initElements(driver, POM.class);
		ewait.until(ExpectedConditions.visibilityOf(pom.imgProblem));
		assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", pom.imgProblem.getAttribute("src"));

	}
	
	@After
	public void tearDown() throws Exception {		
		driver.quit();		
	}
}
