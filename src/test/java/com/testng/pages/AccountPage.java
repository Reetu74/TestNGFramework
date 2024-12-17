package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.testng.base.BasePage;

public class AccountPage extends BasePage{
	//WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="Account_Tab")
	WebElement accounttab; 
	public void accounttabclk()
	{
		waitmethod(accounttab);
	    accounttab.click();
	}
	
	
	@FindBy(xpath="//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
	WebElement newacctbtn;
	public void newacct()
	{
		newacctbtn.click();
	}
	
	String accountname = "SofttechOne";
	@FindBy(id="acc2")
	WebElement acctname;
	public void enteracctname()
	{
	acctname.sendKeys(accountname);
	}
	
	@FindBy(id="acc6")
	WebElement type; 
	public void selecttype()
	{
	Select newacc = new Select(type);
	newacc.selectByVisibleText("Technology Partner");
	}
	
	@FindBy(id="00Naj000006YUD8")
	WebElement priority; 
	public void selectpriority()
	{
	Select prioritytype = new Select(priority);
	prioritytype.selectByVisibleText("High");
	}
	
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
	WebElement savebtn; 
	public void saveacctbtn() throws InterruptedException
	{
	savebtn.click();
	Thread.sleep(2000);
	}
	
	@FindBy(xpath="//*[@id=\"contactHeaderRow\"]/div[2]/h2")
	WebElement pagedesc;
	public Boolean verifynewacct()
	{
		
	    Boolean descflag= false;
		String expecteddesc = accountname;
		String actualdesc = pagedesc.getText();
		if(expecteddesc.equals(actualdesc))
		{
			descflag=true;
		}
		return descflag;
	}
		
	
}

