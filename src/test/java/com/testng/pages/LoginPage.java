package com.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testng.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
          super(driver);
       
	}
	
	
	@FindBy(id="username")
	WebElement userid;
	
	public void enterusername(String username)
	{
		waitmethod(userid);
		userid.sendKeys(username);
				
	}
    @FindBy(name="pw")
    WebElement pswd;
	public void enterpassword(String password)
	{
		pswd.sendKeys(password);
	}
	@FindBy(xpath="//input[@name ='Login']")
	WebElement loginbtn;		
	
	public void clickonlogin()
	{   waitmethod(loginbtn);
		loginbtn.click();
	}
	 
	@FindBy(xpath="//label[contains(text(),'Remember')]")
	WebElement rembme;
	public void rememberme()
	{
		rembme.click();
	}
	
	@FindBy(xpath= "//span[@id='userNavLabel']")
	WebElement usernvlabel;
	public void usernavlabel()
	{ 
		waitmethod(usernvlabel);
		usernvlabel.click();
	}
	
	@FindBy(xpath= "//a[text()='Logout']")
	WebElement logout;
	public void logout()
	{ 
		waitmethod(logout);
		logout.click();
	
	}
	
	@FindBy(xpath="//a[@class='fl small']")
	WebElement forgotpswd;
	@FindBy(id="un")
	WebElement usid;
	@FindBy(name="continue")
	WebElement contbtn;
	public void forgotpassword(String username)
	{
		forgotpswd.click();
		usid.sendKeys(username);
		contbtn.click();
	}
	
	@FindBy(id="error")
	WebElement errortext;
	public Boolean verifyloginerrormessage()
	{
		Boolean errormessageflag = false;
		String expectederrormessage = "Please enter your password.";
		
		String actualerrormessage = errortext.getText();
		if(expectederrormessage.equals(actualerrormessage))
		{
			errormessageflag=true;
		}
		return errormessageflag;
	}
	
	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement hometab;
	public Boolean verifyloginsuccessful()
	{   
		waitmethod(hometab);
		//hometab.click();
		Boolean hometabdisplayed= hometab.isDisplayed();
		return hometabdisplayed ;
	    
	}

	@FindBy(id="idcard")
	WebElement rembtext;
	public Boolean verifyrememberme()
	{
		Boolean remembermeflag = false;
		String expectedtext = "reetu@softtech.com";
		waitmethod(rembtext);
		String actualtext = rembtext.getText();
		
		if(expectedtext.equals(actualtext));
		{
			remembermeflag=true;
		}
		return remembermeflag;
	}
	@FindBy(id="main")
	WebElement mainpage;
	public Boolean verifylogout() throws InterruptedException
	{
		Thread.sleep(5000);
		Boolean logoutflag = false;
		
		if(mainpage.isDisplayed());
		{
			logoutflag=true;
		}
		return logoutflag;
	}
	
	
	@FindBy(xpath ="//h1[contains(text(),'Check Your Email')]")
	WebElement forgotpswdtext;
	public Boolean verifyforgotpassword()
	{
		Boolean forgotpswdflag = false;
		 String expectedtext = "Check Your Email";
	     String actualtext = forgotpswdtext.getText();
		 if(expectedtext.equals(actualtext))
		 {
			 forgotpswdflag = true;
		 }
	     return forgotpswdflag;
	}
	@FindBy(id="error")
	WebElement invaliderrortext;
	public Boolean verifyinvlidcredentils()
	{
		Boolean errorinvlidcredflag= false;
		String expectederrormesaage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualerrormessage = invaliderrortext.getText();
		if(expectederrormesaage.equals(actualerrormessage))
				{
			errorinvlidcredflag = true;
				}
		return errorinvlidcredflag;
		
	}
}
