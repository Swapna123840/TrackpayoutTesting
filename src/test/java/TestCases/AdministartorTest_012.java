package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AdministratorPage;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;

public class AdministartorTest_012 extends TestSetUp {
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	AdministratorPage administratorpage;

	public AdministartorTest_012() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.Administrator();
		
		administratorpage = new AdministratorPage();

	}

	@Test
	public void AccounManager() {

		basepage.AccountManager();


		administratorpage.AddAccountManager();
	}

	@Test
	public void BankDetails() {
		basepage.BankDetails();
		administratorpage.Bankdetails();
	}
	
	@Test
	public void category() {
		basepage.Category();
		administratorpage.ADDCategory();
	}
	
	@Test
	public void Customers() {
		basepage.Customer();
		administratorpage.ADDCustomer();
	}
	
	@Test
	public void User() {
		basepage.User();
		administratorpage.ADDUser();
		administratorpage.EditChangepswd();
	}
	
	
	@Test
	public void log() {
		basepage.logs();
		basepage.Logs();
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
