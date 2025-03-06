package com.tutorialninja.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tutorialninja.basepage.BasePage;

public class RegistrationPage extends BasePage{
		
		public RegistrationPage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(linkText="Register")
		private WebElement register;
		
		@FindBy(name="firstname")
		private WebElement fname;
		
		@FindBy(name="lastname")
		private WebElement lname;
		
		@FindBy(name="email")
		private WebElement email;
		
		@FindBy(name="telephone")
		private WebElement phone;
		
		@FindBy(name="password")
		private WebElement pwd;
		
		@FindBy(id="input-confirm")
		private WebElement confirmpwd;
		
		@FindBy(xpath="//input[@name='agree']")
		private WebElement agreecb;
		
		@FindBy(xpath="//input[@value='Continue']")
		private WebElement continuebtn;
		
		public void registerAUser(String firstname, String lastname, String emailadd, String ph, String password, String confirmPass) {
			
			register.click();			
			fname.sendKeys(firstname);
			lname.sendKeys(lastname);
			email.sendKeys(emailadd);
			phone.sendKeys(ph);
			pwd.sendKeys(password);
			confirmpwd.sendKeys(confirmPass);
			agreecb.click();
			//continuebtn.clear();
		}
		

	}
