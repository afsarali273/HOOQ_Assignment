package com.hooq.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountHomePage {


	public MyAccountHomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
/**
 * @author Afsar Ali
 * @code Login page objects
 */

	
	@FindBy(how=How.CSS , using="a.logout")
	private WebElement button_logout;
	
	
	public void click_logout() {
	button_logout.click();
	System.out.println("Logout button clicked successfully");
	}
	
}
