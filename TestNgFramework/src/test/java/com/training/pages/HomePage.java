package com.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class HomePage extends BasePage  {
	
	public HomePage(WebDriver driver) { 
		super(driver);
	}
	
	@FindBy(id="userNavLabel")
	WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']")
	WebElement userMenuList;
	
	@FindBy(xpath="//a[@href='/secur/logout.jsp']")
	WebElement logout;
	
	@FindBy(id="idcard-identity")
	WebElement after_Logout_Page;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement profile;
	
	@FindBy(xpath="//a[contains(text(),'My Settings')]")
	WebElement settings;

	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	WebElement developerconsoletab;
	
	@FindBy(xpath="//a[@href='/home/home.jsp']")
	WebElement home_Tab;
	
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
	
	@FindBy(id="publisherAttachTextPost")
	WebElement post_Button;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	WebElement post_ImageFrame;
	
	//@FindBy(xpath="//body[contains(text(),'Share an update, @mention someone...')]")
	@FindBy(xpath="//html[1]/body[1]")
	WebElement postbody_EnterText;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	WebElement share_Button;
	
	@FindBy(xpath="//div[@id='0D5Dn0000070QG4']//div[@class='cxfeeditemtextadditional']") 
	WebElement posted_Text;
	
	@FindBy(xpath="//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")
	WebElement file_Link;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	WebElement choose_File_From_Computer;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	WebElement choose_FileOption;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	WebElement sharefile_Button;
	
//	@FindBy(xpath="//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='MAYA ABCD']")
//	WebElement click_OnProfileName;
	
	@FindBy(xpath="//span[@id='displayBadge']")
	WebElement moderator_Option;
	
	@FindBy(xpath="//a[@id='uploadLink']")
	WebElement upload_Link;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	WebElement photoupload_IFrame;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement choosetouploadphoto_Option;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:save']")
	WebElement save_Option;
	
	public void userMenuDropDownList() {
		waitForElement(40,userMenu);
		actionClass(userMenu);
		userMenu.click();
		System.out.println(userMenuList.getText()); 
		
	}
	
	public void userMenuDropDown() {
		waitForElement(40,userMenu);
		actionClass(userMenu);
		userMenu.click();
	}
	
	public void logoutOption() {
		actionClass(logout);
		logout.click();
		
		waitForElement(40,after_Logout_Page);
		actionClass(after_Logout_Page);
		String actualvalue=after_Logout_Page.getText();
		System.out.println(actualvalue);
		String expectedvalue="mayag@tekarch.com";
		Assert.assertEquals(actualvalue, expectedvalue);
	}
	
	public void logoutButton() {
		waitForElement(20,logout);
		actionClass(logout);
		logout.click();
	}
	
	public void myProfile() {
		profile.click();
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
    
    public void postButton() {
    	  waitForElement(20,post_Button); 
    	actionClass(post_Button);
    	post_Button.click();
  	}
    
    public void postImageFrame() {
    	driver.switchTo().frame(post_ImageFrame);
    }
    public void postbodyEnterText(String text) {
    	  waitForElement(40,postbody_EnterText); 
    	actionClass(postbody_EnterText);
    	postbody_EnterText.click();
    	//waitForElement(40,postbody_EnterText); 
    	postbody_EnterText.sendKeys(text);
  	}
    public void shareButton() {
    	driver.switchTo().defaultContent();
  	  waitForElement(20,share_Button); 
  	actionClass(share_Button);
  	share_Button.click();
	}
    public void postedText() {
		waitForElement(40,posted_Text);
		actionClass(posted_Text);
		//waitForElement(40,posted_Text);
		System.out.println(posted_Text.getText()); 
		
	}
    public void fileLink() {
  	 // waitForElement(30,file_Link); 
  	actionClass(file_Link);
  	file_Link.click();
	}
    
    public void chooseFileFromComputer() {
    	  waitForElement(40,choose_File_From_Computer); 
    	actionClass(choose_File_From_Computer);
    	choose_File_From_Computer.click();
  	}
    public void chooseFileOption() {
  	  waitForElement(20,choose_FileOption); 
  	choose_FileOption.sendKeys("/Users/gowthamsuresh/Downloads/pexels-shvets-production-7203724.jpg");
	}
    
    public void sharefileButton() {
    	
  	  waitForElement(20,sharefile_Button); 
  	actionClass(sharefile_Button);
  	sharefile_Button.click();
	}

//    public void clickOnProfileName() {
//    	
//  	  waitForElement(20,click_OnProfileName); 
//  	actionClass(click_OnProfileName);
//  	click_OnProfileName.click();
//	}
    public void moderatorOption() {
    	
    	  waitForElement(60,moderator_Option); 
    	actionClass(moderator_Option);
    	moderator_Option.click();
 
  	}
    public void uploadLink() {
    	
    	 // waitForElement(20,upload_Link); 
    	actionClass(upload_Link);
    	upload_Link.click();
    	System.out.println("Uploaded");
  	}
    public void photouploadIFrame() {
    	driver.switchTo().frame(photoupload_IFrame);
    }
    public void choosetouploadphotoOption() {
    	  waitForElement(20,choosetouploadphoto_Option); 
    	  choosetouploadphoto_Option.sendKeys("/Users/gowthamsuresh/Downloads/pexels-shvets-production-7203724.jpg");
  	}
    public void saveOption() {
    	
  	  waitForElement(20,save_Option); 
  	actionClass(save_Option);
  	save_Option.click();
  	System.out.println("Uploaded");
	}
    
    

	public void mySettings() {
		settings.click();
	}
	public void developerConsole() {
		waitForElement(20,developerconsoletab);
		String parentWindow=driver.getWindowHandle();
		developerconsoletab.click();
	
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			}
			String developerConsoleWindowTitle=driver.getTitle();
			System.out.println(developerConsoleWindowTitle);	
			driver.close();
			driver.switchTo().window(parentWindow);
	}
	
	public void homeTab() {
		waitForElement(40,home_Tab);
		actionClass(home_Tab);
		home_Tab.click();
	}

}
