package selenium;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );//used for page synchronization between your code and elements on page 
		   driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
           driver.get("https://www.google.com/");
           driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Testing");
           List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbtc']"));
           for(int i=0;i<list.size();i++) {
           System.out.println(list.get(i).getText());
           }
           
           for(int i=0;i<list.size();i++) {
               if(list.get(i).getText().contains("testing time")) {
            	   list.get(i).click();
               }
               }
           

	}

}
