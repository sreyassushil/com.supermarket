package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtility generalUtility;
	WaitUtility waitUtility;
	PageUtility pageUtility;
	
	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminUsersButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameText;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordText;
	@FindBy(xpath = "//select[@id='user_type']//option")
	List<WebElement> userTypeSelect;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> usernamesList;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement statusMessage;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminUsersButton() {
		adminUsersButton.click();
	}
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterUsernameField(String username) {
		usernameText.sendKeys(username);
	}
	
	public void enterPasswordField(String password) {
		passwordText.sendKeys(password);
	}
	
	public void selectUserType(String userType) {
		generalUtility = new GeneralUtility();
		List<String> variousUserTypes = generalUtility.getTextOfElements(userTypeSelect);
		for(int i=1; i < userTypeSelect.size(); i++) {
			if(userType.equals(variousUserTypes.get(i))) {
				userTypeSelect.get(i).click();
				break;
			}
		}
		
	}
	
	public void clickOnSaveButton() {
		waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementToBeClickable(saveButton, 10L);
		saveButton.click();
	}
	
	public boolean deactivateUser(String personName) {
		int index = 0;
		generalUtility = new GeneralUtility();
		pageUtility = new PageUtility(driver);
		List<String> names = generalUtility.getTextOfElements(usernamesList);
		for (String name : names) {
			if(personName.equals(name)) {
				index++;
				break;
			}
			index++;
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[5]//a[1]"));
		pageUtility.scrollAndClick(deactivateButton);
		WebElement status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[3]//span"));
		if (status.getText().equals("Inactive")) {
			return true;
		} else
			return false;
	}
	
	public boolean checkStatusMessage(String message) {
		if (statusMessage.getText().contains(message)){
			return true;
		} else
			return false;
	}
	
	public void addNewUser(String username, String password, String userType, String message) {
		clickOnNewButton();
		enterUsernameField(username);
		enterPasswordField(password);
		selectUserType(userType);
		clickOnSaveButton();
		checkStatusMessage(message);
	}

}
