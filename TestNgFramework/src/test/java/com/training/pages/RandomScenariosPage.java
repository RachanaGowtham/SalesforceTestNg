package com.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage{

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//a[@href='/_ui/core/userprofile/UserProfilePage'])[3]")
	WebElement account_Holder_Name;
	
	@FindBy(xpath="//a[@href='/_ui/core/chatter/ui/ChatterPage']")
	WebElement user_Profile_Page;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	WebElement get_AccountHolderName;
	
	@FindBy(id="userNavButton")
	WebElement userMenu;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement profile;
	
	@FindBy(xpath="//a[@href='/_ui/core/chatter/ui/ChatterPage']")
	WebElement myProfile_Path;
	
	@FindBy(xpath="(//a[@class='profileTab'])[1]")
	WebElement overView_Click;
	
	@FindBy(xpath="//a[contains(@class,'contactInfoLaunch editLink')]")
	WebElement edit_Button;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	WebElement imageFrame;
	
	@FindBy(id="aboutTab")
	WebElement clickon_About;
	
	@FindBy(id="lastName")
	WebElement change_Lastname;
	
	@FindBy(xpath="//input[@class='zen-btn zen-primaryBtn zen-pas']")
	WebElement saveAll_Button;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	WebElement verify_AccountName_Dropdown;
	
	@FindBy(xpath="//img[@title='All Tabs']")
	WebElement plus_Symbol;
	
	@FindBy(xpath="//input[@title='Customize My Tabs']")
	WebElement button_MyCustomizeTab;
	
	@FindBy(xpath="//option[@value='ContentSubscriptions']")
	WebElement remove_SelectedTab;
	
	@FindBy(xpath="//img[@title='Remove']")
	WebElement button_Remove;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement button_Save;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	WebElement display_SelectTabContents;
	
	public void accountHolderName() {
		
		waitForElement(40,account_Holder_Name);
		actionClass(account_Holder_Name);
		String actualTitle=account_Holder_Name.getText();
		System.out.println(actualTitle);
		String expectedTitle="MAYA ABCD";
		Assert.assertEquals(actualTitle, expectedTitle);
		account_Holder_Name.click();
	}
	
public void getAccountHolderName() {
		
	waitForElement(40,get_AccountHolderName);
	actionClass(get_AccountHolderName);
	String actualTitle=get_AccountHolderName.getText();
	System.out.println(actualTitle);
	
	}

public void verifyAccountNameDropdown() {
	
	waitForElement(40,verify_AccountName_Dropdown);
	actionClass(verify_AccountName_Dropdown);
	String actualTitle=verify_AccountName_Dropdown.getText();
	System.out.println(actualTitle);
	}
	
	public void userProfilePage() {
		actionClass(userMenu);
		userMenu.click();
		
		String actualTitle=user_Profile_Page.getText();
		System.out.println(actualTitle);
		
		actionClass(userMenu);
		userMenu.click();
		profile.click();
		
		actionClass(myProfile_Path);
		WebElement text=driver.findElement(By.xpath("//a[@href='/_ui/core/chatter/ui/ChatterPage']"));
		
		String expectedTitle=text.getText();
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void editButton() {
	    waitForElement(80,overView_Click);   
		actionClass(overView_Click);
		overView_Click.click();
		waitForElementByLocator(20,"//a[contains(@class,'contactInfoLaunch editLink')]");
		actionClass(edit_Button);
		//waitForElement(20,edit_Button);
		edit_Button.click();
		
	}
	 public void imageFrameMethod() {
	    	driver.switchTo().frame(imageFrame);
	    }
	 public void clickonAbout() {
	    	//waitForElementByLocator(40,"//li[@id='aboutTab']");
	    	  waitForElement(20,clickon_About); 
	    	actionClass(clickon_About);
	    	clickon_About.click();
		}
	    public void changeLastname(String lname) {
	    	  waitForElement(20,change_Lastname); 
	    	actionClass(change_Lastname);
	    	change_Lastname.click();
	    	change_Lastname.clear();
	    	change_Lastname.sendKeys(lname);
	  	}
	      public void saveAllButton() {
	    	  waitForElement(20,saveAll_Button); 
	    	actionClass(saveAll_Button);
	    	saveAll_Button.click();
	  	}
	      
	      public void plusSymbol() {
	    	  waitForElement(40,plus_Symbol); 
	    	  actionClass(plus_Symbol);
	    	  plus_Symbol.click();
	      }
	      public void buttonMyCustomizeTab() {
	    	  waitForElement(40,button_MyCustomizeTab); 
	    	  actionClass(button_MyCustomizeTab);
	    	  button_MyCustomizeTab.click();
	      }
	      public void removeSelectedTab() {
	    	  waitForElement(40,remove_SelectedTab); 
	    	  actionClass(remove_SelectedTab);
	    	  remove_SelectedTab.click();
	      }
	      public void buttonRemove() {
	    	 // waitForElement(40,remove_SelectedTab); 
	    	  actionClass(button_Remove);
	    	  button_Remove.click();
	      }
	      public void buttonSave() {
		    	 // waitForElement(40,remove_SelectedTab); 
		    	  actionClass(button_Save);
		    	  button_Save.click();
		      }
	      
	      public void displaySelectTabContents() {
	    	  waitForElement(40,display_SelectTabContents); 
	    	  actionClass(display_SelectTabContents);
	    	  Select list=new Select(display_SelectTabContents);
	    	  
	    	  List<WebElement> listItems=list.getOptions();
	    	  for(WebElement items:listItems) {
	    		  System.out.println(items.getText());
	    	  }
	    	  
	      }
	
	
}
