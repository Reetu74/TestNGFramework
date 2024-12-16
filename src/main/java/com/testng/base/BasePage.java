package com.testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	protected static WebDriver driver;

	public BasePage(WebDriver driver) 
	{
     this.driver = driver;
     PageFactory.initElements(driver, this);
	}
	
	public void waitmethod(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitmethod1(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
