package com.hooq.interview.utility;
import static java.lang.Math.round;
import static java.lang.Math.random;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static org.apache.commons.lang.StringUtils.leftPad;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utils {
	
	public  WebDriver driver;
	
	public Utils(WebDriver driver) {
		this.driver=driver;
	}

	public void select_dropdownboxByValue(WebElement ele,String enterValue) {
		Select se=new Select(ele);
		se.selectByValue(enterValue);
	}
	
	public  void select_dropdownboxByVisibleText(WebElement ele,String visibleText) {
		Select se=new Select(ele);
		se.selectByVisibleText(visibleText);
	}
	
	public  String uniqueTextGenerate(int lenthofString) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = lenthofString; i > 0; i -= 12) {
	      int n = min(12, abs(i));
	      sb.append(leftPad(Long.toString(round(random() * pow(36, n)), 36), n, '0'));
	    }
	    return sb.toString();
	  }
	
	public static void takeScreenShots(WebDriver driver) {
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Date d=new Date();
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/ScreenShots/"+d.toString()+".png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
