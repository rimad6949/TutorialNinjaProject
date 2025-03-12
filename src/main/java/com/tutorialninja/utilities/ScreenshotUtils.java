package com.tutorialninja.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tutorialninja.basepage.BasePage;

public class ScreenshotUtils extends BasePage {

	public ScreenshotUtils(WebDriver driver) {
		super(driver);

	}

	public static Date d = new Date();
	public static String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

	public static void capturePageScreenshot() {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File(System.getProperty("user.dir") + "/target/Screenshots/" + filename);

		try {
			FileUtils.copyFile(scrFile, desFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
