package com.gojek.ui.base.service;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.gojek.ui.utilities.testInit;

public class commonMethods {

	private  Properties prop;
	private   WebDriver driver;

	public commonMethods() {
		this.driver=testInit.getDriver();
		this.prop=testInit.getProp();

	}

	/**
	 *To launch the browser url

	 */
	public void launchApp() {

		driver.get(prop.getProperty("url"));
	}

	/**
	 *To click on the Webelement element
	 * @param element
	 */
	public void clickElement(WebElement element) {
		waitForElementToBeVisible(element);
		assertTrue("element is not dosplayed",element.isDisplayed() && element.isEnabled());
		element.click();

	}

	/**
	 *To click on the element using javascript
	 * @param element
	 */
	public  void javascriptClick(WebElement element)
	{
		waitForElementToBeVisible(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * wait for the element untill the element is visible
	 * @param element
	 */
	public  void waitForElementToBeVisible(WebElement element) {

		WebDriverWait wait =new WebDriverWait(driver,45);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Enter the values in the text field
	 * @param element
	 * @param text
	 */

	public boolean enterTextField(WebElement element ,String text) {
		boolean returnValue = false;
		waitForElementToBeVisible(element);
		returnValue=element.isDisplayed() && element.isEnabled();
		if(returnValue) {
			element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.TAB);
		}

		return returnValue;
	}

	/**
	 * Switch to a frame/iframe
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		waitForElementToBeVisible(element);
		driver.switchTo().frame(element);
	}

	/**
	 * To close the browser
	 */
	public void tearDown() {
		driver.quit();
	}

}
