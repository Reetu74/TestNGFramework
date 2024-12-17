package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.DeveloperConsolePage;
import com.testng.pages.LoginPage;
import com.testng.pages.MyProfilePage;
import com.testng.pages.MySettingsPage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.UtilitiesScreenshot;

public class UserMenuTest extends BaseTest {
	LoginPage loginpg;
	UserMenuPage userpage;
	MyProfilePage myprofilepg;
	MySettingsPage mysettingspg;
	DeveloperConsolePage devconpage;
	WebDriver driver;
	UtilitiesScreenshot screenshot = new UtilitiesScreenshot();

	@BeforeMethod
	public void beforeMethod() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		userpage = new UserMenuPage(driver);
		myprofilepg = new MyProfilePage(driver);
		mysettingspg = new MySettingsPage(driver);
		devconpage = new DeveloperConsolePage(driver);
	}

	String strusername = getusername();
	String strpassword = getpassword();

	@Test
	public void usernavmenudropdown() throws InterruptedException {
		// TC 05
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		userpage.usermenudropdown();
		Thread.sleep(5000);
		screenshot.takeScreenshot(driver);
		// userpage.verifyusermenudropdown();
	}

	@Test
	public void myprofilefunctions() throws InterruptedException {
		// ----------TC 06-----------
		// TC06 Step 1
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		userpage.usermenudropdown();

		// TC06 Step 2
		myprofilepg.myprofile();
		
		// TC06 Step 3
		myprofilepg.editprofile();
		
		//TC06 Step 4
		myprofilepg.switchAboutframe();
		myprofilepg.verifyabouttab();
		myprofilepg.clickabouttab();
		myprofilepg.enterlastname();
		myprofilepg.tabPanel();
		Boolean labelflag = myprofilepg.verifynamechangereflected();
		Assert.assertTrue(labelflag);

		//TC06 Step 5
		myprofilepg.posttextclick();
		myprofilepg.switchtoframepost();
		myprofilepg.enterpostmessage();
		myprofilepg.sharepostclk();
		Boolean postsharedflag = myprofilepg.verifypostsharedsuccess();
		Assert.assertTrue(postsharedflag);

		// TC06 Step 6
		myprofilepg.filelinkclick();
		myprofilepg.uploadfilefrombrowserlk();
		myprofilepg.choosefiletoupload();
		myprofilepg.sharefile();
		Boolean fileuploadflag = myprofilepg.verifyfileuploaded();
		Assert.assertTrue(fileuploadflag, "File is not uploaded");

		// TC06 Step 7
		myprofilepg.photolkhower();
		myprofilepg.photoclick();
		myprofilepg.switchphotoframe();
		myprofilepg.uploadphoto();
		myprofilepg.savePhoto();
		myprofilepg.photoCrop();
		myprofilepg.savecropphoto();
		screenshot.takeScreenshot(driver);

	}

	@Test
	public void mysettingsfuctions() throws InterruptedException {
		// TC07 Step 1
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		userpage.usermenudropdown();
		
		//TC07 Step 2
		mysettingspg.mySettings();
		
		//TC07 Step 3
		//mysettingspg.personalclk();
		//mysettingspg.loginhistory();
		//mysettingspg.downloadhistoryclk();
		//screenshot.takeScreenshot(driver);
		// mysettingspg.verifydownload();
		
		//TC07 Step 4
		//mysettingspg.display();
		//mysettingspg.CustomizedTab();
		//mysettingspg.salesforcechatter();
		//mysettingspg.reportmove();
		//mysettingspg.addclk();
		//mysettingspg.saveMoveReport();

		//TC07 Step 5
		//mysettingspg.emaillinkclk();
		//mysettingspg.emailsettinglink();
		//mysettingspg.entersendername();
		//mysettingspg.enteremailadd();
		//mysettingspg.clicksenderbcc();
		//mysettingspg.emailSave();
		
		//TC07 Step 6
		mysettingspg.calenderlinkclk();
		mysettingspg.activityreminderlk();
	    mysettingspg.testactreminderbtn();
	    Boolean popupwndflag =mysettingspg.verifypopupwinddisplayed();
	    Assert.assertTrue(popupwndflag);
	   // mysettingspg.closedpopwindow();
	}

	@Test
	public void developerconsolefunctions() throws InterruptedException 
	{
		//TC08
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		userpage.usermenudropdown();
		devconpage.opendevconsole();
		Boolean devconflag = devconpage.verifydevconwnd();
		Assert.assertTrue(devconflag,"Dev Console is not displayed");
		devconpage.closedevcon();
		
	}
	
	@Test
	public void logoutoption() throws InterruptedException
	{
		//TC09
		loginpg.enterusername(strusername);
		loginpg.enterpassword(strpassword);
		loginpg.clickonlogin();
		userpage.usermenudropdown();
		loginpg.logout();
		Boolean logoutflag=loginpg.verifylogout();
		Assert.assertTrue(logoutflag,"Main Page is not displayed");
		
	}
	@AfterMethod
	public void closingdown() {
		driverclose();
	}

}
