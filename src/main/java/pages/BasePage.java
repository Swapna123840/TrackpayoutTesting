package pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class BasePage extends TestSetUp {

	@FindBy(xpath = "//span[contains(text(),'Report')]") // xpath issue
	WebElement ClickReport;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/all']")
	WebElement AllInvoice;

	@FindBy(xpath = "//a[@href ='#/trackpayout/invoice/create' and @class='nav-link']")
	WebElement Invoice;

	@FindBy(xpath = "//a[@href='#/trackpayout/invoice/create']")
	List<WebElement> Invoices;

	@FindBy(xpath = "//span[contains(text(),'Invoice Submission')]")
	WebElement InvSubmission;

	@FindBy(xpath = "//a[contains(text(),'Paid Invoices')]")
	WebElement PaidInvoices;

	@FindBy(xpath = "//a[contains(text(),'Update Payment')")
	WebElement UpdatePayment;

	@FindBy(xpath = "//a[contains(text(),'Unpaid Invoices')]")
	WebElement UnpaidInvoices;

	@FindBy(xpath = "//span[contains(text(),'By Due Days')]")
	WebElement ByDueDays;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/byduedays/todays']/parent::li[@class='ng-star-inserted active']")
	WebElement TodaysPayment;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/byduedays/todays']")
	List<WebElement> TodaysPayments;

	@FindBy(xpath = "//a[contains(text(),'15 Days')]")
	WebElement Days_15;

	@FindBy(xpath = "//a[contains(text(),'30 Days')]")
	WebElement Days_30;

	@FindBy(xpath = "//a[contains(text(),'60 Days')]")
	WebElement Days_60;

	@FindBy(xpath = "//a[contains(text(),'90 Days')]")
	WebElement Days_90;

	@FindBy(xpath = "//a[contains(text(),'Too Far')]")
	WebElement TooFar;

	@FindBy(xpath = "//span[contains(text(),'By Masters')]")
	WebElement ByMasters;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/bymasters/acmanager']")
	WebElement ByAccMangr;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/bymasters/category']")
	List<WebElement> ByCategory;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/report/bymasters/customer\"]")
	WebElement ByCustomer;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/report/bymasters/location\"]")
	WebElement ByLocation;

	@FindBy(xpath = "//a[@class='nav-link' and @href='#/trackpayout/report/ageing']")
	WebElement ByAgeingReports;

	@FindBy(xpath = "//span[contains(text(),'Follow Up')]")
	WebElement FollowUp;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/clients\"]")
	List<WebElement> ClientPerformance;

	@FindBy(xpath = "//span[contains(text(),'Administrator')]")
	WebElement Administrator;

	@FindBy(xpath = "//a[@href='#/trackpayout/administrator/acmanager']")
	WebElement AccountMgr;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/administrator/bankdetails\"]")
	WebElement Bankdetails;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/administrator/category\"]")
	WebElement Category;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/administrator/customer\"]")
	WebElement Customer;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/administrator/user\"]")
	WebElement User;

	@FindBy(xpath = "//a[@class='nav-link ng-tns-c114-7']//span[@class='pcoded-micon ng-tns-c114-7 ng-star-inserted']")
	List<WebElement> Log;

	@FindBy(xpath = "//span[contains(text(),'Log ')]")
	WebElement los;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/log/all\"]")
	WebElement logs;

	@FindBy(xpath = "//a[@href=\"#/trackpayout/log/byuser\"]")
	List<WebElement> logbyuser;

	public BasePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnInvoice() {

		// TestHelpers.clickelement(Invoice);

		TestHelpers.clickelement(Invoices.get(0));

		// return new InvoicePage();// create object of invoicepage
	}

	public void InvoiceSubmission() {

		TestHelpers.clickelement(InvSubmission);

	}

	public void clickonReport() {

		TestHelpers.clickelement(ClickReport);

		Actions actions = new Actions(driver);

		actions.moveToElement(ClickReport).click().perform();
	}

	public void clickonAllInvoice() {

		try {
			TestHelpers.clickelement(AllInvoice);

		} catch (Exception e) {
			TestHelpers.clickelement(AllInvoice);
		}

	}

	public void ClickPaidInvoices() {

		TestHelpers.clickelement(PaidInvoices);

	}

	public void ClickUpdatePayment() {

		TestHelpers.clickelement(UpdatePayment);

	}

	public void ClickUnpaidInvoices() {

		TestHelpers.clickelement(UnpaidInvoices);

	}

	public void ClickByDueDays() {

		TestHelpers.clickelement(ByDueDays);

	}

	public void ClickTodaysPay() {

		TestHelpers.clickelement(TodaysPayments.get(0));

	}

	public void Click15days() {

		TestHelpers.clickelement(Days_15);

	}

	public void Click30days() {

		TestHelpers.scrollheight(Days_30);

		TestHelpers.clickelement(Days_30);
	}

	public void Click60days() {
		TestHelpers.scrollheight(Days_60);

		TestHelpers.clickelement(Days_60);
	}

	public void Click90days() {
		TestHelpers.scrollheight(Days_90);

		TestHelpers.clickelement(Days_90);

	}

	public void ClickTooFar() {

		TestHelpers.scrollheight(TooFar);

		TestHelpers.clickelement(TooFar);

	}

	public void ByMastersdrop() {

		TestHelpers.clickelement(ByMasters);

	}

	public void ByAccMgr() {

		try {

			TestHelpers.clickelement(ByAccMangr);

		} catch (Exception e) {

			TestHelpers.clickelement(ByAccMangr);
		}

	}

	public void ByCategory() {

		TestHelpers.clickelement(ByCategory.get(0));

	}

	public void ByCustomer() {

		TestHelpers.scrollheight(ByCustomer);

		TestHelpers.clickelement(ByCustomer);
	}

	public void ByLocation() {

		TestHelpers.scrollheight(ByLocation);

		TestHelpers.clickelement(ByLocation);
	}

	public void ByAgeingReports() {

		TestHelpers.scrollheight(ByAgeingReports);

		TestHelpers.clickelement(ByAgeingReports);

	}

	public void FollowUp() {

		TestHelpers.clickelement(FollowUp);

	}

	public void ClientPerformance() {

		TestHelpers.clickelement(ClientPerformance.get(0));

	}

	public void Administrator() {

		TestHelpers.clickelement(Administrator);

	}

	public void AccountManager() {

		TestHelpers.clickelement(AccountMgr);

	}

	public void BankDetails() {

		TestHelpers.clickelement(Bankdetails);
	}

	public void Category() {

		TestHelpers.clickelement(Category);
	}

	public void Customer() {

		TestHelpers.clickelement(Customer);
	}

	public void User() {

		TestHelpers.scrollheight(User);

		TestHelpers.clickelement(User);
	}

	public void logs() {

		// TestHelpers.scrollheight(Log.get(0));
		// TestHelpers.clickelement(Log.get(0));

		TestHelpers.scrollheight(los);

		TestHelpers.clickelement(los);

	}

	public void Logs() {

		TestHelpers.clickelement(logs);

	}

	public void LogbyUser() {

		TestHelpers.clickelement(logbyuser.get(0));

	}
}
