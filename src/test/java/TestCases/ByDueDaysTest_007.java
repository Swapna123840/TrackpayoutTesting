package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.ByDueDaysPages;
import pages.InvoicePage;
import pages.LoginPage;

public class ByDueDaysTest_007 extends TestSetUp {

	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	ByDueDaysPages byduedayspage;

	ByDueDaysTest_007() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.clickonReport();

		basepage.ClickByDueDays();

		byduedayspage = new ByDueDaysPages();

	}

	@Test
	public void TodaysPayment() {

		basepage.ClickTodaysPay();
		byduedayspage.TodaysPayment();

	}

	@Test
	public void Click15dayspay() {

		basepage.Click15days();
		byduedayspage.Click15days();
	}

	@Test
	public void Click30dayspay() {

		basepage.Click30days();
		byduedayspage.Click30days();

	}

	@Test
	public void Click60dayspay() {

		basepage.Click60days();
		byduedayspage.Click60days();

	}

	@Test
	public void Click90dayspay() {

		basepage.Click90days();
		byduedayspage.Click90days();
	}

	@Test
	public void ClickTooFardayspay() {

		basepage.ClickTooFar();
		byduedayspage.ClickTooFardays();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
