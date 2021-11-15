@DWLandingPage

Feature: Verify DatawareHouseLandingPage Functionality

Background: User logged in to application
Given user has already logged in to DatawareHouse application


@DatawareHousePageTitle
Scenario: Verify DatawareHouse Landing page title
Given user is on DatawareHouseLanding page

@DatawareHousePageText
Scenario: Verify Heading on DatawareHouse Landing page
Given user is on DatawareHouseLanding page
When  user refreshes the page
Then  verify "Ello Gov'nor!" text on Page

@DatawareHousePageHeaderLinks
Scenario: Verify DatawareHouse Landing page header links
Given user is on DatawareHouseLanding page
When  user refreshes the page
Then  verify header links on homepage
|HOME|
|SOURCES|
|ROLES|
|ADD NEW FILE|
|TABLES|