package com.tutorialninja.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public WebDriver driver;
	public Properties config;
	public FileInputStream fis;

	@BeforeMethod
	public void setUp() {

		config = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browser = config.getProperty("browserName");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

		driver.get(config.getProperty("testSiteURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	public String getEmailAddress() {
		Date d = new Date();
		String timestamp = d.toString().replace(" ", "").replace(":", "");
		return "ria" + timestamp + "@gmail.com";
	}

}
