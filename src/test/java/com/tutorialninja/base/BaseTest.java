package com.tutorialninja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

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

		String browserName = config.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			log.info("Launching Chrome Browser");
			driver = new ChromeDriver();
			

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("Launching Firefox Browser");

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
		}

	}

	public String getEmailAddress() {
		Date d = new Date();
		String timestamp = d.toString().replace(" ", "").replace(":", "");
		return "ria" + timestamp + "@gmail.com";
	}

}
