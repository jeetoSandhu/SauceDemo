package com.SauceDemo.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.SauceDemo.baseClass.BaseClass;
import com.SauceDemo.pageObjects.LoginPage;
import com.SauceDemo.utilites.XLUtils;

//This is to verify the functionality of login feature by  entering Special Symbols in username field and enter valid password
//This testcase will pass if login is unsuccessful

public class TC_008 extends BaseClass {
	@Test(dataProvider = "logintestDDT_008")
	public void loginTest008(String testusername, String testpassword) throws IOException {
		logger.info("Started TC_008");
		// Login Page
		logger.info("Providing Login Details");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtUsername(testusername);
		loginpg.settxtPassword(testpassword);
		loginpg.clkbtnLogin();
		
		logger.info("Login Page validation");
		SoftAssert softassert = new SoftAssert();
		if (loginpg.gettxtErrorMsg().contains("Username and password do not match any user in this service")) {
			logger.info("Login NOT successful");
			softassert.assertTrue(true);
			System.out.println("Login credentials are invalid!!");
			//Refresh the page after invalid data
			driver.navigate().refresh();
		} else {
			logger.error("Login successful with Invalid Credentials");
			softassert.assertTrue(false);
			captureScreen(driver, "LogintestDDT_008");
			System.out.println("Login is successful with Invalid credentials!!");
			//Go back to Homepage
			driver.navigate().back();
		}
		softassert.assertAll();
		
		}

	@DataProvider(name = "logintestDDT_008")
	public String[][] getloginData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\SauceDemo\\testData\\TestData.xlsx";

		int rownum = XLUtils.getRowCount(path, "SpecialCharUname");
		int colnum = XLUtils.getCellCount(path, "SpecialCharUname", 0);

		String logindata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "SpecialCharUname", i, j);
			}
		}
		return logindata;

	}
}
