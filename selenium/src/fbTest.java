import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fbTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
//  		driver.get("https://www.facebook.com");
//  		JavascriptExecutor ex= (JavascriptExecutor)driver;
//  		ex.executeScript("document.getElementById('email').value='sapna030717@gmail.com'");
//  		String title=(String)ex.executeScript("return document.title");
//  		System.out.println(title);
  		try{
  			driver.get("xyz.com");
  		}
  		catch(Exception e) {
  			System.out.println(e.getMessage());
  			
  		}
  		
  		finally {
  			driver.close();
  		}
  		}

	}


