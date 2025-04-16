package com.tutorialninja.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	private WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public static ChromeOptions option;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		config = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
			config.load(fis);
		} catch (IOException e) {
			log.error("Error loading config properties: " + e.getMessage());
			throw new RuntimeException("Failed to load configuration", e);
		}

		if (browser.equalsIgnoreCase("chrome")) {
			option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);			
			log.info("Launching Chrome Browser");
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			log.info("Launching Firefox Browser");
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.get(config.getProperty("testSiteURL"));
		log.info("Launching the URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser closed successfully");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getEmailAddress() {
		Date d = new Date();
		String timestamp = d.toString().replace(" ", "").replace(":", "");
		return "ria" + timestamp + "@gmail.com";
	}
}
