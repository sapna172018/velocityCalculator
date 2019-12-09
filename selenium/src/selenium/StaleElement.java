package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StaleElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
       ChromeOptions op=new ChromeOptions();
       op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
  		driver.get("https://www.facebook.com");
//  		JavascriptExecutor ex= (JavascriptExecutor)driver;
//  		ex.executeScript("document.getElementById('email').value='sapna030717@gmail.com'");
//  		String title=(String)ex.executeScript("return document.title");
//  		System.out.println(title);
  		WebElement username=driver.findElement(By.id("email"));
  		driver.navigate().refresh();
  		try{
  			username.sendKeys("sapna030717@gmail.com");
  		}
  		catch(StaleElementReferenceException e) {
  		 username=driver.findElement(By.id("email"));
  			username.sendKeys("sapna030717@gmail.com");
  		}
  		driver.findElement(By.id("pass")).sendKeys("SHIVANSH@0302");
  		driver.findElement(By.xpath("//input[@type='submit']")).click();
  		

	}

}
