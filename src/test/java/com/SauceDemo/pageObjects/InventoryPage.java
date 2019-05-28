package com.SauceDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
	
	WebDriver ldriver;

	// Constructor
	public InventoryPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Capture Open Menu on Inventory page
	@FindBy (xpath="//button[contains(text(),'Open Menu')]")
		@CacheLookup
		WebElement btnOpenMenu;
	
	//Capture logout from the menu
	@FindBy (xpath = "//a[@id='logout_sidebar_link']")
	@CacheLookup
	WebElement btnLogout;
	
	//-----------------------------------
	
	public void clkbtnOpenMenu()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(btnOpenMenu));
		wait.until(ExpectedConditions.elementToBeClickable(btnOpenMenu));
		btnOpenMenu.click();
	}
	
	public void clkbtnLogout()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnLogout));
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		btnLogout.click();
	}
	
	
}
