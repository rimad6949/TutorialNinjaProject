package com.tutorialninja.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage lp;
	Actions action;

	@Test(priority = 1)
	public void loginWithValidCred() {

		log.info("Executing test case to login with valid credentials");
		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie001@gmail.com");
		lp.addpassword("test1234");
		lp.clickOnLogin();
		// Verifying that after login "Edit your account information" link is displayed
		AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		lp.clickOnMyAct();
		lp.clickOnLogout();

	}

	@Test(priority = 2)
	public void loginWithInvalidCred() {

		log.info("Executing test case to login with invalid credentials");
		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie" + getEmailAddress() + "01@gmail.com");
		lp.addpassword("test123w4");
		lp.clickOnLogin();
		// Verifying the warning message
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		String expectedResult = "Warning: No match for E-Mail Address and/or Password.";
		AssertJUnit.assertEquals(warningmsg, expectedResult);

	}

	//@Test(priority = 3)
	public void loginWithvalidIDAndInvalidPass() {

		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie001@gmail.com");
		lp.addpassword("test123423");
		lp.clickOnLogin();
		// Verifying the warning message
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		System.out.println(warningmsg);

	}

	//@Test(priority = 4)
	public void loginWithInvalidIDAndValidPass() {

		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie00112@gmail.com");
		lp.addpassword("test123423");
		lp.clickOnLogin();
		// Verifying the warning message
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		System.out.println(warningmsg);

	}

	//@Test(priority = 5)
	public void loginWithblankCred() {

		lp = new LoginPage(driver);
		lp.addEmailAddress("");
		lp.addpassword("");
		lp.clickOnLogin();
		// Verifying the warning message
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		System.out.println(warningmsg);
	}

	//@Test(priority = 6)
	public void forgotPassword() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.clickOnForgotPassword();		
		String pageTitle = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		String expectedTitle = "Forgot Your Password?";
		AssertJUnit.assertEquals(pageTitle, expectedTitle);

	}

	//@Test(priority = 7)
	public void keyboardActions() {

		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie001@gmail.com");
		lp.addpassword("test1234");
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}

	//@Test(priority = 8)
	public void verifyPlaceholder() {
		lp = new LoginPage(driver);
		String emailPlaceholder = lp.getEmailPlaceholder("placeholder");
		String expectedEmailPlaceholder = "E-Mail Address";
		AssertJUnit.assertEquals(emailPlaceholder, expectedEmailPlaceholder);

		String pssPlaceholder = lp.getPasswordPlaceholder("placeholder");
		String expectedPassPlaceholder = "Password";
		AssertJUnit.assertEquals(pssPlaceholder, expectedPassPlaceholder);

	}

	//@Test(priority = 9)
	public void logoutAndBrowsingBack() {

		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie001@gmail.com");
		lp.addpassword("test1234");
		lp.clickOnLogin();
		AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.navigate().back();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h2")).isDisplayed());
	}

//	@Test(priority = 11)
//	public void verifyTheBreadcrump() {
//
//	}

}
