package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tutorialninja.basepage.BasePage;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement searchtextbox;

	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/p[1]")
	private WebElement paraDetails;

	public void searchItem(String itemname) {

		searchtextbox.sendKeys(itemname);
	}
	
	public void clickOnSearch() {

		searchbtn.click();
	}
	
	public void getItemDetails() {

		System.out.println(paraDetails.getText());
		
	}

}
