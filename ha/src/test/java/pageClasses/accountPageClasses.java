package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountPageClasses {
	
	WebDriver driver;

	public accountPageClasses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Loacte My account page element
	@FindBy(css=".account_icon")
	WebElement myAccount;
	
	//Click on My account link
	public void clickMyAccount(){
		myAccount.click();
	}
	
	//Find View details link on Your account page
	@FindBy(linkText="Your Details")
	WebElement yourDetails;
	
	//Click on Your details link
	public void clickYourDetails(){
		yourDetails.click();
	}
	
	//Submit Edit account details form
	@FindBy(name="submit")
	WebElement submitButton;
	
	//Click on Submit button on Edit details form
	public void clickSubmit(){
		submitButton.click();
	}
	
}
