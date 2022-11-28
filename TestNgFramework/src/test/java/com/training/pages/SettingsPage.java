package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.training.base.BasePage;

public class SettingsPage extends BasePage{

	public SettingsPage(WebDriver driver) { 
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(@id,'PersonalInfo_font')]")
	WebElement personal;
	
	@FindBy(id="LoginHistory_font")
	WebElement loginhistory;
	
	@FindBy(xpath="//a[@href='/servlet/servlet.LoginHistory?id=005Dn000001PtUD']")
	WebElement downloadloginhistory;
	
	@FindBy(xpath="//span[contains(@id,'DisplayAndLayout_font')]")
	WebElement displayandlayout;
	
	@FindBy(id="CustomizeTabs_font")
	WebElement customizetabs;
	
	@FindBy(id="p4")
	WebElement customApp;
	
	@FindBy(id="duel_select_0")
	WebElement availabletabs;
	
	@FindBy(xpath="//img[contains(@title,'Add')]")
	WebElement add;
	
	@FindBy(xpath="//span[contains(@id,'EmailSetup_font')]")
	WebElement email;
	
	@FindBy(id="EmailSettings_font")
	WebElement emailsettings;
	
	@FindBy(id="sender_name")
	WebElement emailname;
	
	@FindBy(id="sender_email")
	WebElement emailaddress;
	
	@FindBy(id="auto_bcc1")
	WebElement automaticBcc;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement save;
	
	@FindBy(xpath="//span[contains(@id,'CalendarAndReminders_font')]")
	WebElement calenderandreminder;
	
	@FindBy(id="Reminders_font")
	WebElement activityreminder;
	
	
	@FindBy(id="testbtn")
	WebElement opentestreminder;
	
	@FindBy(xpath="//span[contains(text(),'Start Time: ')]")
	WebElement opentestreminder_Text;
	
	public void personalOption() {
		waitForElement(20,personal);
		actionClass(personal);
		personal.click();
	}
	public void loginHistoryButton() {
		loginhistory.click();
	}
	public void downloadLoginHistoryButton() {
		downloadloginhistory.click();
	}
	public void displayAndLayoutOption() {
		waitForElement(20,displayandlayout);
		actionClass(displayandlayout);
		displayandlayout.click();
	}
	public void customizeTabsButton() {
		customizetabs.click();
	}
	public void customAppButton() {
		Select option=new Select(customApp);
		option.selectByVisibleText("Salesforce Chatter");
	}
	public void availableTabsButton() {
		waitForElement(20,availabletabs);
		Select options=new Select(availabletabs);
		options.selectByVisibleText("Reports");
	}
	public void addButton() {
		add.click();
	}
	public void emailOption() {
		waitForElement(20,email);
		actionClass(email);
		email.click();
	}
	public void emailSettingsButton() {
		emailsettings.click();
	}
	public void emailName(String ename) {
		emailname.clear();
		emailname.sendKeys(ename);
	}
	public void emailAddress(String eaddress) {
		emailaddress.clear();
		emailaddress.sendKeys(eaddress);
	}
	public void automatic_Bcc() {
		automaticBcc.click();
	}
	public void saveButton() {
		save.click();
	}
	public void calenderandreminderOption() {
		waitForElement(20,calenderandreminder);
		actionClass(calenderandreminder);
		calenderandreminder.click();
	}
	public void activityReminderButton() {
		activityreminder.click();
	}
	public void openTestReminderButton() {
		opentestreminder.click();
		
		for(String handle: driver.getWindowHandles()) {
		driver.switchTo().window(handle);
		}
		String sampleWindowTitle=driver.getTitle();
		System.out.println(sampleWindowTitle);		
		
	}
	
	
}
