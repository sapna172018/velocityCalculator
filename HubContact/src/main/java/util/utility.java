package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class utility {
	
	
	public static void clickOn(WebDriver driver,WebElement locator,int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));
		//locator.click();
		
	}
	
	
	@DataProvider(name="EmpData")
	
	public static  Object[][]  Emp(){
		
		FileInputStream file=null;
		
		try {
			file=new FileInputStream("C:\\Users\\sapna\\Desktop\\workspaceSele\\HubContact\\Contacts1.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook book=null;
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet =book.getSheet("Sheet1");
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] Data=new Object[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				
				 Data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return Data;
		
	}

}
