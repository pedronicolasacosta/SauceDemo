package com.challenge.saucedemo.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.saucedemo.LoginPage;
import com.challenge.saucedemo.POM;

public class TestLoginToForceError extends LoginPage {
	public TestLoginToForceError() {
		super(driver);
	}
	
	@Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();

	@Before
	public void setUp() {	
		String user = "error_user";
		String pw = "secret_sauce";
		this.login(user, pw);
	}
	
	@Test
	public void testLoginLocked() {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		POM pom = PageFactory.initElements(driver, POM.class);
		ewait.until(ExpectedConditions.visibilityOf(pom.div_errorMsg));
		assertEquals("Epic sadface: Username and password do not match any user in this servi", pom.div_errorMsg.getText());
	}
	
	class ScreenshotTestRule implements MethodRule {
        @Override
		public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        statement.evaluate();
                        driver.quit();
                    } catch (Throwable t) {
                        captureScreenshot(frameworkMethod.getName());
                        throw t;
                    }
                    
                }

                public void captureScreenshot(String fileName) {
                    try {
                        new File("target/surefire-reports/").mkdirs();
                        FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
                        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                        out.close();
                        driver.quit();
                    } catch (Exception e) {
                    }
                }
            };
        }
    }
}
