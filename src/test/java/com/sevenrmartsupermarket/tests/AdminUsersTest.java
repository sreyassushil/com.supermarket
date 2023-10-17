package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.Screenshot;

public class AdminUsersTest extends Base{

	AdminUsersPage adminUsersPage;
	LoginPage loginPage;
	
	
	@Test(groups = "SanityTest")
	public void verifyNewAdminUser() {
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();
		adminUsersPage.clickOnAdminUsersButton();
		String expectedMessage = "User Created Successfully";
		adminUsersPage.addNewUser("Jane", "Jane123", "Admin", expectedMessage);
		Assert.assertTrue(adminUsersPage.checkStatusMessage(expectedMessage), "Username already exists");
	}
	
	@Test
	public void verifyDeactivateUser() {
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();
		adminUsersPage.clickOnAdminUsersButton();
		Assert.assertTrue(adminUsersPage.deactivateUser("Joy_110"),"User not deactivated properly");
	}
	
	@Test (dataProvider = "User login", dataProviderClass = Constants.class)
	public void verifyDeleteUser(String username, String password) {
		System.out.println(GeneralUtility.getRandomFullName());
		System.out.println(username);
		System.out.println(password);
	}
	

}
