package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tutorialninja.basepage.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="My Account")
	private WebElement myaccount;
	
	@FindBy(linkText="Login")
	private WebElement loginBtn;
	
	@FindBy(name="email")
	private WebElement emailAddress;
	
	@FindBy(name="password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement loginToAcct;

	public void login(String emailaddress, String password) {
		
		myaccount.click();
		loginBtn.click();
		emailAddress.sendKeys(emailaddress);
		enterPassword.sendKeys(password);
		loginToAcct.click();
		
	}

}
