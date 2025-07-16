package us_001;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

//import com.aventstack.extentreports.ExtentReports;

public class TS13 extends BaseClass {
	
	
  @Test
  public void f() {
	  driver.findElement(By.xpath("//a[@href]")).click();
	  implicitlyWait(3);
	  
	 
	  //TC85
	  WebElement element1 = driver.findElement(By.xpath("//label[text()='Backup Contact(s) ']"));
	  scrollIntoView(element1);
	  implicitlyWait(3);
	  
	  WebElement ck = driver.findElement(By.xpath("(//div[@role='combobox'])[3]"));
	  jsClick(ck);
	  
	  
	  WebElement dropdownElement = driver.findElement(By.xpath("//div[text()='Select Backup Contact(s)']"));
	   Dropdown(dropdownElement);
	  
	   //TC86
//	   WebElement element2 = driver.findElement(By.xpath("//label[text()='Select Recipient(s)'']"));
//	   scrollIntoView(element2);
	   implicitlyWait(3);
		  
	   WebElement jsck = driver.findElement(By.xpath("(//div[@role='combobox'])[4]"));
	   jsClick(jsck);
		  
		  
	   WebElement dropdownElement1 = driver.findElement(By.xpath("//div[text()='Select Recipient(s)']"));
	   Dropdown(dropdownElement1);
	   
	  


  }
  
  









  @BeforeMethod
  public void beforeMethod() {
	  url("http://localhost:4200/homepage");
	  maximize();
  }

  @AfterMethod
  public void afterMethod() {
//	  close();

	  
  }
}



