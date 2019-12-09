package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AllowPopUp {
	static WebDriver driver;
		public static void main(String[] args) {
			ChromeOptions options = new ChromeOptions();
	  		options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
			driver = new ChromeDriver(options);
	         driver.manage().window().maximize();
	  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	  		driver.get("https://www.facebook.com/");
	  		driver.findElement(By.name("email")).sendKeys("sapna030717@gmail.com");
	  		driver.findElement(By.name("pass")).sendKeys("SHIVANSH@0302");
	  		driver.findElement(By.xpath("//input[@value='Log In']")).click();

	  		driver.findElement(By.xpath("//a[@id='findFriendsNav']")).click();
	  	    //Alert alert = driver.switchTo().alert();
 		    //alert.accept();

	}

}
