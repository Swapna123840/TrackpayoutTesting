package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.Homepage;
import pages.InvoiceSubmissionPage;
import pages.LoginPage;

public class InvoiceSubmission_003 extends TestSetUp {

	LoginPage loginPage;
	BasePage basepage;
	InvoiceSubmissionPage invsub;
	
	public InvoiceSubmission_003() {

		super();

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		loginPage.login();

	}

	@Test
	public void SubmitInvoiceBtn() throws InterruptedException {
		
		basepage=new BasePage();
		
		basepage.InvoiceSubmission();
		
		invsub=new InvoiceSubmissionPage();
		
		String refno=invsub.ClickSubmitInvoicebtn();
		
		invsub.search(refno);
		
		invsub.View_MarkAsDelivered_Delete(refno);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
