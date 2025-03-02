package com.tutorialninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tutorialninja.basepage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

//	@FindBy(linkText = "My Account")
//	private WebElement myaccount;
//
//	@FindBy(linkText = "Login")
//	private WebElement loginBtn;

	@FindBy(name = "email")
	private WebElement emailAddress;

	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement loginToAcct;

	public void login(String emailaddress, String password) {


		emailAddress.sendKeys(emailaddress);
		enterPassword.sendKeys(password);
		loginToAcct.click();

	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
	private WebElement forgetPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement title;

	public void forgetPass() {
		
		forgetPassword.click();
		String pageTitle = title.getText();
	}
	
	

}
