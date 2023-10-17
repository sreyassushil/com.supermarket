package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriver driver;
	WebDriverWait wait;

	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToBeClickable(WebElement element, long maxTimeToWait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeToWait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(String xpath, long maxTimeToWait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForElementToBeVisible(By locator, long maxTimeToWait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
