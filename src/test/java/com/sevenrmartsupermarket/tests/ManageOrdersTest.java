package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base {

	ManageOrdersPage manageOrdersPage;
	LoginPage loginPage;
	
	@Test
	public void verifyManageOrdersFunctionality() {
		loginPage = new LoginPage(driver);
		manageOrdersPage = new ManageOrdersPage(driver);
		loginPage.login();
		manageOrdersPage.clickOnManageOrders();
		String expectedResult = "List Orders(1)";
		manageOrdersPage.manageOrdersFunctionality("277");
		Assert.assertTrue(manageOrdersPage.getResultStatus(expectedResult),"Order ID missing");
		manageOrdersPage.clickOnResetButton();
		
	}
	
	@Test
	public void verifyDeletionStatus() {
		loginPage = new LoginPage(driver);
		manageOrdersPage = new ManageOrdersPage(driver);
		loginPage.login();
		manageOrdersPage.clickOnManageOrders();
		String expectedMessage = "Order Deleted Successfully";
		if (manageOrdersPage.getResultStatus("List Orders(1)")) {
			Assert.assertTrue(manageOrdersPage.getDeleteStatus("276", expectedMessage), "Order ID could not be deleted");
		}
		else
			Assert.assertFalse(false,"Order ID not found");
		
	}
}
