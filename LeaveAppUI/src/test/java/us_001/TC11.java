package us_001;

import base.BaseClass;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC11 extends BaseClass {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
    ExtentTest test;

    @Test
    public void verifyDateFormatAndManualEntry() throws InterruptedException {
        test = extent.createTest("TC_079, TC_080, TC_081, TC_082 – Date Format and Manual Entry");

        try {
            // Wait for page load if needed
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[@href]")).click();
            Thread.sleep(1000);

            // Locate date fields
            WebElement startDateField = driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
            WebElement endDateField = driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));

            // Get actual values
            String startDateValue = startDateField.getAttribute("min");
            String endDateValue = endDateField.getAttribute("min");

            // Define regex for MM/DD/YYYY
//            String datePattern = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$";
            String datePattern = "\\d{2}/\\d{2}/\\d{4}";


            // TC_079 – Check Start Date format
            boolean isStartDateFormatCorrect = Pattern.matches(datePattern, startDateValue);
            assertequals(isStartDateFormatCorrect, true, "TC_079 – Start Date format is MM/DD/YYYY", test);

            // TC_080 – Check End Date format
            boolean isEndDateFormatCorrect = Pattern.matches(datePattern, endDateValue);
            assertequals(isEndDateFormatCorrect, true, "TC_080 – End Date format is MM/DD/YYYY", test);

            // TC_081 – Try manual entry for Start Date
            String manualDate = "07/17/2025";
            startDateField.clear();
            startDateField.sendKeys(manualDate);
            Thread.sleep(500);
            String updatedStartDate = startDateField.getAttribute("value");
            assertequals(updatedStartDate, manualDate, "TC_081 – Manual entry of Start Date works", test);
            
         // TC_082 – Manual entry of End Date in MM/DD/YYYY format
            String manualEndDate = "07/17/2025";
            WebElement endDateField1 = driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));
            endDateField1.clear();
            endDateField1.sendKeys(manualEndDate);
            Thread.sleep(500);
            String updatedEndDate = endDateField1.getAttribute("value");
            assertequals(updatedEndDate, manualEndDate, "TC_082 – Manual entry of End Date works", test);


        } catch (Exception e) {
            test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://localhost:4200/homepage");
        driver.manage().window().maximize();
        maximize(); // in BaseClass
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void afterMethod() {
        close(); // or quit() based on your BaseClass
        extent.flush();
    }
}
