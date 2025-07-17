package base;
 
import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
 
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 
public class BaseClass {
	
	public static void assertequals(String actual, String expected, String tc, ExtentTest test) {
		
	        try {
	    SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected);
		
	            test.log(Status.PASS, tc +"Result [" + expected + "],["+ actual+"]");
	        } catch (AssertionError e) {
	            test.log(Status.FAIL, tc +e.getMessage());}
	        }

	public static void mandatoryfield(String actual, String expected, ExtentTest test) {
	        try {
	    
	            Assert.assertEquals(actual, expected);
	            test.log(Status.PASS, "Result [" + expected + "],["+ actual+"]");
	        } catch (AssertionError e) {
	            test.log(Status.FAIL,e.getMessage());}
	        }
	public static void verifyDropdownHasOptions(List<WebElement> options, String dropdownName, ExtentTest test) {
	        try {
	            Assert.assertTrue(options.size()>0, dropdownName );
	            test.log(Status.PASS, dropdownName+ " has " + options.size());
	            for (WebElement String : options) {
	                test.log(Status.INFO, "Option: " + String.getText());
	            }
	        } catch (AssertionError e) {
	            test.log(Status.FAIL, dropdownName + " has no options. " + e.getMessage());
	        }
	    }
//	public void assertequals(String string, List<String> expectedOptions, List<String> actop) {
//		
//	}


	public static Actions actions;

    public static WebDriver driver = new EdgeDriver();
 
 
    public static void url(String url) {

        driver.get(url);

    }
 
    public static void maximize() {

        driver.manage().window().maximize();

    }
 
    public static void minimize() {

        driver.manage().window().minimize();

    }
 
    public static void quit() {

        driver.quit();

    }
 
    public static void close() {

        driver.close();

    }
 
    public static void back() {

        driver.navigate().back();

    }
 
    public static void forward() {

        driver.navigate().forward();

    }
 
    public static void click(String xpath) {

        driver.findElement(By.xpath(xpath)).click();

    }
 
    public static void sendKeys(WebElement element, String inputValues) {

        element.sendKeys(inputValues);

    }
 
    public static void alertdismiss(){

        driver.switchTo().alert().dismiss();

    }

    public static void alertaccept(){

        driver.switchTo().alert().accept();

    }
 
    public static void takeScreenshot(String location) throws IOException {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File(location);

        FileUtils.copyFile(source, destination);

    }
 
    public static void refresh() {

        driver.navigate().refresh();

    }
 
    public static void doubleClick(String id) {

        WebElement elementLocator = driver.findElement(By.id(id));

        actions.doubleClick(elementLocator).perform();

    }
 
    public static void switchToFrame(String iframe) {

        driver.switchTo().frame(iframe);

    }
 
    public static void scrollIntoView(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor)driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    
    public static void scrollIntoViewXY(int x, int y){

    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	 
    	 js.executeScript("window.scrollBy(x,y)");
    }
    
    public static void  implicitlyWait(int s) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    	
    }
    
    public static void Dropdown(WebElement dropdownElement) {
//    	WebElement dropdownElement = driver.findElement(By.xpath(""));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Get all options
        List<WebElement> allOptions = dropdown.getOptions();

        // Print text of each option
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
    	
    }
    

 
    public static void jsClick(WebElement element) {

        JavascriptExecutor js= (JavascriptExecutor)driver;
 
        js.executeScript("arguments[0].click();", element);

    }
 
    public static void windowhandles(WebDriver driver){

        String mainWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            if (!handle.equals(mainWindowHandle)) {

                driver.switchTo().window(handle);

                break;

            }

        }

    }

	public static void assertequals(String actual, List<String> expectedOptions, List<String> actop, ExtentTest test) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
 


 
