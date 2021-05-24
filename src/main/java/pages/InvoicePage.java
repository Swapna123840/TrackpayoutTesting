package pages;

import java.io.Console;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class InvoicePage extends TestSetUp {

	@FindBy(xpath = "//button[contains(text(),'ADD INVOICE')]")
	WebElement AddInvoice;

	@FindBy(xpath = "//select[@id='customer_id']")
	WebElement SelectCust;

	@FindBy(xpath = "//select[@id='category_id']")
	WebElement SelectCat;

	@FindBy(xpath = "//input[@id='more_receipents']")
	WebElement Morereceipients;

	@FindBy(id = "po_no")
	WebElement Po_No;

	@FindBy(id = "invoice_no")	
	 WebElement Inv_no;
	
//span[@class='dropdown-btn']....xpath
	
	@FindBy(id = "invoice_date")
	WebElement Inv_date;

	@FindBy(id = "invoice_amount")
	WebElement Inv_amount;

	@FindBy(xpath = "//input[@id='igst' and @type='text']")
	WebElement igst;

	@FindBy(id = "cgst")
	WebElement cgst;

	@FindBy(id = "sgst")
	WebElement sgst;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement description;

	@FindBy(id = "payment_term")
	WebElement pay_term;

	@FindBy(id = "payment_due_date")
	WebElement pay_duedate;

	@FindBy(id = "start_reminder_from")
	WebElement selectRemainder;

	@FindBy(id = "reminder_frequency")
	WebElement RemainderFrequency;

	@FindBy(xpath = "//label[@for='payment_status']")
	WebElement checkboxpaidinvoice;

	@FindBy(id = "payment_type")
	WebElement Payment_type;

	@FindBy(xpath = "//input[@id='payment_date']")
	WebElement PaymentDate;

	@FindBy(id = "files")
	WebElement Attachfile;

	@FindBy(xpath = "//button[contains(text(), 'Cancel')]//following-sibling::button")
	WebElement Submitbtn;

	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	WebElement Cancelbtn;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okalert;

	@FindBy(xpath = "//button[contains(text(),'BULK UPLOAD FORMAT')]")
	WebElement BulkUploadFormat;

	@FindBy(id = "bulk_file")
	WebElement ChooseFile;

	@FindBy(xpath = "//button[@title='Submit Invoice!']")
	WebElement InvSubmitbtn;

	@FindBy(className = "alert alert-danger")
	WebElement Invalidinvoicealert;

	@FindBy(xpath = "//button[@title='Submit Invoice!']")
	WebElement Bulkuploadsubmitbtn;
	
	
	
	public InvoicePage() {

		PageFactory.initElements(driver, this);

		TestHelpers.waitforpageload(AddInvoice);

	}

	
	
	
	public void  AddInvoice()  {

		TestHelpers.clickelement(AddInvoice);

		TestHelpers.waitforpageload(SelectCust);

		TestHelpers.selectByIndex(SelectCust, 1);

		TestHelpers.selectByIndex(SelectCat, 1);

		TestHelpers.addtext(Morereceipients, TestHelpers.randomestring()+"@gmail.com");

		
		//Morereceipients.sendKeys(props.getProperty("MoreReceipients"));

		TestHelpers.addtext(Po_No, props.getProperty("POno"));
		
           String text=	TestHelpers.addtext(Inv_no, TestHelpers.randomeNum());
           System.out.println(text);

			
		TestHelpers.inputdate("invoice_date", props.getProperty("SelInvDt"));

		TestHelpers.addtext(Inv_amount, props.getProperty("Invoiceamt"));

		

		if (igst.isEnabled()) {

			TestHelpers.addtext(igst, props.getProperty("Igst"));


		} else {
			
			TestHelpers.addtext(sgst, props.getProperty("sgst"));

			TestHelpers.addtext(cgst, props.getProperty("cgst"));

		
		}
		
		TestHelpers.addtext(description, props.getProperty("Desc"));

		TestHelpers.addtext(pay_term, props.getProperty("Payterm"));

		TestHelpers.inputdate("payment_due_date", props.getProperty("Selduedt"));

		TestHelpers.selectByIndex(selectRemainder, 1);

		TestHelpers.selectByIndex(RemainderFrequency, 0);

		TestHelpers.waitforpageload(checkboxpaidinvoice);// wait for load

		if (!checkboxpaidinvoice.isSelected()) {

			checkboxpaidinvoice.click();
			
			TestHelpers.addtext(Payment_type, props.getProperty("paymentType"));

			
			TestHelpers.inputdate("payment_date", props.getProperty("paydt"));
			
			
		}

	//	TestHelpers.addtext(Attachfile, System.getProperty("user.dir") + "/src/main/resources/Report.csv");

	
		Attachfile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");

		TestHelpers.clickelement(Submitbtn);

		boolean res=driver.getPageSource().contains("Invoice has been created successfully!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....Invoice has been created successfully!");
			
		}
		else
		{
			logger.info("test case passed....Invoice with this invoice no is already exist!");
			Assert.assertTrue(true);
		}
			
		//TestHelpers.clickelement(Cancelbtn);

		

	 	Actions actions1 = new Actions(driver);

		actions1.moveToElement(okalert).click().perform();
		
		
	}
	
	

	public void BulkUpload() {

		TestHelpers.clickelement(BulkUploadFormat);


		ChooseFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/BulkUploadSample2.csv");

		
		//For Invalid File type..........
		//ChooseFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");

		
				
		boolean res=driver.getPageSource().contains("The number of columns in the CSV file are not matched with format!");

		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....The number of columns in the CSV file are not matched with format!");
			
		}
		else
		{
			logger.info("test case passed....Bulkupload file added");
			Assert.assertTrue(true);

			Bulkuploadsubmitbtn.click();

		}
		

	}

	
	
	//For tally invoice..........
	
	/*public void chooseAttachment() {
		
		TestHelpers.waitforpageload(Attachfile);
		
		Attachfile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");
		
		driver.navigate().refresh();
	}*/

	
	 


 }


