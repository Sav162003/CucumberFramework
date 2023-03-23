package com.salesforce.pages;

import org.openqa.selenium.WebDriver;

public class EmailPage extends BasePage{
		

		public EmailPage(WebDriver driver2) {
			super(driver2);
		}
		public String getTitleOfCheckEmailPage() {
			String title = getTitleOfThePage();
			System.out.println("Title of the page: "+title);
					return title;
			
			}
		}



