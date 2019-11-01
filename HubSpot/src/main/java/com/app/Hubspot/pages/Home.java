package com.app.Hubspot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.Hubspot.base.BaseTest;

public class Home extends BaseTest {
	
	@FindBy(xpath="//a[@id='nav-primary-contacts-branch' and @data-tracking='click hover']")
	WebElement contact;
	
	@FindBy(xpath="//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Contacts')] ")
	WebElement contactIns;
	
	
	public Home() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyAfterLogin() {
		return driver.getTitle();
	}
	
    
	public Contacts clickOnContact() {
		contact.click();
		contactIns.click();
		return new Contacts();
	}
}
