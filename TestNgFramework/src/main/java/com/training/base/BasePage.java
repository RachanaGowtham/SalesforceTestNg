package com.training.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	public BasePage(WebDriver driver) {// constructor is catching the WebDriver driver that has been passed from the LoginPage
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void waitForElement(int time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	public void waitForElementByLocator(int time, String object) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
	}
	
	public void actionClass(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	

}
