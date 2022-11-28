package com.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.training.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
    }
	
	@FindBy(xpath="//a[contains(@title,'Leads Tab')]")
	WebElement leads_Tab;
	
	@FindBy(xpath="//h1[contains(@class,'pageType')]")
	WebElement leads_Title;
	
	@FindBy(id="fcf")
	WebElement view_Dropdown;
	
	@FindBy(id="fcf")
	WebElement my_Unread_Leads;
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement go_Button;
	
	@FindBy(id="00BDn000004cmGp_listSelect")
	WebElement current_page_Unread;
	
	@FindBy(id="fcf")
	WebElement todays_Leads;
	
	@FindBy(id="00BDn000004cmH3_listSelect")
	WebElement current_page_Today;
	
	@FindBy(xpath="//input[contains(@value,' New ' )]")
	WebElement lead_New_Button;
	
	@FindBy(xpath="//input[contains(@id,'name_lastlea2' )]")
	WebElement leads_Lastname;
	
	@FindBy(id="lea3")
	WebElement leads_Company;
	
	@FindBy(xpath="(//input[contains(@value,' Save ' )])[2]")
	WebElement leads_Save_Button;
	
	@FindBy(xpath="//h2[contains(@class,'topName' )]")
	WebElement new_Leads_Page;
	
	public void leadsTab() {
		actionClass(leads_Tab);
		waitForElement(20,leads_Tab);
		leads_Tab.click();
	}
	public void leadsTitle() {
		waitForElement(20,leads_Title);
		actionClass(leads_Title);
		String actualTitle=leads_Title.getText();
		//System.out.println(actualTitle);
		String expectedTitle="Leads";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void viewDropdown(){
		waitForElement(20,view_Dropdown);
		actionClass(view_Dropdown);
	
	Select lists=new Select(view_Dropdown);
	
			List<WebElement> allOptions=lists.getOptions();
			
			for(WebElement options: allOptions) {
				System.out.println(options.getText());
				
			}
				
	}
	public void myUnreadLeads(){
		waitForElement(20,my_Unread_Leads);
		actionClass(my_Unread_Leads);
		
		Select lists=new Select(my_Unread_Leads);
		lists.selectByVisibleText("My Unread Leads");
	}
	
	public void goButton() {
		waitForElement(40,go_Button);
		actionClass(go_Button);
		go_Button.click();
	}
	public void currentPageUnread() {
		waitForElement(20,current_page_Unread);
		actionClass(current_page_Unread);
		Select lists=new Select(current_page_Unread);
		lists.selectByValue("00BDn000004cmGp");
		String expectedTitle="My Unread Leads";
		WebElement text=driver.findElement(By.xpath("//option[@selected='selected']"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);		
		
	}
	public void todaysLeads(){
		waitForElement(20,todays_Leads);
		actionClass(todays_Leads);
		
		Select lists=new Select(todays_Leads);
		lists.selectByVisibleText("Today's Leads");
	}
	
	public void currentPageToday() {
		waitForElement(20,current_page_Today);
		actionClass(current_page_Today);
		Select lists=new Select(current_page_Today);
		lists.selectByValue("00BDn000004cmH3");
	
		String expectedTitle="Today's Leads";
		WebElement text=driver.findElement(By.xpath("//option[@selected='selected']"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void leadNewButton() {
		waitForElement(20,lead_New_Button);
		actionClass(lead_New_Button);
		
		lead_New_Button.click();
	}
	
	public void leadsLastname(String lname) {
		waitForElement(40,leads_Lastname);
		actionClass(leads_Lastname);
	
		leads_Lastname.click();
		leads_Lastname.sendKeys(lname);
	}
	
	public void leadsCompany(String cname) {
		waitForElement(40,leads_Company);
		actionClass(leads_Company);
		leads_Company.click();
		leads_Company.sendKeys(cname);
	}
	public void leadsSaveButton() {
		actionClass(leads_Save_Button);
		waitForElement(20,leads_Save_Button);
		leads_Save_Button.click();
	}
	public void newLeadsPage() {
		waitForElement(20,new_Leads_Page);
		actionClass(new_Leads_Page);
		String actualTitle=new_Leads_Page.getText();
		//System.out.println(actualTitle);
		String expectedTitle="ABCDE";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
