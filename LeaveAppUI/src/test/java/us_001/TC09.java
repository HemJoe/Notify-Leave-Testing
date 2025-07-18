package us_001;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC09 extends BaseClass {

	EdgeDriver driver= new EdgeDriver();
	 ExtentReports extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		ExtentTest test;

    @Test
    public void verifyStartAndEndDateAutoPopulate() throws InterruptedException {
        test = extent.createTest("TC_069 & TC_070 – Auto-Populate Start and End Dates");
        
        Thread.sleep(1000); 
        driver.findElement(By.xpath("//a[@href]")).click();
        Thread.sleep(1000);   
try  {
        
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

     
        WebElement startDateField = driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
        WebElement endDateField = driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));

        String actualStartDate = startDateField.getAttribute("min");
        String actualEndDate = endDateField.getAttribute("min");
        if (expectedDate == actualStartDate) {
        	assertequals(actualStartDate, expectedDate, "TC_069 – Start Date auto-populate", test);
        		
		}else {
			assertequals(actualStartDate, expectedDate, "TC_069 – Start Date auto-populate" + "Fail", test);
			
		}
        if (expectedDate == actualEndDate ) {
        	assertequals(actualEndDate, expectedDate, "TC_070 – End Date auto-populate", test);	
		}else {
			assertequals(actualEndDate, expectedDate, "TC_070 – End Date auto-populate" + "Fail", test);
		}

        
//        assertequals(actualStartDate, expectedDate, "TC_069 – Start Date auto-populate", test);
//        assertequals(actualEndDate, expectedDate, "TC_070 – End Date auto-populate", test);
        }
        
        
        
      	catch (Exception e) {
      	  test.log(Status.FAIL, "Exception occurred: " + e.getMessage());}
  }
    
    
    @BeforeMethod
    
    public void beforeMethod() {
        driver.get("http://localhost:4200/homepage");  
        driver.manage().window().maximize();
        maximize();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);}

    @AfterMethod
    public void afterMethod() {
        quit(); //
        extent.flush();
    }
}
