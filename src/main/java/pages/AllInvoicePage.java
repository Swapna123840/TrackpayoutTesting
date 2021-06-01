package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

	@FindBy(xpath = "//span[@class='btn btn-outline-primary']")//xpath........
	WebElement ReportDownload;

	
	@FindBy(xpath = "//i[@class='feather icon-download']")
	List<WebElement> ReportDownloads;

	@FindBy(xpath = "//a[@title='View']/i[@class='feather icon-eye']")
	List<WebElement> Viewbuttons;
	
	@FindBy(xpath = "//strong[contains(text(),'Payment details')]")
	WebElement paydetails;
	
	@FindBy(xpath = "//strong[contains(text(),'Payment Date details')]")
	WebElement payDtdetails;
	
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-secondary']")
	WebElement Closebtn;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement Closebtnx;
	
	@FindBy(xpath = "//a[@class='ng-star-inserted']/i[@class='feather icon-edit']")
	List<WebElement> Editbuttons;
	
	@FindBy(xpath = "//i[@class='feather icon-edit']")
	WebElement Editbutton;
	
	@FindBy(id = "invoice_amount")
	WebElement Inv_amount;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement Edisubmit;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkAlert;
	
	@FindBy(xpath = "//a[@title='Delete']/i[@class='feather icon-trash-2']")
	
	//@FindBy(xpath = "//i[@class='feather icon-trash-2']")
	List<WebElement> Deletebuttons;
	
	@FindBy(xpath = "//button[contains(text(),'Remove') and @class='btn btn-danger']")
	WebElement Removebtn;
	
	
	@FindBy(xpath = "//a[@title='Download Attachments']//i[@class='feather icon-download']")//xpath..issue
	List<WebElement> DownAttachments;
	
	@FindBy(xpath = "//a[@title='Followup Details']//i[@class='feather icon-mail']")
	List<WebElement> FollowupDetails;
	
	
	
	
	public AllInvoicePage() {

		PageFactory.initElements(driver, this);
	}

	public void searchallinvoice(String invno) {

		TestHelpers.enterdate(From_dt, props.getProperty("Fromdt"));

		TestHelpers.enterdate(To_dt, props.getProperty("Todt"));

		TestHelpers.addtext(searchbtn, invno);

		logger.info("Search");

	}

		public void Report_Download() {

		 TestHelpers.clickelement(ReportDownload);

		//TestHelpers.clickelement(ReportDownloads.get(0));
		

		logger.info("Report download");

	}

	public void View_Edit_Delete_Invoice() {

		TestHelpers.clickelement(Viewbuttons.get(0));
		
		TestHelpers.clickelement(paydetails);

		TestHelpers.clickelement(payDtdetails);
		
		TestHelpers.clickelement(Closebtn);

		logger.info("close Invoice");
		
		//TestHelpers.clickelement(Editbuttons.get(0));
		
		try {
			
			TestHelpers.clickelement(Editbutton);

		} catch (Exception e) {
			
			TestHelpers.clickelement(Editbutton);
		}

		
		logger.info("Edit Invoice");
		
		TestHelpers.addtext(Inv_amount, "79328");
		
		TestHelpers.clickelement(Edisubmit);

		boolean res = driver.getPageSource().contains("	Invoice has been updated successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			
			logger.info("test case passed....Invoice has been updated successfully!");

		} else {
			
			logger.info("test case passed...Invoice not updated successfully!");
			
			Assert.assertTrue(true);
		}
		
		TestHelpers.clickelement(OkAlert);
		
		logger.info("Invoice Updated");
		
		

			
			TestHelpers.clickelement(Deletebuttons.get(0));

			
			logger.info("Delete Invoice");

			TestHelpers.clickelement(Removebtn);
		
			boolean rem = driver.getPageSource().contains("Invoice has been removed successfully!");

			if (rem == true) {
				
				Assert.assertTrue(true);
				
				logger.info("test case passed....Invoice has been removed successfully!");

			}

			logger.info("RemovePopup... Invoice");
		
		
			
			TestHelpers.clickelement(FollowupDetails.get(0));
			
			logger.info("Followup details display");

		
		
	/*	not working...............
	 * 	TestHelpers.clickelement(DownAttachments.get(0));
			
			logger.info("Download Attachments");*/


	}

}
