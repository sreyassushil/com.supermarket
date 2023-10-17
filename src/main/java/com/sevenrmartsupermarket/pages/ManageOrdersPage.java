package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOrdersPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//p[text()='Manage Orders']")
	private WebElement manageOrdersButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='od']")
	private WebElement orderIDField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement nextSearch;
	@FindBy(xpath = "//button[@name='Reset']")
	private WebElement resetButton;
	@FindBy(xpath = "//div[@class='card-header']//h4[contains(text(),'List Orders(')]")
	private WebElement searchResult;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[7]//a//i")
	private List<WebElement> deleteOrderButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteMessage;
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageOrders() {
		manageOrdersButton.click();
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void enterOrderIDSearchField(String orderID) {
		orderIDField.sendKeys(orderID);
	}

	public void clickOnSearchAfterEnteringValue() {
		nextSearch.click();
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}
	
	public boolean getDeleteStatus(String ID, String message) {
		manageOrdersFunctionality(ID);
		for (WebElement element: deleteOrderButton) {
			element.click();
			driver.switchTo().alert().accept();
		}
		if(deleteMessage.getText().contains(message)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean getResultStatus(String result) {
		if((searchResult.getText().equals(result))) {
			return true;
		}
		else
			return false;
	}
	
	public void manageOrdersFunctionality(String orderID) {
		clickOnSearchButton();
		enterOrderIDSearchField(orderID);
		clickOnSearchAfterEnteringValue();
		}
}
