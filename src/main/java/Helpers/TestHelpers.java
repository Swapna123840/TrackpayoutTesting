package Helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetUp.TestSetUp;

public class TestHelpers extends TestSetUp {

	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT = 40;

	public static void waitforpageload(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}

	public static String addtext(WebElement element, String text) 
	{
		WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
		//return text;
		return text;
	}
	
	
	public static void clickelement(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	// For input date
	
	public static void inputdate(String element_id, String date) {

		String docStr = "document.getElementById('" + element_id + "').removeAttribute('readonly',0);";
		((JavascriptExecutor) driver).executeScript(docStr);
		WebElement InputDate = driver.findElement(By.id(element_id));

		InputDate.clear();
		InputDate.sendKeys(date);
	}

	// Dropdown-Select by index
	
	public static void selectByIndex(WebElement element, int index) {

		Select drop = new Select(element);
		drop.selectByIndex(index);

	}
	
	// Random string generator
	
	public static String randomestring() {
	  
	  String generatestring=RandomStringUtils.randomAlphabetic(8); 

	  return(generatestring);
}
	
	//Random number generator
	
	public static String randomeNum() { 
		
 	String generatestring2=RandomStringUtils.randomNumeric(4); 
 		
 	return(generatestring2);
 	
  }
	// From date-To date calender
	public static void enterdate(WebElement element_id, String date) {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].value = arguments[1]", element_id , date);
	js.executeScript("arguments[0].value = arguments[1]", element_id, date);

	}	
}

