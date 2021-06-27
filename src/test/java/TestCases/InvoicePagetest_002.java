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
import pages.PaidInvoicesPage;

public class InvoicePagetest_002 extends TestSetUp {

	LoginPage loginPage;
	Homepage homePage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allinvoicepage;
	PaidInvoicesPage paidinvoicepage;
	
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
		
		String invno=invoicepage.AddPaidInvoice();
		logger.info("invoice added ");
		
		driver.navigate().refresh();
		
		basepage.clickonReport();
		
		basepage.clickonAllInvoice();
		
		logger.info("All Invoices page displayed ");

		allinvoicepage = new AllInvoicePage();
		
		allinvoicepage.searchallinvoice(invno);
		
		
		logger.info("Added invoice is searched ");

		allinvoicepage.Report_Download();
		
		logger.info("Report download ");

		
		allinvoicepage.ViewAllInvoice();
		
		allinvoicepage.downloadAttachment();
		
		logger.info("view,download");

		driver.navigate().refresh();
		
		basepage.clickonReport();
		
		basepage.ClickPaidInvoices();
		
		paidinvoicepage=new PaidInvoicesPage();
		
		paidinvoicepage.searchpaidinvoice(invno);
		
		paidinvoicepage.view_download_Paidinvoice();
		
		logger.info("view,downloadpaidinvoice");

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
		
		allinvoicepage.searchallinvoice("213");
		
		logger.info("Added invoice is searched ");
		

	}

	
	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
