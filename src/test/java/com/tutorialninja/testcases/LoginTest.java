package com.tutorialninja.testcases;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	

	@Test(priority = 1)
	public void loginWithValidCred() {

		LoginPage lp = new LoginPage(driver);
		lp.login("minnie001@gmail.com", "test1234");
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

	@Test(priority = 2)
	public void loginWithInvalidCred() {

		LoginPage lp = new LoginPage(driver);
		lp.login("minnie"+getDate()+"01@gmail.com", "test123w4");
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		String expectedResult = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(warningmsg, expectedResult);
		
	}
	

	@Test(priority = 3)
	public void loginWithvalidIDAndInvalidPass() {

		LoginPage lp = new LoginPage(driver);
		lp.login("minnie001@gmail.com", "test123423");
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		System.out.println(warningmsg);
		
	}
	

	@Test(priority = 4)
	public void loginWithInvalidIDAndValidPass() {

		LoginPage lp = new LoginPage(driver);
		lp.login("minnie"+getDate()+"01@gmail.com", "test1234");
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();		
		System.out.println(warningmsg);
		
	}
	

	@Test(priority = 5)
	public void loginWithblankCred() {

		LoginPage lp = new LoginPage(driver);
		lp.login("", "");
		String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		System.out.println(warningmsg);
		driver.quit();
	}
	
	@Test(priority = 6)
	public void forgotPassword() {
		
	}
	
	@Test(priority = 7)
	public void keyboardActions() {
		
	}
	
	@Test(priority = 8)
	public void verifyPlaceholder() {
		
	}
	
	@Test(priority = 9)
	public void browsingBack() {
		
	}
	
	@Test(priority = 10)
	public void logoutAndBrowsingBack() {
		
	}
	
	@Test(priority = 11)
	public void verifyPasswordIsHidden() {
		
	}
	
	@Test(priority = 12)
	public void verifyDifferentPages() {
		
	}
	
	@Test(priority = 13)
	public void verifyUIOfLoginPage() {
		
	}
	
	@Test(priority = 14)
	public void verifyTheBreadcrump() {
		
	}
	

}
