package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
          super(driver);
       
	}
	
	
	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement hometab;
	public Boolean verifyloginsuccessful()
	{   
		waitmethod(hometab);
		Boolean hometabdisplayed= hometab.isDisplayed();
		return hometabdisplayed ;
	    
	}

}
