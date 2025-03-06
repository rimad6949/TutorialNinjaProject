package com.tutorialninja.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.RegistrationPage;

public class RegistrationTest extends BaseTest{
	
	RegistrationPage rp;
	
	@Test
	public void verifyRegisteringAUser() throws InterruptedException {
		
		rp = new RegistrationPage(driver);
		rp.registerAUser("ria", "lim", getEmailAddress(), "839827211", "test1234", "test1234");
		Thread.sleep(3000);
	}

}
