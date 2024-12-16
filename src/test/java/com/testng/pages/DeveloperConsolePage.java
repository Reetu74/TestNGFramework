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
	//driver.switchTo().activeElement();
	//Thread.sleep(5000);
	}

	@FindBy(xpath="//*[@id=\"ext-gen1361\"]")
	WebElement devconsolwnd;
	public Boolean verifydevconwnd() 
	{
		
		Boolean devconwndflag = false;
		if(devconsolwnd.isDisplayed())
		{
			devconwndflag = true;
		}
		return devconwndflag;
	}
}
