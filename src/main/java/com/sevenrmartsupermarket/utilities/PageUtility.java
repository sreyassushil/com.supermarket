package com.sevenrmartsupermarket.utilities;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void _selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void _selectByVisibleText(WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(element.getText());
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void jsScrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void elementRightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void elementDoubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	public void acceptAlert(WebElement element) {
		element.click();
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebElement element) {
		element.click();
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindows(WebElement element) {
		element.click();
		Set<String> windowIDs = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for (String s : windowIDs) {
			if(!s.equals(parentWindow)) {
				driver.switchTo().window(s);
			}
		}
	}
	
	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y+=5;
		}
		
	}
	
	public boolean isClicked (WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
