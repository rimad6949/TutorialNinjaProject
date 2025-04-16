package com.tutorialninja.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.tutorialninja.base.BaseTest;
import com.tutorialninja.pages.LoginPage;
import com.tutorialninja.pages.SearchPage;

public class SearchTest extends BaseTest {

	SearchPage sp;
	LoginPage lp;
	WebDriver driver;
	Select select;

	public void loginFunctionality() {
		lp = new LoginPage(driver);
		lp.addEmailAddress("minnie001@gmail.com");
		lp.addpassword("test1234");
		lp.clickOnLogin();
	}
	@Test(priority=1)
	public void searchWithExistingProduct() {
		driver = getDriver();

		// Login into the application
		loginFunctionality();

		// Searching for an item
		sp = new SearchPage(driver);
		sp.searchItem("MacBook");
		sp.clickOnSearch();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/h2")));

		// Looping over number of items present in the page
		List<WebElement> itemImage = driver.findElements(By.xpath("//img[@class='img-responsive']"));

		if (itemImage.size() > 0) {
			System.out.println("Total number of product present after search is : " + itemImage.size());
		} else {
			System.out.println("There are no matching products");
		}

		for (int i = 1; i <= itemImage.size(); i++) {

			WebElement itemName = driver
					.findElement(By.xpath("//*[@id='content']/div[3]/div[" + i + "]/div/div[2]/div[1]/h4/a"));
			String items = itemName.getText();
			System.out.println(items);
		}

	}
	@Test(priority=2)
	public void searchWithNonExistingProduct() {
		driver = getDriver();

		// Login into the application
		loginFunctionality();

		// Searching for an non existing item
		sp = new SearchPage(driver);
		sp.searchItem("tesingnonproduct");
		sp.clickOnSearch();

		String noProductText = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		System.out.println(noProductText);

		Assert.assertEquals(noProductText, "There is no product that matches the search criteria.");
	}

	@Test(priority=3)
	public void selectSubCatagory() {

		driver = getDriver();

		// Login into the application
		loginFunctionality();

		// Searching for an item
		sp = new SearchPage(driver);
		sp.searchItem("MacBook");
		sp.clickOnSearch();

		WebElement drpdown = driver.findElement(By.name("category_id"));

		select = new Select(drpdown);
		select.selectByVisibleText("Desktops");
		driver.findElement(By.id("button-search")).click();

		WebElement macbook = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a"));
		macbook.getText();

		List<WebElement> itemImage = driver.findElements(By.xpath("//img[@class='img-responsive']"));

		if (itemImage.size() > 0) {
			System.out.println("Total number of product present after search is : " + itemImage.size());
		} else {
			System.out.println("There are no matching products");
		}

	}

	public void verifyProductCompare() {

	}

}
