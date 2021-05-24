package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;

public class AllInvoiceTest_004 extends TestSetUp {

	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allinvoicepage;

	public AllInvoiceTest_004() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.clickonReport();

		basepage.clickonAllInvoice();

	}

	@Test
	public void verifyInvoice() throws InterruptedException {

		allinvoicepage = new AllInvoicePage();

		allinvoicepage.searchallinvoice();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	
}