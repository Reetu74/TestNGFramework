package com.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;

public class DeveloperConsolePage extends BasePage{

	//WebDriver driver;
	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[3]")
	WebElement devconsole;
	public void opendevconsole() throws InterruptedException
	{
	devconsole.click();
	Thread.sleep(5000);
	}
	
	String parentwindow = driver.getWindowHandle();
	public void switchwindow()
	{
		 for(String windowhandle : driver.getWindowHandles())
				 {
			 driver.switchTo().window(windowhandle);
				 }
	}
	
	@FindBy(xpath="//*[@id=\"ext-gen1361\"]")
	WebElement devconsolwnd;
	public Boolean verifydevconwnd() 
	{
		switchwindow();
		Boolean devconwndflag = false;
		if(devconsolwnd.isDisplayed())
		{
			devconwndflag = true;
		}
		return devconwndflag;
	}
	 public void closedevcon()
	 {
		switchwindow();
		 
		 driver.close();
		 driver.switchTo().window(parentwindow);
	 }
}
