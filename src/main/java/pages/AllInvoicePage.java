package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class AllInvoicePage extends TestSetUp {

	
	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-all[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/select[1]")
	WebElement Dropdown;
			
	
	@FindBy(xpath = "//select[@id='customer_id']")
	WebElement SelectCust;
	
	@FindBy(xpath = "//input[@placeholder='Search here']")
	WebElement searchbtn;
	
	@FindBy(xpath = "//input[@placeholder='From Date']")
	WebElement From_dt;
	
	@FindBy(xpath = "//input[@placeholder='To Date']")
	WebElement To_dt;

	@FindBy(xpath = "//span[@title='DOWNLOAD']")
	WebElement ReportDownload;
	
	@FindBy(xpath = "//i[@class='ng-tns-c114-3 feather icon-home']")
	WebElement Viewbutton;




	
	
	public AllInvoicePage() {
		
		PageFactory.initElements(driver, this);
	}

	public void searchallinvoice() {
		
	
		TestHelpers.enterdate(From_dt, props.getProperty("Fromdt"));
		
		TestHelpers.enterdate(To_dt, props.getProperty("Todt"));
		
		TestHelpers.addtext(searchbtn,  "" );

		
		
	}
	
	
	public void Report_Download() {
		
		ReportDownload.click();
		
		Viewbutton.click();
	}

		
	
	
			
		
}
	
	
			
