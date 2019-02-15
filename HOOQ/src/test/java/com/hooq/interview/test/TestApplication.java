package com.hooq.interview.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.hooq.interview.pageobjects.SignInPage;
import com.hooq.interview.utility.BaseClass;

public class TestApplication extends BaseClass {

	@Test(priority = 1)
	public void RegistrationOfUser() throws InterruptedException {

		hp.click_button_SignIn();
		signin.Enter_input_email();
		signin.click_button_Submit();
		newaccount.createAccountForNewUser();
	}

	@Test(dependsOnMethods = "RegistrationOfUser")
	public void LoginWithNewlyCreatedAccount() {
		signin.SignInExistingUser(SignInPage.enterEmailaddress, "Password");
	}

	@AfterMethod
	public void logoutSuccess() {
		myaccount.click_logout();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
