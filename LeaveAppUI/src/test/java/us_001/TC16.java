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

public class TC16 extends BaseClass{
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() {
	  
	  test = extent.createTest("Keyword-Based Dropdown Search" ,"Field Suggestions in every field");
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	  
	  //leave type
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("Sick Leave");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Sick Leave");
		     List<String> actualOptions= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions);
//	        System.out.println(actualOptions);
	        BaseClass.assertequals(" Leave Type", expectedOptions, actualOptions, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	//Availed By
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("hema");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "hemajothi.kumar@accenture.com");
		     List<String> actualOptions1= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions1.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions1);
	        System.out.println(actualOptions1);
	        BaseClass.assertequals(" Availed By", expectedOptions, actualOptions1, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  // scroll down
	  WebElement element = driver.findElement(By.xpath("//label[text()='Brief Reason']"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  implicitlyWait(5);
	  
	  
	  //Backup Contact
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("hema");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "hemajothi.kumar@accenture.com");
		     List<String> actualOptions2= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions2.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions2);
	        System.out.println(actualOptions2);
	        BaseClass.assertequals(" Backup contact", expectedOptions, actualOptions2, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  //Notify to contact
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("hema");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "hemajothi.kumar@accenture.com");
		     List<String> actualOptions3= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions3.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions3);
	        System.out.println(actualOptions3);
	        BaseClass.assertequals(" notify to contactt", expectedOptions, actualOptions3, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  //Base Location
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("Chennai");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Chennai");
		     List<String> actualOptions4= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions4.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions4);
	        System.out.println(actualOptions4);
	        BaseClass.assertequals(" Base Location", expectedOptions, actualOptions4, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  //Project
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("Yet to Onboard");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Yet to Onboard");
		     List<String> actualOptions5= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions5.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions5);
	        System.out.println(actualOptions5);
	        BaseClass.assertequals("Project", expectedOptions, actualOptions5, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  //team
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("Yet to Onboard");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Yet to Onboard");
		     List<String> actualOptions6= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions6.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions6);
	        System.out.println(actualOptions6);
	        BaseClass.assertequals("Team", expectedOptions, actualOptions6, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
	    }
	  
	  
	  //Leave Status
	  try {
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		  Thread.sleep(3000); 
		  element1.sendKeys("Availed");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Availed");
		     List<String> actualOptions7= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions7.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions7);
	        System.out.println(actualOptions7);
	        BaseClass.assertequals("Leave Status", expectedOptions, actualOptions7, test);
	        test.pass(" keyword-based dropdown search works as expected.");
	        

	    } catch (Exception e) {
	        test.fail(" failed due to exception: " + e.getMessage());
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
