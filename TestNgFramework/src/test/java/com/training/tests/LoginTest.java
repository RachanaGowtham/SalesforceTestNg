package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;
import com.training.utilities.ExcelUtils;

public class LoginTest extends BaseTest {
	
	protected WebDriver driver;
	 String url;
	 String browser;
	 String email;
	 String password;
	 String wrongemail;
	 String wrongpassword;
	 CommonUtilities common=new CommonUtilities();//inorder to call the getproperty method we need to create an object of that class
	 LoginPage login;// inorder to call the methods of the class LoginPage we need to create an object of that class(see line no 35)
	 HomePage home;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url=common.getproperty("url");// key value pair, the url(key) is read from property file and is returned as value. This happened in the 
		//CommonUtilities class
		browser=common.getproperty("browser");
		email=common.getproperty("email");
		password=common.getproperty("password");
		
		
		driver= getDriver(browser); //assigning BaseTest method getDriver to driver
		Log.info("URL of the application " +url);

		driver.get(url);
		
		login=new LoginPage(driver);//Since LoginPage does not have driver we need to pass the driver from LoginTest(LoginTest got it from BaseTest)
		home=new HomePage(driver);
		
		wrongemail=common.getproperty("wrongemail");
		wrongpassword=common.getproperty("wrongpassword");

	}
	
	@Test(dataProvider = "LoginValid")
	public void invalidLoginWithOnlyEmail(String email, String password1) {
		Log.info("Starting the testcase");
		Log.info("Username entered "+email);
		
//		System.out.println(email);
		login.enterIntoEmail(email);
		login.clickOnLogin();
		Log.info("Testcase ended");
		}//testcase 1 - PASSED
	
	@Test
	public void validUsernameAndPassword() {
		DOMConfigurator.configure("log4j.xml");
		Log.info("Starting the testcase");
		Log.info("Username entered "+email);
		Log.info("Password entered "+password);
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		login.homeTab();
		Log.info("Testcase ended");
	}//testcase 2 - PASSED
	
	@Test
	public void validLoginWithRememberMeAndLogout() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.rememberMeButton();
		login.clickOnLogin();
		home.userMenuDropDown();
		home.logoutOption();
	}//testcase 3 - PASSED
	
	@Test
	public void forgotPassword() {
		login.enterIntoEmail(email);
		login.forgotPasswordButton();
		login.forgotPasswordPageField(email);
		login.continueButton();
		login.forgotPasswordMessagePage();
	}//testcase 4a - PASSED
	
	@Test
	public void wrongEmailAndPassword() {
		login.enterIntoWrongEmail(wrongemail);
		login.enterIntoWrongPassword(wrongpassword);
		login.clickOnLogin();
		login.loginErrorTextMessage();
	}//testcase 4b - PASSED
	
	@DataProvider
	public Object[][] LoginValid() throws IOException {
		Object[][] logintestArray = ExcelUtils.getTableArray("/Users/gowthamsuresh/Desktop/Rachana/Java/InputData.xlsx", "Login", 1);
		// Object[][] logintestArray = {{"Jnanesh","Test123"}, {"Kishore","Test123"} };
		return (logintestArray);

	}
	
//	@AfterMethod
//	public void teardown() {
//		takescreenshot(driver);
//		driver.close();
//	}

}
