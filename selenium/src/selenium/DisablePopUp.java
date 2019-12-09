package selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DisablePopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
         Alert alert = driver.switchTo().alert();
  		   alert.accept();


	}

}
