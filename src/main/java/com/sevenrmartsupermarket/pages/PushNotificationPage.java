package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//p[text()='Push Notifications']")
	private WebElement pushNotificationButton;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleText;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement descriptionText;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPushNotification() {
		pushNotificationButton.click();
	}
	
	public void enterTitleText(String text) {
		titleText.sendKeys(text);
	}
	
	public void enterDescriptionText(String description) {
		descriptionText.sendKeys(description);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public void sendNotification(String title, String descriptionField) {
		enterTitleText(title);
		enterDescriptionText(descriptionField);
		clickOnSubmitButton();
	}
	

}
