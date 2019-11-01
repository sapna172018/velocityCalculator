package com.app.Hubspot.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.Hubspot.base.BaseTest;
import com.app.Hubspot.pages.Home;
import com.app.Hubspot.pages.Login;
import com.app.Hubspot.util.utility;

public class HomeTest extends BaseTest {
	Login log;
	Home home;
	utility ut;
	
	
	public HomeTest() {
		super();
	}

	@BeforeMethod
	 public void Setup() {
 	   Initialization();
 	   log=new Login();
 	  home=log.LoginInHub(prop.getProperty("Email"), prop.getProperty("password"));
    }
	
	@Test(priority=1)
	public void VerifyTitleAfterLoginTest() {
		String Title=home.verifyAfterLogin();
		Assert.assertEquals(Title,"HubSpot Login");
	}
	
	@Test(priority=2)
	public void MoveCreateContact() {
		home.clickOnContact();
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
	}
}
