package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest{
	
	 WebDriver driver;
	 String url;
	 String browser;
	 String email;
	 String password;
	 String emailname;
	 String emailaddress;
	 CommonUtilities common=new CommonUtilities();
	 LoginPage login;
	 HomePage home;
	 SettingsPage settings;
	AccountPage account;
	String viewname;
	String viewuniquename;
	String newviewname;
	String value;
	String accountnametomerge;
	String lastname;
	 
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url=common.getproperty("url");
		browser=common.getproperty("browser");
		email=common.getproperty("email");
		password=common.getproperty("password");
		emailname=common.getproperty("emailname");
		emailaddress=common.getproperty("emailaddress");
		
		viewname=common.getproperty("viewname");
		viewuniquename=common.getproperty("viewuniquename");
		
		newviewname=common.getproperty("newviewname");
		accountnametomerge=common.getproperty("accountnametomerge");
		
		value=common.getproperty("value");
		lastname=common.getproperty("lastname");
		
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		settings=new SettingsPage(driver);
		account=new AccountPage(driver);
	}
	
	@Test
	public void userMenuDropDown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.userMenuDropDownList();
	}//testcase  5 - PASSED
	
	@Test
	public void userMenuMyProfileOption() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.userMenuDropDownList();
		home.myProfile();
		home.editButton();
		home.imageFrameMethod();
		//home.clickon_Contact();
		home.clickonAbout();
		home.changeLastname(lastname);
		home.saveAllButton();
		home.postButton();
		home.postImageFrame();
		home.postbodyEnterText("hello");
		home.shareButton();
		//home.postedText();
		home.fileLink();
		home.chooseFileFromComputer();
		home.chooseFileOption();
		home.sharefileButton();
		//home.clickOnProfileName();
		home.moderatorOption();
		home.uploadLink();
		home.photouploadIFrame();
		home.choosetouploadphotoOption();
		home.saveOption();
	}// testcase 6
	
	@Test
	public void userMenuSettingsOption() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.userMenuDropDown();
		home.mySettings();
		settings.personalOption();
		settings.loginHistoryButton();
		settings.displayAndLayoutOption();
		settings.customizeTabsButton();
		settings.customAppButton();
		settings.availableTabsButton();
		settings.addButton();
		settings.emailOption();
		settings.emailSettingsButton();
		settings.emailName(emailname);
		settings.emailAddress(emailaddress);
		settings.automatic_Bcc();
		settings.saveButton();
		settings.calenderandreminderOption();
		settings.activityReminderButton();
		settings.openTestReminderButton();
		
	}//testcase 7 - PASSED
	
	@Test
	public void userMenuDeveloperConsole() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.userMenuDropDown();
		home.developerConsole();
	}//testcase 8 - PASSED
	
	@Test
	public void userMenuLogout() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.rememberMeButton();
		login.clickOnLogin();
		home.userMenuDropDown();
		home.logoutOption();
	}//testcase 9 - PASSED
		
//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}

}
