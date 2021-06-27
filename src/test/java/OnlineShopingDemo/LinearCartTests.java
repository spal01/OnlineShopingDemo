package OnlineShopingDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LinearCartTests {
	
	 @BeforeTest
	  public void beforeTest() {
		 System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		  System.out.println("In side before test");
	  }
  @Test
  public void LinearAddToCartTest() {
  //Installation
	  WebDriver browser=new ChromeDriver();
      WebDriverWait wait = new WebDriverWait(browser, 10);
      browser.manage().window().maximize();

	  
  //Launch the website 
      browser.get("http://automationpractice.com/");
  //Navigate to Login Page
  //Login Operation
	  
  //Navigate back to Home Page
	  
 //Select the first product from list
	  
//Add 1 product to cart

//proceed to checkout
	  
//Verify we have 1 item in the cart	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  System.out.println("In side before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In side after method");

  }

 

  @AfterTest
  public void afterTest() {
	  System.out.println("In side after test");
  }

}
