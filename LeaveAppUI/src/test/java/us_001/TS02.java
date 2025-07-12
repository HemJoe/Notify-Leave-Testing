package us_001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TS02 {
	WebDriver driver = new EdgeDriver();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	ExtentTest test;
	
	public static void main(String[] args) {
		
		

}

@BeforeMethod
public void beforeMethod() {
	  driver.get("http://localhost:4200/homepage");
	  driver.manage().window().maximize();
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
}
}