package com.app.Hubspot.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.Hubspot.base.BaseTest;
import com.app.Hubspot.pages.Contacts;
import com.app.Hubspot.pages.Home;
import com.app.Hubspot.pages.Login;
import com.app.Hubspot.util.utility;

public class ContactTest extends BaseTest {
	Login log;
	Home home;
	Contacts con;
	String SheetName="Sheet1";
	
	
	public ContactTest() {
		super();
	}

	@BeforeMethod
	 public void Setup() {
 	   Initialization();
 	   log=new Login();
 	   con=new Contacts();
 	  home=log.LoginInHub(prop.getProperty("Email"), prop.getProperty("password"));
 	 home.clickOnContact();
 	    }
	
	/*@Test(priority=1)
	public void VerifyTitleContactTest() {
		String Title=con.verifyTitleOfContact();
		Assert.assertEquals(Title,"Contacts");
	}
	*/
	@DataProvider
	public Object[][] HubSpotData() {
		Object Data[][]=utility.getTestData(SheetName);
		return Data;
	}
	
	@Test(dataProvider="HubSpotData")
	public void CreateContact(String Email,String FirstName,String LastName,String COwner,String JobTitle) {
		utility.Wait(Contacts.Create);
		con.CreateContact(Email, FirstName, LastName,COwner, JobTitle);
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	
	
}
