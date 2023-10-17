package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	ExcelReader excelReader = new ExcelReader();

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyLoginFunctionality() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		loginPage.login();
		String actualProfileName = homePage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName, "Incorrect profile name");
	}
	
	@Test (groups = "SmokeTest")
	public void verifyInvalidLoginScenario() {
		loginPage = new LoginPage(driver);
		loginPage.login("Hello", "hello");
	}
	
	@Test (groups = {"SmokeTest","SanityTest"})
	public void verifyStaffLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		excelReader.setExcelFile("LoginData", "Staff Credentials");
		String userName = excelReader.getCellData(0, 0);
		String passWord = excelReader.getCellData(0, 1);
		loginPage.login(userName, passWord);
		String actualProfileName = homePage.getProfileName();
		String expectedProfileName = "Tim";
		Assert.assertEquals(actualProfileName, expectedProfileName, "Incorrect profile name");
	}
}
