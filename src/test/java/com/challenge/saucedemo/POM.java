package com.challenge.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM {

	@FindBy(name = "user-name")
	public WebElement txt_username;
	
	@FindBy(name = "password")
	public WebElement txt_password;
	
	@FindBy(name = "login-button")
	public WebElement btn_login;
	
	@FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]")
	public WebElement div_errorMsg;
	
	@FindBy(xpath = "//*[@id='item_4_img_link']/img")
	public WebElement imgProblem;
}
