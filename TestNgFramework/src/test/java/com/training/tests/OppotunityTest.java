package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class OppotunityTest  extends BaseTest{
	
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
		
		value=common.getproperty("value");
		
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		settings=new SettingsPage(driver);
		account=new AccountPage(driver);
		opportunity=new OpportunityPage(driver);
	}
	
	@Test
	public void opportunitiesDropDown() {
	login.enterIntoEmail(email);
	login.enterIntoPassword(password);
	login.clickOnLogin();
	opportunity.opportunitiesTab();
	opportunity.viewOpportunities();
	
	}//testcase 15 - PASSED
	
	@Test
	public void opportunityCreateNewOpty() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunity.opportunitiesTab();
		opportunity.newButton();
		opportunity.optyName(optyName);
		opportunity.accountName(accountName);
		
	}//testcase 16 date selection is not thought
	
	@Test
	public void opportunityTestOptyPipelineReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunity.opportunitiesTab();
		opportunity.optyPipeline();
		opportunity.optyPipelinePage();
		
	}//testcase 17 -PASSED
	
	@Test
	public void opportunityTestStuckOptyReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunity.opportunitiesTab();
		opportunity.stuckOpty();
		opportunity.stuckOptyPage();
		
	}//testcase 18 - PASSED
	
	@Test
	public void opportunityTestQuarterlySummaryReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunity.opportunitiesTab();
		opportunity.quaterlySummaryInterval();
		opportunity.quaterlySummaryInclude();
		opportunity.runReportButton();
		opportunity.optyReporPage();
		
	}//testcase 19 - PASSED

	
	//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}

}
