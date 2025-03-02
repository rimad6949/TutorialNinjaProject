package com.tutorialninja.testcases;

import org.testng.annotations.Test;

import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.LoginPage;

public class demo extends BaseTest{
	
	LoginPage lp;
	
	@Test
	public void forgetpass() {
		lp = new LoginPage(driver);
		lp.forgetPass();
	}
	

}
