Feature: Login functionality

  Background: 
    Given Salesforce application is open
@test1
  Scenario: Login with valid user name and password
    When User is on "LoginPage"
    When User enters a valid username in the field 
    When User enters a valid password in the field 
    And User clicks on the login button
    When User is on "Homepage"
    Then verify page title as "Home Page ~ Salesforce - Developer Edition"
@test2
  Scenario: Login with Invalid user name and invalid password
    When User is on "LoginPage"
    When User enters an invalid username in the field 
    When User enters an invalid password in the field 
    And User clicks on the login button
    When User is on "LoginPage"
    Then verify the Error message "Please check you username and password.If you still can't log in,contact your Salesforce adminstrator.";
@test3
  Scenario: Login and select Remember me
    When User is on "LoginPage"
    When User enters a valid username in the field 
    When User enters a valid password in the field 
    When User selects checkbox remember me
    And User clicks on the login button
    When User is on "HomePage"
    Then verify page title as "Home Page ~ Salesforce - Developer Edition"
    When User clicks on User name and clicks Logout
    
@test4
      Scenario: Login with Forgot Password
    When User is on "LoginPage"
    When User enters a valid username in the field 
    When User clicks forgot password
    When User is on "ForgotPage"
    Then verify forgot page title as "Forgot Your Password | Salesforce"
    When User enters email 
    When User clicks Continue
    When User is on "EmailPage"
    Then verify check email page title as "Check Your Email | Salesforce"
@test5
  Scenario: Login with invalid user name and password
    When User is on "LoginPage"
    When User enters an invalid username in the field 
    When User enters a valid password in the field 
    And User clicks on the login button
    When User is on "LoginPage"
   Then verify the Error message "Please check you username and password.If you still can't log in,contact your Salesforce adminstrator.";  
    
