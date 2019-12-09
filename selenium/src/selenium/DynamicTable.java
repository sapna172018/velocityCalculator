package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		WebDriver driver;
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]"));
		List<WebElement> col=driver.findElements(By.xpath("//div[@id='leftcontainer']//table//thead//tr//th"));
		List<WebElement> row=driver.findElements(By.xpath("//div[@id='leftcontainer']//table//tbody//tr"));
		System.out.println("Number of cols "+col.size());
		System.out.println("Number of rows "+row.size());
		
		String before_xpath="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
				String After_xpath="]/td[1]/a";
				
				for(int i=1;i<=row.size();i++) {
					String name=driver.findElement(By.xpath(before_xpath+i+After_xpath)).getText();
					if(name.equals("Vakrangee")) {
						String s=driver.findElement(By.xpath(before_xpath+i+"]//td[4]")).getText();
						System.out.println(s);
					}
					
					
				}
				
				
		
		//*[@id="leftcontainer"]/table/tbody/tr[3]/td[1]/a
		//*[@id="leftcontainer"]/table/tbody/tr[4]/td[1]/a
		
		
		
		//*[@id="leftcontainer"]/table/tbody/tr[3]/td[4]
		//*[@id="leftcontainer"]/table/tbody/tr[4]/td[4]
		
		

	}

}
