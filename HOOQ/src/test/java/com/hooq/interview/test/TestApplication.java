package com.hooq.interview.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.hooq.interview.pageobjects.SignInPage;
import com.hooq.interview.utility.BaseClass;
import com.hooq.interview.utility.Utils;

public class TestApplication extends BaseClass {

	@Test(priority = 1)
	public void RegistrationOfUser() throws InterruptedException {

		hp.click_button_SignIn();
		signin.Enter_input_email();
		signin.click_button_Submit();
		newaccount.createAccountForNewUser();
		myaccount.click_logout();
	}

	@Test(priority=2,dependsOnMethods = "RegistrationOfUser",description="Sign In using valid credentials with newly created user")
	public void LoginWithNewlyCreatedAccount() {

		signin.SignInExistingUser(SignInPage.enterEmailaddress, "Password");
		AssertJUnit.assertTrue(driver.getTitle().contains("My account - My Store"));
		myaccount.click_logout();

	}

	@Test(priority=3,dependsOnMethods = "LoginWithNewlyCreatedAccount",description="Sign In with invalid credentials")
	public void loginWithInvalidCrfedentials() {

		signin.SignInExistingUser("invaliduser@test.com", "Password");
		AssertJUnit.assertFalse(driver.getTitle().contains("My account - My Store"));
	}

	@BeforeMethod
	public void screenshotsBeforeMethod() {
		Utils.takeScreenShots(driver);
	}


	@AfterMethod
	public void screenshotsAfterMethod() {
		Utils.takeScreenShots(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
