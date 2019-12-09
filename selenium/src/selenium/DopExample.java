package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DopExample {

	static WebDriver driver;
	public static void Wait(WebElement Locator) {
		 WebDriverWait wait =new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.elementToBeClickable(Locator));
			Locator.click();
	}
	
//	public void checkAlert() {
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, 2);
//	        wait.until(ExpectedConditions.alertIsPresent());
//	        Alert alert = driver.switchTo().alert();
//	        alert.accept();
//	    } catch (Exception e) {
//	        //exception handling
//	    }
//	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable notifications");
		
		driver=new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("http://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("header_topcat"))).build().perform();
		Thread.sleep(3000);
		WebElement link = driver.findElement(By.cssSelector("#software-testing-certification-courses"));
		builder.moveToElement(link).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[text()='Software Testing']")).click();

		
//		WebElement el=driver.findElement(By.xpath("//*[@id='exitpop_mode']/div/div/button"));
//		Wait(el); 
		WebElement act = driver.findElement(By.cssSelector(".search_inp"));
		WebElement search = driver.findElement(By.xpath("//*[@id='remote']/span[2]"));
		
		builder.moveToElement(search).build().perform();
		Thread.sleep(3000);
		Action seriesOfActions;
		seriesOfActions = builder
		.sendKeys(act, "Selenium")
		.keyDown(search, Keys.SHIFT)
		.keyUp(search, Keys.SHIFT)
		.build();
		seriesOfActions.perform();
		//Thread.sleep(3000);
		//driver.quit();

	}

}
