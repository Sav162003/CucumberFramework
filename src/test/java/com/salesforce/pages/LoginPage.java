package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{   

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="username")	WebElement username;
	@FindBy(id="password")	WebElement password;
	@FindBy(id="Login")	WebElement loginButton;
	@FindBy(xpath="//*[@id='rememberUn']")	WebElement rememberMe;
	@FindBy(id="forgot_password_link")	WebElement forgotpwd;
	@FindBy(id = "error") WebElement errormsg;	

	public void enterUserName(String userName) {
		enterText(username,userName);
	}
	public void enterPassword(String passWord) {
		enterText(password,passWord);
	}
	public WebDriver clickLogin() {
		clickElement(loginButton);
				return driver;
	}
	public void selectRemember() {
		waitUntiVisible(rememberMe, "remember");
		clickElement(rememberMe);
		
	}
	public void forgotPwd() {
		clickElement(forgotpwd);
	}
	public String errorMsg(String msg) {
		String actual = getTextWebElement(errormsg);
		System.out.println("Error msg: "+actual);
		return msg;
	}

}
