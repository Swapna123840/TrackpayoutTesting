package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;
import pages.UnpaidInvoicesPage;

public class UnpaidInvoicesTest_006 extends TestSetUp {

	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allInvoicepage;
	UnpaidInvoicesPage unpaidinvoicespage;

	UnpaidInvoicesTest_006() {

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
	public void searchUnpaidInvoice() {

		invoicepage = new InvoicePage();

		String invno = invoicepage.AddUnPaidInvoice();
		logger.info("Unpaid invoice added ");

		// driver.navigate().refresh();

		basepage.clickonReport();

		logger.info("Unpaid invoice added ");

		basepage.clickonAllInvoice();

		logger.info("All Invoices page displayed ");

		allInvoicepage = new AllInvoicePage();

		allInvoicepage.searchallinvoice(invno);

		logger.info("Added invoice is searched ");

		/*
		 * allinvoicepage.Report_Download();
		 * 
		 * logger.info("Report download ");
		 */

		
		driver.navigate().refresh();
		
		basepage.clickonReport();

		basepage.ClickUnpaidInvoices();

		unpaidinvoicespage = new UnpaidInvoicesPage();

		unpaidinvoicespage.searchUnpaidinvoice(invno);
		
		logger.info("search paidinvoice ");
		
		unpaidinvoicespage.view_Edit_Delete_UnPaidinvoice();
		logger.info("view,delete,edit unpaidinvoice ");

	}

	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
