package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class AccountTest extends BaseTest {
	
	
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
	String Accountname;
	 
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
		
		Accountname=common.getproperty("Accountname");
		
		value=common.getproperty("value");
		
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		settings=new SettingsPage(driver);
		account=new AccountPage(driver);
	}
	
	@Test
	public void createAnAccount() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.accountTab();
		account.newButton();
		account.accountName(Accountname);
		account.accountType();
		account.customerPriority();
		account.saveButton();
		account.newAccountPgTitle();
	}//testcase 10 - PASSED
	
	@Test
	public void accountCreateNewView() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.accountTab();
		account.createNewViewOption();
		account.viewName(viewname);//CHANGE VALUE
		account.viewUniqueName(viewuniquename);//CHANGE VALUE
		account.saveButton();
		account.newViewName();//CHANGE VALUE
		//testcase 11 - PASSED
	}
	
	@Test
	public void accountChangeViewName(){
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.accountTab();
		account.selectViewName();//CHANGE VALUE
		//account.goButton();
		account.editButton();
		account.editViewName(newviewname);
		account.filtersField();
		account.filtersOperator();
		account.filtersValue(value); //CHANGE VALUE
		account.saveButtonInDisplayField();
		account.newViewName();//CHANGE VALUE
	}//test case 12 - PASSED
	
	@Test
	public void accountMergeAccount() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.accountTab();
		account.mergeAccount();
		account.findAccountsToMerge(accountnametomerge);
		account.findAccountsButton();
		account.nextButton();
		account.mergeButton();
	}//testcase 13- PASSED
	
	@Test
	public void accountCreateAccountReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		account.accountTab();
		account.accountsActivityTab();
		account.dateField();
		account.dateFrom();
		//account.todayButtonFrom();
		account.dateTo();
		//account.todayButtonTo();
		account.saveUnsavedReport();
		account.reportName("CreekFile");
		account.reportUniqueName("Creek_File");
		account.text_Area();
		account.wait_Load();
		account.saveRunReport();
		account.reportNameOnReportPage() ;
	}//testcase 14 - PASSED
	
	
//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}

}
