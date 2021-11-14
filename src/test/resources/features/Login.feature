# Author: Paras Pardesi
@loginFunctionality


Feature: Verify Login feature functionality

#Background: User logged in to bainnonprod account
#Given user has already logged with bainnonprod account
#When  user is on appuser page
#Then  user gets the title of the page
#And   page title should be "My Apps Dashboard | Bain Non-Prod"
#
#Scenario: Verify user is on Data Warehouse Management login page
#Given user is on "common-qa-ui" page
#When  user gets the title of the page
#Then  page title should be "Data Warehouse Management"
#
#Scenario: Verify user logs in to Data Warehouse Management login page with Okta
#Given user is on "common-qa-ui" page
#When  user gets the title of the page
#Then  page title should be "Data Warehouse Management"
#When  user clicks on Sign in with AWS link
#And   user clicks on Okta under sign in with your corporate id
#When  user gets the title of the page
#Then  page title should be "Data Warehouse Management"


Scenario: Verify forgot your password link exists
Given user is on "common-qa-ui" page
When  user gets the title of the page
Then  page title should be "Data Warehouse Management"
When  user clicks on Sign in with AWS link
And   verify "Forgot your password" link exist


@incorrectUsername
Scenario: Verify gets error message with incorrect username
Given user is on "common-qa-ui" page
When  user gets the title of the page
Then  page title should be "Data Warehouse Management"
When  user clicks on Sign in with AWS link
And   user enters wrong username
And   user enters password
And   user clicks on Login button
Then  verify user gets "Incorrect username or password." error message


@incorrectPassword
Scenario: Verify gets error message with incorrect password
Given user is on "common-qa-ui" page
When  user gets the title of the page
Then  page title should be "Data Warehouse Management"
When  user clicks on Sign in with AWS link
And   user enters username
And   user enters wrong password
And   user clicks on Login button
Then  verify user gets "Incorrect username or password." error message


Scenario: Verify user logged in to Data Warehouse Management with correct credentials
Given user is on "common-qa-ui" page
When  user gets the title of the page
Then  page title should be "Data Warehouse Management"
When  user clicks on Sign in with AWS link
And   user enters username
And   user enters password
And   user clicks on Login button
Then  user gets the title of the page
Then  page title should be "Data Warehouse Management"

