package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;

public class CreateNewViewPage extends BasePage{

	public CreateNewViewPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
	WebElement newview;

	public void createnewviewclk() {
		newview.click();
	}

	String newviewname = "powersoft-0";
	@FindBy(id = "fname")
	WebElement viewname;

	public void enterviewname() {
		viewname.sendKeys(newviewname);
	}

	@FindBy(id = "devname")
	WebElement uniqviewname;

	public void eneteruniqviewname() 
	{
		uniqviewname.click();
	}

	@FindBy(xpath = "//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")
	WebElement saveview;
	public void newviewsave() throws InterruptedException {
		saveview.click();
		Thread.sleep(2000);
	}
	@FindBy(xpath="//*[@id=\"00Baj00000ON2Mf_listSelect\"]")
	WebElement viewitle;
	public void verifynewcreateview()
	{
		String actualdisplayview =viewitle.getText();
		System.out.println(actualdisplayview);
	}
}
