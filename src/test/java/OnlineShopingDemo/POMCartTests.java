package OnlineShopingDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class POMCartTests {
	
	public WebDriver browserDriver=null;
	public LoginPage loginPage=null;
	public HomePage homePage=null;
	public WebDriverWait wait=null;
	
	@BeforeSuite
	public void beforeSuite(){
		
		System.out.println("Inside @BeforeSuite");
		
		 
		browserDriver=new ChromeDriver();
		wait=new WebDriverWait(browserDriver,Duration.ofSeconds(10));
		 
		 browserDriver.get("https://demo.openmrs.org/openmrs/login.htm");
		 browserDriver.manage().window().maximize();			
	}
	
	@BeforeTest
	public void setUp(){
		System.out.println("Inside @BeforeTest");
		 loginPage=new LoginPage(browserDriver);
		 homePage=new HomePage(browserDriver);		 
	}
	
  @Test(dataProvider="testData",priority=1)
  public void testLogin(String userName,String password) {
	  loginPage.login(userName,password,"Inpatient ward");  
  }
  
	
	  @Test(enabled=false) public void registerPatient(){
	  homePage.registerPatient(); }
	 
	
	  @Test(enabled=true,priority=2) public void testLogout(){
	  homePage.logOutOps();
	  
	  }
	 
  
  
  @DataProvider(name="testData")
	 public static String[][] getTestData() throws IOException, InvalidFormatException{
		
		 File f1=new File("testData\\TestData.xlsx");
		 XSSFWorkbook workBook=new XSSFWorkbook(f1);
		 String userName="";
		 String password="";
		 int i=0;
		 int j=0;
		
		 //int numberOfRow=workBook.getSheet("UserCred").getLastRowNum();
		 
		 
		 String [] [] cred= new String[1][2];
		 
		 workBook.getSheet("UserCred").getRow(1).getCell(0).setCellType(CellType.STRING);;
		 userName=workBook.getSheet("UserCred").getRow(1).getCell(0).getStringCellValue();
	 
		 workBook.getSheet("UserCred").getRow(1).getCell(0).setCellType(CellType.STRING);;
		 password=workBook.getSheet("UserCred").getRow(1).getCell(1).getStringCellValue();
		 
		 cred[0][0]=userName;
		 cred[0][1]=password;
	
		 
		 return cred;
	 }
	
  @AfterTest
  public void tearDown() {
	  browserDriver.quit();
  }
  
  
}
