package com.testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.testng.utilities.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;
	PropertiesReader properties;
	String browsername;
	String url;
	String username;
	String password;

	public WebDriver getDriver() {

		if (driver == null) {
			properties = new PropertiesReader();
			browsername = properties.getProperties("browser");
			String url = properties.getProperties("browser");
			{
				if (browsername.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else {
					if (browsername.equalsIgnoreCase("firefox")) {
						WebDriverManager.chromedriver().setup();
						driver = new FirefoxDriver();
					}
				}
				url = properties.getProperties("url");
				driver.manage().window().maximize();
				driver.get(url);
			}
		}
		return driver;
	}

	public String getusername() {
		properties = new PropertiesReader();
		username = properties.getProperties("username");

		return username;

	}

	public String getpassword() {
		properties = new PropertiesReader();
		password = properties.getProperties("password");

		return password;

	}

	public void driverclose() {
		driver.close();
		driver = null;
	}
}
