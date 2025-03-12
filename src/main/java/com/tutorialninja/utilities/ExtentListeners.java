package com.tutorialninja.utilities;

import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tutorialninja.basepage.BasePage;

public class ExtentListeners implements ITestListener {

	public static Date d = new Date();
	public static String reportfileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	public static ExtentReports extent = ExtentReportManager
			.extentReportSetup(System.getProperty("user.dir") + "/target/ExtentReports/" + reportfileName);
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent
				.createTest(result.getTestClass().getName() + " @TestCase : " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test case :- " + methodName.toUpperCase() + "PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		ScreenshotUtils.capturePageScreenshot();

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=" + ScreenshotUtils.filename + " target=\"_blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=" + ScreenshotUtils.filename + " target=\"_blank\"><img src=" + ScreenshotUtils.filename
				+ " height=200 width=200></a>");

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " FAILED" + "</b>";

		try {
			String screenshot = ScreenshotUtils.filename;
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logtext = "<b>" + "Test case :- " + methodName.toUpperCase() + "SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.YELLOW);
		test.skip(m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

}
