package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.ContactPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.RandomScenariosPage;
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class RandomScenariosTest extends BaseTest{
	 WebDriver driver;
	 String url;
	 String browser;
	 String email;
	 String password;
	 String emailname;
	 String emailaddress;
	 String optyName;
	 String accountName;
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
	OpportunityPage opportunity;
	LeadsPage lead;
	String lastname;
	String company;
	ContactPage contact;
	String Lastname;
	String AccountName;
	String viewnameC;
	String viewuniquenameC;
	RandomScenariosPage randomtest;
	 
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
		
		optyName=common.getproperty("optyName");
		accountName=common.getproperty("accountName");
		
		lastname=common.getproperty("lastname");
		company=common.getproperty("company");
		
		Lastname=common.getproperty("Lastname");
		AccountName=common.getproperty("AccountName");
		
		viewnameC=common.getproperty("viewnameC");
		viewuniquenameC=common.getproperty("viewuniquenameC");
		
		value=common.getproperty("value");
		
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		settings=new SettingsPage(driver);
		account=new AccountPage(driver);
		opportunity=new OpportunityPage(driver);
		lead=new LeadsPage(driver);
		contact=new ContactPage(driver);
		randomtest=new RandomScenariosPage(driver);
	}
	
	@Test
	public void verifyIfFirstnameAndLastnameOfLoggedInUserIsDisplayed() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.homeTab();
		randomtest.accountHolderName();
		randomtest.userProfilePage();
	}//testcase 33 - PASSED
	
	@Test
	public void verifyEditedLastnameIsUpdatedAtVariousPlaces() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.homeTab();
		randomtest.accountHolderName();
		randomtest.editButton();
		randomtest.imageFrameMethod();
		randomtest.clickonAbout();
		randomtest.changeLastname("ABCD");
		randomtest.saveAllButton();
		randomtest.getAccountHolderName();
		randomtest.verifyAccountNameDropdown();
	}//testcase 34 - PASSED
	
	@Test
	public void verifyTabCustomization() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		randomtest.plusSymbol();
		randomtest.buttonMyCustomizeTab();
		randomtest.removeSelectedTab();
		randomtest.buttonRemove();
		randomtest.buttonSave();
		home.userMenuDropDown();
		home.logoutButton();
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		randomtest.plusSymbol();
		randomtest.buttonMyCustomizeTab();
		randomtest.displaySelectTabContents();
		randomtest.buttonSave();
	}//testcase 35 - PASSED
	
//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}

}
