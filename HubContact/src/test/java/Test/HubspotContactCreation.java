package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.utility;

public class HubspotContactCreation {

	  WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
           driver = new ChromeDriver();
          driver.manage().window().maximize();
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
  		driver.get("https://app.hubspot.com/login?_ga=2.198293807.1499448162.1570408621-563110891.1570212511");
	
		
		driver.findElement(By.id("username")).sendKeys("sana03175@gmail.com");
  		driver.findElement(By.id("password")).sendKeys("Texas@123");
  		driver.findElement(By.id("loginBtn")).click();
  		
	}
	
	
	@DataProvider
	public Object[][] Data(){
		Object[][] EData=utility.Emp();
		return EData;
	}
	
	@Test(dataProvider="Data") 
	
	public void createContact(String email,String FName,String LName,String owner,String Job) {
		Actions action =new Actions(driver);
  		WebElement contact=driver.findElement(By.id("nav-primary-contacts-branch"));
  	   // utility.clickOn(driver, contact, 60);
  		action.moveToElement(contact).click().build().perform();
  		WebElement con=driver.findElement(By.xpath("//ul[@class='primary-links']//li[2]//div[contains(text(),'Contacts')]"));
  		//utility.clickOn(driver, con, 60);
  		con.click();
  	    WebElement cc=driver.findElement(By.xpath("//span[contains(text(),'Create contact')]"));
  		JavascriptExecutor ex=((JavascriptExecutor)driver);
  		ex.executeScript("arguments[0].click();",cc);
  		WebElement em=driver.findElement(By.xpath("//input[@data-field='email']"));
  		utility.clickOn(driver, em, 40);
  	    em.sendKeys(email);
  		//WebDriverWait wait=new WebDriverWait(driver,30);
  		driver.findElement(By.xpath("//input[@data-field='firstname']")).sendKeys(FName);
  		WebDriverWait wait=new WebDriverWait(driver,30);
  		driver.findElement(By.xpath("//input[@data-field='lastname']")).sendKeys(LName);
  		//Actions action =new Actions(driver);
  		WebElement drop=driver.findElement(By.xpath("//span[@class='uiDropdown__buttonCaret private-dropdown__caret private-dropdown__caret--form']"));
  		action.moveToElement(drop).click().build().perform();
  		
  		driver.findElement(By.xpath("//input[@class='form-control private-form__control private-search-control__input' and @role='combobox']")).sendKeys(owner+"\n");
  		driver.findElement(By.xpath("//input[@data-field='jobtitle']")).sendKeys(Job);
  		driver.findElement(By.xpath("//button[@class='uiButton private-button--primary private-loading-button private-button--primary private-button private-button--default private-button--non-link']")).click();
  		//WebDriverWait wait1 =new WebDriverWait(driver,30);
  		}

	
	
	

	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	
	
}


