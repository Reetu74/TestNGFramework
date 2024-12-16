package com.testng.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilitiesScreenshot {
	
	WebDriver driver;
	
	public void takeScreenshot(WebDriver driver)
	{
		String methodname = new Throwable().getStackTrace()[1].getMethodName(); //to get the method name 
		//To Take Screenshot Selenium has an inbuilt Interface TakesScreenshot
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);    //typecasting
		File srnfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String userDir = System.getProperty("user.dir"); //System functionality to fectch the path of the project
		
		Date current = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-MM-SS").format(current);
		String filepath = userDir+"\\ScreenShot\\Screenshot"+"_"+methodname+"_"+timestamp+".jpeg";
		
		File desfile = new File(filepath);
		
		try {
			FileUtils.copyFile(srnfile, desfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
