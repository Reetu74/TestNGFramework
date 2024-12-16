package com.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testng.base.BasePage;

public class MySettingsPage extends BasePage
{
    //WebDriver driver;
    
	public MySettingsPage(WebDriver driver) 
	{
		super(driver);
		
	}


	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[2]")
	WebElement mysettings;

	public void mySettings() {
		mysettings.click();
	}

	@FindBy(xpath = "//*[@id=\"PersonalInfo\"]")
	WebElement personal;

	public void personalclk() {
		personal.click();
	}

	@FindBy(xpath="//*[@id=\"LoginHistory_font\"]")
	WebElement loginhist;

	public void loginhistory() 
	{
		loginhist.click();
	}
	
	@FindBy(xpath="//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	WebElement downldhistory;
	public void downloadhistoryclk() throws InterruptedException
	{
		downldhistory.click();
		Thread.sleep(5000);
	}
	/*public void verifydownload() 
	{
		        String downloadFilepath = System.getProperty("user.dir") + "/downloads";
		        //public static void verifyFileDownloaded(String downloadFilepath) {
		            File dir = new File(downloadFilepath);
		            File[] files = dir.listFiles();

		            boolean fileFound = false;
		            if (files != null) {
		                for (File file : files) {
		                    // Check if the file is downloaded (e.g., file extension, last modified time)
		                    if (file.getName().endsWith(".xls") && file.lastModified() > System.currentTimeMillis() - 30000) {
		                        fileFound = true;
		                        System.out.println("File downloaded: " + file.getName());
		                        break;
		                    }
		                }
		            }

		            if (!fileFound) {
		                System.out.println("Downloaded file not found or has not been updated recently.");
		            }
		        }*/
	
	@FindBy(xpath="//*[@id=\"DisplayAndLayout_font\"]")
	WebElement display1;
	public void display()
	{
		display1.click();
	}
	
	@FindBy(id="CustomizeTabs_font")
			WebElement customizetab;
	public void CustomizedTab()
	{
		customizetab.click();
	}
	
	@FindBy(xpath="//*[@id=\"p4\"]")
	WebElement customtab1;
	public void salesforcechatter()
	{
		Select customapp = new Select(customtab1);
		customapp.selectByVisibleText("Salesforce Chatter");
	}
	
	@FindBy(xpath="//*[@id=\"duel_select_0\"]")
	WebElement availabledd;
	public void reportmove() 
	{
		Select available = new Select(availabledd);
		available.selectByVisibleText("Reports");
	}
	
	@FindBy(xpath="//*[@id=\"duel_select_0_right\"]/img")
	WebElement add;
	public void addclk() throws InterruptedException {
		add.click();
		Thread.sleep(5000);
	}
	
	@FindBy(name="save")
	WebElement savemove;
	public void saveMoveReport()
	{
		savemove.click();
	}
	
	//TC07 Step 5
	@FindBy(xpath="//*[@id=\"EmailSetup\"]/a")
	WebElement emaillnk;
	public void emaillinkclk()
	{
	emaillnk.click();
	}
	
	@FindBy(xpath="//*[@id='EmailSettings_font']")
	WebElement emailsettinglk;
	public void emailsettinglink()
	{
		emailsettinglk.click();
	}
	
	@FindBy(id="sender_name")
	WebElement sendername; 
	public void entersendername()
	{
		sendername.clear();
		sendername.sendKeys("Reetu Gupt");
	}
	
	@FindBy(id="sender_email")
	WebElement senderemailadd;
	public void enteremailadd()
	{
	waitmethod(senderemailadd);
	senderemailadd.clear();
	senderemailadd.sendKeys("reetug74@gmail.com");
	}
	
	@FindBy(id="auto_bcc1")
	WebElement senderaddbcc;
	public void clicksenderbcc()
	{
	senderaddbcc.click();
	}
	
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
	WebElement emailsavebtn; 
	public void emailSave()
	{
	emailsavebtn.click();
	}
	
	//TC07 Step 6 
	@FindBy(xpath="//*[@id=\"CalendarAndReminders\"]")
	WebElement calenderlnk ;
	public void calenderlinkclk()
	{
	calenderlnk.click();
	}
	
	@FindBy(xpath="//*[@id=\"Reminders_font\"]")
	WebElement activityremlnk; 
	public void activityreminderlk()
	{
	activityremlnk.click();
	}
	
	@FindBy(xpath="//*[@id=\"testbtn\"]")
	WebElement testactivityrembtn; 
	public void testactreminderbtn()
	{
	testactivityrembtn.click();
	}
	
	@FindBy(xpath="/html")
	WebElement popwndw;
	public Boolean verifypopupwinddisplayed() throws InterruptedException
	{
	Boolean displayflag = false;	
	if(popwndw.isDisplayed())
	{
	    displayflag = true;
	}
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	return displayflag;
	}
	
	
}

