package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class OpportunityPage  extends BasePage{

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'Opportunities') and @title='Opportunities Tab']")
	WebElement opportunities_Tab;
	
	@FindBy(id="fcf")
	WebElement view_Opportunities;
	
	@FindBy(xpath="//input[contains(@title,'New')]")
	WebElement new_Button;
	
	@FindBy(id="opp3")
	WebElement opty_Name;
	
	@FindBy(id="opp4")
	WebElement account_Name;
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement opty_Pipeline;
	
	@FindBy(xpath="//h1[contains(@class,'noSecondHeader pageType')]")
	WebElement opty_Pipeline_pg;
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuck_Opty;
	
	@FindBy(xpath="//h1[contains(text(),'Stuck Opportunities')]")
	WebElement stuck_Opty_Pg;
	
	@FindBy(id="quarter_q")
	WebElement quaterly_Summary_interval;
	
	@FindBy(id="open")
	WebElement quaterly_Summary_Include;
	
	@FindBy(xpath="//input[@title='Run Report']")
	WebElement run_Report_Button;
	
	@FindBy(xpath="//h1[contains(text(),'Opportunity Report')]")
	WebElement opty_Repor_Pg;
	
	public void opportunitiesTab() {
		//waitForElement(20,opportunities_Tab);
		actionClass(opportunities_Tab);
		opportunities_Tab.click();
		}
	
	public void viewOpportunities() {
		waitForElement(20,view_Opportunities);
		actionClass(view_Opportunities);
		
		Select lists=new Select(view_Opportunities);
		
				List<WebElement> allOptions=lists.getOptions();
				
				for(WebElement options: allOptions) {
					System.out.println(options.getText());
					
				}
		}
	
	public void newButton() {
		waitForElement(20,new_Button);
		actionClass(new_Button);
		new_Button.click();
		}
	
	public void optyName(String optyname) {
		waitForElement(20,opty_Name);
		actionClass(opty_Name);
		opty_Name.sendKeys(optyname);
		}
	
	public void accountName(String accountname) {
		waitForElement(20,account_Name);
		actionClass(account_Name);
		account_Name.sendKeys(accountname);
		}
	
	public void stuckOpty() {
		waitForElement(20,stuck_Opty);
		actionClass(stuck_Opty);
		stuck_Opty.click();
		}
	
	public void optyPipelinePage() {
	     waitForElement(20,opty_Pipeline_pg);
		//actionClass(opty_Pipeline_pg);
		String pageText=opty_Pipeline_pg.getText();
		System.out.println(pageText);
		String expextedText="Opportunity Pipeline";
		Assert.assertEquals(pageText, expextedText);
		
		}
	
	public void optyPipeline() {
		waitForElement(20,opty_Pipeline);
		actionClass(opty_Pipeline);
		opty_Pipeline.click();
		}
	
	public void stuckOptyPage() {
	     waitForElement(20,stuck_Opty_Pg);
		//actionClass(opty_Pipeline_pg);
		String pageText=stuck_Opty_Pg.getText();
		System.out.println(pageText);
		String expextedText="Stuck Opportunities";
		Assert.assertEquals(pageText, expextedText);
		
		}
	
	public void quaterlySummaryInterval() {
		waitForElement(20,quaterly_Summary_interval);
		actionClass(quaterly_Summary_interval);
		Select option=new Select(quaterly_Summary_interval);
		option.selectByVisibleText("Current and Next FQ");
		}
	
	public void quaterlySummaryInclude() {
		waitForElement(20,quaterly_Summary_Include);
		actionClass(quaterly_Summary_Include);
		Select option=new Select(quaterly_Summary_Include);
		option.selectByVisibleText("Open Opportunities");
		}
	
	public void runReportButton() {
		waitForElement(20,run_Report_Button);
		run_Report_Button.click();
		}
	
	public void optyReporPage() {
	     waitForElement(20,opty_Repor_Pg);
		String pageText=opty_Repor_Pg.getText();
		System.out.println(pageText);
		String expextedText="Opportunity Report";
		Assert.assertEquals(pageText, expextedText);
		
		}
	

}
