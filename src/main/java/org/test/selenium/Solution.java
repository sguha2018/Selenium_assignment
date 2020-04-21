package org.test.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.selenium.util.Utility;

public class Solution {
	public static void main( String[] args ){
		
		WebDriver driver = Utility.setUpDriver("Chrome");
		
		//defining a wait property to be used while finding the elements
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		Utility.navigateTo(driver, "https://spec.atsspecsolutions.com/");
		try {
			//check if the page loaded properly
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h4[contains(text(),'Log In')]")));
		} catch (Exception e) {
			System.out.println("Log In Page Not Found");
		}
		createLogin(driver, wait);
		createNewProject(driver, wait);
		driver.quit();
		System.out.println("Test Case completed");
	}   

	/**
	 * 
	 * @param driver webdriver
	 * @param wait websriver wait
	 * 
	 * This function completes the login step for the user.
	 */
	public static void createLogin(WebDriver driver, WebDriverWait wait) {
		//get element and click and then verify the page load
		try {
			//check if the page loaded properly
			Utility.clickElement("//span[contains(text(),'LOG IN')]", wait);
			Utility.sendValueToElement("//input[contains(@name,'username')]", "dovini5510@one-mail.top", wait);
			Utility.sendValueToElement("//input[contains(@name,'password')]", "Ats123456", wait);
			Utility.clickElement("//button/span[contains(text(),'Login')]", wait);
			System.out.println("Log in successful");
			
		} catch (Exception e) {
			System.out.println("Element Not Found");
		}

	}
	
	
	/**
	 * 
	 * @param driver
	 * @param wait
	 * 
	 * This function manages the flow on the create project page by filling all the details in Step 1, 2 and 3.
	 */
	public static void createNewProject(WebDriver driver, WebDriverWait wait) {
		try {
			Utility.clickElement("//span[contains(text(),'New Project')]", wait);
			basicProjectDetails(driver, wait);
			buildingOptions(driver, wait);
			addCollaborators(driver, wait);
			System.out.println("New project created");
		} catch (Exception e) {
			System.out.println("Element Not Found" + e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @param driver
	 * @param wait
	 * 
	 * This function handles the fields in Step 1 of create project page
	 */
	public static void basicProjectDetails(WebDriver driver, WebDriverWait wait) {
		Utility.sendValueToElement("//div/label[contains(text(),'Internal No.')]/parent::div//input", "123", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'Project Name')]/..//input", "ATS_Assignment", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'Country')]/..//input", "Canada", wait);
		Utility.clickElement("//div/ul[@role='listbox']/li//span[contains(text(),'Canada')]", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'State')]/..//input", "Ontario", wait);
		Utility.clickElement("//div/ul[@role='listbox']/li//span[contains(text(),'Ontario')]", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'City')]/..//input", "Toronto", wait);
		Utility.clickElement("//div/ul[@role='listbox']/li//span[contains(text(),'Toronto')]", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'Address')]/..//textarea[1]", "320 Front St West", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'Date')]/..//input", "2020-02-02", wait);
		Utility.sendValueToElement("//div/label[contains(text(),'Area')]/..//input", "2000", wait);
		Utility.clickElement("//button/span[contains(text(),'Next')]", wait);
		System.out.println("Data entry for Step 1 complete.");
	}
	
	/**
	 * 
	 * @param driver
	 * @param wait
	 * 
	 * This function handles the fields in Step 2 of create project page
	 */
	public static void buildingOptions(WebDriver driver, WebDriverWait wait) {
		
		Utility.clickElement("//div/p[contains(text(),'Education')]", wait);
		Utility.clickElement("//div//span[contains(text(),'College')]", wait);
		Utility.clickElement("//button/span[contains(text(),'Next')]", wait);
		System.out.println("Data entry for Step 2 complete.");
			
	}
	
	/**
	 * 
	 * @param driver
	 * @param wait
	 * 
	 * This function handles the fields in Step 3 of create project page
	 */
	public static void addCollaborators(WebDriver driver, WebDriverWait wait) {
		Utility.clickCheckBox("//div/p[contains(text(),'123 Main Street')]/../following-sibling::div[position()=4]", wait);
		Utility.clickElement("//button/span[contains(text(),'Finish')]", wait);
		System.out.println("Data entry for Step 3 complete.");

	}
}
