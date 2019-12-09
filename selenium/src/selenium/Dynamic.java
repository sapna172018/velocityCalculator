package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
  		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
  		
  		driver.get("https://www.guru99.com/xpath-selenium.html");
  		WebElement el=driver.findElement(By.xpath("//ul[@class='g-toplevel']//li[2]//*[text()='Testing']"));
  		Actions action =new Actions(driver);
  		action.moveToElement(el).contextClick().build().perform();
  		
	}

}
