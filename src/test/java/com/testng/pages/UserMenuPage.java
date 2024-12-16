package com.testng.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.testng.base.BasePage;
import com.testng.base.BaseTest;

public class UserMenuPage extends BasePage {

	WebDriver driver;

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}

	BaseTest btest = new BaseTest();
	@FindBy(id = "userNav")
	WebElement usermenu;

	public void usermenudropdown() {
		waitmethod(usermenu);
		usermenu.click();
		System.out.println("UserMenuDropDown Opened");
	}

	@FindBy(xpath = "//div[@id='userNavMenu']")
	List<WebElement> usernavmenu; // list of WebElemnts

	public void verifyusermenudropdown() {
		List<String> expectedlist = Arrays.asList("My Profile", "My Settings", "Developer Console",
				"\"Switch to Lightning Experience", "Logout");
		List<WebElement> usernavmenu = driver.findElements(By.xpath("//div[@id='userNavMenu']"));
		List<String> actuallist = new ArrayList<>();

		for (WebElement element : usernavmenu) {
			actuallist.add(element.getText());
		}
		// List<String> actuallist = usernavmenu.stream().map(WebElement
		// ::getText).toList();
		Assert.assertEquals(actuallist, expectedlist, "Menu List is not displayed correctly");
		// Assert.assertTrue(actuallist.containsAll(expectedlist));
		System.out.println("Test Passed");
	}

			
	   
	}

