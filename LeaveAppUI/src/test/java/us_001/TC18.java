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

public class TC18 extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() {
	  
	  test = extent.createTest("Error Message Validations" ,"Error message ie displayed");
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
 try {
		  
		  WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  implicitlyWait(5);
		  
		  WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		  jsClick(submit);
		  
		  implicitlyWait(3);
		  
		  WebElement element1 = driver.findElement(By.xpath("//div[@role='alert']"));
		  Thread.sleep(3000); 
		  element1.getText();
		  
	        
	        test.info("Expected: " +  "Error!Please fill in all required fields before submitting the form.");
	        test.info("Actual: " + element1.getText());
	        System.out.println(element1.getText());
	        test.pass(" Error message ie displayed");
	        

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
