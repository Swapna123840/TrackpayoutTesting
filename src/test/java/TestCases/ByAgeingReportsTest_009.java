package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.ByAgeingReportsPage;
import pages.InvoicePage;
import pages.LoginPage;

public class ByAgeingReportsTest_009 extends TestSetUp{
	
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allinvoicepage;
	ByAgeingReportsPage byageingreportspage;
	
	public ByAgeingReportsTest_009() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.clickonReport();

		basepage.ByAgeingReports();

	}

	@Test
	public void verifyInvoice()  {

		byageingreportspage = new ByAgeingReportsPage();

		byageingreportspage.AgeingReportsByamount();
		
		byageingreportspage.AgeingReportsByInvoices();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
