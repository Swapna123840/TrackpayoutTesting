package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.FollowUpPage;
import pages.InvoicePage;
import pages.LoginPage;

public class FollowUp_010 extends TestSetUp{
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	FollowUpPage followuppage;

	public FollowUp_010() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.FollowUp();
		followuppage = new FollowUpPage();

		

	}

	@Test
	public void FollowupHistory()  {

		followuppage.FollowUpHistory();
	}
	
	@Test
	public void DoMoreFollowupCall()  {

		followuppage.DoMoreFollowUp();
		
		followuppage.call();
	}
	
	@Test
	public void DoMoreFollowupSMS()  {

		followuppage.DoMoreFollowUp();
		
		followuppage.SMS();
	}
	
	
	@Test
	public void DoMoreFollowupEmail()  {

		followuppage.DoMoreFollowUp();
		
		followuppage.Email();
	}
	@Test
	public void requestmonreport() {
		
		followuppage.RequestMonthlyReport();
	}
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	
}


