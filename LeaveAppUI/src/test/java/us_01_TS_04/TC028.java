package us_01_TS_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TC028 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;

@Test
public void  ProjectTC027() throws InterruptedException {
	test = extent.createTest("TC025NotifyToRecipient");

	driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	Thread.sleep(2000);
	try {
		
        Thread.sleep(2000);
    
		 WebElement element = driver.findElement(By.xpath("(//div[@class='ng-input'])[7]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  Thread.sleep(500);  
		  element.click();
		List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-top']"));
		 List<String> expectedOptions = Arrays.asList(
				 "FCT QA, FCT DEV, Mobile QA, Mobile DEV, ECVT QA, ECVT DEV,DPT-DEV,DPT QA, EPT QA, EPT DEV, PMO,Yet to Onboard, Leadership.");
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


