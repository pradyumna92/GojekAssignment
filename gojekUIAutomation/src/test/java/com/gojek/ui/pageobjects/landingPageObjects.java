package com.gojek.ui.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.gojek.ui.base.service.commonMethods;
import com.gojek.ui.utilities.testInit;

public class landingPageObjects extends commonMethods{

	public landingPageObjects() {
		WebDriver driver =testInit.getDriver();
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	landingPageObjects landingpage =new landingPageObjects();
	private static Properties prop;
	boolean returnValue = false;

	@FindBy(xpath="//a[contains(text(),'BUY NOW')]")
	public WebElement buynowBtn;

	@FindBy(xpath="//*[@id='container']//tr[1]/td[2]/input")
	public WebElement nameField;

	@FindBy(xpath="//*[@id='container']//tr[2]/td[2]/input")
	public WebElement emailField;

	@FindBy(xpath="//*[@id='container']//tr[3]/td[2]/input")
	public WebElement phoneNumber;

	@FindBy(xpath="//*[@id='container']//tr[4]/td[2]/input")
	public WebElement cityField;

	@FindBy(xpath="//*[@id='container']//tr[5]/td[2]/textarea")
	public WebElement addressField;

	@FindBy(xpath="//*[@id='container']//tr[6]/td[2]/input")
	public WebElement postalCode;

	@FindBy(xpath="//*[@class='cart-checkout']")
	public WebElement checkoutBtn;

	@FindBy(xpath="//*[@id='application']/div[1]/a/div[1]")
	public WebElement continueBtn;

	@FindBy(xpath="//*[@id='payment-list']/div[1]//div[2]/div[1]")
	public WebElement creditCardLnk;

	@FindBy(xpath="//*[@id='application']//div[2]/div[1]/input")
	public WebElement cardnumber;

	@FindBy(xpath="//*[@id='application']//div[2]/div[2]/input")
	public WebElement expiryDate;

	@FindBy(xpath="//*[@id='application']//div[2]/div[3]/input")
	public WebElement cvvNumber;

	@FindBy(xpath="//*[@id='application']/div[1]/a/div[1]/span")
	public WebElement payNowBtn;

	@FindBy(xpath="//*[@id='PaRes']")
	public WebElement merchantOtpField;

	@FindBy(xpath="//*[contains(text(),'OK')]")
	public WebElement okBtn;

	@FindBy(xpath="//span[contains(text(),'Transaction failed')]")
	public WebElement failedTransactionText;

	@FindBy(xpath="//span[contains(text(),'Transaction successful')]")
	public WebElement successTransactionText;



	public void clickOnBuyNowButton() {
		Reporter.log("Verify buy now button is not disbaled when user in on landing page");
		landingpage.clickElement(buynowBtn);
	}

	public boolean verifyBuyNowButtonIsDisplayed() {
		Reporter.log("Verify buy now button is displayed when user in on landing page");
		returnValue=buynowBtn.isDisplayed();
		if (returnValue) {
			Reporter.log("User is on the landing page and buy now button isdisplayed");

		} else {
			Reporter.log("Error occured on the Landing page");

		}
		return returnValue;
	}

	public boolean enterCheckoutDetailsAndCheckout() {
		Reporter.log("Verify user is able to fill the checkout details on checkouk screen");
		if (returnValue) {
			Reporter.log("Enter name");
			returnValue=landingpage.enterTextField(nameField, prop.getProperty("name"));
			Reporter.log("Enter email");
			returnValue=landingpage.enterTextField(emailField, prop.getProperty("email"));
			Reporter.log("Enter phonenumber");
			returnValue=landingpage.enterTextField(phoneNumber, prop.getProperty("phoneNumber"));
			Reporter.log("Enter city");
			returnValue=landingpage.enterTextField(cityField, prop.getProperty("city"));
			Reporter.log("Enter address");
			returnValue=landingpage.enterTextField(addressField, prop.getProperty("address"));
			Reporter.log("Enter postal code");
			returnValue=landingpage.enterTextField(postalCode, prop.getProperty("postalCode"));

			if (returnValue) {
				Reporter.log("verify and click on checkout button");
				landingpage.clickElement(checkoutBtn);
			}
			else {
				Reporter.log("Error occuried while filling checkout details");
			}}
		return returnValue;
	}

	public void clickOnContinueButton() {
		Reporter.log("Verify continue button is enabled and click on continue button");
		landingpage.clickElement(continueBtn);
	}

	public void clickOnCreditCardLink() {
		Reporter.log("Verify credit card link is enabled and click on credit card link");
		landingpage.clickElement(creditCardLnk);
	}

	public boolean enterSuccessCreditCardDetailsAndPayNow() {
		Reporter.log("Verify user is able to fill the creditcard details on click on pay now button");
		if (returnValue) {
			Reporter.log("Enter credit card number");
			returnValue=landingpage.enterTextField(cardnumber, prop.getProperty("successCreditCardNumber"));
			Reporter.log("Enter credit card expiry date");
			returnValue=landingpage.enterTextField(expiryDate, prop.getProperty("expiryDate"));
			Reporter.log("Enter credit card cvv");
			returnValue=landingpage.enterTextField(cvvNumber, prop.getProperty("cvv"));
			if (returnValue) {
				Reporter.log("Verify pay now button is enabled and click on pay now button");
				landingpage.clickElement(payNowBtn);
			}
		}
		else {
			Reporter.log("Error occuried while filling credit card details");	
		}
		return returnValue;
	}

	public boolean enterIncorrectCreditCardDetailsAndPayNow() {
		Reporter.log("Verify user is able to fill the creditcard details on click on pay now button");
		if (returnValue) {
			Reporter.log("Enter credit card number");
			returnValue=landingpage.enterTextField(cardnumber, prop.getProperty("failureCreditCardNumber"));
			Reporter.log("Enter credit card expiry date");
			returnValue=landingpage.enterTextField(expiryDate, prop.getProperty("expiryDate"));
			Reporter.log("Enter credit card cvv");
			returnValue=landingpage.enterTextField(cvvNumber, prop.getProperty("cvv"));
			if (returnValue) {
				Reporter.log("Verify pay now button is enabled and click on pay now button");
				landingpage.clickElement(payNowBtn);
			}
		}
		else {
			Reporter.log("Error occuried while filling credit card details");	
		}
		return returnValue;
	}

	public void verifySuccessTransactionMessage() {
		Reporter.log("Verify transaction is successful message is displayed on entering valid credit card number");
		assertTrue("Transaction failed and error message is displayed",successTransactionText.getText().equalsIgnoreCase("Transaction successful"));
	}

}
