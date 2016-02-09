package com.mvn.ha;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClasses.homeawayPageClasses;
import utilities.constants;

public class HomeawayTest {

	private WebDriver driver;
	homeawayPageClasses homeAway;

	@BeforeMethod
	public void setUp() throws Exception {
		// Start Firefox
		driver = new FirefoxDriver();

		// Import URL from constants file
		String baseURL = constants.productPage;

		homeAway = new homeawayPageClasses(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Open Product Page URL
		driver.get(baseURL);

	}

	@Test
	public void checkIphone4s() throws InterruptedException {
		// Click on the Iphone 4S product link
		homeAway.clickon4S();

		// Click on Add cart button on the product page
		homeAway.clickonAddtoCart();

		// Click on the Checkout button
		homeAway.clickOnCheckout();
		Thread.sleep(3000);

		// Check if the Price on the page shows correct
		Assert.assertEquals(homeAway.ispriceCorrect(), "$270.00");

		// On Checkout page click Continue
		homeAway.clickContinue();
		Thread.sleep(3000);

		// Fill in the billing information
		homeAway.fillBillingForm();

		// Select Shipping information same as billing information
		homeAway.selectSameasBillingchdckbox();

		// Click on Purchase button
		homeAway.clickPurchaseButton();
		Thread.sleep(5000);

		// Verify order is confirmed
		Assert.assertEquals(homeAway.isOrderConfirmed(), true);
	}

	@Test
	public void emptyCartMessage() throws InterruptedException {

		// Click on the Iphone 4S product link
		homeAway.clickon4S();

		// Click on Add cart button on the product page
		homeAway.clickonAddtoCart();

		// Click on the Checkout button
		homeAway.clickOnCheckout();
		Thread.sleep(3000);

		// Check if the Price on the page shows correct
		Assert.assertEquals(homeAway.ispriceCorrect(), "$270.00");
		
		//CLick on Remove button on Checkout page
		homeAway.clickRemove();
		
		//Check empty cart message
		Assert.assertEquals(homeAway.isEmptyCartMsgAvailable(), "Oops, there is nothing in your cart.");
	}

	@AfterMethod
	public void afterClass() {
		driver.close();
	}
}