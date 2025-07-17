package us_001;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TS14 extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() {
	  
	  test = extent.createTest("Calendar Selection UI" ,"Selected date is highlighted in the calendar and Unselected dates are not highlighted");
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	  
	  //TC87 - StartDate
	  WebElement dateToSelect = driver.findElement(By.id("start-date-icon"));
	  jsClick(dateToSelect);

	  implicitlyWait(3); 


	  
	  String classAttr = dateToSelect.getAttribute("class");
	  
	  
	  if (classAttr.contains("selected") || classAttr.contains("highlighted")) {
		  
		  String expectedOptions = "PASS - Selected date is highlighted";
		  String actop = "PASS - Selected date is highlighted";
		  test.info("expected :" + expectedOptions);
			test.info("actual:"+ actop);
			System.out.println(actop);
			BaseClass.assertequals("date is highlighted", expectedOptions, actop,test);
	        test.pass("Selected date is highlighted in the calendar");
	         
	      System.out.println("PASS - Selected date is highlighted.");
	  } else {
		  
		  String expectedOptions = "FAIL - Selected date is NOT highlighted.";
		  String actop = "FAIL - Selected date is NOT highlighted.";
		  test.info("expected :" + expectedOptions);
			test.info("actual:"+ actop);
			System.out.println(actop);
			BaseClass.assertequals("date is not highlighted", expectedOptions, actop,test);
	        test.pass("Selected date is not highlighted in the calendar");
	      System.out.println("FAIL - Selected date is NOT highlighted.");
	  }
	  
	  
	  
	  
	//TC87 - EndDate
	  WebElement dateToSelect1 = driver.findElement(By.id("end-date-icon"));
	  jsClick(dateToSelect1);

	  implicitlyWait(3); 


	  
	  String classAttr1 = dateToSelect1.getAttribute("class");

	  if (classAttr1.contains("selected") || classAttr1.contains("highlighted")) {
		  
		  String expectedOptions = "PASS - Selected date is highlighted";
		  String actop = "PASS - Selected date is highlighted";
		  test.info("expected :" + expectedOptions);
			test.info("actual:"+ actop);
			System.out.println(actop);
			BaseClass.assertequals("date is highlighted", expectedOptions, actop,test);
	        test.pass("Selected date is highlighted in the calendar"); 
	      System.out.println("PASS - Selected date is highlighted.");
	  } else {
		  
		  String expectedOptions = "FAIL - Selected date is NOT highlighted.";
		  String actop = "FAIL - Selected date is NOT highlighted.";
		  test.info("expected :" + expectedOptions);
			test.info("actual:"+ actop);
			System.out.println(actop);
			BaseClass.assertequals("date is not highlighted", expectedOptions, actop,test);
	        test.pass("Selected date is not highlighted in the calendar");
	      System.out.println("FAIL - Selected date is NOT highlighted.");
	  }
	  

	  
	//TC88 - StartDate
	  List<WebElement> allDates = driver.findElements(By.id("start-date-icon"));

	  // Loop through all dates
	  for (WebElement date : allDates) {
	      String classAttr2 = date.getAttribute("class");
	      
	      // Skip the selected one
	      if (classAttr2.contains("selected") || classAttr2.contains("highlighted")) {
	    	  
	          continue;
	      }

	      // Check if wrongly highlighted
	      if (classAttr2.contains("highlighted")) {
	    	  
	    	  String expectedOptions = "FAIL - Unselected date is incorrectly highlighted";
			  String actop = "FAIL - Unselected date is incorrectly highlighted";
			  test.info("expected :" + expectedOptions);
				test.info("actual:"+ actop);
				System.out.println(actop);
				BaseClass.assertequals("date is not highlighted", expectedOptions, actop,test);
		        test.pass("FAIL - Unselected date is incorrectly highlighted");
	          System.out.println("FAIL - Unselected date is incorrectly highlighted: " + date.getText());
	      }
	  }

	  System.out.println("PASS - All unselected dates are not highlighted.");
	  
	  
	  
	//TC88 - StartDate
	  List<WebElement> allDates1 = driver.findElements(By.id("end-date-icon"));

	  // Loop through all dates
	  for (WebElement date : allDates1) {
	      String classAttr3 = date.getAttribute("class");
	      
	      // Skip the selected one
	      if (classAttr3.contains("selected") || classAttr3.contains("highlighted")) {
	          continue;
	      }

	      // Check if wrongly highlighted
	      if (classAttr3.contains("highlighted")) {
	    	  
	    	  String expectedOptions = "FAIL - Selected date is NOT highlighted.";
			  String actop = "FAIL - Selected date is NOT highlighted.";
			  test.info("expected :" + expectedOptions);
				test.info("actual:"+ actop);
				System.out.println(actop);
				BaseClass.assertequals("date is not highlighted", expectedOptions, actop,test);
		        test.pass("Selected date is not highlighted in the calendar");
	          System.out.println("FAIL - Unselected date is incorrectly highlighted: " + date.getText());
	      }
	  }

	  System.out.println("PASS - All unselected dates are not highlighted.");
	  
	  
	  
	  
	  

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
