package com.hooq.interview.pageobjects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hooq.interview.utility.Utils;

public class SignInPage {

	Utils util;
	public static String enterEmailaddress;
	public WebDriver driver;
	
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		util=new Utils(driver);
	}
/**
 * @author Afsar Ali
 * @code Login page objects
 */

	
	@FindBy(how=How.ID , using="email_create")
	private WebElement input_email;
	
	@FindBy(how=How.ID , using="SubmitCreate")
	private WebElement button_Submit;
	
	@FindBy(how=How.ID , using="email")
	private WebElement input_email_login;
	
	@FindBy(how=How.ID , using="passwd")
	private WebElement input_password;
	
	@FindBy(how=How.ID , using="SubmitLogin")
	private WebElement button_login;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"center_column\"]/div[1]/ol/li[contains(text(),'Authentication failed.')]")
	private WebElement text_authFailerrorMessage;
	
	
	
	
	public void waitForLoginPageTobeVisible() {
		
	}
	
	public void Enter_input_email() {
		enterEmailaddress=this.util.uniqueTextGenerate(15)+"@test.com";
		input_email.sendKeys(enterEmailaddress);
		System.out.println("Email address entered as : "+enterEmailaddress);
	}
	
	public void click_button_Submit() {
		
		button_Submit.click();
		System.out.println("Submit button clicked");
	}
	
	public void Enter_input_email_login(String enterEmailaddress) {
		
		input_email_login.sendKeys(enterEmailaddress);
		System.out.println("Email address entered as : "+enterEmailaddress);
	}
	
	public void click_button_login_existing() {
		
		button_login.click();
		System.out.println("Submit button clicked for existing account");
	}
	
	public void SignInExistingUser(String enteremail,String enterPasword) {
		Enter_input_email_login(enteremail);
		input_password.sendKeys(enterPasword);
		click_button_login_existing();
		 
	}
}
