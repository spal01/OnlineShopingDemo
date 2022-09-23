package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	private final By logoutLocator=By.linkText("Logout");
	String dd="referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]";
	private final By regiserPatietLocator=By.id(dd);
	
		public HomePage(WebDriver webDriver){
		super(webDriver);
		
	}
	
	public void logOutOps(){
		WebElement wb=chromeDriver.findElement(logoutLocator);
		 clickOnElement(wb);
		
	}

	
	public void registerPatient(){
		WebElement wb=chromeDriver.findElement(regiserPatietLocator);
		 clickOnElement(wb);
		
	}
}
