package com.salesforce.steps;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.salesforce.pages.EmailPage;
import com.salesforce.pages.ForgotPage;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;
import com.salesforce.utility.PropertiesUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDefinitionSalesforce  {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ForgotPage forgot;
	EmailPage check;

	@Before
	public void setUp() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("Salesforce application is open")
	public void salesforce_application_is_open() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String url1 = properties.getPropertyValue("url");
		driver.get(url1);
	}

	@When("User is on {string}")
	public void user_is_on(String page) {
		switch(page.toLowerCase()) {
		case"loginpage":
			login=new LoginPage(driver);
			break;
		case"homepage":
			home = new HomePage(driver);
			break;
		case "forgotpage":
			forgot = new ForgotPage(driver);
			break;
		case "emailpage":
			check = new EmailPage(driver);
			break;
		default:
			System.out.println("Invalid page name :"+page);
		}
	}

	@When("User enters a valid username in the field")
	public void user_enters_the_username_in_the_field() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String username = properties.getPropertyValue("login.valid.userid");
		login.enterUserName(username);
		System.out.println("Username is entered");
	}

	@When("User enters a valid password in the field")
	public void user_enters_the_password_in_the_field() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String password = properties.getPropertyValue("login.valid.password");
		login.enterPassword(password);
		System.out.println("Password is entered");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		login.clickLogin();
		System.out.println("Login button clicked");

	}

	@Then("verify page title as {string}")
	public void verify_page_title_as(String expected) {
		String actual = home.getTitleOfHomePage();
		Assert.assertEquals(actual, expected);
		System.out.println("Page Title verified");
	}
	@When("User enters an invalid username in the field")
	public void user_enters_the_invalid_username_in_the_field() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String username = properties.getPropertyValue("login.invalid.userid");
		login.enterUserName(username);
		System.out.println("Invalid username entered");
	}

	@When("User enters an invalid password in the field")
	public void user_enters_an_invalid_password_in_the_field() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String password = properties.getPropertyValue("login.invalid.password");
		login.enterPassword(password);
		System.out.println("Password entered is invalid");
	}
	@Then("verify the Error message {string};")
	public void verify_the_error_message(String string) {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual = login.errorMsg(expected);
		Assert.assertEquals(actual, expected);
		System.out.println("Error message verified");
	}

	@When("User selects checkbox remember me")
	public void user_selects_checkbox_remember_me() {
		login.selectRemember();
		System.out.println("Remember me is checked");
		login.waitUntilPageLoads();
	}

	@When("User clicks on User name and clicks Logout")
	public void user_clicks_on_user_name_and_clicks_logout() throws IOException {
		home.user();
		System.out.println("Clicked the user");
		home.logoutbtn();
		System.out.println("Logged out of Salesforce");
	}

	@When("User clicks forgot password")
	public void user_clicks_forgot_password() {
		login.forgotPwd();
		System.out.println("Forgot password clicked");
		
	}

	@When("User enters email")
	public void user_enters_email() {
		PropertiesUtility properties = new PropertiesUtility();
		properties.loadFile("applicationData.Properties");
		String emailId = properties.getPropertyValue("gmail.id");
		forgot.enterEmail(emailId);
		System.out.println("Email id entered");
	}
	@Then("verify forgot page title as {string}")
	public void verify_forgot_page_title_as(String expected) {
		String actual = forgot.getTitleOfForgotPage();
		Assert.assertEquals(actual, expected);
		System.out.println("Page Title verified");
	}
	    
	
	@Then("verify check email page title as {string}")
	public void verify_check_email_page_title_as(String expected) {
		String actual = check.getTitleOfCheckEmailPage();
		Assert.assertEquals(actual, expected);
		System.out.println("Page Title verified");
	}
	

	@When("User clicks Continue")
	public void user_clicks_continue() {
		forgot.continueButton();
		System.out.println("Continue button clicked");
	}

}