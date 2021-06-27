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
		
		basepage.AccountManager();

		
		administratorpage = new AdministratorPage();

	}

	@Test
	public void AddAccounManager() {

		
		administratorpage.AddAccountManager();
	}

	@Test
	public void AddBankDetails() {
		
		basepage.BankDetails();
		
		String texts=administratorpage.Bankdetails();
		
		administratorpage.Edit_Delete(texts);

	}
	
	@Test
	public void Addcategory() throws InterruptedException {
		
		basepage.Category();
		
		String texts=administratorpage.ADDCategory();//deleted message not display
		
		administratorpage.Edit_Delete_Category(texts);
	}
	
	@Test
	public void AddCustomers() {
		
		basepage.Customer();
		
		String texts=administratorpage.ADDCustomer();
		
		//administratorpage.Edit_Delete_Customer(texts);
	}
	
	@Test
	public void AddUser() {
		
		basepage.User();
		
		String texts=administratorpage.ADDUser();
		
		administratorpage.Edit_Delete_User(texts);
		//administratorpage.EditChangepswd();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
