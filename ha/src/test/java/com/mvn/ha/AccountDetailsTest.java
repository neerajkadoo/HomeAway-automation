package com.mvn.ha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageClasses.accountPageClasses;
import pageClasses.homeawayPageClasses;
import utilities.constants;

public class AccountDetailsTest {
	
	private WebDriver driver;
	homeawayPageClasses homeAway;
	accountPageClasses account;
	
	@BeforeMethod
	public void setUp() throws Exception {
		//Start Firefox
		driver = new FirefoxDriver();
		
		//Import URL from constants file
		String baseURL = constants.onlineStore;
		
		homeAway = new homeawayPageClasses(driver);
		account = new accountPageClasses(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open Product Page URL
		driver.get(baseURL);
		
	}
	
	@Test
	public void accountDetails() throws InterruptedException{
		//CLick on My account link
		account.clickMyAccount();
		
		//Enter User name
		homeAway.enterUserName();
		
		//Enter Password
		homeAway.enterPassword();
		
		//CLick on Login button
		homeAway.clickLogin();
		
		//Click on Your details link
		account.clickYourDetails();
		
		//Update Phone number on the page
		homeAway.updatePhone();
		
		//Click on Save profile
		account.clickSubmit();
		
		Thread.sleep(5000);
		
		//Click on Your details link to populate update information
		account.clickYourDetails();
		
		//Get the value of the Phone number in string for verify
		String phoneNumber = driver.findElement(By.id("wpsc_checkout_form_18")).getAttribute("value");
		Assert.assertEquals(phoneNumber, "6666666666");
	}

	@AfterMethod
	public void afterClass() {
		driver.close();
	}
}
