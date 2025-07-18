package us_001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TC15 extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void f() throws InterruptedException {
	  
	  test = extent.createTest("Help Text / Tooltips" ,"Verify label form Backup Contact and Notify To Recipient");
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	  WebElement element = driver.findElement(By.xpath("//label[text()='Brief Reason']"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  Thread.sleep(3000);
	  
	// TC_089 – Help text next to Backup Contacts field: “Acc Peer only. If none, add Supervisor”
	  try {
	      WebElement backupHelpText = driver.findElement(By.xpath("//label[contains(text(),'Backup Contact')]"));
	      String actualBackupHelpText = backupHelpText.getText().trim();
	      String expectedBackupHelpText = "*Backup Contact(s) (Acc Peer only. If none, add Supervisor)";
	      
	      test.info("Expected: " + expectedBackupHelpText);
	      test.info("actual:"+ actualBackupHelpText);
	      BaseClass.assertequals("Backup Contact help text mismatch", expectedBackupHelpText, actualBackupHelpText, test);
	      test.pass("Help text next to Backup Contact field matched successfully.");
	  } catch (Exception e) {
	      test.fail("Failed to locate or assert Backup Contact help text: " + e.getMessage());
	  }

	  
	  
	  // TC_090 – Help text next to Notify To Recipients field: “Must add- Acc Supervisor”
	  try {
	      WebElement notifyHelpText = driver.findElement(By.xpath("//label[contains(text(),'Notify To Recipient')]"));
	      String actualNotifyHelpText = notifyHelpText.getText().trim();
	      String expectedNotifyHelpText = "*Notify To Recipient(s) (Must add- Acc Supervisor)";
	      
	      test.info("Expected: " + expectedNotifyHelpText);
	      test.info("actual:"+ actualNotifyHelpText);
	      BaseClass.assertequals("Notify To Recipient help text mismatch", expectedNotifyHelpText, actualNotifyHelpText, test);
	      test.pass("Help text next to Notify To Recipient field matched successfully.");
	  } catch (Exception e) {
	      test.fail("Failed to locate or assert Notify To Recipient help text: " + e.getMessage());
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
