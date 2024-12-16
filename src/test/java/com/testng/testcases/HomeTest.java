package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.UtilitiesScreenshot;

public class HomeTest extends BaseTest
{
	LoginPage loginpg;
	HomePage homepg;
	WebDriver driver;
	UtilitiesScreenshot screenshot = new UtilitiesScreenshot();
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		
	}
	
	
	String strusername = getusername();
	String strpassword = getpassword();
	
	@Test
	public void homepagetab() 
	{
		loginpg.enterusername(getusername());
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		homepg.verifyloginsuccessful();
	}
	@AfterMethod
	public void closingdown()
	{
		driverclose();
	}

}
