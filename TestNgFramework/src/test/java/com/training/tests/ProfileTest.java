package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class ProfileTest extends BaseTest {
	
	 WebDriver driver;
	 String url;
	 String browser;
	 String email;
	 String password;
	 CommonUtilities common=new CommonUtilities();
	 LoginPage login;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		url=common.getproperty("url");
		browser=common.getproperty("browser");
		browser=common.getproperty("browser");
		password=common.getproperty("password");
		driver= getDriver(browser); 
		driver.get(url);
		login=new LoginPage(driver);
	}

}
