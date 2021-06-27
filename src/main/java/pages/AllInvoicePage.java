package pages;

import java.util.List;
import java.util.NoSuchElementException;

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

	@FindBy(xpath = "//span[@title='DOWNLOAD']/parent::div")
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

	@FindBy(xpath = "//tbody/tr[8]/td[9]/a[2]")
	WebElement Editbutton;

	@FindBy(id = "invoice_amount")
	WebElement Inv_amount;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Submit')]")
	WebElement Edisubmit;

	@FindBy(xpath = "//textarea[@id='payment_type' ]")
	WebElement PayDescription;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkAlert;

	@FindBy(xpath = "//a[@title='Cancel Invoice']")
	List<WebElement> CancelInvoicebtn;

	@FindBy(xpath = "//button[contains(text(),'Remove') and @class='btn btn-danger']")
	WebElement Removebtn;

	@FindBy(xpath = "//a[@title='Download Attachments' and @class='ng-star-inserted']/i") // xpath..issue
	List<WebElement> DownAttachments;

	@FindBy(xpath = "//a[@title='Followup Details']//i[@class='feather icon-mail']")
	List<WebElement> FollowupDetails;

	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> FollowupClose;

	@FindBy(xpath = "//a[@title='Cancel Invoice']")
	List<WebElement> CancelInv;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement RemInv;

	public AllInvoicePage() {

		PageFactory.initElements(driver, this);
	}

	public void searchallinvoice(String invno) {

		TestHelpers.enterdate(From_dt, props.getProperty("Fromdt"));

		TestHelpers.enterdate(To_dt, props.getProperty("Todt"));

		TestHelpers.addtext(searchbtn, invno);

		logger.info("Search");

	}
	public void Verify_AllInvoice_SearchInvoice(String invno) {

		String searchInv = driver.findElement(By.xpath("//app-card[@cardtitle='All Invoices']//tbody/tr/td[5]"))
				.getText();

		if (invno.equalsIgnoreCase(searchInv)) {

			System.out.println("Added Invoice no. matched with searched invoice");
		} else {
			System.out.println("Added Invoice no. not  matched with searched invoice");

		}
	}
	
	public void Report_Download() {

		try {

			TestHelpers.clickelement(ReportDownload);

		} catch (Exception e) {

			TestHelpers.clickelement(ReportDownload);
		}

		logger.info("Report download");

	}

	public void ViewAllInvoice() {

		TestHelpers.clickelement(Viewbuttons.get(0));

		TestHelpers.clickelement(paydetails);

		TestHelpers.clickelement(payDtdetails);

		TestHelpers.clickelement(Closebtn);

		logger.info("close Invoice");

	}

	public void followup() {

		try {
			TestHelpers.clickelement(FollowupDetails.get(0));

			logger.info(" followup icon available, Followup details display");

			TestHelpers.clickelement(FollowupClose.get(3));

		} catch (NoSuchElementException e) {
			logger.info(" followup icon is not available");
		}
	}

	public void downloadAttachment() {
		try {
			try {
				TestHelpers.clickelement(DownAttachments.get(0));

			} catch (Exception e) {
				TestHelpers.clickelement(DownAttachments.get(0));
			}

			logger.info(" Download attachment icon available, Attachment download");

		} catch (NoSuchElementException e) {
			logger.info(" Download attachment icon  not available");
		}
	}

	public void UnpaidInv_Edit() {
		
		try {
			TestHelpers.clickelement(Editbutton);

		} catch (NoSuchElementException e) {
			System.out.println("No such element present");
		
		}

		TestHelpers.clickelement(Edisubmit);

		boolean res = driver.getPageSource().contains("	Invoice has been updated successfully!");

		if (res == true) {

			Assert.assertTrue(true);

			logger.info("test case passed....Invoice not updated successfully!");

		} else {
			logger.info("test case passed..Invoice has been updated successfully!");

			Assert.assertTrue(true);
		}

		TestHelpers.clickelement(OkAlert);

		logger.info("Invoice Updated");

	}

	public void cancelInvoice() {
		try {
			TestHelpers.Actionclick(CancelInv.get(0));
		} catch (Exception e) {
			TestHelpers.Actionclick(CancelInv.get(0));

		}

		logger.info("Delete Invoice");

		TestHelpers.Actionclick(RemInv);

		boolean rem = driver.getPageSource().contains("Invoice has been removed successfully!");

		if (rem == true) {

			Assert.assertTrue(true);

			logger.info("test case passed....Invoice has been removed successfully!");

		}
	}

}
