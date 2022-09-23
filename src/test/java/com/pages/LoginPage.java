package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	
//Declaring all WebElement
private final By userNameLocator = By.id("username");
private final By passwordLocator = By.id("password");
private final By locationLocator=By.id("Inpatient Ward");
private final By loginButtonLocator = By.id("loginButton");

public LoginPage(WebDriver driver){
	super(driver);	
}

public void login(String userName,String password,String location){
	setUserName(userName);
	setPassword(password);
	choseLocation(location);
	clickOnLogin();		
}

private void setUserName(String userName){
	WebElement userNameTextBox=chromeDriver.findElement(userNameLocator);
	visibilityOfElement(userNameTextBox);
	setText(userNameTextBox,userName);
	}

private void setPassword(String password){
	WebElement passwordTextBox=chromeDriver.findElement(passwordLocator);
	visibilityOfElement(passwordTextBox);
	setText(passwordTextBox,password);
	}

private void choseLocation(String location){
	WebElement wb=chromeDriver.findElement(locationLocator);
	mouseHoverAndClick(wb);		
}


private void clickOnLogin(){	
	WebElement loginButton=chromeDriver.findElement(loginButtonLocator);
	visibilityOfElement(loginButton);
	clickOnElement(loginButton);
					
}


}
