package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
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

	@FindBy(xpath = "//ul[@class='item2']/li")
	List<WebElement> checkboxes;

	@FindBy(xpath = "//input[@id='shipping_date']/ancestor::form/div[2]/div[2]/input[1]")
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

	@FindBy(xpath = "//button[contains(text(), 'Close')]")
	List<WebElement> Closebtns;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement Okalert;

	@FindBy(xpath = "//button[ @data-dismiss='modal' and @class='btn btn-danger']")
	WebElement closebtn;

	@FindBy(xpath = "//input[@placeholder='Enter Keyword for filter result']")
	WebElement Searchbtn;

	@FindBy(xpath = "//a[@title='show']/i[@class='feather icon-eye']")
	List<WebElement> Viewbtns;

	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> Closebtn;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/a[1]")
	WebElement Delbtns;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement Removebtn;

	@FindBy(xpath = "//a[@title='Mark As Delivered']/i[@class='feather icon-map-pin']")
	List<WebElement> MarkasDelivered;

	@FindBy(xpath = "//button[contains(text(),'Mark As Delivered')]")
	WebElement Markdelivered;

	public InvoiceSubmissionPage() {

		PageFactory.initElements(driver, this);

	}

	public String ClickSubmitInvoicebtn() throws InterruptedException {

		try {

			TestHelpers.clickelement(SubmitInvoice_btn);

		} catch (Exception e) {
			TestHelpers.clickelement(SubmitInvoice_btn);
		}

		try {
			TestHelpers.selectByIndex(Customer, 1);

		} catch (Exception e) {
			TestHelpers.selectByIndex(Customer, 1);
		}

		TestHelpers.clickelement(SelInvoiceno);
		logger.info("invoice no added");

		/*
		 * TestHelpers.clickelement(SelAllCheck);
		 * logger.info("All invoice no selected");-for selecting all Invoices
		 */

		Thread.sleep(3000);
		TestHelpers.clickelement(checkboxes.get(2));

		logger.info("invoice no... selected");

		TestHelpers.inputdate(shippingDate, props.getProperty("shipping_Date"));
		logger.info("Shipping date added");

		TestHelpers.addtext(shipping_mode, props.getProperty("shippingMode"));

		String text = TestHelpers.randomeNum();
		TestHelpers.addtext(RefNo, text);
		System.out.println(text);
		logger.info("Random Reference no added");

		TestHelpers.addtext(ConName, props.getProperty("ConName"));

		TestHelpers.addtext(RefConNo, props.getProperty("RefConNo"));

		TestHelpers.addtext(Desc, props.getProperty("Desc"));

		AttachFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");

		TestHelpers.clickelement(Submitbtns.get(1));

		logger.info("submit");

		/*
		 * TestHelpers.clickelement(Closebtns.get(1));
		 * 
		 * logger.info("cancel");....For canceling page
		 */

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

		boolean res = driver.getPageSource().contains("Invoice has been submitted successfully!");

		if (res == true) {

			Assert.assertTrue(true);
			logger.info("test case passed....Invoice has been submitted successfully!");
			TestHelpers.addtext(Searchbtn, refno);
			logger.info("test case passed....Searching Invoice no. display");

		} else {

			Assert.assertTrue(false);
			logger.info("test case passed..Invoice with this invoice no is already exist!");

			// TestHelpers.addtext(Searchbtn, refno);//if particular invoice searched
		}

	}

	public void View_MarkAsDelivered_Delete(String refno) {

		WebElement msg = driver.findElement(By.xpath(
				"/html/body/app-root/app-admin/div/div/app-pushinvoices/div/app-card/div/div[2]/div/div[3]/table/tbody/tr/td[5]"));
		String text1 = msg.getText();

		if (refno.equals(text1)) {
			System.out.println("Reference no is same ");
		} else {
			System.out.println("Reference no not exist");
		}

		TestHelpers.clickelement(Viewbtns.get(0));

		logger.info("View submitted Invoice");

		TestHelpers.clickelement(Closebtn.get(10));

		logger.info("close Invoice");

		TestHelpers.clickelement(MarkasDelivered.get(0));

		TestHelpers.clickelement(Markdelivered);

		logger.info("  Invoice delivered");
		try {
			TestHelpers.clickelement(Delbtns);

		} catch (Exception e) {
			TestHelpers.clickelement(Delbtns);
		}

		TestHelpers.clickelement(Removebtn);

		logger.info(" submitted Invoice deleted");

	}

}
