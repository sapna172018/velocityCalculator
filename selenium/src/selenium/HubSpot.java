package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;

public class HubSpot {
	static WebDriver driver;
	public static void Wait(WebElement Locator) {
		 WebDriverWait wait =new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.elementToBeClickable(Locator));
			Locator.click();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
        driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );//used for page synchronization between your code and elements on page 
		   driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		   driver.get("https://app.hubspot.com/login?_ga=2.205256208.1499448162.1570408621-563110891.1570212511");
		   System.out.println(driver.getTitle());
		   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sana03175@gmail.com");
		   driver.findElement(By.id("password")).sendKeys("Texas@123");
		   driver.findElement(By.id("loginBtn")).click();
		   System.out.println(driver.getTitle());
		   driver.findElement(By.xpath("//a[@id='nav-primary-contacts-branch' and @data-tracking='click hover']")).click();
		   driver.findElement(By.xpath("//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Contacts')] ")).click();
		   System.out.println(driver.getTitle());
		
		  WebElement Loc=driver.findElement(By.xpath("//span[contains(text(),'Create contact')]"));
		  Wait(Loc);
		   //WebDriverWait wait =new WebDriverWait(driver,100);
			//wait.until(ExpectedConditions.elementToBeClickable(Loc));
			//Loc.click();
		   driver.findElement(By.xpath("//input[@data-field='email']")).sendKeys("honey123@gmail.com");
		   driver.findElement(By.xpath("//input[@data-field='firstname']")).sendKeys("honey");
		   driver.findElement(By.xpath("//input[@data-field='lastname']")).sendKeys("don");
	      //WebElement drop= driver.findElement(By.xpath("//div[@data-field='hubspot_owner_id']//span[@class='private-dropdown__button-label uiDropdown__buttonLabel']"));
	     
		   WebDriverWait wait=new WebDriverWait(driver,30);
		   boolean invisible =wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='private-overlay uiOverlay-backdrop private-overlay--light private-overlay--contextual' and @role='presentation']")));
		   if(invisible) {
			   
			   driver.findElement(By.xpath("//div[@data-field='hubspot_owner_id']//span[@class='private-dropdown__button-label uiDropdown__buttonLabel']")).click();
			   
		   }
		    driver.findElement(By.xpath("//input[@class='form-control private-form__control private-search-control__input' and @role='combobox']")).sendKeys("sana sharma"+"\n");
		    
		   /* WebDriverWait wait1=new WebDriverWait(driver,30);
			   boolean invisible1 =wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class='form-control private-form__control' and @data-field='firstname']")));
			   if(invisible) {
				   
				   driver.findElement(By.xpath("//span[contains(text(),'sana sharma (sana03175@gmail.com)')]")).click();
			   }*/
		  // driver.findElement(By.xpath("//span[contains(text(),'sana sharma (sana03175@gmail.com)')]")).click();
		   driver.findElement(By.xpath("//input[@data-field='jobtitle' and @data-selenium-test='property-input-jobtitle']")).sendKeys("tester");
		  
		   /*WebDriverWait wait1=new WebDriverWait(driver,30);
		   boolean invisible1 =wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='UIIcon__IconContent-pg6n1x-0 dEdOCo']")));
		   if(invisible1) {
			   
			   driver.findElement(By.xpath("//div[contains(text(),'Create contact')]")).click();
			   
		   }*/
		  driver.findElement(By.xpath("//button[@class='uiButton private-button--primary private-loading-button private-button--primary private-button private-button--default private-button--non-link'] ")).click();
		 

	}

}
//span[@class='private-dropdown__button-label uiDropdown__buttonLabel']//span/descendant::span[@class='private-dropdown__item__label']

// <div class="private-overlay uiOverlay-backdrop private-overlay--light private-overlay--contextual" role="presentation">...</div>