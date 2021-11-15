package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.ElementUtils;

public class DatawareHouseLandingPage {

	private WebDriver driver;

	private By heading = By.xpath("//h1[contains(text(),'Ello')]");
	private By headerLinks = By.cssSelector(".nav-link");

	public DatawareHouseLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getDatawareHouseHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyText(String text) {
		boolean flag = false;
		ElementUtils.waitForElementToBeDisplayed(driver, heading, 30);
		if (ElementUtils.getText(driver, heading).equalsIgnoreCase(text)) {
			flag = true;
		}
		return flag;
	}

	public void refreshesPage() {
//		ElementUtils.waitForPageToLoad(driver);
//		ElementUtils.setScriptTimeout(driver, 20);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ElementUtils.refreshPage(driver);
	}

	public boolean verifyHomePageLinks(List<String> homepageLinks) {
		boolean flag = false;
		ElementUtils.waitForElementToBeDisplayed(driver, headerLinks, 30);
		List<WebElement> headers = driver.findElements(headerLinks);
		List<String> headerValues = new ArrayList<String>();

		for (WebElement header : headers) {
			headerValues.add(header.getText());
		}
		if (headerValues.containsAll(homepageLinks)) {
			flag = true;
		}
		return flag;
	}
}
