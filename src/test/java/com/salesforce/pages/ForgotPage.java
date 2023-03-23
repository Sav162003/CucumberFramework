package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPage extends BasePage{


	public ForgotPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="un")	WebElement forgotuser;
	@FindBy(xpath="//div[@id='error']")	WebElement loginErrorMsg;
	@FindBy(id="continue")	WebElement continuebutton;


	public void enterEmail(String eMail) {
		clickElement(forgotuser);
		enterText(forgotuser,eMail);
	}

	public void continueButton() {
		clickElement(continuebutton);
	}
	public String getTitleOfForgotPage() {
		String title = getTitleOfThePage();
		System.out.println("Title of the page: "+title);
		return title;

	}
}



