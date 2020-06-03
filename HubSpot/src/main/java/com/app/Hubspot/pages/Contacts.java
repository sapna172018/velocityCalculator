package com.app.Hubspot.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.Hubspot.base.BaseTest;
import com.app.Hubspot.util.utility;

public class Contacts extends BaseTest {
	// added a comment 
	
	// one more
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	public static WebElement Create;
	
	@FindBy(xpath="//input[@data-field='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@data-field='firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@data-field='lastname']")
	WebElement Lastname;
	
	@FindBy(xpath="//span[@class='uiDropdown__buttonCaret private-dropdown__caret private-dropdown__caret--form'] ")
	WebElement drop;
	@FindBy(xpath="//div[@data-field='hubspot_owner_id']//span[@class='private-dropdown__button-label uiDropdown__buttonLabel']")
	WebElement Cowner;
	
	@FindBy(xpath="//div[@class='private-overlay uiOverlay-backdrop private-overlay--light private-overlay--contextual' and @role='presentation']")
	WebElement Invis;
	
	@FindBy(xpath="//input[@class='form-control private-form__control private-search-control__input' and @role='combobox']")
	WebElement Search;
	
	@FindBy(xpath="//div[@class='Select-option is-focused']//span[@role='option']//button[@class='private-button--unstyled private-typeahead-result-label uiTypeaheadResults__item truncate-text' and @title='sana sharma']")
	WebElement text;
	
	@FindBy(xpath="//input[@data-field='jobtitle']")
	WebElement JobTitle;
	
	@FindBy(xpath="//button[@class='uiButton private-button--primary private-loading-button private-button--primary private-button private-button--default private-button--non-link'] ")
	WebElement CreateContact;

	
	
	public Contacts() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyTitleOfContact() {
		return driver.getTitle();
	}

	public void CreateContact(String Email1,String Fname,String Lname,String COwner,String JT) {
		//utility.Wait(Create);
		//Create.click();
		Email.sendKeys(Email1);
		Firstname.sendKeys(Fname);
		Lastname.sendKeys(Lname);
		utility.Wait2(Invis, Cowner);
		Search.sendKeys(COwner+"\n");
		JobTitle.sendKeys(JT);
		CreateContact.click();
		
		
	}
}
