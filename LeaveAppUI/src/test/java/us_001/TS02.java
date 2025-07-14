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
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TS02 {
	EdgeDriver driver= new EdgeDriver();
	 ExtentReports extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		ExtentTest test;
  @Test
  public void f() throws InterruptedException {
	  
	  //TC_013 – Verify mandatory fields have asterisk symbols
	  test = extent.createTest("mandatory Field and nonasterisks Verification");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	  Thread.sleep(5000);
	  //leavetype
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='leaveType']")).getText(),"*Leave Type",test);
	  //availed by
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='availedBy']")).getText(), "*Availed By", test);
	  //Start Date
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='startDate']")).getText(), "*Start Date", test);
	  //End Date
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='endDate']")).getText(),"*End Date", test);
	  //BackUp Contact(s)
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='backupContact']")).getText(),"*Backup Contact(s) (Acc Peer only. If none, add Supervisor)", test);
	  //Notify To Recipients(s)
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='notifyTo']")).getText(),"*Notify To Recipient(s) (Must add- Acc Supervisor)", test);
	  //Base Location
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='baseLocation']")).getText(),"*Base Location", test);
	  //Project
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='projectSow']")).getText(),"*Project", test);
	  //Team
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='subLobTeam']")).getText(), "*Team", test);
	  //Leave Status
	  BaseClass.mandatoryfield(driver.findElement(By.xpath("//label[@for='leaveStatus']")).getText(),"*Leave Status (Pick Planned if start date is in future)", test);
  }
  @Test
  public void nonasterisks(){
	 // Verify "Brief Reason" and "Comments" don't have asterisks
	  //Briefreason
	  SoftAssert sa=new SoftAssert();
		  
		  String briefreason=driver.findElement(By.xpath("//label[@for='briefReason']")).getText();
		  String comments= driver.findElement(By.xpath("//label[@for='comments']")).getText();
		 
		 boolean briefasterisk=  briefreason.trim().startsWith("*");
		 boolean  commentsasterisk=comments.trim().startsWith("*");
		 try {
		 sa.assertFalse(briefasterisk);
		 test.log(Status.PASS, "brief reason dont have asterisks");   }
		 catch (Exception e) {
			 test.log(Status.FAIL, "brief reason has asterisks");
		 }
		  try {
			  sa.assertFalse(commentsasterisk);
			  test.log(Status.PASS,"comments dont have asterisks");}
			catch (Exception e) {
				test.log(Status.FAIL,"comments have asterisks");
			}  
  
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
