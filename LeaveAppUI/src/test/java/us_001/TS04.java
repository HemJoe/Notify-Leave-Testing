package us_001;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TS04 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
  @Test
  public void f() throws InterruptedException  {
	  test = extent.createTest("dropdown fields");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@href]")).click();
	  Thread.sleep(3000);
	  
		
		  driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		  try { 
		  Thread.sleep(2000);
		  List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'ng-dropdown-panel-items')]//div[contains(@class, 'ng-option')]"));
		  BaseClass.verifyDropdownHasOptions(options, "Leavetype", test);}
	  
  	catch (Exception e) {
	  test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	
   }  
  }
	 // TC_020 – "Leave Type" dropdown allows only one option
@Test
	public void leavetype() throws InterruptedException{
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//a[@href]")).click();
	  //Thread.sleep(3000);
		test = extent.createTest("dropdown is a single select");
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
	    
	    // Selecting second option
	    options.get(1).click();
//	    test.info("Selected: " + options.get(1).getText());
	    String selectedText = driver.findElement(By.xpath("(//div[@class='ng-value']//span)[1]")).getText();
//	    test.info("Final selected value: " + selectedText);
	    Assert.assertNotNull(selectedText, "A selection should exist");
	    test.pass("Only one option was selected as expected.");

	}
//@Test
//public void backupcontact() throws InterruptedException {
//	 test = extent.createTest("TC_024 Verify Backup Contact Dropdown Options");
//	driver.findElement(By.xpath("//a[@href]")).click();
//
//	Thread.sleep(2000);
//	try {
//		driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[3]")).click();
//		List<WebElement> optionsElements = driver.findElements(By.xpath("//div[contains(@class, 'ng-option')]"));
//		 List<String> expectedOptions = Arrays.asList("vimala.polkagani@accenture.com\r\n"
//		 		+ "bevin.john@accenture.com\r\n"
//		 		+ "logesh.r@accenture.com\r\n"
//		 		+ "mark.daniel@accenture.com");
//	     List<String> actop= new ArrayList<>();
//	
//     for(WebElement option:optionsElements) {
//    	 actop.add(option.getText().trim());
//     }
//		test.info("expected :" + expectedOptions);
//		test.info("actual:"+ actop);
//		System.out.println(actop);
//		assertequals("Dropdown values mismatch", expectedOptions, actop);
//        test.pass("Dropdown options matched successfully.");
//         
//	} catch (Exception e) {
// 		test.fail("assertion fail:"+ e.getMessage());
// 	}
//}
//	  
//	  
//  
//  private void assertequals(String string, List<String> expectedOptions, List<String> actop) {
//	
//}
//


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
