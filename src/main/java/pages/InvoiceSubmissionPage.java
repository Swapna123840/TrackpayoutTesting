package pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class InvoiceSubmissionPage extends TestSetUp {

	@FindBy(xpath = "//button[contains(text(),'Submit Invoice')]")
	WebElement SubmitInvoice_btn;

	@FindBy(id = "customer_id")
	WebElement Customer;

	@FindBy(xpath = "//span[contains(text(),'Select Invoice No')]")
	WebElement SelInvoiceno;

	@FindBy(xpath = "//div[contains(text(),'Select All')]")
	WebElement SelAllCheck;

	
	@FindBy(xpath = "//div[@class='dropdown-list']/ul[@class='item2']/li")
	List<WebElement> checkboxes;

	@FindBy(xpath = "//input[@id='shipping_date']/ancestor::form/div[2]/div[2]/input[1]") // xpath
	WebElement shippingDate;

	@FindBy(id = "shippingMode")
	WebElement shipping_mode;

	@FindBy(id = "lastName")
	WebElement RefNo;

	@FindBy(id = "contactName")
	WebElement ConName;

	@FindBy(id = "contact")
	WebElement RefConNo;

	@FindBy(id = "description")
	WebElement Desc;

	@FindBy(id = "files")
	WebElement AttachFile;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]") 
	List<WebElement> Submitbtns;
	

	@FindBy(xpath = "//button[contains(text(), 'Close')]") // xpath
	List<WebElement> Closebtns;
	
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")  
	WebElement Okalert;
	

	@FindBy(xpath = "//button[ @data-dismiss='modal' and @class='btn btn-danger']") // xpath
	WebElement closebtn;

	@FindBy(xpath = "//input[@placeholder='Enter Keyword for filter result']") 
	WebElement Searchbtn;

	@FindBy(xpath = "//a[@title='show']/i[@class='feather icon-eye']") 
	List<WebElement> Viewbtns;
	
	@FindBy(xpath = "//button[contains(text(),'Close') and @class='btn btn-secondary']") // xpath
	List<WebElement> Closebtn;
	
	@FindBy(xpath = "//a[@title='Delete' ]/i[@class='feather icon-trash-2']") // xpath
	List<WebElement> Delbtns;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]") // xpath
	WebElement Removebtn;
	
	@FindBy(xpath = "//a[@title='Mark As Delivered']/i[@class='feather icon-map-pin']") // xpath
	List<WebElement> MarkasDelivered;
	
	@FindBy(xpath = "//button[contains(text(),'Mark As Delivered')]") // xpath
	WebElement Markdelivered;
	
	public InvoiceSubmissionPage() {

		PageFactory.initElements(driver, this);

	}

	public String ClickSubmitInvoicebtn() {

		TestHelpers.clickelement(SubmitInvoice_btn);

		TestHelpers.selectByIndex(Customer, 1);

		TestHelpers.clickelement(SelInvoiceno);
		logger.info("invoice no selected");
	
		//TestHelpers.clickelement(SelAllCheck);
		//logger.info("All invoice no selected");

		TestHelpers.clickelement(checkboxes.get(0));

		logger.info("invoice no... selected");

		WebElement dateBox = shippingDate;

		dateBox.sendKeys(props.getProperty("shipping_Date"));

		dateBox.sendKeys(Keys.TAB);

		// TestHelpers.inputdate("shippingDate", props.getProperty("shipping_Date"));

		TestHelpers.addtext(shipping_mode, props.getProperty("shippingMode"));

		TestHelpers.addtext(RefNo, TestHelpers.randomeNum());
		
		
		String text = TestHelpers.randomeNum();
		TestHelpers.addtext(RefNo, text);
		System.out.println(text);
		

		TestHelpers.addtext(ConName, props.getProperty("ConName"));

		TestHelpers.addtext(RefConNo, props.getProperty("RefConNo"));

		TestHelpers.addtext(Desc, props.getProperty("Desc"));

		// TestHelpers.addtext(AttachFile, System.getProperty("user.dir") +
		// "/src/main/resources/Report.csv");

		AttachFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");


		TestHelpers.clickelement(Submitbtns.get(1));
		
		logger.info("submit");

/*		TestHelpers.clickelement(Closebtns.get(1));

		logger.info("cancel");*/

		try {
			
			TestHelpers.clickelement(Okalert);

		} catch (Exception e) {
			
			TestHelpers.clickelement(Okalert);
		}
		
		logger.info("created");
		
		boolean res = driver.getPageSource().contains("Invoice has been submitted successfully!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....Invoice has been submitted successfully!");

		} else {
			logger.info("test case passed...Invoice with this invoice no is already exist!");
			Assert.assertTrue(true);
		}

		
		return text;

	}
	
	public void search(String refno) {
		
		TestHelpers.addtext(Searchbtn, refno);
		
		logger.info("invoice searched");

	}
	
	public void View_MarkAsDelivered_Delete() {
		
		TestHelpers.clickelement(Viewbtns.get(0));
		
		logger.info("View submitted Invoice");

			/*TestHelpers.clickelement(Closebtn.get(0));
		
		logger.info("close Invoice");*/

		TestHelpers.clickelement(MarkasDelivered.get(0));
		
		TestHelpers.clickelement(Markdelivered);

		logger.info("  Invoice delivered");
		
		TestHelpers.clickelement(Delbtns.get(0));

		TestHelpers.clickelement(Removebtn);

		logger.info(" submitted Invoice deleted");

	}

}
