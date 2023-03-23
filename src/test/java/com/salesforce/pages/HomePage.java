package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	

	public HomePage(WebDriver driver1) {
		super(driver1);
	}
	
	@FindBy(xpath = "//*[@id=\"userNavLabel\"]") WebElement userbutton;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logoutbutton;
	
	public void user() {
		clickElement(userbutton);
	}
	
	public void logoutbtn() {
		clickElement(logoutbutton);
	}
	public String getTitleOfHomePage() {
		String title = getTitleOfThePage();
		System.out.println("Title of the page: "+title);
				return title;
		
		}
	}

