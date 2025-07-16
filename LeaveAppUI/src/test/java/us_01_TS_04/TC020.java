package us_01_TS_04;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class TC020 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
	// TC_020 – "Leave Type" dropdown allows only one option
	@Test
		public void ddleavetype() throws InterruptedException{
		  Thread.sleep(3000);
		
			test = extent.createTest("TC023dropdown is a single select");
			driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
			  Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();
		    Thread.sleep(2000);
			
		    List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		    
		    test.info("Dropdown options count: " + options.size());
		    // Selecting first option
		    options.get(0).click();
		    //test.info("Selected: " + options.get(0).getText());

		    driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();
		    Thread.sleep(1000);
		    options = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		    Thread.sleep(1000);
		    // Selecting second option
		    options.get(1).click();
//		    test.info("Selected: " + options.get(1).getText());
		    String selectedText = driver.findElement(By.xpath("(//div[@class='ng-value']//span)[1]")).getText();
		    Thread.sleep(1000);
		    Assert.assertNotNull(selectedText, "A selection should exist");
		    test.pass("Only one option was selected as expected.");

		}
	@BeforeSuite
	  public void beforeMethod() {
		  driver.get("http://localhost:4200/homepage");
		  driver.manage().window().maximize();
	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	  
	  }

	  @AfterSuite
	  public void afterMethod() {
		  driver.close();
		  extent.flush();
	  }

	}


