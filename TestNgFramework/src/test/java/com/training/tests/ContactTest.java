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
import com.training.pages.SettingsPage;
import com.training.utilities.CommonUtilities;

public class ContactTest extends BaseTest {
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
	}
	
	@Test
	public void contactCreateNewContact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.contactsNewButton();
		contact.contactsLname(Lastname);
		contact.contactsAccountName(AccountName);
		contact.contactsSaveButton();
		contact.newContactsPage();
	}//testcase 25 - PASSED
	
	@Test
	public void contactCreateNewViewInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.contactsCreateNewView();
		contact.contactsViewname(viewname);
		contact.contactsViewUniquename(viewuniquename);
		contact.contactPageSaveButton();
		contact.ContactsPageNew();
	}//testcase 26 - PASSED
	
	@Test
	public void contactRecentlyCreatedContactInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.recentlyCreatedTab();
	}//testcase 27 - PASSED
	
	@Test
	public void contactCheckMyContactsViewInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.myContactsView();
	}//testcase 28 - PASSED
	
	@Test
	public void contactViewContactInContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.selectedNameofContact();
		contact.contactDetails();
	}//testcase 29 - PASSED
	
	@Test
	public void contactNewViewErrorMessage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.contactsCreateNewView();
		contact.contactsViewname(viewname);
		contact.contactsViewUniquenameError();
		contact.contactPageSaveButton();
		contact.contactCreateviewErrorMsg();
	}//testcase 30 - PASSED
	
	@Test
	public void contactNewViewCancelButton() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.contactsCreateNewView();
		contact.contactsViewname(viewnameC);
		contact.contactsViewUniquename(viewuniquenameC);
		contact.contactCancelButton();
		contact.myContactsViewAfterCancel();
	}//testcase 31 - PASSED
	
	@Test
	public void contactSaveAndNewButtonForNewContactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contact.contactTab();
		contact.contactsNewButton();
		contact.contactsLname(Lastname);
		contact.contactsAccountName(AccountName);
		contact.contactsSaveAndNew();
		contact.newContactEditPage();
		
	}//testcase 32 - PASSED
	
	//	@AfterMethod
	//takescreenshot(driver);
//	public void teardown() {
//		driver.close();
//	}
}
