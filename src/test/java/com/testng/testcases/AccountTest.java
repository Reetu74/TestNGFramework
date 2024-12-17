package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.AccountPage;
import com.testng.pages.EditViewPage;
import com.testng.pages.CreateNewViewPage;
import com.testng.pages.LoginPage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.UtilitiesScreenshot;

public class AccountTest extends BaseTest{

	WebDriver driver;
	LoginPage loginpg;
	UserMenuPage userpage;
	AccountPage accountpg;
	CreateNewViewPage createviewpg;
	EditViewPage editviewpg;
	UtilitiesScreenshot screenshot = new UtilitiesScreenshot();
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver = getDriver();
		loginpg = new LoginPage(driver);
		accountpg = new AccountPage(driver);
		createviewpg = new CreateNewViewPage(driver);
		editviewpg = new EditViewPage(driver);
	}
	String strusername = getusername();
	String strpassword = getpassword();
	
	@Test
	public void createaccount() throws InterruptedException
	{     
		//TC 10
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		accountpg.accounttabclk();
		accountpg.newacct();
		accountpg.enteracctname();
		accountpg.selecttype();
		accountpg.selectpriority();
		accountpg.saveacctbtn();
		Boolean descpageflag =accountpg.verifynewacct();
		Assert.assertTrue(descpageflag, "New Account is not created");
		
	}
	
	@Test
	public void createnewview() throws InterruptedException
	{
		//TC11
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		accountpg.accounttabclk();
		createviewpg.createnewviewclk();
		createviewpg.enterviewname();
		createviewpg.eneteruniqviewname();
		createviewpg.newviewsave();
		//createviewpg.verifynewcreateview();
	}
	
	@Test
	public void editView()
	{
		//TC12
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		accountpg.accounttabclk();
		editviewpg.selectview();
		editviewpg.editviewlink();
		editviewpg.enternewviewname();
		editviewpg.enteruniqviewname();
		editviewpg.selectacctname();
		editviewpg.selectoperator();
		editviewpg.filteracctby();
		editviewpg.selectfields();
		editviewpg.addField();
		editviewpg.savefilter();
		//editviewpg.verifyfilterresult();
		
	}
	
	@Test
	public void mergeAccounts()
	{
		
	}
	@AfterMethod
	public void closingdown()
	{
		driverclose();
	}
}

