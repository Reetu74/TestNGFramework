package com.testng.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.testng.base.BaseTest;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.UtilitiesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {
	
	LoginPage loginpg;
	HomePage homepg;
	WebDriver driver;
	UtilitiesScreenshot screenshot = new UtilitiesScreenshot();
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver = getDriver();
		homepg = new HomePage(driver);
		loginpg = new LoginPage(driver);
		
	}
	
	String strusername = getusername();
	String strpassword = getpassword();
	String invalidusername = "123";
	String invalidpassword = "2231";
    
	
	@Test(priority =1)
	
	
	public void loginerrormessage()
	{
		
		loginpg.enterusername(strusername);
		loginpg.clickonlogin();
		Boolean errormessageflag = loginpg.verifyloginerrormessage();
		Assert.assertTrue(errormessageflag);
		//screenshot.takeScreenshot(driver);
	}
	
	@Test(priority = 2)
	
	public void logintoSalesforce()
	{ 
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		Boolean hometabdisplayed = homepg.verifyloginsuccessful();
		Assert.assertTrue(hometabdisplayed);
	}

	@Test(priority = 3)
	public void checkRememberme()
	{ 
		
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.rememberme();
		loginpg.clickonlogin();
		loginpg.usernavlabel();
		loginpg.logout();
		Boolean remebermeflag =loginpg.verifyrememberme();
		Assert.assertTrue(remebermeflag);
	}
	
	@Test(priority = 4)
	public void forgotPassword()
	{
		loginpg.forgotpassword(strusername);
		Boolean forgotpswdflag =loginpg.verifyforgotpassword();
		Assert.assertTrue(forgotpswdflag);
	}

	@Test(priority = 5)
	public void invalidCredentials()
	{
		loginpg.enterusername(invalidusername);
		loginpg.enterpassword(invalidpassword);
		loginpg.clickonlogin();
		Boolean errorinvalidcredflag =loginpg.verifyinvlidcredentils();
		Assert.assertTrue(errorinvalidcredflag);
		
	}
	@AfterMethod
	public void closingdown()
	{
		driverclose();
	}
}
