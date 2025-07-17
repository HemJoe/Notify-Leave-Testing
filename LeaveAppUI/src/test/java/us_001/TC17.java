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

public class TC17 extends BaseClass{
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() {
	  
	  test = extent.createTest("Keyword-Based Dropdown Search" ,"Field Suggestions in every field");
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	  
	  try {
		  
		  WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  implicitlyWait(5);
		  
		  WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		  Thread.sleep(3000); 
//		  element1.sendKeys("Availed");
		  
	        
	        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
			 List<String> expectedOptions = Arrays.asList(
					 "Availed");
		     List<String> actualOptions7= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actualOptions7.add(option.getText().trim());
	     }
	        test.info("Expected: " + expectedOptions);
	        test.info("Actual: " + actualOptions7 +"Availed");
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
//		  close();

	  }	  
	  
}
