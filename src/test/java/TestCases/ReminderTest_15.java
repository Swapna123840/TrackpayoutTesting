package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.AllInvoicePage;
import pages.BasePage;
import pages.InvoicePage;
import pages.LoginPage;
import pages.ReminderPage;

public class ReminderTest_15 extends TestSetUp{
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	AllInvoicePage allinvoicepage;
	ReminderPage reminderpage;
	
	public ReminderTest_15() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.Reminderbtn();
		
		reminderpage=new ReminderPage(); 
	}
	
	
	
	@Test
	
	public void Reminder() {
		
		String strText=	reminderpage.EnableReminder();
		reminderpage.reminderverify(strText);
	}
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
	
}
