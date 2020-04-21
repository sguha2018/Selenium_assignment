package org.test.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	/**
	 * 
	 * @param xpath
	 * @param wait
	 * 
	 * Utility method to click on checkbox
	 */
	public static void clickCheckBox(String xpath, WebDriverWait wait) {
		WebElement element = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(xpath)));
		element.findElement(By.xpath("//input")).click();
	}
	
	/**
	 * 
	 * @param xpath
	 * @param wait
	 * 
	 * Utility method to click on an element
	 */
	public static void clickElement(String xpath, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
		System.out.println("Clicked on element: " + xpath);
	}
	
	/**
	 * 
	 * @param xpath
	 * @param wait
	 * 
	 * Utility method to enter a value in the given element
	 */
	public static void sendValueToElement(String xpath, String value, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(value);
		System.out.println("Entered value: " + value);
	}
	
	/**
	 * 
	 * @param driver
	 * @param url
	 * 
	 * Used to navigate to a particular URL provided by user
	 */
	public static void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);
		System.out.println("Navigated to URL: " + url);
	}
	
	/**
	 * 
	 * @param type string to represent the browser driver needed. ex:  Chrome, Firefox. Default is Chrome driver
	 * @return
	 * 
	 * Utility method to return the correct Webdriver based on the argument user sends.
	 */
	public static WebDriver setUpDriver(String type) {
		System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");
		WebDriver driver = null;
		//setting the maximize property to open the chrome browser and maximize
		if(type.equals("Chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
			System.out.println("Setup complete for Chrome driver.");
		}
		return driver == null ? new ChromeDriver() : driver;
	}
}
