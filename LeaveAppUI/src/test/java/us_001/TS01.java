package us_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class TS01 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
  @Test
  public void f() throws InterruptedException {
	  test = extent.createTest("Field and UI Verification", "Verify all labels on the form");
	  SoftAssert softAssert = new SoftAssert();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@href]")).click();
	  Thread.sleep(5000);

	  //TC001
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='leaveType']")).getText(),"*Leave Typ", "TC001",test);
	  //TC002
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='availedBy']")).getText(), "*Availed By","TC002", test);
	  //TC003
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='startDate']")).getText(), "*Start Date","TC003", test);
	  //TC004
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='endDate']")).getText(),"*End Date","TC004", test);
	  //TC005
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='briefReason']")).getText(),"Brief Reason","TC005", test);
	  //TC006
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='backupContact']")).getText(),"*Backup Contact(s) (Acc Peer only. If none, add Supervisor)","TC006", test);
	  //TC007
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='notifyTo']")).getText(),"*Notify To Recipient(s) (Must add- Acc Supervisor)","TC007", test);
	  //TC008
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='baseLocation']")).getText(),"*Base Location","TC008", test);
	  //TC009
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='projectSow']")).getText(),"*Project","TC009", test);
	  //TC010
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='subLobTeam']")).getText(), "*Team","TC010", test);
	  //TC011
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='leaveStatus']")).getText(),"*Leave Status (Pick Planned if start date is in future)","TC011", test);
	  //TC012
	  BaseClass.assertequals(driver.findElement(By.xpath("//label[@for='comments']")).getText(),"Comments","TC012", test);
	  softAssert.assertAll();
	  
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

