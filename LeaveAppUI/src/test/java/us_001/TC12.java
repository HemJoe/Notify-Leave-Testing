package us_001;
import com.aventstack.extentreports.ExtentTest;


import base.BaseClass;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC12 extends BaseClass {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
    ExtentTest test;
    ExtentTest test1;


@Test
public void TC_083_TC084_VerifyMultiSelection() throws InterruptedException {
    ExtentTest test = extent.createTest("TC_083 – Multi-selection support in Backup Contacts");

    
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@href]")).click();
    Thread.sleep(1000);

    
    WebElement backupContact = driver.findElement(By.xpath("/html/body/app-root/app-notifyleave/div/div/div/div/form/div[6]/ng-select/div/div/div[2]/input"));

  
    backupContact.sendKeys("san");
    Thread.sleep(1000);
    backupContact.sendKeys(Keys.ENTER);
    test.log(Status.INFO, "Selected in TC_83: santhosh.d.ganesan@accenture.com");

    
    backupContact.sendKeys("log");
    Thread.sleep(1000);
    backupContact.sendKeys(Keys.ENTER);
    test.log(Status.INFO, "Selected in TC_83: logesh.ravichandran@accenture.com");

    
    List<WebElement> selectedBackup = driver.findElements(By.xpath("/html/body/app-root/app-notifyleave/div/div/div/div/form/div[6]/ng-select/div/div/div[2]/input"));
    BaseClass.assertequals(selectedBackup.size(), 2, "TC_083 – Backup Contacts holds multiple selections", test);


//    public void TC084_VerifyMultiSelection() throws InterruptedException {
   // 	ExtentTest test = extent.createTest("TC_083, TC_084 – Multi-selection support in Backup Contacts and Notify To Recipients");
   // }
    
    
    ExtentTest test1 = extent.createTest("TC_084 – Multi-selection support in Notify To Recipients");

    WebElement notifyToRecipient = driver.findElement(By.xpath("/html/body/app-root/app-notifyleave/div/div/div/div/form/div[7]/ng-select/div/div/div[2]/input"));

    
    notifyToRecipient.sendKeys("bev");
    Thread.sleep(1000);
    notifyToRecipient.sendKeys(Keys.ENTER);
    test1.log(Status.INFO, "Selected in TC_84: bevin.john.r@accenture.com");

    
    notifyToRecipient.sendKeys("log");
    Thread.sleep(1000);
    notifyToRecipient.sendKeys(Keys.ENTER);
    test1.log(Status.INFO, "Selected in TC_84: logesh.ravichandran");

    
    List<WebElement> selectedNotify = driver.findElements(By.xpath("/html/body/app-root/app-notifyleave/div/div/div/div/form/div[7]/ng-select/div/div/div[2]/input"));
    BaseClass.assertequals(selectedNotify.size(), 2, "TC_084 – Notify To Recipients holds multiple selections", test1);
}

@BeforeMethod
public void beforeMethod() {
    driver.get("http://localhost:4200/homepage");
    driver.manage().window().maximize();
    maximize(); 
    extent.attachReporter(htmlReporter);
}

@AfterMethod
public void afterMethod() {
    close(); 
    extent.flush();
}
}

        
        
        
        
        
        
        
        
        
        
        
        