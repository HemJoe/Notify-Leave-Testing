package us_01_TS_04;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TC026 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	@Test
	
public void BaseLocationTC026() throws InterruptedException {
	test = extent.createTest("TC026 Baselocation");
	driver.findElement(By.xpath("//a[@class='click-link fs-5']")).click();
	  Thread.sleep(3000);
	  WebElement element = driver.findElement(By.xpath("(//div[@class='ng-select-container'])[4]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  Thread.sleep(500); 
	  element.click();
	  try {
	  List<WebElement> optionsElements = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-select-bottom']"));
		 List<String> expectedOptions = Arrays.asList(
				 "Bengaluru, Chennai, Hyderabad, Ahmedabad, Coimbatore, Gurugram, Kolkata, Mumbai, New Delhi, Noida, Pune, Indore, Jaipur, others");
	     List<String> actop= new ArrayList<>();
	
  for(WebElement option:optionsElements) {
 	 actop.add(option.getText().trim());
  }
		test.info("expected :" + expectedOptions);
		test.info("actual:"+ actop);
		System.out.println(actop);
		BaseClass.assertequals("Dropdown values mismatching", expectedOptions, actop,test);
     test.pass("Dropdown options matched successfully");}
      
	 catch (Exception e) {
		test.fail("assertion fail:"+ e.getMessage());
	}
	
	
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
	  //driver.close();
	  extent.flush();
}

}
