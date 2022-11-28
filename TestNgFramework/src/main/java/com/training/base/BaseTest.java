package com.training.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;

import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.FILE_SEPARATOR;
import static com.training.utilities.Constants.SCREENSHOT_PATH;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	public WebDriver getDriver(String browser) {
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
		
	}
       public void takescreenshot(WebDriver driver) {
		TakesScreenshot screenshot=((TakesScreenshot)driver); //Since it is an interface we cannot create an object of it.
		//We need to Typecaste it to driver.
		//Since screenshot is an object and it cannot see how the file will look like, we need to put it into a file.
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);//It will be a source file which will be a part of the object
		//we have a srcFile which is taken from the screenshot and we need to put into a file which we can read. i.e. png file.
		
	
		
		//since the path is hardcoded "/Users/gowthamsuresh/eclipse-workspace/TestNgFramework/screenshots/Salesforce.png"
		//it will overwrite the existing screenshot each time it takes a new one. so inorder to overcome this we need
		//to timestamp (format year-month-date hour-minute-second
		Date currentDate=new Date();
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);//put in this format and add it to the path
		
		//String filepath="/Users/gowthamsuresh/eclipse-workspace/TestNgFramework/screenshots/Salesforce"+timeStamp+".png"; //(add/Salesforce.png 
		//after copying the path)
		
		
		
		/*String fileSeparator= System.getProperty("file.separator");
		String reportFilePath= System.getProperty("user.dir")+fileSeparator+"screenshots"; */
		//to make the code more robust and get rid of hard coding we use "user directoy" to get
		// half of the path "/Users/gowthamsuresh/eclipse-workspace/TestNgFramework" you can use reportFilePath to replace till there in filpath
		// it will come till screenshot
		
		String reportFilePath=USER_DIR+FILE_SEPARATOR+SCREENSHOT_PATH;//Further simplify by creating a constant class and import manually
		String fileName= "Salesforce"+timeStamp+".png";
		
		String filepath=reportFilePath+FILE_SEPARATOR+fileName;
		
		//filepath is the destination. Since srcFile is a File we need to convert destination also into same path i.e. file.
		File destFile=new File(filepath);
		//The selenium driver will take a screenshot (1st line) and keep in the srcFile, we need to transfer the screenshot from the driver to a physical
		//location i.e. filepath, since filepath is a String and srcFile is a File the destination should also have a File(destFile). whatever is captured
		//by selenium should be transfered to physical location i.e. destFile.
		try {
			FileUtils.copyFile(srcFile, destFile);//copy from srcFile to destFile
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
