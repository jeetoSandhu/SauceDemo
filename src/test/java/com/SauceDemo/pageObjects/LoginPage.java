package com.SauceDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;

	// Constructor
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Capture the username text field
	@FindBy(id = "user-name")
	@CacheLookup
	WebElement txtUsername;

	// Capture the password text field
	@FindBy(id = "password")
	@CacheLookup
	WebElement txtPassword;

	// Capture Login Button
	@FindBy(xpath = "//input[@class='btn_action']")
	@CacheLookup
	WebElement btnLogin;
	
	//Capture Error Message on login page
	@FindBy (xpath="//*[@id=\"login_button_container\"]/div/form/h3")
	@CacheLookup
	WebElement txtErrorMsg;
	
	

	// ----------------------------------------------------------------------------------------------

	// Pass value to username
	public void settxtUsername(String uname) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.sendKeys(uname);
	}

	// Pass value to password
	public void settxtPassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(pwd);
	}

	// Click on Login button
	public void clkbtnLogin() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}

	//Get the text from the error message
	public String gettxtErrorMsg() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtErrorMsg));
		wait.until(ExpectedConditions.elementToBeClickable(txtErrorMsg));
		return txtErrorMsg.getText();
	}
	
}
