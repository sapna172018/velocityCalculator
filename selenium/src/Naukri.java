import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Naukri {

	public static void main(String[] args) {
		WebDriver driver;
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver(op);
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/");
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        Alert alert=driver.switchTo().alert();
//        alert.accept();
//        
	}

}
