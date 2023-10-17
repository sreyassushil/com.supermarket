package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {

	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream is;
	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userName; //Encapsulation example declaring web elements as private, right now these elements can be called by this same class only
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			is = new FileInputStream(Constants.CONFIG_FILE_PATH); // For initializing the file
			properties.load(is); // For reading the file path mentioned
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public void login() {
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}

}
