package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.Homepage;
import pages.InvoicePage;
import pages.LoginPage;

public class InvoicePagetest_002 extends TestSetUp {

	LoginPage loginPage;
	Homepage homePage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allinvoicepage;

	public InvoicePagetest_002() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		loginPage.login();
		
		basepage = new BasePage();
		
		basepage.clickOnInvoice();
		
		logger.info("Invoice page is displayed");


	}

	@Test
	public void ClickAddInvoice()  {

		invoicepage = new InvoicePage();
		
		invoicepage.AddInvoice();
		logger.info("invoice added ");
		
		driver.navigate().refresh();
		
		basepage.clickonReport();
		
		basepage.clickonAllInvoice();
		
		logger.info("All Invoices page displayed ");

		allinvoicepage = new AllInvoicePage();
		
		allinvoicepage.searchallinvoice();
		
		logger.info("Added invoice is searched ");


	}

	//For tally.......................
	/*@Test
	public void AddAttachments() {

		invoicepage = new InvoicePage();
		
		invoicepage.chooseAttachment();

		logger.info("Attachment is added ");

	}
*/
	@Test
	public void BulkUploadFile() {

		invoicepage = new InvoicePage();

		invoicepage.BulkUpload();
		
		logger.info("Download bulk upload file ");
		
		driver.navigate().refresh();
		
		basepage.clickonReport();
		
		basepage.clickonAllInvoice();
		
		logger.info("All Invoices page displayed ");

		allinvoicepage = new AllInvoicePage();
		
		allinvoicepage.searchallinvoice();
		
		logger.info("Added invoice is searched ");

	}


	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
