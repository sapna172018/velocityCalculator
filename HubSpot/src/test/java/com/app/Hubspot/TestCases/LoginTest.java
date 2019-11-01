package com.app.Hubspot.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.Hubspot.base.BaseTest;
import com.app.Hubspot.pages.Home;
import com.app.Hubspot.pages.Login;
import com.app.Hubspot.util.utility;

public class LoginTest extends BaseTest{
	
	Login log;
	Home home;
	utility ut;
	
       public LoginTest() {
    	   	super();
       }
   
       @BeforeTest
        public void Setup() {
    	   Initialization();
    	  
    	  log=new Login();
       }
       
       @Test(priority=1)
       public void ValidateBrowserTitleTest() {
    	   String title=log.validateBrowsingTitle();
    	   Assert.assertEquals(title,"Checking browser");
       }
       
       
       /*@Test(priority=2)
       public void verifyLoginTitleTest() {
     	  
    	  String title= log.validateLoginTitle();
    	  Assert.assertEquals(title,"HubSpot LogIn");
       }*/
       
       @Test(priority=2)
       public void VerifyLoginTest() {
    	home=log.LoginInHub(prop.getProperty("Email"), prop.getProperty("password"));
    	  
       }
       
       @AfterTest
       public void TearDown() {
    	 driver.quit();
       }
       
       
       
       
}
