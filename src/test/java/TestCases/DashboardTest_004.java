package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.DashboardPage;
import pages.Homepage;
import pages.InvoicePage;
import pages.LoginPage;

public class DashboardTest_004 extends TestSetUp{

		LoginPage loginPage;
		Homepage homePage;
		InvoicePage invoicepage;
		BasePage basepage;
		DashboardPage dashboardpage;
		
		public DashboardTest_004() {

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
			dashboardpage=new DashboardPage();

		}
		
		@Test
		public void logout() {
			
			dashboardpage.lagoutTrackpayout();
		}

		@Test
		public void profile() {
			dashboardpage.profile();
		}
		
		@Test
		public void searchinvoice() {
			invoicepage=new InvoicePage();
			String text1=invoicepage.AddUnPaidInvoice();
			dashboardpage=new DashboardPage();

			dashboardpage.searchicon(text1);
			dashboardpage.Verify_searchInvoice(text1);
		}
		
		@AfterMethod
		public void tearDown() {

			driver.quit();

		}

		
}
