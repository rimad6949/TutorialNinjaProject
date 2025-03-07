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

	@FindBy(name = "email")
	private WebElement emailAddress;

	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement loginToAcct;

	@FindBy(linkText = "My Account")
	private WebElement myAccount;

	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

	@FindBy(xpath="//input[@name='password']/following-sibling::a")
	private WebElement forgotPass;

	@FindBy(css = "input[name='email']")
	private WebElement emailPlaceholder;

	@FindBy(css = "input[name='password']")
	private WebElement passwordPlaceholder;

	public void addEmailAddress(String emailaddress) {
		emailAddress.sendKeys(emailaddress);
	}

	public void addpassword(String password) {
		enterPassword.sendKeys(password);
	}

	public void clickOnLogin() {
		loginToAcct.click();
	}

	public void clickOnMyAct() {
		myAccount.click();
	}

	public void clickOnLogout() {
		logoutBtn.click();
	}

	public void clickOnForgotPassword() {
		forgotPass.click();
		
	}

	public String getEmailPlaceholder(String emailAttribute) {
		return emailPlaceholder.getAttribute(emailAttribute);

	}

	public String getPasswordPlaceholder(String passAttribute) {
		return passwordPlaceholder.getAttribute(passAttribute);

	}
}
