package com.salesforce.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static WebDriver driver;//should be used in all the pages
	protected static WebDriverWait wait = null;


	public BasePage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public static String getTitleOfThePage() {
		return driver.getTitle();
	}
	public  void enterText(WebElement element,String text) {
		if(element.isDisplayed()) {
			element.sendKeys(text);
			System.out.println("Element entered");
		}
		else {
			System.out.println("Element not entered");
		}
	}
	public  void clearElement(WebElement element) {
		if(element.isDisplayed()) {
			element.clear();
			System.out.println("Element is cleared");
		}
		else {
			System.out.println("Element is not cleared");
		}
	}

	public  void clickElement(WebElement element) {
		if(element.isDisplayed()) {
			element.click();
			System.out.println("The element is clicked");
		}
		else {
			System.out.println("The element is not clicked");

		}
	}

	public  void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

	}

	public  void waitUntiVisible(WebElement element, String objName) {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  String getTextWebElement(WebElement element) {
		if(element.isDisplayed()) {
			element.getText();
		}
		else {
			System.out.println("Error text not displayed");
		}
		return null;
	}
}



