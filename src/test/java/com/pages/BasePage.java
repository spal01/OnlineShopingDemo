package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public WebDriver chromeDriver=null;
	public WebDriverWait wait=null;
	
	//Used for Mouse Operation
	public Actions actions=null;
	public Action action=null;
	//Used for DropDown Operation
	public Select sel=null;
	//Alert Operation
	public Alert alert=null;
		
	public BasePage(WebDriver driver){
		System.out.println("Inside Parent Class BasePage consructor");
		chromeDriver=driver;				
	}
	
	//Get text from the attribute
		public String getText(WebElement wb){
			return wb.getText();
		}
		
			
		//list of all operation that is related to web element
		//Send characters to edit box
		public void setText(WebElement wb,String data){		
			wb.clear();
			wb.sendKeys(data);
		}
		
		//Click on WebElement
		public void clickOnElement(WebElement wb){
			wb.click();		
		}
		
		//Get the value from the text and the method is getText()
		public void textVerify(WebElement wb,String expected){
			String actual=wb.getText();
			System.out.println("actual:"+actual);
			
			//to compare between actual and expected value
			Assert.assertEquals(actual,expected);
		}
		
		//To verify if the element is display
		public boolean presenceOfElement(WebElement wb){
			
			return  wb.isSelected();
			//return wb.isEnabled();
			//return wb.isDisplayed();
			
		}
			
		//Alert operation

			//Click on Yes on Alert
			public void acceptAlert(){
			    //Switch to alert
				alert=chromeDriver.switchTo().alert();
				alert.accept();
			}
			
			//Click on Cancel/No on Alert
			public void dismissAlert(){
				//Switch to alert
				alert=chromeDriver.switchTo().alert();
				alert.dismiss();
			}

			//Get the text from Alert
			public String getTextAlert(){
				//Switch to alert
				alert=chromeDriver.switchTo().alert();
				String txt=alert.getText();
				System.out.println("alert message"+txt);
				
				return txt;
			}

		
		//Hover the mouse on the WebElement
		
		public void mouseHover(WebElement wb){	
			//Actions is a class 
			actions=new Actions(chromeDriver);
			//Generates a composite action containing all actions so far, ready to be performed
			//(and resets the internal builder state, so subsequent calls to build() will contain fresh sequences).return Action type
			action=actions.moveToElement(wb).build();
			//action is interface			
			//now perform the action that has been build
			action.perform();		
		}
		
		//MouseHover and Click on the web element ..... 
		public void mouseHoverAndClick(WebElement wb){
			actions=new Actions(chromeDriver);
			actions.moveToElement(wb).build().perform();
			wb.click(); 
		}
		
		//Right click on the web element the method is contextClick()
		public void rightClickOnElement(WebElement wb){
			actions=new Actions(chromeDriver);
			action=actions.contextClick(wb).build();
			action.perform();		
		}
		

	//Use the keyboard in selenium  	
		public void pressEnter(){
			actions=new Actions(chromeDriver);
			actions.sendKeys(Keys.ENTER).perform();
		}

		
		//Drag from one WebElement to Other WebElement>>>>>> dragAndDrop(WebElemnet1 , WebElement2)
		public void dragAndDrop(WebElement wb1,WebElement wb2){
			actions=new Actions(chromeDriver);
			action=actions.dragAndDrop(wb1, wb2).build();
			action.perform();		
		}
		
		
		//Auto Suggest 
		public void autoSuggset(WebElement wb){
			wb.click();
		}
		
		//===============Select Operation=================
		//Select the Item from Select Operation >> index , value and visible text
		public void selectByIndex(WebElement wb,int index){	
			sel = new Select(wb);
			sel.selectByIndex(index);	
		}
		
		//Select the Item from Select Operation >> value
		public void selectByValue(WebElement wb,String option){	
			sel = new Select(wb);
			sel.selectByValue(option);
			
		}
		
		//Select the Item from Select Operation >> visibleText
		public void selectByText(WebElement wb,String visibleText){	
			sel = new Select(wb);
			sel.selectByVisibleText(visibleText);
		}

		
		public void uploadFileChrome() throws IOException{	
			String autoItPath="C:\\Users\\spal\\workspace1\\SkyPortalAutomationC\\AutoItScript\\FileUploadChrome.exe";
			Runtime.getRuntime().exec(autoItPath);
		}
		
		
		public void uploadFileFirefox() throws IOException{
			String autoItPath="C:\\Users\\spal\\workspace1\\SkyPortalAutomationC\\AutoItScript\\FileUploadFirefox.exe";
			Runtime.getRuntime().exec(autoItPath);
		}
		
		
		public void uploadFileIE() throws IOException{
			String autoItPath="C:\\Users\\spal\\workspace1\\SkyPortalAutomationC\\AutoItScript\\FileUploadIE.exe";
			Runtime.getRuntime().exec(autoItPath);
		}
		
		
		public void downloadFile(WebElement wb){
			wb.click();	
		}
		
		
		//The browser related operation
		
		//Maximize the Browser Window
		public void maximizeWindow(){
			chromeDriver.manage().window().maximize();
		}
		
		//Refresh the browser Page
		public void refreshPage(){
			chromeDriver.navigate().refresh();		
		}
		
		//navigation operation
		public void forwardPage(){
			chromeDriver.navigate().forward();
		}
		
		public void backwordPage(){
			chromeDriver.navigate().back();
		}
		//=============Wait operation==============
		//Implicit Wait
		public void implicitWait(long time){
			chromeDriver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		}
		
		public void pageLoadWait(long time){
			chromeDriver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
		}
		
		
		
		//Exple of  Explicit Wait	
		public void verifyPresenceOfElement(long time,String loc){
			wait = new WebDriverWait(chromeDriver,time);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(loc)));
		}
		
		public void presenceOfElement(long time,String loc){
			wait = new WebDriverWait(chromeDriver,time);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
		}
		
		////Verify the visibility of the element by using the Explicit Wait
		public void visibilityOfElement(WebElement wb){
			wait = new WebDriverWait(chromeDriver,10);
			wait.until(ExpectedConditions.visibilityOf(wb));
		}
		
		
		
		//Check box operation on WebElement
		public void selectCheckBox(WebElement wb){
			if(!wb.isSelected())
				wb.click();
			}
		
		//TakeScreen Shot and save into a file
		public void takeScreenShot(String fileName) throws IOException{	
			String filePath=fileName;
			System.out.println("filePath "+ filePath);
			
			EventFiringWebDriver efw = new EventFiringWebDriver(chromeDriver);
			File srcFile = efw.getScreenshotAs(OutputType.FILE);
			File dstFile = new File(filePath);
			//Copy the files from source file to destination file
			//FileUtils.copyFile(srcFile, dstFile);
			}
		
		

		public String getTextOnSingleLink(WebElement wba){
			return wba.getText();
		}	
		
		
		//List of WebElement
		public HashMap<Integer,String> getAllTextOnMultipleLink(List<WebElement> wba){
		
			//Get the total number of HyperLink
			int size=wba.size();
		
		//Wrapper class should be use inside the HashMap
		HashMap<Integer,String> ob=new HashMap<Integer,String>();
		//Now take the text from the link but the text is stored in HashMap
		for(int i=0;i<size;i++){
			ob.put(i, wba.get(i).getText());
	    }
		
		return ob;
		}
		
		
		

		public int getNumberOfRowsInTable(List<WebElement> wbs){	
			return  wbs.size();		
		}

		public int getNumberOfLinksOnPage(List<WebElement> wba){
			return wba.size();
		}

		public int numberOfCheckBoxOnPage(List<WebElement> wbc){
			return wbc.size();
		}
		
		
		public List<String> getFirstColumnData(List<WebElement> wb){
			
			List<String> ob = new ArrayList<String>();
			
			int size=wb.size();
			
			for(int i=0;i<size;i++){
				ob.add(wb.get(i).getText());
			}
			
			return ob;
		}

		
		public List<String> getAnyColumnData(String xpathOfRow,int columnNumber){
			
			List<String> coloumData = new ArrayList<String>();
			
			String xpathCol=xpathOfRow+"/td["+columnNumber+"]";
			
			int numberOfRow=chromeDriver.findElements(By.xpath(xpathOfRow)).size();
			
			List<WebElement> singleColoumn=chromeDriver.findElements(By.xpath(xpathCol));
			
			
			for(int i=0;i<numberOfRow;i++){
				coloumData.add(singleColoumn.get(i).getText());
			}
					
			return coloumData;
		}
		
		//Switch to the frame::good example of method overloading frame(WebElement) frame(index) frame(String) 
		public void switchToFrame(WebElement wb){
			chromeDriver.switchTo().frame(wb);
		}
		public void switchToFrame(int index){	
			chromeDriver.switchTo().frame(index);
		}	
		public void switchToFrame(String frameName){
			chromeDriver.switchTo().frame(frameName);
		}
		
		//Again move back to previous frame
		  public void switchToPreviousFrame(String frameName){
			  chromeDriver.switchTo().defaultContent(); 
		  }
		
	//return the set of String for more than one window
		public Set<String> getAllWindow(){		
			return chromeDriver.getWindowHandles();		
		}
		
		//return the set of String for Single Window	
	  public String getSingleWindow(){		
			return chromeDriver.getWindowHandle();		
		}
	//Move to particular window by String
	  public void switchToParticularWindow(String windowName){
		  chromeDriver.switchTo().window(windowName);
	  }
		
	

}
