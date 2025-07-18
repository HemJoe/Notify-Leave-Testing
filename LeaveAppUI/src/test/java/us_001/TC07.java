package us_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TC07  extends BaseClass{
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() throws InterruptedException {
	  test = extent.createTest("Placeholder Text Verification", "Verify all placeholders on the form");
	    SoftAssert softAssert = new SoftAssert();
	  
	        Thread.sleep(1000); 
	        driver.findElement(By.xpath("//a[@href]")).click();
	        Thread.sleep(1000);   
  
	try {
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[1]")).getText(), "Select Leave Type","TC_051", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("//textarea[@id='briefReason']")).getText(), "Optional - Describe your leave in less than (or) equal to 100 characters","TC_052", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[3]")).getText(), "Select Backup Contact(s)","TC_053", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[4]")).getText(), "Select Recipient(s)","TC_054", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[5]")).getText(), "Select Base Location","TC_055", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[6]")).getText(), "Select Project","TC_056", test);
	  BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[7]")).getText(), "Select Team","TC_057", test);	  
	 // BaseClass.assertequals(driver.findElement(By.xpath("(//div[@class='ng-select-container'])[8]")).getText(), "Availed","TC_058", test);
      BaseClass.assertequals(driver.findElement(By.xpath("//textarea[@placeholder=\"Optional - Mention anything else that you'd like to add in less than (or) equal to 100 characters\"]")).getText(), "Optional - Mention anything else that you'd like to add in less than (or) equal to 100 characters","TC_059", test);

	  
	  
	  
	  softAssert.assertAll();}
	  
	  catch (Exception e) {
		  test.log(Status.FAIL,"mesage"+e.getMessage());
	  }
	    }
	  
	   
  
  @BeforeMethod
  public void beforeMethod() {
	  url("http://localhost:4200/homepage");
	  maximize();
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
  }

  @AfterMethod
  public void afterMethod() {
	  close();
	  extent.flush();
	  
  }
}
