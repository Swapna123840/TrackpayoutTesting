package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AdministratorPage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LogPage;
import pages.LoginPage;

public class LogsTest_013 extends TestSetUp{
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	LogPage logpage;

	public LogsTest_013() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();
		basepage.logs();

		
		logpage = new LogPage();

	}

	@Test
	public void log() {
		basepage.Logs();
		logpage.logbydt();
	}
	
	@Test
	public void logbyuser() {
		basepage.LogbyUser();
		logpage.logbyuser();
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}