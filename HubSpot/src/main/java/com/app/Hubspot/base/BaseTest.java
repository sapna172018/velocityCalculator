package com.app.Hubspot.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.app.Hubspot.util.WebEventListener;
import com.app.Hubspot.util.utility;



public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseTest()  {
		try {
			prop=new Properties();
			FileInputStream inp;
			inp = new FileInputStream("C:\\Users\\sapna\\Desktop\\workspaceSele\\HubSpot\\src\\main\\java\\com\\app\\Hubspot\\config\\config.properties");
			try {
				prop.load(inp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void Initialization() {
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.contains("chrome")) {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
	           driver = new ChromeDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		//now create object of event listener to register it with eventFiringDriver
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT,TimeUnit.SECONDS );
		driver.get(prop.getProperty("url"));
		
	}
	
	
}

