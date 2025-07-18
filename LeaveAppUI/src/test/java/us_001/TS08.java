package us_001;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import base.BaseClass;
 
public class TS08 extends BaseClass {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
  @Test
  public void checkPlaceholderDisappears(String xpath, String inputText, SoftAssert softAssert, String fieldName) {
      try {
          WebElement field = driver.findElement(By.xpath(xpath));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
          String placeholderBefore = field.getAttribute("placeholder");
 
          test.info("Before typing in " + fieldName + ": Placeholder is '" + placeholderBefore + "'");
          softAssert.assertNotNull(placeholderBefore, fieldName + " should have a placeholder.");
 
          field.sendKeys(inputText);
          Thread.sleep(1000); // wait for placeholder to disappear
 
          String placeholderAfter = field.getAttribute("placeholder");
          boolean disappeared = (placeholderAfter == null || placeholderAfter.isEmpty());
 
          if (disappeared) {
              test.pass(fieldName + " placeholder disappeared after typing.");
          } else {
              test.fail(fieldName + " placeholder did NOT disappear. Still shows: " + placeholderAfter);
          }
 
          softAssert.assertTrue(disappeared, fieldName + " placeholder should disappear after typing.");
 
      } catch (Exception e) {
          test.fail("Error in field: " + fieldName + " - " + e.getMessage());
      }
  }
 
  @Test
  public void verifyPlaceholderDisappearance() {
      test = extent.createTest("Placeholder Disappearance", "Verify placeholder disappears on typing");
      SoftAssert softAssert = new SoftAssert();
 
      // Replace the below XPaths with actual formcontrolname/xpaths from your app
      checkPlaceholderDisappears("(//input[@type='text'])[1]", "Sick", softAssert, "Leave Type");             // TC_060
      checkPlaceholderDisappears("//textarea[@id=['briefReason']","function", softAssert, "brief Reason");
      checkPlaceholderDisappears("(//input[@type='text'])[3]", "santhosh.d.ganesan", softAssert, "Backup Contact(s)"); // TC_062
      checkPlaceholderDisappears("(//input[@type='text'])[4]", "santhosh.d.ganesan", softAssert, "Notify To Recipient(s)"); // TC_063
      checkPlaceholderDisappears("(//input[@type='text'])[5]", "Chennai", softAssert, "Base Location"); // TC_064
      checkPlaceholderDisappears("(//input[@type='text'])[6]", "Yet to Onboarding", softAssert, "Project"); // TC_065
      checkPlaceholderDisappears("(//input[@type='text'])[7]", "Yet to Onboarding", softAssert, "Team"); // TC_066
      checkPlaceholderDisappears("(//input[@type='text'])[8]", "Availed", softAssert, "Leave Status"); // TC_067
      checkPlaceholderDisappears("//textarea[@id='commentsInput']","Availed", softAssert, "comments");
 
      
 
      softAssert.assertAll();
  }

  @BeforeMethod
  public void beforeMethod() {
	  url("http://localhost:4200/homepage");
	  maximize();
	  extent= new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
  }
 
  @AfterMethod
  public void afterMethod() {
	  extent.flush();
//	  close();
 
  }
}