package com.gojek.ui.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testInit {

	public static Properties getProp() {
		return prop;
	}

	private static Properties prop;
	private static WebDriver driver;

	public static WebDriver openBrowser() {
		String broserName= prop.getProperty("browser");
		if (broserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","\\src\\test\\resources\\drivers\\chromedriver.exe" );
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(broserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver","\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void loadProperties() {
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream("\\src\\test\\resources\\config.properties");
			prop.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		if(driver==null) {
			driver=openBrowser();
		}
		return driver;
	}

}
