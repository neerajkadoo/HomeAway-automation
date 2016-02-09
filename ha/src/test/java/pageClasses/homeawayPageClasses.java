/**
 * 
 */
/**
 * @author neeraj.kadoo
 *
 */
package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.constants;

public class homeawayPageClasses {

	WebDriver driver;

	public homeawayPageClasses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Look for iphone 4S product on the page
	@FindBy(xpath = "id('default_products_page_container')/div[4]/div[2]/h2/a")
	WebElement iphone4S;

	// Click on the iPhone 4S product
	public void clickon4S() {
		iphone4S.click();
	}

	// Look for Add to cart button for iphone4s Product
	@FindBy(css = "input.wpsc_buy_button")
	WebElement addProduct;

	// Click on the Add to Cart button
	public void clickonAddtoCart() {
		addProduct.click();
	}

	// Go to checkout button location
	@FindBy(css = ".go_to_checkout")
	WebElement checkoutButton;

	// Click on GotoCheckout button
	public void clickOnCheckout() {
		checkoutButton.click();
	}

	// Sub-total price text
	@FindBy(css = ".yourtotal > span:nth-child(1)")
	WebElement subTotalPrice;

	// Check price on the page is correct
	public String ispriceCorrect() {
		return subTotalPrice.getText();
	}

	// Continue button on the checkout page
	@FindBy(css = ".step2 > span:nth-child(1)")
	WebElement continueButton;

	// Click on COntinue button on Checkout page
	public void clickContinue() {
		continueButton.click();
	}

	// Select country dropdown
	@FindBy(css = "#current_country")
	WebElement selectCountry;

	// Select Counyry as USA
	@FindBy(css = "#current_country > option:nth-child(233)")
	WebElement countryUSA;

	// Select Country as USA
	public void clickCountryDropdown() {
		selectCountry.click();
		countryUSA.sendKeys("USA");
	}

	// User name field on Checkout page
	@FindBy(id = "log")
	WebElement userName;

	// Enter User name on the chckout page
	public void enterUserName() {
		userName.sendKeys("neerajkadoo");
	}

	// Password field on Checkout page
	@FindBy(id = "pwd")
	WebElement password;

	// Enter User name on the chckout page
	public void enterPassword() {
		password.sendKeys("y9L05QA4HQpW");
	}

	// Login button on checkout page
	@FindBy(id = "login")
	WebElement loginButton;

	// Click on Login Button
	public void clickLogin() {
		loginButton.click();
	}

	// Find Firstname Field on Billing form
	@FindBy(id = "wpsc_checkout_form_2")
	WebElement firstName;

	// Find Last name on billing form
	@FindBy(id = "wpsc_checkout_form_3")
	WebElement lastName;

	// Find Addres field on billing form
	@FindBy(id = "wpsc_checkout_form_4")
	WebElement address;

	// Find City field on billing form
	@FindBy(id = "wpsc_checkout_form_5")
	WebElement city;

	// Find State field on billing form
	@FindBy(id = "wpsc_checkout_form_6")
	WebElement state;

	// Find Country field on billing form
	@FindBy(id = "wpsc_checkout_form_7")
	WebElement country;

	// Find Postal code field on billing form
	@FindBy(id = "wpsc_checkout_form_8")
	WebElement postalCode;

	//Find email address field on billing form
	@FindBy(id="wpsc_checkout_form_9")
	WebElement emailAddress;
	
	// Find phone field on billing form
	@FindBy(id = "wpsc_checkout_form_18")
	WebElement phone;

	// Fill the billing form
	public void fillBillingForm() {
		emailAddress.sendKeys("nk@yopmail.com");
		firstName.sendKeys("Neeraj");
		lastName.sendKeys("Kadoo");
		address.sendKeys("Winema cmn");
		city.sendKeys("Fremont");
		state.sendKeys("CA");
		country.sendKeys("USA");
		postalCode.sendKeys("55555");
		phone.sendKeys("5555555555");
	}

	// Find checkbox for same shipping address
	@FindBy(id = "shippingSameBilling")
	WebElement sameBillingCheckbox;

	// Click Same billing checkbox
	public void selectSameasBillingchdckbox() {
		sameBillingCheckbox.click();
	}
	
	// Find Purcase button
	@FindBy(css = ".make_purchase")
		WebElement purchaseButton;
	
	//Click on Purchase button
	public void clickPurchaseButton(){
		purchaseButton.click();
	}
	
	//Find confirmation message
	@FindBy(css=".wpsc-transaction-results-wrap")
	WebElement confirmation;
	
	//Check for successful order submit
	public boolean isOrderConfirmed(){
		return confirmation.isDisplayed();
	}
	
	//Update Phone number
	public void updatePhone(){
		phone.clear();
		phone.sendKeys("6666666666");
	}
	
	// Find phone field on billing form
	@FindBy(id = "wpsc_checkout_form_18")
	String phonenumber;
	
	//Get text from Phone number fiels
	public void getPhone(){
		phone.getAttribute("value");
	}
	
	//Find Remove button on Checkout page
	@FindBy(css=".remove > input:nth-child(4)")
	WebElement removeProduct;
	
	//CLick on Remove button on Checkout page
	public void clickRemove(){
		removeProduct.click();
	}
	
	//Find the message for empty cart
	@FindBy(css=".entry-content")
	WebElement emptyCartMsg;
	
	//Check empty cart message
	public String isEmptyCartMsgAvailable(){
		return emptyCartMsg.getText();
	}
}
