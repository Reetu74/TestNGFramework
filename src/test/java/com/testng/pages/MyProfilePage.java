package com.testng.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.testng.base.BasePage;


public class MyProfilePage extends BasePage
{
   //WebDriver driver;
	Actions action= new Actions(driver);
    
	public MyProfilePage(WebDriver driver) 
	{
		super(driver);
		
	}

	
	@FindBy(xpath = "//a[text()='My Profile']")
	WebElement myprofile;

	public void myprofile() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myprofile.click();
	}

	@FindBy(id = "profileTabSetHeader")
	WebElement profiletabheader;

	public void verifymyprofilepage() {
		// waitmethod1(myprofile);
		myprofile();
		profiletabheader.isDisplayed();

		System.out.println("My Profile page opens");
	}

	

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	WebElement editbutton;

	public void editprofile() {
		editbutton.click();
	}

	@FindBy(id="contactInfoContentId")
	WebElement iaboutframe;

	public void switchAboutframe() throws InterruptedException {
		//Thread.sleep(5000);
		 waitmethod(iaboutframe);
		driver.switchTo().frame(iaboutframe);

	}

	@FindBy(xpath = "//*[@id=\"aboutTab\"]/a")
	WebElement abouttab;

	public void verifyabouttab() {
		String expectedtabtext = "About";
		String actualtabtext = abouttab.getText();
		Assert.assertEquals(actualtabtext, expectedtabtext);
		System.out.println("About Tab is opened");

	}

	public void clickabouttab() {
		waitmethod1(abouttab);
		abouttab.click();
	}

	@FindBy(id = "lastName")
	WebElement lastname;

	public void enterlastname() {
		lastname.clear();
		lastname.sendKeys("Gupta");
	}

	@FindBy(xpath = "//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
	WebElement tabpanel;

	public void tabPanel() {
		waitmethod(tabpanel);
		tabpanel.click();
		driver.switchTo().defaultContent();
	}

	@FindBy(id="userNavLabel")
	WebElement usernavtext;

	public Boolean verifynamechangereflected() 
	{
		Boolean labelflag = false;
		String expectedlabelname = "Reetu Gupta";
		String actuallabelname = usernavtext.getText();

	if(expectedlabelname.equals(actuallabelname))
	{
		labelflag = true;
	}
		 return   labelflag;
		
	 }
	
	//Post a Message TC06 Step 3
	
	@FindBy(xpath="//*[@id=\"publisherAttachTextPost\"]/span[1]")
	WebElement post;
	public void posttextclick() throws InterruptedException
	{
		Thread.sleep(5000);
		//waitmethod(post);
		post.click();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	WebElement framepost;
    public void switchtoframepost()
    {
    waitmethod(framepost);
	driver.switchTo().frame(framepost);
    }
    
    @FindBy(xpath="//body[@role='textbox']")
    WebElement postwn;	
	public void enterpostmessage()
	{
	postwn.sendKeys("Selenium Automation Text thru TestNG");
	driver.switchTo().defaultContent();
	}
	
	@FindBy(id="publishersharebutton")
	WebElement sharebtn;
	public void sharepostclk() throws InterruptedException
	{
	sharebtn.click();
	Thread.sleep(2000);
	}


	@FindBy(xpath="//*[@id=\"0D5aj00000C7sHl\"]/div/div[1]/div[1]/div[2]/div[1]/span/p")
	WebElement postshared;
	public Boolean verifypostsharedsuccess()
	{
		Boolean postmessageflag = false;
		String expectedpost = "Selenium Automation Text thru TestNG";
		String actualpost = postshared.getText();
		if(expectedpost.equals(actualpost))
		{
			postmessageflag = true;
		}
		return postmessageflag;
	}
		
	//TC 06 Upload File Step 4
	@FindBy(xpath="//*[@id=\"publisherAttachContentPost\"]")
	WebElement filelk;
	public void filelinkclick() throws InterruptedException
	{
		Thread.sleep(5000);
	filelk.click();
	}
	
	@FindBy(xpath="//*[@id=\"chatterUploadFileAction\"]")
	WebElement fileuploadlkck;
	public void uploadfilefrombrowserlk() throws InterruptedException
	{
	//Thread.sleep(5000);
	fileuploadlkck.click();
	}
	
	@FindBy(id="chatterFile")
	WebElement choosefilebtn;  
	public void choosefiletoupload()
	{
						
    	String filepath = "C:\\Users\\ajayk\\Downloads\\test1testng.txt";
    	choosefilebtn.sendKeys(filepath);
	}
	
	@FindBy(id="publishersharebutton")
	WebElement sharefilebtn;
	public void sharefile()
	{
		sharefilebtn.click();
	}
	
	@FindBy(xpath="//span[@class='contentTitleLink']")
	WebElement uploadedfile;
	public Boolean verifyfileuploaded()
	{
		Boolean uploadfileflag = false;
		String expectedfilename = "test1testng";
		String actualfilename = uploadedfile.getText();
		if(expectedfilename.equals(actualfilename))
		{
			uploadfileflag= true;
		}
		return uploadfileflag;
	}
	
	//TC06 MyProfile Add Photo
	@FindBy(xpath="//*[@id=\"photoSection\"]/span[2]/img[2]")
	WebElement photohower;
	public void photolkhower()
	{
	//Actions action = new Actions(driver);
	action.moveToElement(photohower).build().perform();
	}
	
	@FindBy(xpath="//*[@id=\"uploadLink\"]")
	WebElement photoclk;
	public void photoclick()
	{
	photoclk.click();
	}
	
	@FindBy(xpath="//*[@id=\"uploadPhotoContentId\"]")
	WebElement phframe;
	public void switchphotoframe()
	{
	driver.switchTo().frame(phframe);
	}
	
	@FindBy(xpath="//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]")
	WebElement upphoto;
	//String filePath = System.getProperty("user.dir"), "Downloads", "pic.jpg").toString(); 
	String filePath = "C:\\Users\\ajayk\\Downloads\\testngpic.jpg";  //how to get this hard coded path with a logic
	public void uploadphoto()
	{
	upphoto.sendKeys(filePath);
	}
	
	@FindBy(xpath="//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]")
	WebElement savephoto;
	public void savePhoto()
	{
	if(savephoto.isEnabled())
	  savephoto.click();
	}
	
	@FindBy(xpath="//*[@id=\"j_id0:outer\"]/div[1]/div/div/div")
	WebElement photocropimg; 
	public void photoCrop() throws InterruptedException
	{
		Thread.sleep(2000);
	action.clickAndHold(photocropimg).moveByOffset(175,175).release().build().perform();
	}
	
	@FindBy(id="j_id0:j_id7:save")
	WebElement savecropphoto;
	public void savecropphoto() throws InterruptedException
	{
	savecropphoto.click();
	Thread.sleep(2000);
	}
}
