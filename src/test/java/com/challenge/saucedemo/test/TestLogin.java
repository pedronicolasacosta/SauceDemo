package com.challenge.saucedemo.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.challenge.saucedemo.LoginPage;

public class TestLogin extends LoginPage {
	
	public TestLogin() {
		super(driver);
	}

	@Before
	public void setUp() {	
		String user = "standard_user";
		String pw = "secret_sauce";
		this.login(user, pw);
	}
	
	@Test
	public void loginTest() {
		assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws IOException
	{
		driver.quit();
	}
}
