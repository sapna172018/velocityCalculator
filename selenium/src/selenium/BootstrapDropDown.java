package selenium;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BootstrapDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS );//used for page synchronization between your code and elements on page 
		   driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		   driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		   driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		   List<WebElement> list=driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		   for(int i=0;i<list.size();i++) {
			   list.get(i).getText();
			   if(list.get(i).getText().contains("Angular")) {
				   list.get(i).click();
				   break;
			   }
		   }
		   
		   /*for(int i=0;i<list.size();i++) {
			   System.out.println(list.get(i).getText());
			   boolean sel=list.get(i).isSelected();
			   System.out.println(sel);
			   if(!list.get(i).isSelected()) {
			     list.get(i).click();
		   }
			   boolean sel1=list.get(i).isSelected(); 
			     System.out.println(sel1);
		  
		   }
	}*/

		   /*driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		   JavascriptExecutor jse=(JavascriptExecutor)driver;
		   jse.executeScript("window.scrollBy(0,1000)");
		   driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		   List<WebElement>list=driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		   
		   for(int i=0;i<list.size();i++) {
			   System.out.println(list.get(i).getText());
			   //if(list.get(i).getText().contains("Another action")) {
				 //  list.get(i).click();
			   //}
			   
		   }*/
		   
}
}
