package com.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="Contact_Tab")
	WebElement contact_Tab;
	
	@FindBy(xpath="//input[contains(@value,' New ' )]")
	WebElement contacts_New_Button;
	
	@FindBy(id="name_lastcon2")
	WebElement contacts_Lname;
	
	@FindBy(id="con4")
	WebElement contacts_AccountName;
	
	@FindBy(xpath="(//input[contains(@value,' Save ' )])[2]")
	WebElement contacts_Save_Button;
	
	@FindBy(xpath="//h2[contains(@class,'topName' )]")
	WebElement new_Contacts_Page;
	
	@FindBy(xpath="//a[contains(text(),'Create New View' )]")
	WebElement contacts_Create_New_View;
	
	@FindBy(id="fname")
	WebElement contacts_Viewname;
	
	@FindBy(id="devname")
	WebElement contacts_View_Uniquename;
	
	@FindBy(xpath="(//input[contains(@value,' Save ' )])[2]")
	WebElement contactPage_Save_Button;
	
	@FindBy(xpath="//select[@name='fcf']")
	WebElement ContactsPage_new;
	
	@FindBy(id="hotlist_mode")
	WebElement recentlyCreated;
	
	@FindBy(id="fcf")
	WebElement my_Contacts_View;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	WebElement contacts_Go_Button;
	
	@FindBy(xpath="//a[contains(text(),'Indian')]")
	WebElement selected_NameofContact;
	
	@FindBy(xpath="//h2[contains(text(),'Indian')]")
	WebElement contact_Details;
	
	@FindBy(id="devname")
	WebElement contacts_View_Uniquename_Error;
	
	@FindBy(xpath="(//div[contains(@class,'errorMsg')])[1]")
	WebElement contact_Createview_ErrorMsg;
	
	@FindBy(xpath="(//input[@title='Cancel'])[2]")
	WebElement contact_Cancel_Button;
	
	@FindBy(id="fcf")
	WebElement my_Contacts_View_AfterCancel;
	
	@FindBy(xpath="(//input[contains(@value,'Save & New' )])[2]")
	WebElement contacts_SaveAndNew;
	
	@FindBy(xpath="//h1[contains(@class,'pageType' )]")
	WebElement new_Contact_EditPg;
	
	public void contactTab() {
		actionClass(contact_Tab);
		waitForElement(20,contact_Tab);
		contact_Tab.click();
	}
	
	public void contactsNewButton() {
		waitForElement(40,contacts_New_Button);
		actionClass(contacts_New_Button);
		
		contacts_New_Button.click();
	}
	public void contactsLname(String lname) {
		waitForElement(40,contacts_Lname);
		actionClass(contacts_Lname);
	
		contacts_Lname.click();
		contacts_Lname.sendKeys(lname);
	}
	
	public void contactsAccountName(String compname) {
		waitForElement(40,contacts_AccountName);
		actionClass(contacts_AccountName);
	
		contacts_AccountName.click();
		contacts_AccountName.sendKeys(compname);
	}
	public void contactsSaveButton() {
		actionClass(contacts_Save_Button);
		waitForElement(20,contacts_Save_Button);
		contacts_Save_Button.click();
	}
	
	public void newContactsPage() {
		waitForElement(20,new_Contacts_Page);
		actionClass(new_Contacts_Page);
		String actualTitle=new_Contacts_Page.getText();
		//System.out.println(actualTitle);
		String expectedTitle="Kalam";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void contactsCreateNewView() {
		waitForElement(40,contacts_Create_New_View);
		actionClass(contacts_Create_New_View);
		
		contacts_Create_New_View.click();
	}
	
	public void contactsViewname(String vname) {
		waitForElement(40,contacts_Viewname);
		actionClass(contacts_Viewname);
	
		contacts_Viewname.click();
		contacts_Viewname.sendKeys(vname);
	}
	
	public void contactsViewUniquename(String vuname) {
		waitForElement(40,contacts_View_Uniquename);
		actionClass(contacts_View_Uniquename);
	
		contacts_View_Uniquename.click();
		contacts_View_Uniquename.clear();
		contacts_View_Uniquename.sendKeys(vuname);
	}
	
	public void contactPageSaveButton() {
		actionClass(contactPage_Save_Button);
		waitForElement(20,contactPage_Save_Button);
		contactPage_Save_Button.click();
	}
	public void ContactsPageNew() {
		waitForElement(40,ContactsPage_new);
		actionClass(ContactsPage_new);
		
		Select lists=new Select(ContactsPage_new);
		lists.selectByVisibleText("TrainingCenters12345");
		
		WebElement text=driver.findElement(By.xpath("//option[@selected='selected']"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
	}
	

	public void recentlyCreatedTab() {
		waitForElement(40,recentlyCreated);
		actionClass(recentlyCreated);
		
		Select lists=new Select(recentlyCreated);
		lists.selectByValue("2");
		
		String expectedTitle = "Recently Created";
		WebElement text=driver.findElement(By.xpath("(//option[@selected='selected'])[2]"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void myContactsView() {
		waitForElement(40,my_Contacts_View);
		actionClass(my_Contacts_View);
		
		Select lists=new Select(my_Contacts_View);
		lists.selectByVisibleText("My Contacts");
		
		contacts_Go_Button.click();
		
		String expectedTitle = "My Contacts";
		waitForElementByLocator(40,"(//option[@selected='selected'])[1]");
		WebElement text=driver.findElement(By.xpath("(//option[@selected='selected'])[1]"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
			
	}
	
	public void selectedNameofContact() {
		waitForElement(40,selected_NameofContact);
		actionClass(selected_NameofContact);
		
		selected_NameofContact.click();
	}
	
	public void contactDetails() {
		waitForElement(40,contact_Details);
		actionClass(contact_Details);
		String actualTitle=contact_Details.getText();
		System.out.println(actualTitle);
		String expectedTitle="Indian";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void contactsViewUniquenameError() {
		contacts_View_Uniquename_Error.click();
		contacts_View_Uniquename_Error.clear();
	}
	public void contactCreateviewErrorMsg() {
		waitForElement(40,contact_Createview_ErrorMsg);
		actionClass(contact_Createview_ErrorMsg);
		String actualTitle=contact_Createview_ErrorMsg.getText();
		System.out.println(actualTitle);
		String expectedTitle="Error: The View Unique Name field can only contain underscores and alphanumeric characters. It must be unique, begin with a letter, not include spaces, not end with an underscore, and not contain two consecutive underscores.";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void contactCancelButton() {
		actionClass(contact_Cancel_Button);
		waitForElement(20,contact_Cancel_Button);
		contact_Cancel_Button.click();
	}
	
	public void myContactsViewAfterCancel() {
		waitForElement(20,my_Contacts_View_AfterCancel);
		actionClass(my_Contacts_View_AfterCancel);
		Select lists=new Select(my_Contacts_View_AfterCancel);
		
		List<WebElement> allOptions=lists.getOptions();
		String actualTitle = "";
		String expectedTitle="ABCD";
		
		for(WebElement options: allOptions) {
			actualTitle=options.getText();
			if(!actualTitle.equals(expectedTitle)) {
				System.out.println("Test case passed : "+actualTitle);	
			}
		}
	}
	
	public void contactsSaveAndNew() {
		actionClass(contacts_SaveAndNew);
		waitForElement(20,contacts_SaveAndNew);
		contacts_SaveAndNew.click();
	}
	
	public void newContactEditPage() {
		waitForElement(20,new_Contact_EditPg);
		actionClass(new_Contact_EditPg);
		String actualTitle=new_Contact_EditPg.getText();
		System.out.println(actualTitle);
		String expectedTitle="Contact Edit";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	


}
