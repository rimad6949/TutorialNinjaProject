package com.tutorialninja.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

	RegistrationPage rp;

	@Test(priority = 1)
	public void verifyRegisteringAUser() {

		rp = new RegistrationPage(driver);
		rp.registerAUser("ria", "lim", getEmailAddress(), "839827211", "test1234", "test1234");
		rp.clickOnAgreeCheckbox();
		rp.clickOnContinue();
		String actualConfirmationMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualConfirmationMsg, "Your Account Has Been Created!");
	}

	@Test(priority = 2)
	public void verifyErrorMsgIfFirstNameFieldAreBlanks() {

		rp = new RegistrationPage(driver);
		rp.registerAUser("", "lim", getEmailAddress(), "839827211", "test1234", "test1234");
		rp.clickOnAgreeCheckbox();
		rp.clickOnContinue();
		Assert.assertEquals(rp.getFirstNameErrMsg(), "First Name must be between 1 and 32 characters!");

	}
	
	@Test(priority = 3)
	public void verifyMsgEnteringTwoDifferentPasswords() {
		rp = new RegistrationPage(driver);
		rp.registerAUser("ria", "lim", getEmailAddress(), "839827211", "test1234212", "test1234");
		rp.clickOnAgreeCheckbox();
		rp.clickOnContinue();
		String passwordErrorMsg = driver.findElement(By.xpath("//div[@class=\"text-danger\"]")).getText();
		Assert.assertEquals(passwordErrorMsg, "Password confirmation does not match password!");

	}

	@Test(priority=4)
	public void verifyMsgWhenDuplicateEmailIsAdded() {

		rp = new RegistrationPage(driver);
		rp.registerAUser("ria", "lim", "minnie001@gmail.com", "839827211", "test1234", "test1234");
		rp.clickOnAgreeCheckbox();
		rp.clickOnContinue();
		String duplicateErrorMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertEquals(duplicateErrorMsg, "Warning: E-Mail Address is already registered!");

	}
	 
	 @Test(priority=5)
	public void uncheckTheAcceptCheckboxAndSubmit(){
		rp = new RegistrationPage(driver);
		rp.registerAUser("ria", "lim", getEmailAddress(), "839827211", "test1234", "test1234");
		rp.clickOnContinue();		
		String acceptErrorMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertEquals(acceptErrorMsg, "Warning: You must agree to the Privacy Policy!");

	}
	
	@Test(priority=6)
	public void verifyErrorMsgIfAllFieldsAreBlanks() {
		
		rp = new RegistrationPage(driver);
		rp.registerAUser("", "", "", "", "", "");
		rp.clickOnAgreeCheckbox();
		rp.clickOnContinue();
		Assert.assertEquals(rp.getFirstNameErrMsg(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(rp.getLastNameErrMsg(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(rp.getemailErrMsg(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(rp.gettelephoneErrMsg(), "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(rp.getpasswordErrMsg(), "Password must be between 4 and 20 characters!");
		
		
	}

}
