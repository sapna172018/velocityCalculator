package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class javaScriptExecutor {
	
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
         driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );//used for page synchronization between your code and elements on page 
		   driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
           driver.get("https://classic.crmpro.com/index.html?e=1");
           driver.findElement(By.name("username")).sendKeys("naveenk");
           driver.findElement(By.name("password")).sendKeys("test@123");
           WebElement btn= driver.findElement(By.xpath("//input[@class='btn btn-small']"));
           flash(btn,driver);//to make the element flas
           drawBorder(btn,driver);//to draw the border
           //take a screen shot 
           File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(src,new File("C:\\Users\\sapna\\Desktop\\workspaceSele\\selenium\\src\\selenium\\crm.png"));
           //generate the alert
          // generateAlert(driver,"There is some issue with login button");
           clickByJs(driver,btn);
           refresh(driver);
          String tit= getTitle(driver);
          System.out.println(tit);
         System.out.println( getInnerText(driver));
         scrollDown(driver);
        // WebElement fp=driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
         //scrollIntoView(driver,fp);

	}
	
	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		
	
	 try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

}
	
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		
	
	 try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
		
	
	 try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static void clickByJs(WebDriver driver,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
		
	
	 try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
	public static void refresh(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		
	
	 try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}
	public static String getInnerText(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String text=js.executeScript("return document.documentElement.innerText;").toString();
		return text;
		
	}
	
	public static void  scrollDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
	}
	public static void  scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		
	}
}
