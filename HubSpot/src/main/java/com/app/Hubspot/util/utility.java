package com.app.Hubspot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.app.Hubspot.base.BaseTest;
import com.google.common.graph.ElementOrder.Type;


public class utility extends BaseTest {
public static long PAGE_LOAD_TIMEOUT=40;
public static long IMPLICIT_WAIT=30;
public static String path="C:\\Users\\sapna\\Desktop\\workspaceSele\\HubSpot\\src\\main\\java\\com\\app\\Hubspot\\TestData\\Contacts.xlsx";
static Workbook book;
static Sheet sheet;
/*public void HandleAlert() {
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
}

public void DropDown() {
	
	
}*/

public static void Wait(WebElement Locator) {
	 WebDriverWait wait =new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		Locator.click();
}
public static void Wait2(WebElement eleIn,WebElement eleVis) {
	 WebDriverWait wait=new WebDriverWait(driver,60);
	   boolean invisible =wait.until(ExpectedConditions.invisibilityOf(eleIn));
	   if(invisible) {
		   
		  eleVis.click();
		   
	   }
	
}
  public static void takeScreenshotAtEndOfTest() throws IOException {
	  File scrFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  String currentDir = System.getProperty("user.dir");
	 // FileUtils.copyFile(scrFile,new File("C://Users//sapna//Desktop//workspaceSele//edureka//src//co//edureka//selenium//in//google.png"));
	
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
  }

@DataProvider(name="TestAdd")
public static Object[][] getTestData(String SheetName) {
FileInputStream file=null;
try {
	file =new FileInputStream(path);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
	book=WorkbookFactory.create(file);
} catch (EncryptedDocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

sheet=book.getSheet(SheetName);
 
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