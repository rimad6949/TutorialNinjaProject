package com.tutorialninja.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tutorialninja.basepage.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(name = "firstname")
	private WebElement fname;

	@FindBy(name = "lastname")
	private WebElement lname;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "telephone")
	private WebElement phone;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(id = "input-confirm")
	private WebElement confirmpwd;

	@FindBy(xpath = "//input[@name='agree']")
	public WebElement agreecb;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebtn;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement fnameErrorMsg;

	public void clickOnRegister() {
		register.click();
	}

	public void enterFName(String firstname) {
		fname.sendKeys(firstname);
	}

	public void enterLName(String lastname) {
		lname.sendKeys(lastname);
	}

	public void enterEmail(String emailadd) {
		email.sendKeys(emailadd);
	}

	public void enterPhoneNum(String ph) {
		phone.sendKeys(ph);
	}

	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPass) {
		confirmpwd.sendKeys(confirmPass);
	}

	public void clickOnAgreeCheckbox() {
		agreecb.click();
	}

	public void clickOnContinue() {
		continuebtn.click();
	}

	// Code to get lastname error message
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameErrMsg;

	public String getFirstNameErrMsg() {
		String fnameErrMsg = firstNameErrMsg.getText();
		return fnameErrMsg;
	}

	// Code to get firstname error message
	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameErrMsg;

	public String getLastNameErrMsg() {
		String lnameErrMsg = lastNameErrMsg.getText();
		return lnameErrMsg;
	}

	// Code to get Email address error message
	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement emailErrMsg;

	public String getemailErrMsg() {
		String mailErrMsg = emailErrMsg.getText();
		return mailErrMsg;
	}

	// Code to get telephone error message
	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneErrMsg;

	public String gettelephoneErrMsg() {
		String teleErrMsg = telephoneErrMsg.getText();
		return teleErrMsg;
	}

	// Code to get password error message
	@FindBy(xpath = "//input[@name='password']/following-sibling::div")
	private WebElement passwordErrMsg;

	public String getpasswordErrMsg() {
		String passErrMsg = passwordErrMsg.getText();
		return passErrMsg;
	}

}
