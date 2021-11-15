package com.pages;

import org.openqa.selenium.WebDriver;

public class AppUserHomePage {

	
	private WebDriver driver;
	
	public AppUserHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAppUserHomePageTitle() {
		return driver.getTitle();
	}
	
}
