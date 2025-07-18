package us_001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

import com.aventstack.extentreports.ExtentReports;

public class TS13 extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
	
  @Test
  public void f() {
	  test = extent.createTest("Field Suggestions", "Field Suggestions in Backup Contact(s) and Notify To Recipient(s)");
	  SoftAssert softAssert = new SoftAssert();
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	 
	  //TC85
		try {
			WebElement element = driver.findElement(By.xpath("//label[text()='Brief Reason']"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			  Thread.sleep(3000);  
			  driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("hema");
			 List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "hemajothi.kumar@accenture.com");
		     List<String> actop= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actop.add(option.getText().trim());
	     }
			test.info("expected :" + expectedOptions);
			test.info("actual:"+ actop);
			System.out.println(actop);
			BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop,test);
	        test.pass("Dropdown options matched successfully");
	         
		} catch (Exception e) {
	 		test.fail("assertion fail:"+ e.getMessage());
	 	}
		implicitlyWait(3);
	  
	   //TC86
  
		try {
			WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			  Thread.sleep(3000); 
			  element1.sendKeys("hema");
			List<WebElement> optionsElements1 = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions1 = Arrays.asList(
					 "hemajothi.kumar@accenture.com");
		     List<String> actop1= new ArrayList<>();
		
	     for(WebElement option1:optionsElements1) {
	    	 actop1.add(option1.getText().trim());
	     }
			test.info("expected :" + expectedOptions1);
			test.info("actual:"+ actop1);
			System.out.println(actop1);
			BaseClass.assertequals("Dropdown values mismatch", expectedOptions1, actop1,test);
	        test.pass("Dropdown options matched successfully");
	         
		} catch (Exception e) {
	 		test.fail("assertion fail:"+ e.getMessage());
	 	}

	 
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  url("http://localhost:4200/homepage");
	  maximize();
	  extent= new ExtentReports();
	  extent.attachReporter(htmlReporter);
  }

  @AfterMethod
  public void afterMethod() {
	  extent.flush();
//	  close();

	  
  }
}



