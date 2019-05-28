package com.SauceDemo.testCases;

import java.io.IOException;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.SauceDemo.baseClass.BaseClass;
import com.SauceDemo.pageObjects.LoginPage;

//This is to verify the functionality of login feature by leaving username field 'Blank' and entering valid password
//This testcase will pass when the login is Unsuccessful

public class TC_005 extends BaseClass {
	@Test
	public void loginTest005() throws IOException {

		logger.info("Started TC_005");
		// Login Page
		logger.info("Providing Login Details");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtPassword(password);
		loginpg.clkbtnLogin();
		
		logger.info("Login Page validation");
		SoftAssert softassert = new SoftAssert();
		if (loginpg.gettxtErrorMsg().contains("Username is required")) {
			logger.info("Login NOT successful due to Blank Username");
			softassert.assertTrue(true);
			System.out.println("Login NOT successful!!");
			
			//Refresh the page after invalid data
			driver.navigate().refresh();
			
		} else {
			logger.error("Login successful even when username is 'Blank'");
			softassert.assertTrue(false);
			captureScreen(driver, "LoginTest005");
			System.out.println("Login is successful with Blank Username!!");
			
			//Go back to Homepage to read data
			driver.navigate().back();
		}
		softassert.assertAll();
		
	
		}

	}
