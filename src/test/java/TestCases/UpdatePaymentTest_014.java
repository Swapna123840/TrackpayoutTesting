package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;
import pages.UpdatePaymentPage;

public class UpdatePaymentTest_014 extends TestSetUp {
	
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	UpdatePaymentPage updatepaymentpage;
	
	UpdatePaymentTest_014() {
		
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.clickonReport();

		basepage.ClickUpdatePayment();
	}
	
	
	@Test
	
	public void CollectAmount() {
		
		updatepaymentpage=new UpdatePaymentPage();
		
		updatepaymentpage.collectAmount();
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}



