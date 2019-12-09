package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static WebDriver driver;
	public static void clickByJs(WebDriver driver,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
	       ChromeOptions op=new ChromeOptions();
	       op.addArguments("--disable-notifications");
			 driver = new ChromeDriver();
	          driver.manage().window().maximize();
	  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	  		driver.get("https://www.amazon.com/?ref_=nav_signin&");
//	  		WebElement ele= driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]//following::span[1]"));
//	  		Actions action= new Actions(driver);
//	  		action.moveToElement(ele).click().build().perform();
//	  		driver.findElement(By.xpath("//div[@class='nav-flyout-content']//a//span[contains(text(),'Sign in')]")).click();
//	  		driver.findElement(By.id("ap_email")).sendKeys("sapna172016@gmail.com");
//	  		driver.findElement(By.id("continue")).click();
//	  		driver.findElement(By.id("ap_password")).sendKeys("Aarna@172018");
//	  		driver.findElement(By.id("signInSubmit")).click();
	  		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby toys");
	  		WebElement search=driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
//	  		Actions action= new Actions(driver);
//	  		action.moveToElement(search).click().build().perform();
//	  		JavascriptExecutor js =(JavascriptExecutor)driver;
//	  		js.executeScript("argument[0].click();", search);
	  		//clickByJs(driver,search);
         WebDriverWait wait = new WebDriverWait(driver, 40);
	  		wait.until(ExpectedConditions.elementToBeClickable(search));
	  		search.click();
	  		WebElement drop=driver.findElement(By.id("a-autoid-0-announce"));
	  		drop.click();
	  		driver.findElement(By.xpath("//a[contains(text(),'Price: High to Low')]")).click();
	  		 //List<WebElement> list= driver.findElements(By.tagName("a"));
	  		List<WebElement> list=new ArrayList<WebElement>();
	  		list=driver.findElements(By.xpath("//span[@class='a-color-base']"));
	  		List<WebElement> list1=new ArrayList<WebElement>();
	  		list1=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	  		
	  		list.addAll(list1);
	  		System.out.println(list.size());
	  		for(int i=0;i<list.size();i++) {
	  		System.out.println(list.get(i).getText());
	  	
	  		
	}
	}

}
