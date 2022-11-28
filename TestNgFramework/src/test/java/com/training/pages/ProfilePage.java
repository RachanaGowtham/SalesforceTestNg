package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver) { 
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
	WebElement edit;
	
	public void editButton() {
		waitForElement(20,edit);
		actionClass(edit);
		edit.click();
	}

}
