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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TS04 extends BaseClass {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
	 @Test(priority = 1)
	
		public void leavetype() throws InterruptedException{
		  Thread.sleep(3000);
		
			test = extent.createTest("TC_020-dropdown is a single select");
			driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
			  Thread.sleep(3000);
		    driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();
		    Thread.sleep(2000);
			try {
		    List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		    
		    test.info("Dropdown options count: " + options.size());
		    // Selecting first option
		    options.get(0).click();
		    //test.info("checking the second option to know whether we can select multiple options");
		    driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();
		    Thread.sleep(1000);
		    options = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		    
		    // Selecting second option
		    options.get(1).click();
		    String selectedText = driver.findElement(By.xpath("(//div[@class='ng-value']//span)[1]")).getText();
		    Assert.assertNotNull(selectedText, "A selection should exist");
		    test.pass("Only one option was selected");}
		    catch (Exception e) {
		    	test.log(Status.FAIL,"failed :"+e.getMessage());
		    }
		}
	 @Test(priority = 2)
	  public void LeavetypeTC019() throws InterruptedException  {
		  test = extent.createTest("TC_019-dropdown fields");
		  Thread.sleep(3000);
		  //driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
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
	
	 @Test(priority = 3)
	 public void backupcontactTC024() throws InterruptedException {
	 	 test = extent.createTest("TC_024-Verify Backup Contact Dropdown Options");
	 	 //driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	 	 Thread.sleep(2000);
	 	try {
	 		WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	 		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 		  Thread.sleep(500);  
	 		  element.click();
	 		List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
	 		 List<String> expectedOptions = Arrays.asList(
	 				 "polagani.vimala@accenture.com\r\n"
	 		 		+ "bevin.john@accenture.com\r\n"
	 		 		+ "logesh.r@accenture.com\r\n"
	 		 		+ "mark.daniel@accenture.com");
	 	     List<String> actop= new ArrayList<>();
	 	
	      for(WebElement option:optionsElements) {
	     	 actop.add(option.getText().trim());
	      }
	 		test.info("expected :" + expectedOptions);
	 		test.info("actual:"+ actop);
	 		System.out.println(actop);
	 		BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop,test);
	         test.pass("Dropdown options matched successfully");
	          
	 	} catch (Exception e) {
	  		test.fail("assertion fail:"+ e.getMessage());}
	 	Thread.sleep(2000);
	 	driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[3]")).click();
	 	Thread.sleep(1000);
	  	}
	 @Test(priority = 4)
	 public void  NotifyToRecipientTC025() throws InterruptedException {
	 	test = extent.createTest("TC_025-NotifyToRecipient");
//	 	driver.findElement(By.xpath("//a[@href]")).click();
	 	//driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	 	Thread.sleep(2000);
	 	try {
	 		 WebElement element = driver.findElement(By.xpath("(//div[@class='ng-input'])[4]"));
	 		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 		  Thread.sleep(500);  
	 		  element.click();
	 		List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-multiple ng-select-bottom']"));
	 		 List<String> expectedOptions = Arrays.asList(
	 				 "polagani.vimala@accenture.com\r\n"
	 		 		+ "bevin.john@accenture.com\r\n"
	 		 		+ "logesh.r@accenture.com\r\n"
	 		 		+ "mark.daniel@accenture.com");
	 	     List<String> actop= new ArrayList<>();
	 	
	      for(WebElement option:optionsElements) {
	     	 actop.add(option.getText().trim());
	      }
	 		test.info("expected :" + expectedOptions);
	 		test.info("actual :"+ actop);
	 		System.out.println(actop);
	 		BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop,test);
	         test.pass("Dropdown options matched successfully.");
	          
	 	} catch (Exception e) {
	  		test.fail("assertion fail:"+ e.getMessage());
	  	}
	 	Thread.sleep(2000);
	 driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[4]")).click();
	 Thread.sleep(1000);
	 }
	 @Test(priority = 5)
		
	 public void BaseLocationTC026() throws InterruptedException {
	 	test = extent.createTest("TC026 Baselocation");
	 	//driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	 	  Thread.sleep(1000);
	 	  WebElement element1 = driver.findElement(By.xpath("(//div[@class='ng-select-container'])[4]"));
	 	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
	 	  Thread.sleep(500); 
	 	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
	 	  Thread.sleep(1000);
	 	  List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-bottom']"));
	 	 try {
	 		 List<String> expectedOptions = Arrays.asList(
	 				 "Bengaluru, Chennai, Hyderabad, Ahmedabad, Coimbatore, Gurugram, Kolkata, Mumbai, New Delhi, Noida, Pune, Indore, Jaipur, others");
	 	     List<String> actop1= new ArrayList<>();
	 	
	   for(WebElement option:optionsElements) {
	  	 actop1.add(option.getText().trim());
	   }
	 		test.info("expected :" + expectedOptions);
	 		test.info("actual:"+ actop1);
	 		System.out.println(actop1);
	 		BaseClass.assertequals("Dropdown values mismatching", expectedOptions, actop1,test);
	      test.pass("Dropdown options matched successfully");}
	       
	 	 catch (Exception e) {
	 		test.fail("assertion fail:"+ e.getMessage());
	 	}
	 	  Thread.sleep(1000);
	 	WebElement ck=driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[5]"));
	 	ck.click();
	 	Thread.sleep(1000);
 }
	 @Test(priority = 6)
	 public void  ProjectTC027() throws InterruptedException {
	 	test = extent.createTest("TC027-Project");
	 	Thread.sleep(2000);
	 	try {
			 WebElement element1 = driver.findElement(By.xpath("(//div[@class='ng-input'])[6]"));
			  Thread.sleep(500);  
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
			Thread.sleep(1000);
			List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@id=\"a211c739838f\"]"));
			 List<String> expectedOptions = Arrays.asList(
					 "1136 "
					+"1286 " 
					+"Yet to onboard "
					+ "PMO, Leadership");
		     List<String> actop3= new ArrayList<>();
		
	     for(WebElement option:optionsElements) {
	    	 actop3.add(option.getText().trim());
	     }
			test.info("expected :" + expectedOptions);
			test.info("actual :"+ actop3);
			System.out.println(actop3);
			BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop3,test);
	        test.pass("Dropdown options matched successfully.");
	         
		} catch (Exception e) {
	 		test.fail("assertion fail:"+ e.getMessage());
	 	}
	 	Thread.sleep(2000);
	 	WebElement element=driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[6]"));
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);	 
	 	
	 	Thread.sleep(1000);
	 }
	
	 
	 @Test(priority = 7)
	 public void  TeamTC028() throws InterruptedException {
	 	test = extent.createTest("TC_028-Team");

	 	
	 	try {
	 		
	         Thread.sleep(2000);
	     
	 		 WebElement element = driver.findElement(By.xpath("(//div[@class='ng-input'])[7]"));
	 		 
	 		  Thread.sleep(500);  
	 		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	 		 Thread.sleep(1000);
	 		List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-top']"));
	 		 List<String> expectedOptions = Arrays.asList(
	 				 "FCT QA, FCT DEV, Mobile QA, Mobile DEV, ECVT QA, ECVT DEV,DPT-DEV,DPT QA, EPT QA, EPT DEV, PMO,Yet to Onboard, Leadership.");
	 	     List<String> actop4= new ArrayList<>();
	 	
	      for(WebElement option:optionsElements) {
	     	 actop4.add(option.getText().trim());
	     	 System.err.println(actop4);
	      }
	 		test.info("expected :" + expectedOptions);
	 		test.info("actual :"+ actop4);
	 		
	 		BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop4,test);
	         test.pass("Dropdown options matched successfully.");
	          
	 	} catch (Exception e) {
	  		test.fail("assertion fail:"+ e.getMessage());
	  	}
	 	Thread.sleep(2000);
	 	WebElement element=driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[7]"));
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	 	Thread.sleep(1000);
	 }
	 @Test(priority = 8)
		public void  LeaveStatusTC029() throws InterruptedException {
			test = extent.createTest("TC_029-LeaveStatus");

			//driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
		
			try {
				Thread.sleep(2000);
		    
				 WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
				  
				  Thread.sleep(500);  
				 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				 	Thread.sleep(1000);
				List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-bottom']"));
				 List<String> expectedOptions = Arrays.asList("Availed ,planned ,cancelled");
			     List<String> actop= new ArrayList<>();
			
		     for(WebElement option:optionsElements) {
		    	 actop.add(option.getText().trim());
		     }
				test.info("expected :" + expectedOptions);
				test.info("actual :"+ actop);
				
				BaseClass.assertequals("Dropdown values mismatch", expectedOptions, actop,test);
		        test.pass("Dropdown options matched successfully.");
		         
			} catch (Exception e) {
		 		test.fail("assertion fail:"+ e.getMessage());
		 	}
			Thread.sleep(2000);
			WebElement ck=driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[8]"));
		 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ck);
		 	Thread.sleep(1000);
		}
@BeforeSuite
  public void Beforemethod() {
	  url("http://localhost:4200/homepage");
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
