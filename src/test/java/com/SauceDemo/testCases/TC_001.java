package com.SauceDemo.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.SauceDemo.baseClass.BaseClass;
import com.SauceDemo.pageObjects.LoginPage;
import com.SauceDemo.utilites.XLUtils;

//This is to verify the functionality of login feature with valid username and valid password

public class TC_001 extends BaseClass {
	@Test(dataProvider = "logintestDDT_001")
	public void loginTest001(String testusername, String testpassword) throws IOException {

		logger.info("Started TC_001");
		// Login Page
		logger.info("Providing Login Details");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtUsername(testusername);
		loginpg.settxtPassword(testpassword);
		loginpg.clkbtnLogin();
		
		logger.info("Login Page validation");
		SoftAssert softassert = new SoftAssert();
		if (driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html")) {
			logger.info("Login successful");
			softassert.assertTrue(true);
			System.out.println("Login is successful!!");
			//Go back to HomePage
			driver.navigate().back();
		} else {
			logger.error("Login failed");
			softassert.assertTrue(false);
			captureScreen(driver, "LoginTest001");
			System.out.println("Login is NOT successful!!");
			//Refresh the page to read data
			driver.navigate().refresh();
		}
		softassert.assertAll();
				
		}

	@DataProvider(name = "logintestDDT_001")
	public String[][] getloginData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\SauceDemo\\testData\\TestData.xlsx";

		int rownum = XLUtils.getRowCount(path, "ValidData");
		int colnum = XLUtils.getCellCount(path, "ValidData", 0);

		String logindata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "ValidData", i, j);
			}
		}
		return logindata;

	}

}
