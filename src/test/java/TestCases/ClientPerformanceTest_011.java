package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.ClientPerformancePage;
import pages.InvoicePage;
import pages.LoginPage;

public class ClientPerformanceTest_011 extends TestSetUp {
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	ClientPerformancePage clientperformance;

	public ClientPerformanceTest_011() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.ClientPerformance();
		clientperformance = new ClientPerformancePage();


	}

	@Test
	public void Clientperformance()  {

		clientperformance.clientbelowavg();
	}


	@Test
	public void Outstanding()  {

		clientperformance.outstanding();
	}
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	
}


