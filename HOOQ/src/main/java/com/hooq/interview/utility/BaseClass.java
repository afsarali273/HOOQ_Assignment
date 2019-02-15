package com.hooq.interview.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hooq.interview.pageobjects.CreateNewAccountPage;
import com.hooq.interview.pageobjects.HomePage;
import com.hooq.interview.pageobjects.MyAccountHomePage;
import com.hooq.interview.pageobjects.SignInPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	protected HomePage hp;
	protected SignInPage signin;
	protected CreateNewAccountPage newaccount;
	protected MyAccountHomePage myaccount;
	
	
	@BeforeTest
	public void init() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	hp=new HomePage(driver);
	signin=new SignInPage(driver);
	newaccount=new CreateNewAccountPage(driver);
	myaccount=new MyAccountHomePage(driver);
	
	driver.get("http://automationpractice.com/");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
