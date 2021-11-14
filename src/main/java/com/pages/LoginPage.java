package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.utils.ConfigReader;
import com.qa.utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;

	/*
	 * 1. Private by locators
	 */

//	private By emaidId = By.id("okta-signin-username");
//	private By password = By.id("okta-signin-password");
//	private By loginBtn = By.id("okta-signin-submit");
	private By emaidId = By.xpath("(//input[@id='signInFormUsername'])[2]");
	private By password = By.xpath("(//input[@id='signInFormPassword'])[2]");
	private By loginBtn = By.xpath("(//input[@name='signInSubmitButton'])[2]");
	private By signInoptions = By.xpath("//a[contains(text(),'Sign in options')]");
	private By signInWithBainLink = By.xpath("//ul[@id='help-links-container']//a[contains(text(),'baincapital.com')]");
	private By signInWithAWS = By.xpath("//span[contains(text(),'Sign in with AWS')]/parent::button");
	private By okta = By.xpath("(//input[@class='btn btn-info idpButton-customizable'])[2]");
	private By forgotLink = By.xpath("(//a[contains(text(),'Forgot your password')])[2]");
	private By errorMessage = By.xpath("(//p[@id='loginErrorMessage'])[2]");

	/*
	 * 2. Constructor of the page class
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions:
	/*
	 * should be public in nature We will not write assertions in page class, it
	 * will be in step def or test class
	 */

	public String getLoginPageTitle() {
		ElementUtils.waitForPageToLoad(driver);
		return driver.getTitle();
	}

	public void enterUserName() {
		ElementUtils.waitForElementToBeLocated(driver, emaidId, 30);
		ElementUtils.sendKeys(driver, emaidId, ConfigReader.getProperty("username"));
	}

	public void enterWrongUserName() {
		ElementUtils.waitForElementToBeLocated(driver, emaidId, 30);
		ElementUtils.sendKeys(driver, emaidId, ConfigReader.getProperty("wrong_username"));
	}

	public void enterPassword() {
		ElementUtils.waitForElementToBeLocated(driver, emaidId, 30);
		ElementUtils.sendKeys(driver, password, ConfigReader.getProperty("password"));
	}
	
	public void enterWrongPassword() {
		ElementUtils.waitForElementToBeLocated(driver, emaidId, 30);
		ElementUtils.sendKeys(driver, password, ConfigReader.getProperty("wrong_password"));
	}

	public void clickLoginBtn() {
		ElementUtils.clickElement(driver, loginBtn);
	}

	public void clickSignInOptions() {
		ElementUtils.waitForElementToBeLocated(driver, signInoptions, 20);
		ElementUtils.clickElement(driver, signInoptions);
	}

	public void clickSignInWithBainCapital() {
		ElementUtils.waitForElementToBeVisible(driver, signInWithBainLink, 20);
		if (ElementUtils.elementIsDisplayed(driver, signInWithBainLink)) {
			ElementUtils.clickAnElementByJavaScriptExecutor(driver, signInWithBainLink);
		}
	}

	public void clickOnSignInWithAWS() {
		ElementUtils.waitForElementToBeLocated(driver, signInWithAWS, 20);
		ElementUtils.clickElement(driver, signInWithAWS);
	}

	public void clickOnSignInWithOkta() {
		ElementUtils.waitForElementToBeLocated(driver, okta, 20);
		ElementUtils.clickElement(driver, okta);
	}

	public boolean verifyForgotPasswordLink(String text) {
		boolean flag = false;
		ElementUtils.waitForElementToBeDisplayed(driver, forgotLink, 30);
		String actualText = ElementUtils.getText(driver, forgotLink);
		if (actualText.contains(text)) {
			flag = true;
		}
		return flag;
	}

	public DatawareHouseLandingPage doLogin() {
		clickOnSignInWithAWS();
		enterUserName();
		enterPassword();
		clickLoginBtn();
//		clickSignInOptions();
//		clickSignInWithBainCapital();
		return new DatawareHouseLandingPage(driver);

	}

	public AppUserHomePage doLoginBainNonProd() {

		enterUserName();
		enterPassword();
		clickLoginBtn();
//		clickSignInOptions();
//		clickSignInWithBainCapital();
		return new AppUserHomePage(driver);

	}

	public boolean verifyloginPageErrorMessage(String error) {
		boolean flag = false;
		ElementUtils.waitForElementToBeDisplayed(driver, errorMessage, 30);
		String actualText = ElementUtils.getText(driver, errorMessage);
		if (actualText.equalsIgnoreCase(error)) {
			flag = true;
		}
		return flag;

	}

}
