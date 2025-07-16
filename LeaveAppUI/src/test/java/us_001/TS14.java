package us_001;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class TS14 extends BaseClass {
  @Test
  public void f() {
	  
	  
	  //TC87 - StartDate
	  WebElement dateToSelect = driver.findElement(By.id("startDate"));
	  jsClick(dateToSelect);

	  implicitlyWait(3); 


	  
	  String classAttr = dateToSelect.getAttribute("class");

	  if (classAttr.contains("selected") || classAttr.contains("highlighted")) {
	      System.out.println("PASS - Selected date is highlighted.");
	  } else {
	      System.out.println("FAIL - Selected date is NOT highlighted.");
	  }
	  
	//TC87 - EndDate
	  WebElement dateToSelect1 = driver.findElement(By.id("endDate"));
	  jsClick(dateToSelect1);

	  implicitlyWait(3); 


	  
	  String classAttr1 = dateToSelect1.getAttribute("class");

	  if (classAttr1.contains("selected") || classAttr1.contains("highlighted")) {
	      System.out.println("PASS - Selected date is highlighted.");
	  } else {
	      System.out.println("FAIL - Selected date is NOT highlighted.");
	  }
	  

	  
	//TC88 - StartDate
	  List<WebElement> allDates = driver.findElements(By.id("startDate"));

	  // Loop through all dates
	  for (WebElement date : allDates) {
	      String classAttr2 = date.getAttribute("class");
	      
	      // Skip the selected one
	      if (classAttr2.contains("selected") || classAttr2.contains("highlighted")) {
	          continue;
	      }

	      // Check if wrongly highlighted
	      if (classAttr2.contains("highlighted")) {
	          System.out.println("FAIL - Unselected date is incorrectly highlighted: " + date.getText());
	      }
	  }

	  System.out.println("PASS - All unselected dates are not highlighted.");
	  
	  
	//TC88 - StartDate
	  List<WebElement> allDates1 = driver.findElements(By.id("endDate"));

	  // Loop through all dates
	  for (WebElement date : allDates1) {
	      String classAttr3 = date.getAttribute("class");
	      
	      // Skip the selected one
	      if (classAttr3.contains("selected") || classAttr3.contains("highlighted")) {
	          continue;
	      }

	      // Check if wrongly highlighted
	      if (classAttr3.contains("highlighted")) {
	          System.out.println("FAIL - Unselected date is incorrectly highlighted: " + date.getText());
	      }
	  }

	  System.out.println("PASS - All unselected dates are not highlighted.");
	  
	  
	  
	  
	  

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
