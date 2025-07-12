package us_001;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TS01 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
  @Test
  public void f() throws InterruptedException {
	  test = extent.createTest("Field Presence and UI Verification", "Verify all labels on the form");
	 
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@href]")).click();
	  Thread.sleep(5000);
	  //TC_001
	  try {
	  String tc001 = driver.findElement(By.xpath("//label[@for='leaveType']")).getText();
	  Assert.assertEquals(tc001, "*Leave Type");}
	  	  catch (Exception e) {
		  test.log(Status.FAIL, "TC001: " + e.getMessage());
		  }
	  //TC_002
	  try {
	  String tc002=driver.findElement(By.xpath("//label[@for='availedBy']")).getText();
	  Assert.assertEquals(tc002,"*Availed By" );}
	  catch (Exception e) {
		test.log(Status.FAIL, "TC002: " + e.getMessage());
	  }
	  //TC_003
	  try {
	  String tc003=driver.findElement(By.xpath("//label[@for='startDate']")).getText();
	  Assert.assertEquals(tc003,"*Start Date");}
	  catch (Exception e) {
			test.log(Status.FAIL, "TC003: " + e.getMessage());

	}
	  //TC_004
	  try {
	  String tc004=driver.findElement(By.xpath("//label[@for='endDate']")).getText();
	  Assert.assertEquals(tc004,"*End Date");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC004: " + e.getMessage());	}

	  //TC_005
	  try {
	  String tc005=driver.findElement(By.xpath("//label[@for='briefReason']")).getText();
	  Assert.assertEquals(tc005,"Brief Reason");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC005: " + e.getMessage());
	}
	  //TC_006
	  try {
	  String tc006=driver.findElement(By.xpath("//label[@for='backupContact']")).getText();
	  Assert.assertEquals(tc006,"*Backup Contact(s) (Acc Peer only. If none, add Supervisor)" );}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC006: " + e.getMessage());
	}
	  //TC_007
	  try {
	  String tc007=driver.findElement(By.xpath("//label[@for='notifyTo']")).getText();
	  Assert.assertEquals(tc007,"*Notify To Recipient(s) (Must add- Acc Supervisor)");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC007: " + e.getMessage());	}
	  //TC_008
	  try {
	  String tc008=driver.findElement(By.xpath("//label[@for='baseLocation']")).getText();
	  Assert.assertEquals(tc008,"*Base Location");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC008: " + e.getMessage());
	}
	  //TC_009
	  try {
	  String tc009=driver.findElement(By.xpath("//label[@for='projectSow']")).getText();
	  Assert.assertEquals(tc009,"*Project");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC009: " + e.getMessage());	}
	  //TC_010
	  try {
	  String tc010=driver.findElement(By.xpath("//label[@for='subLobTeam']")).getText();
	  Assert.assertEquals(tc010,"*Team");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC010: " + e.getMessage());
	}
	  
	//TC_011
	  try {
	  String tc011=driver.findElement(By.xpath("//label[@for='leaveStatus']")).getText();
	  Assert.assertEquals(tc011,"*Leave Status (Pick Planned if start date is in future)");}
	 catch (Exception e) {
		 test.log(Status.FAIL, "TC0011: " + e.getMessage());	}
	  //TC_012
	  try {
	  String tc012=driver.findElement(By.xpath("//label[@for='comments']")).getText();
	  Assert.assertEquals(tc012,"Comments");}
	  catch (Exception e) {
		  test.log(Status.FAIL, "TC0012: " + e.getMessage());	}
	  
	  test.log(Status.PASS,"Test Script 01 Passed");
	  
	  

	  
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

