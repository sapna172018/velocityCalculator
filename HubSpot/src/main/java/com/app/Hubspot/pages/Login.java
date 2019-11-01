package com.app.Hubspot.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.Hubspot.base.BaseTest;


public class Login extends BaseTest {
  
	//Page Factory

	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	 public WebElement Email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//span[@class='private-checkbox__indicator']")
	WebElement Remember;
	
	@FindBy(id="loginBtn")
	WebElement Submit;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateBrowsingTitle() {
		return driver.getTitle();
	}

	/*public String validateLoginTitle() {
		
		return driver.getTitle();
	}*/
	
	public Home LoginInHub(String un,String pwd) {
		
		Email.sendKeys(un);
		password.sendKeys(pwd);
		Remember.click();
		Submit.click();
		return new Home();
		}
	
}
