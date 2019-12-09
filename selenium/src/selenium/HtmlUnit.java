package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlUnit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
       //WebDriver driver = new ChromeDriver();
		 ChromeOptions option =new ChromeOptions();
	       option.addArguments("window-size=1400,800");
	       option.addArguments("headless");
		WebDriver driver = new ChromeDriver(option);
          driver.manage().window().maximize();
           driver.get("https://www.facebook.com");
           String BeforeLogin=driver.getTitle();
           System.out.println("Title before login"+BeforeLogin);
           driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sapna030717@gmail.com");
           driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("SHIVANSH@0302");
           driver.findElement(By.xpath("//input[@type='submit']")).click();
           //driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sapna030717@gmail.com");
           //driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Loveyou7*");
           String AfterLogin=driver.getTitle();
           System.out.println("Title After login"+AfterLogin);
           

	}

}
