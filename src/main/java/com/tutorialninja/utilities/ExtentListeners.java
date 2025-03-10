package com.tutorialninja.utilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener {

	public static Date d = new Date();
	public static String filename = "Extent_"+ d.toString().replace(":", "_").replace(" ", "_") + ".html";
	public static ExtentReports extent = ExtentReportManager
			.extentReportSetup("/Users/rimadas/eclipse-workspace/TutorialNinjaProject/target/ExtentReports" + filename);
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent
				.createTest(result.getTestClass().getName() + " @TestCase : " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+"Test case :- "+ methodName.toUpperCase()+"PASSED"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String logtext = "<b>"+"Test case :- "+methodName.toUpperCase()+"FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.RED);
		test.fail(m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String logtext = "<b>"+"Test case :- "+methodName.toUpperCase()+"SKIPPED"+"</b>";
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
		
		if(extent!=null) {
			extent.flush();
		}

	}

}
