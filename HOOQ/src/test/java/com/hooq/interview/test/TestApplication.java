package com.hooq.interview.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
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
		myaccount.click_logout();
		Assert.assertTrue(driver.getTitle().contains("My account - My Store"));
	}
	
	@Test(priority=3,dependsOnMethods = "LoginWithNewlyCreatedAccount",description="Sign In with invalid credentials")
	public void loginWithInvalidCrfedentials() {
		
		signin.SignInExistingUser("invaliduser@test.com", "Password");
		Assert.assertFalse(driver.getTitle().contains("My account - My Store"));
	}
	


	@AfterMethod
	public void logoutSuccess(ITestResult test) {
		Utils.takeScreenShots(driver, test);
	}

	@AfterTest
	public void teardown() {
		//driver.quit();
	}

}
