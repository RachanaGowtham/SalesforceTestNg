package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) { //constructor, it accepts Webdriver driver. from Login Test driver is passed to this constructor.
		super(driver);//we need to pass the driver into the page also
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement email;
	
	@FindBy(id="username")
	WebElement wrongemail;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password")
	WebElement wrongpassword;
	
	@FindBy(id="Login")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@href='/home/home.jsp']")
	WebElement home_Tab;
	
	@FindBy(id="error")
	WebElement errorMessage;
	
	@FindBy(xpath="//label[text()='Remember me']")
	WebElement rememberme;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotPassword;
	
	@FindBy(id="un")
	WebElement forgotPasswordPage;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="header")
	WebElement forgotPasswordMessage;
	
	@FindBy(id="error")
	WebElement loginerror;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	WebElement savedEmail;
	
	public void enterIntoEmail(String stremail) {
		waitForElement(40,email);
    	actionClass(email);
    	email.click();
		email.sendKeys(stremail);
	}
	public void enterIntoWrongEmail(String stremail) {
		waitForElement(10,email);
		wrongemail.sendKeys(stremail);
	}
	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	public void enterIntoWrongPassword(String strpassword) {
		wrongpassword.sendKeys(strpassword);
	}
	public void clickOnLogin() {
		loginbutton.click();
	}
	
	public void homeTab() {
		waitForElement(40,home_Tab);
		String homePageTitle=driver.getTitle();
		System.out.println(homePageTitle);
//		actionClass(home_Tab);
//		String actualTitle=home_Tab.getText();
//		System.out.println(actualTitle);
//		String expectedTitle="Home";
//		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void displayErrorMessage() {
		String error="Please enter your password.";
		String message=errorMessage.getText();
		Assert.assertEquals(message, error);
	}
	
	public void rememberMeButton() {
		rememberme.click();
	}
	public void forgotPasswordButton() {
		forgotPassword.click();
	}
	public void forgotPasswordPageField(String stremail) {
		waitForElement(20,forgotPasswordPage);
		actionClass(forgotPasswordPage);
		forgotPasswordPage.sendKeys(stremail);
	}
	public void continueButton() {
		continuebutton.click();
	}
	public void forgotPasswordMessagePage() {
		String expectedMessage="Check Your Email";
		String actualMessage=forgotPasswordMessage.getText();
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	public void loginErrorTextMessage() {
		String message=loginerror.getText();
		System.out.println(message);
		String expectedMessage="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(message, expectedMessage);
		}
	
	public void rememberedEmail() {
		String email_Id="mayag@tekarch.com";
		waitForElement(20,savedEmail);
		String validate=savedEmail.getText();
		Assert.assertEquals(validate, email_Id);
	}


}
