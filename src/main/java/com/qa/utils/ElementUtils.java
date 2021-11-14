package com.qa.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 ** This class is created for selenium interactions 
 ** like click, sendKeys, waits, actions
*/

public class ElementUtils {

	public static void clickElement(WebDriver driver, By ele) {
		driver.findElement(ele).click();
	}

	public static void sendKeys(WebDriver driver, By ele, String input) {
		driver.findElement(ele).sendKeys(input);
	}

	/* Below method purpose is to wait for a page to load */
	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(pageLoadCondition);
	}

	/*
	 * Below method purpose is to click an element where an element is getting Stale
	 * Exception
	 */
	public static boolean retryingFindClick(WebDriver driver, By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	/* Below method purpose is to click an element by Actions Class */
	public static void clickAnElementByActionClass(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public static void doubleClickAnElementByActionClass(WebDriver driver, WebElement ele, String content) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).doubleClick().sendKeys(content).build().perform();
	}

	public static void waitForElementToBeLocated(WebDriver driver, By locator, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void implicitWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static boolean elementIsDisplayed(WebDriver driver, By element) {
		boolean flag = false;

		if (driver.findElement(element).isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public static void waitForElementToBeDisplayed(WebDriver driver, By locator, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void clickAnElementByJavaScriptExecutor(WebDriver driver, By element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(element));
	}

	public static void clickAnElementByJavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}

	public static void waitForElementToBeVisible(WebDriver driver, WebElement ele, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
	}

	public static void waitForElementToBeVisible(WebDriver driver, By ele, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ele)));
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
	}

	public static String getText(WebDriver driver, By ele) {
		return driver.findElement(ele).getText();
	}

	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public static void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);;
	}

	public static void setScriptTimeout(WebDriver driver, long time) {
		driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
	}

}
