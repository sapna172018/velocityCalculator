import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class weather {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );//used for page synchronization between your code and elements on page 
		   driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		   driver.get("https://www.msn.com/en-in/weather/today/delhidelhiindia/we-city?q=delhi&form=PRWLAS&iso=IN&el=%2BGsK394XuR4ZKoIR%2F4A02w%3D%3D&fbclid=IwAR099lbjVDNP7zy6FO85P9MPPNlU5G4ZasMFtRegSTuJ6igTh7KIy2041fQ");
		   scrollDown( driver);
		  
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		   WebElement fr=driver.findElement(By.xpath("//li[@id='fbcount']//iframe"));
		   driver.switchTo().frame(fr);
		   WebDriverWait wait1=new WebDriverWait(driver, 20);
		   WebElement like=driver.findElement(By.xpath("//div[@id='u_0_0']//div//button[@class='inlineBlock _2tga _49ve' ]"));
		  
		   Actions builder = new Actions(driver);
		   builder.moveToElement(like).click().build().perform();
		 
		    
		   Set<String> LikWin=driver.getWindowHandles();
	       Iterator<String> it=LikWin.iterator();
		   String parentId=it.next();
		   String ChildId=it.next();
		   driver.switchTo().window(ChildId);
           driver.close();
		  
		
		 
	}
	
	public static void  scrollDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
	}


	
}
