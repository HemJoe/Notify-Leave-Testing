package us_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TS04 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
  @Test
  public void f() throws InterruptedException {
	  test = extent.createTest("dropdown fields");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@href]")).click();
	  Thread.sleep(3000);
	  try {
		
		  WebElement click=driver.findElement(By.xpath("//input[@type='text']"));
		  click.click();
		  Thread.sleep(2000);
		  List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'ng-dropdown-panel-items')]//div[contains(@class, 'ng-option')]"));
		  BaseClass.verifyDropdownHasOptions(options, "Leavetype", test);}
	  
   catch (Exception e) {
	   test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	
   }  
  }
	 

	  
	  
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://localhost:4200/homepage");
	  driver.manage().window().maximize();
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  extent.flush();
  }

}
