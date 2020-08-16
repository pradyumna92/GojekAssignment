package com.gojek.ui.testSuites;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gojek.ui.base.service.*;
import com.gojek.ui.pageobjects.*;
import com.gojek.ui.utilities.*;

public class successCreditCardPayment  {
	commonMethods baseMethods = new commonMethods();
	landingPageObjects pageObjects = new landingPageObjects();
	testInit init =new testInit();
	boolean testResult = false;

	@BeforeTest
	public void beforeTest() {
		try {
			baseMethods.launchApp();
			testResult = pageObjects.verifyBuyNowButtonIsDisplayed();
		} catch (Exception e) {
			testResult &= false;
			Reporter.log("An error occured during execution : " + e.getMessage());
		}

		if (testResult) {
			Reporter.log("Before Test method passed");
			Assert.assertTrue(testResult);
		} else {
			Reporter.log("Before Test method failed");
			Assert.fail();
		}
	}

	@Test
	public void validateSuccessCreditCardPayment() {
		try {
			pageObjects.clickOnBuyNowButton();
			testResult = pageObjects.enterCheckoutDetailsAndCheckout();
			baseMethods.switchToFrame(null);
			pageObjects.clickOnContinueButton();
			pageObjects.clickOnCreditCardLink();
			testResult &= pageObjects.enterSuccessCreditCardDetailsAndPayNow();
			pageObjects.verifySuccessTransactionMessage();

		} catch (Exception e) {
			testResult &= false;
			Reporter.log("An error occured during execution : " + e.getMessage());
		}
		if (testResult) {
			Reporter.log("validateSuccessCreditCardPayment method passed");
			Assert.assertTrue(testResult);
		} else {
			Reporter.log("validateSuccessCreditCardPayment method failed");
			Assert.fail();
		}

	}

	@AfterTest
	public void closeDriver() {
		Reporter.log("Close the application browser");
		baseMethods.tearDown();
	}


}
