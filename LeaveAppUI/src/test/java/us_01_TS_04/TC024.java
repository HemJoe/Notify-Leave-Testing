package us_01_TS_04;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TC024 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;


@Test
public void backupcontactTC024() throws InterruptedException {
	 test = extent.createTest("TC_024 Verify Backup Contact Dropdown Options");
	 driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	 Thread.sleep(2000);
	try {
		WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  Thread.sleep(500);  
		  element.click();
		//(//input[@type='text'])[3]
		List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@role='listbox']"));
		 List<String> expectedOptions = Arrays.asList(
				 "vimala.polagani@accenture.com\r\n"
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
 		test.fail("assertion fail:"+ e.getMessage());
 	}
}@BeforeSuite
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



