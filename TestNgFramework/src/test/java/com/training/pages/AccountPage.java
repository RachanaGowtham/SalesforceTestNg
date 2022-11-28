package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Account_Tab")
	WebElement account;
	
	@FindBy(xpath="//input[@title='New']")
	WebElement newbutton;
	
	@FindBy(id="acc2")
	WebElement account_Name;
	
	@FindBy(id="acc6")
	WebElement account_Type;
	
	@FindBy(id="00NDn000006w7Hz")
	WebElement customer_Priority;
	
	@FindBy(xpath="//a[text()='Create New View']")
	WebElement createNewView;
	
	@FindBy(xpath="//h2[@class='topName']")
	WebElement new_AccountPg_Title;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement viewuniquename;
	
	@FindBy(xpath="(//input[@value=' Save '])[1]")
	WebElement save;
	
	@FindBy(xpath="//select[@name='fcf']")
	 WebElement newviewname;
	
	@FindBy(xpath="//a[(text()='Edit')]")
	WebElement edit;
	
	@FindBy(id="fname")
	WebElement editviewname;
	
	@FindBy(xpath="//select[@id='fcol1']")
	WebElement filtersfield;
	
	@FindBy(xpath="//select[@id='fop1']")
	WebElement filtersoperator;
	
	@FindBy(xpath="//input[@id='fval1']")
	WebElement filtersvalue;
	
	@FindBy(xpath="(//input[@title='Save'])[2]")
	WebElement savebutton;
	
	@FindBy(id="00BDn0000073pNM_listSelect")
	WebElement displayviewname;
	
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	WebElement mergeaccount;
	
	@FindBy(id="srch")
	WebElement findaccountstomerge;
	
	@FindBy(xpath="//input[@value='Find Accounts']")
	WebElement findaccountsbutton;
	
	@FindBy(xpath="(//input[@class='btn'])[3]")
	WebElement nextbutton;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Merge']")
	WebElement mergebutton;
	
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement accountsActivity;
	
	@FindBy(xpath="//input[@id='ext-gen20']")
	WebElement datefield;
	
	@FindBy(id="fcf")
	WebElement select_View_Name;
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement go_Button;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement createDate_Option;
	
	@FindBy(xpath="//h1[normalize-space()='Merge My Accounts']")
	WebElement mergeaccount_PageText;
	
	@FindBy(xpath="//input[@id='ext-comp-1042']")
	WebElement date_From;
	
	@FindBy(xpath="//table[@id='ext-comp-1113']") 
	WebElement todayButton_From;
	
	@FindBy(xpath="//input[@id='ext-comp-1045']")
	WebElement date_To;
	
	@FindBy(xpath="//table[@id='ext-comp-1115']")
	WebElement todayButton_To;
	
	@FindBy(xpath="//button[@id='ext-gen49']")
	WebElement save_Button;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")
	WebElement report_Name;
	
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")
	WebElement report_UniqueName;
	
	@FindBy(xpath="//textarea[@id='ext-comp-1067']")
	WebElement text_Area;
	
	@FindBy(id="ext-gen275")
	WebElement wait_Load;
	
	@FindBy(xpath="//table[@id='dlgSaveAndRun']") 
	WebElement save_Run_Report;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	WebElement reportName_OnReportPage;
	
	
	
	public void accountTab() {
	actionClass(account);
	account.click();
	}
	
	public void goButton() {
		actionClass(go_Button);
		go_Button.click();
		}
	
	public void selectViewName() {
		waitForElement(20,select_View_Name);
		actionClass(select_View_Name);
		
		Select field=new Select(select_View_Name);
		field.selectByVisibleText("Parabens");
	}
	public void newButton() {
		waitForElement(20,newbutton);
		newbutton.click();
		String expectedTitle="Account Edit: New Account ~ Salesforce - Developer Edition";
		String pagetitle=driver.getTitle();
		Assert.assertEquals(pagetitle, expectedTitle);
	}
	
	public void accountName(String aname) {
		waitForElement(20,account_Name);
		actionClass(account_Name);
		account_Name.sendKeys(aname);
		}
	
	public void accountType() {
		waitForElement(20,account_Type);
		actionClass(account_Type);
		
		Select field=new Select(account_Type);
		field.selectByVisibleText("Technology Partner");
	}
	
	public void customerPriority() {
		waitForElement(20,customer_Priority);
		actionClass(customer_Priority);
		
		Select field=new Select(customer_Priority);
		field.selectByVisibleText("High");
	}
	
	public void createNewViewOption() {
		waitForElement(20,createNewView);
	    createNewView.click();
	}
	public void viewName(String vname) {
		waitForElement(20,viewname);	
	    viewname.sendKeys(vname);
	}
	public void viewUniqueName(String vuname) {
		waitForElement(20,viewuniquename);
		viewuniquename.click();
		viewuniquename.clear();
		viewuniquename.sendKeys(vuname);
	}
	public void saveButton() {
		  save.click();
	}
	public void newViewName() {
		waitForElement(40,newviewname);
		actionClass(newviewname);
		
		Select lists=new Select(newviewname);
		lists.selectByVisibleText("Parabens1");
		
		WebElement text=driver.findElement(By.xpath("//option[@selected='selected']"));
		String actualTitle=text.getText();
		System.out.println(actualTitle);
	}
	public void editButton() {
		//waitForElement(20,edit);
		actionClass(edit);
		edit.click();
	}
	public void editViewName(String vname) {
		waitForElement(20,editviewname);	
		editviewname.sendKeys(vname);
	}
	public void filtersField() {
		actionClass(filtersfield);
		waitForElement(20,filtersfield);
		Select field=new Select(filtersfield);
		field.selectByVisibleText("Account Name");
	}
	public void filtersOperator() {
		actionClass(filtersoperator);
		waitForElement(30,filtersoperator);	
		Select operator=new Select(filtersoperator);
		operator.selectByValue("c");
	}
	public void filtersValue(String vname) {
		actionClass(filtersvalue);
		waitForElement(20,filtersvalue);	
		filtersvalue.sendKeys(vname);
	}
	public void saveButtonInDisplayField() {
	    actionClass(savebutton);
		savebutton.click();
	}
	public void displayViewName() {
		waitForElement(20,displayviewname);	
		String display=displayviewname.getText();
		System.out.println(display);
	}
	public void mergeAccount() {
		waitForElement(40,mergeaccount);
		actionClass(mergeaccount);	
		mergeaccount.click();
	}
	public void findAccountsToMerge(String account) {
		waitForElement(40,findaccountstomerge);
		actionClass(findaccountstomerge);	
		findaccountstomerge.sendKeys(account);
	}
	public void findAccountsButton() {	
		findaccountsbutton.click();
	}
	public void nextButton() {
		waitForElement(40,nextbutton);
		 actionClass(nextbutton);
		 nextbutton.click();
		
	}
	public void mergeButton() {
		waitForElement(60,mergeaccount_PageText);
		String text=mergeaccount_PageText.getText();
		System.out.println(text);
		waitForElementByLocator(40,"//div[@class='pbBottomButtons']//input[@title='Merge']");
		//waitForElement(60,mergebutton);
		 actionClass(mergebutton);
	waitForElement(60,mergebutton);
		 mergebutton.click();
		 String textalert=driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
			 System.out.println(textalert);
	}
	public void accountsActivityTab() {
		waitForElement(40,accountsActivity);
		actionClass(accountsActivity);	
		accountsActivity.click();
	}
	public void dateField() {
		waitForElement(40,datefield);
		
		actionClass(datefield);
		datefield.click();
		actionClass(createDate_Option);
		createDate_Option.click();
		
	}
	
	public void dateFrom() {
		 waitForElement(20,date_From);
		actionClass(date_From);
		date_From.click(); 
		date_From.clear();
		date_From.sendKeys("11/15/2022");
	}
	public void todayButtonFrom() {
		waitForElement(40,todayButton_From);
		actionClass(todayButton_From);
		todayButton_From.click();
		}
	
	public void dateTo() {
		 waitForElement(20,date_To);
		actionClass(date_To);
		date_To.click();
		date_To.clear();
		date_To.sendKeys("11/15/2022");
	}
	
	public void todayButtonTo() {
		 waitForElement(20,todayButton_To);
		actionClass(todayButton_To);
		todayButton_To.click();
		}
	public void saveUnsavedReport() {
		actionClass(save_Button);
		save_Button.click();
	
	}
	
	public void newAccountPgTitle() {
	 waitForElement(20,new_AccountPg_Title);
		actionClass(new_AccountPg_Title);
		String pageText=new_AccountPg_Title.getText();
		System.out.println(pageText);
		}
	public void reportName(String rname) {
		 waitForElement(20,report_Name);
		actionClass(report_Name);
		report_Name.sendKeys(rname);;
	
	}
	public void reportUniqueName(String runame) {
		actionClass(report_UniqueName);
		report_UniqueName.sendKeys(runame);;
	
	}
	public void text_Area() {
		actionClass(text_Area);
		text_Area.click();
	
	}
	public void wait_Load() {
		waitForElement(40,wait_Load);
		actionClass(wait_Load);
		wait_Load.click();
		
	
	}
	
	
	
	public void saveRunReport() {
		 waitForElement(60,save_Run_Report);
		
		actionClass(save_Run_Report);
		 waitForElement(40,save_Run_Report);
		save_Run_Report.click();
	
	}
	public void reportNameOnReportPage() {
		 waitForElement(20,reportName_OnReportPage);
			actionClass(reportName_OnReportPage);
			String pageText=reportName_OnReportPage.getText();
			System.out.println(pageText);
			}
	
	    
	
	
	
	

}
