package selenium;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           driver.get("https://www.facebook.com");
           //clickOn(driver,driver.findElement(By.xpath("//input[@value='Log In']")),40);

           

	
	
	Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofMillis(100))
			.pollingEvery(Duration.ofMillis(10))
			.ignoring(NoSuchElementException.class);
	
	WebElement myElement = wait.until(new Function<WebDriver,WebElement>() {
		public WebElement apply(WebDriver driver) {
			WebElement currentElement=driver.findElement(By.xpath("//input[@value='Log In']"));
			return currentElement;
		}
	});
	
	myElement.click();
//	public static void clickOn(WebDriver driver,WebElement locator,int timeout) {
//		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//		locator.click();
//		
//	}//Here we create an object refrence of WebDriverWait class with parameter  driverand timeout that call a method ignoring stale Element Refrence 
	 //until a condition met which click on a locator

}
}
