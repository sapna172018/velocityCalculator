package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HandlingElement {
 
	WebDriver driver;
	String url;

	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\sapna\\Desktop\\New folder\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			//WebDriver driver=new FirefoxDriver();//using firefox browser driver
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void HandleTextArea() {
		try {
			invokeBrowser("https://www.gmail.com/");
			driver.findElement(By.name("identifier")).sendKeys("sapna030717");
			System.out.println(driver.findElement(By.name("identifier")).getAttribute("value"));
			int num=driver.findElements(By.tagName("a")).size();
			System.out.println();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	public void HandleImage() {
		try {
			invokeBrowser("https://www.google.com/");
			WebElement img=driver.findElement(By.id("hplogo"));
			System.out.println(img.getAttribute("title"));
			driver.navigate().to("http://newtours.demoaut.com/");
			driver.findElement(By.name("login")).click();
			driver.navigate().to("https://www.amazon.com/");
			driver.findElement(By.xpath("//div[@class='a-section grid-row-1']//div[@class='a-section a-spacing-none quadrant-container-1 aok-float-left']//a[@class='a-link-normal quadrant-overlay']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	public void HandlingLink(){
		invokeBrowser("https://www.google.com/");
		//driver.findElement(By.className("gb_P")).click();
		//driver.findElement(By.linkText("Gmail")).click();
		//driver.findElement(By.partialLinkText("ma")).click();
		WebElement gmail=driver.findElement(By.cssSelector(".gb_e"));
		//driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		Boolean isDis=gmail.isDisplayed();
		System.out.println(isDis);
		Boolean isEnable=gmail.isEnabled();
		System.out.println(isEnable);
		String text=gmail.getText();
		System.out.println(text);
		gmail.click();
		}
	public void HandlingRadioButton() {
		invokeBrowser("http://www.gcrit.com/build3/create_account.php?osCsid=d2ir0hha6aup6bbves3o32kua6");
		WebElement Radio=driver.findElement(By.xpath("//input[@value='m']"));
		System.out.println(Radio.isDisplayed());
		System.out.println(Radio.isEnabled());
		System.out.println(Radio.isSelected());
		Radio.click();
		System.out.println(Radio.isSelected());
		
	}
	
	public void HandlingDropDown() {
		invokeBrowser("http://www.gcrit.com/build3/create_account.php?osCsid=d2ir0hha6aup6bbves3o32kua6");
		Select Drop=new Select(driver.findElement(By.name("country")));
		//Drop.selectByIndex(1);
		Drop.selectByVisibleText("India");
		List<WebElement> e=Drop.getOptions();
		System.out.println(e.get(2));
	
		int itemCount=e.size();
		System.out.println(itemCount);
		driver.findElement(By.name("telephone")).sendKeys("9901385634");
		
		}
	
	public void HandlingInlineElements() {
		invokeBrowser("https://www.google.com/");
		driver.findElement(By.cssSelector(".gb_C")).click();
		//driver.findElement(By.xpath("//a[@class='gb_z gb_vc']")).click();
		driver.switchTo().frame("I0_1568308710954");
		//driver.findElement(By.xpath("//span[@class='MrEfLc' and@ pid='8']")).click();
		driver.findElement(By.xpath("//a[@id='gb1']//span[@class='gb_m']")).click();
		//driver.findElement(By.xpath(" //a[@class='gb_F gb_bg']")).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//ul[@class='gb_E gb_w']")));
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("window.ScrollBy(0,1000)");
		//driver.findElement(By.xpath("//a[@id='gb24']//span[@class='gb_m']")).click();
		//driver.findElement(By.xpath("//a[@id='gb429']//span[@class='gb_m']")).click();
		//driver.findElement(By.xpath("//a[@id='gb23']//span[@class='gb_W']")).click();
		//driver.navigate().back();
	}
	
	public void HandlingFrame() throws InterruptedException {
		invokeBrowser("https://seleniumhq.github.io/selenium/docs/api/java/");
		//driver.switchTo().frame(2);//using frame index
		//switch to 3rd frame
		driver.switchTo().frame("classFrame");//by using frame name
		
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		Thread.sleep(3000);
		//Switch from 3rd frame to top window
		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		//driver.switchTo().frame(0);
		//driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		}
	public void HandlingMouseHover() {
		invokeBrowser("https://www.carmax.com/");
		WebElement menu=driver.findElement(By.cssSelector(".header-helpful-links-title"));
		//create action instance (Builder) by passing webdriver Instance(driver)
		Actions builder=new Actions(driver);
		builder.moveToElement(menu).build().perform();
		driver.findElement(By.linkText("Service")).click();
		
	}
	public void HandleDuplicateObject() {
		invokeBrowser("http://www.gcrit.com/build3/admin/login.php");
		driver.findElement(By.name("username")).sendKeys("admina");
		driver.findElement(By.name("password")).sendKeys("admin@123");
		driver.findElement(By.id("tdb1")).click();
		//driver.findElement(By.linkText("Online Catalog")).click();
		String url=driver.getCurrentUrl();
		if(url.equals("http://www.gcrit.com/build3/admin/index.php"))
		{
			driver.findElement(By.linkText("Online Catalog")).click();
		}
		System.out.println(driver.getCurrentUrl());		
	}
	public static void main(String[] args) throws InterruptedException {
     HandlingElement obj=new HandlingElement();
    //obj.HandleTextArea();	
    // obj.HandleImage();
     //obj.HandlingLink();
     //obj.HandlingRadioButton();
    // obj.HandlingDropDown();
       // obj.HandlingInlineElements();
     obj.HandlingFrame();
    // obj.HandlingMouseHover();
    // obj.HandleDuplicateObject();
	}

	
}



