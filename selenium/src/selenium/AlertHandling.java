package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
		
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
           driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
           driver.findElement(By.name("proceed")).click();
           Thread.sleep(5000);
           //Alert alert=driver.switchTo().alert();
           //System.out.println(alert.getText());
           //alert.accept();//to ok the alert
           //alert.dismiss();//to cancel the alert
           
	}

}
