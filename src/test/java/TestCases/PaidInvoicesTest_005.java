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
			
			String invno=invoicepage.AddUnPaidInvoice();
			logger.info("Unpaiinvoice added ");
			
			basepage.clickonReport();
			
			basepage.clickonAllInvoice();
			
			logger.info("All Invoices page displayed ");

			allinvoicepage = new AllInvoicePage();
			
			allinvoicepage.searchallinvoice(invno);
			
			
			logger.info("Added invoice is searched ");

		//	allinvoicepage.Report_Download();
			
			logger.info("Report download ");

			
			allinvoicepage.View_Edit_Delete_Invoice();
			
			logger.info("view,edit,delete invoice");

		//	driver.navigate().refresh();
			
			//basepage.clickonReport();

			basepage.ClickPaidInvoices();
			paidinvoicespage=new PaidInvoicesPage();
			
			paidinvoicespage.searchpaidinvoice(invno);
			
			logger.info("searched paid invoice");
		}
		
		@AfterMethod
		public void tearDown() {

			driver.quit();

		}
	}


