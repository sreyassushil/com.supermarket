package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;

public class PushNotificationTest extends Base{
	
	LoginPage loginPage;
	PushNotificationPage pushNotificationPage;
	
	@Test
	public void verifyPushNotificationPageDisplayed() {
		loginPage = new LoginPage(driver);
		pushNotificationPage = new PushNotificationPage(driver);
		loginPage.login();
		pushNotificationPage.clickOnPushNotification();
		pushNotificationPage.sendNotification("Manager", "Manager for this department");
	}

}
