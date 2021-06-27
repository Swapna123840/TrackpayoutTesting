package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;
import pages.PaidInvoicesPage;

public class PaidInvoicesTest_005 extends TestSetUp {

	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	PaidInvoicesPage paidinvoicespage;
	AllInvoicePage allinvoicepage;

	PaidInvoicesTest_005() {

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

	public void verifyInvoice() {

		invoicepage = new InvoicePage();

		String invno = invoicepage.AddPaidInvoice();
		logger.info("paiinvoice added ");

		driver.navigate().refresh();
		
		basepage.clickonReport();

		basepage.clickonAllInvoice();

		logger.info("All Invoices page displayed ");

		allinvoicepage = new AllInvoicePage();

		allinvoicepage.searchallinvoice(invno);

		allinvoicepage.Verify_AllInvoice_SearchInvoice(invno);

		logger.info("Added invoice is searched ");

		allinvoicepage.Report_Download();

		logger.info("Report download ");

		allinvoicepage.ViewAllInvoice();

		logger.info("view All Invoice ");

		allinvoicepage.downloadAttachment();

		logger.info("Download Attachment ");

		basepage.ClickPaidInvoices();
		
		paidinvoicespage = new PaidInvoicesPage();

		paidinvoicespage.searchpaidinvoice(invno);

		logger.info("searched paid invoice");

		paidinvoicespage.Verify_SearchInvoice(invno);

		paidinvoicespage.view_download_Paidinvoice();

		logger.info("View & Download Paid Invoice");

		paidinvoicespage.Report_Download();
		
		logger.info("Paid Invoice Report download");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
