package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest  extends BaseTest{
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
		
		value=common.getproperty("value");
		
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		settings=new SettingsPage(driver);
		account=new AccountPage(driver);
		opportunity=new OpportunityPage(driver);
		lead=new LeadsPage(driver);
	}
	
	@Test
	public void leadCheckLeadTabsLink() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.leadsTitle();
	}//testcase 20 - PASSED
	
	@Test
	public void leadValidateViewDropdownListContents() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.viewDropdown();
	}//testcase 21 - PASSED
	
	@Test
	public void leadAppLaunchedUserLoggedIn() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.myUnreadLeads();
		home.userMenuDropDown();
		home.logoutOption();
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.goButton();
		lead.currentPageUnread();
	}//testcase 22 - PASSED
	
	@Test
	public void leadListItemsTodaysLeads() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.todaysLeads();
		lead.goButton();
		lead.currentPageToday();
	}//testcase 23 - PASSED
	
	@Test
	public void leadUserLoggedOutAndAppClosed() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		lead.leadsTab();
		lead.leadNewButton();
		lead.leadsLastname(lastname);
		lead.leadsCompany(company);
		lead.leadsSaveButton();
		lead.newLeadsPage();
	}//testcase 24 - PASSED
	
	
	//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}

}
