package com.SauceDemo.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.SauceDemo.baseClass.BaseClass;
import com.SauceDemo.pageObjects.LoginPage;

//This is to verify the functionality of login feature by  entering valid username and leaving password field 'Blank'
//This testcase will pass if login is Unsuccessful

public class TC_006 extends BaseClass {
	@Test
	public void loginTest006() throws IOException {

		logger.info("Started TC_006");
		// Login Page
		logger.info("Providing Login Details");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtUsername(username1);
		loginpg.clkbtnLogin();
		
		logger.info("Login Page validation");
		SoftAssert softassert = new SoftAssert();
		if (loginpg.gettxtErrorMsg().contains("Password is required")) {
			logger.info("Login NOT successful due to Blank Password");
			softassert.assertTrue(true);
			System.out.println("Login NOT successful!!");
			//Refresh the page after invalid data
			driver.navigate().refresh();
			
		} else {
			logger.error("Login successful even when Password is Blank ");
			softassert.assertTrue(false);
			captureScreen(driver, "LoginTest006");
			System.out.println("Login is successful with Blank Password!!");
			//Go back to Homepage to read data
			driver.navigate().back();
		}
		softassert.assertAll();
		
	
		}
}
