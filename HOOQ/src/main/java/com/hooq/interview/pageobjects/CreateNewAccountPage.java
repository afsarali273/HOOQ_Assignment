package com.hooq.interview.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hooq.interview.utility.Utils;

public class CreateNewAccountPage {
	
	public Utils util;
	WebDriver driver;
	
public CreateNewAccountPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		util=new Utils(driver);
	}
/**
 * @author Afsar Ali
 * @code Login page objects
 */

	
	@FindBy(how=How.ID , using="id_gender1")
	private WebElement radio_gender1;
	
	@FindBy(how=How.ID , using="customer_firstname")
	private WebElement input_FirstName;
	
	@FindBy(how=How.ID , using="customer_lastname")
	private WebElement input_LastName;
	
	@FindBy(how=How.ID , using="email")
	private WebElement input_email;
	
	@FindBy(how=How.ID , using="passwd")
	private WebElement input_Password;
	
	@FindBy(how=How.ID , using="days")
	private WebElement drpbx_Days;
	
	@FindBy(how=How.ID , using="months")
	private WebElement drpbx_Months;
	
	@FindBy(how=How.ID , using="years")
	private WebElement drpbx_Years;
	
	//=========================================
	//===========  Address ====================
	//=========================================
	
	@FindBy(how=How.ID , using="firstname")
	private WebElement input_FirstName_Address;
	
	@FindBy(how=How.ID , using="lastname")
	private WebElement input_LastName_Address;
	
	@FindBy(how=How.ID , using="company")
	private WebElement input_company_Address;
	
	@FindBy(how=How.ID , using="address1")
	private WebElement input_addressLine1_Address;
	
	@FindBy(how=How.ID , using="address2")
	private WebElement input_addressLine2_Address;
	
	@FindBy(how=How.ID , using="city")
	private WebElement input_city_Address;
	
	@FindBy(how=How.ID , using="id_state")
	private WebElement drpbx_State;
	
	@FindBy(how=How.ID , using="postcode")
	private WebElement input_postcode_Address;
	
	@FindBy(how=How.ID , using="id_country")
	private WebElement input_country_Address;
	
	@FindBy(how=How.ID , using="other")
	private WebElement input_additionalInfo_Address;
	
	@FindBy(how=How.ID , using="phone")
	private WebElement input_HomePhone_Address;
	
	@FindBy(how=How.ID , using="phone_mobile")
	private WebElement input_Mobile_Address;
	
	@FindBy(how=How.ID , using="alias")
	private WebElement input_alias_Address;
	
	@FindBy(how=How.ID , using="submitAccount")
	private WebElement button_Submit_CreateAcc;
	
	
	
	
	
	
	public void waitForLoginPageTobeVisible() {
		
	}
	
	public void createAccountForNewUser() throws InterruptedException {
		
		radio_gender1.click();
		input_FirstName.sendKeys("Afsar");
		input_LastName.sendKeys("Ali");
		if(input_email.getAttribute("value").length()>0) {  System.out.println("email already exists");}else {input_email.sendKeys(this.util.uniqueTextGenerate(15)+"@test.com");}
		input_Password.sendKeys("Password");
		this.select_DOB("12", "3","1992");
		//===== address part =======
		input_FirstName_Address.sendKeys("Afsar");
		input_LastName_Address.sendKeys("Ali");
		input_company_Address.sendKeys("HOOQ");
		input_addressLine1_Address.sendKeys("31, Exeter Road, Singapore.");
		input_addressLine2_Address.sendKeys("Singtel Building");
		input_city_Address.sendKeys("Clementi Singapore");
		this.util.select_dropdownboxByVisibleText(drpbx_State, "New York");
		input_postcode_Address.sendKeys("12345");
		input_additionalInfo_Address.sendKeys("This is a Test Description \n This is a Demo ");
		input_HomePhone_Address.sendKeys("+65 94657845");
		input_Mobile_Address.sendKeys("+65 9864567");
		input_alias_Address.sendKeys("afsarali273@gmail.com");
		button_Submit_CreateAcc.click();
		assertEquals(driver.getTitle().contentEquals("My account - My Store"),true);
				
	
	
 }
	/**
	 * @description This method will select Date of Birth from Dropdown box
	 * @param Day
	 * @param Month
	 * @param Year
	 * @author Afsar
	 */
	
	public void select_DOB(String Day,String Month , String Year) {
		this.util.select_dropdownboxByValue(this.drpbx_Days, Day);
		this.util.select_dropdownboxByValue(this.drpbx_Months, Month);
		this.util.select_dropdownboxByValue(this.drpbx_Years, Year);
		
		System.out.println("Date of Birth selected as : Date : "+Day +" Month : "+Month+" Year : "+Year);
	}
	
}
