package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class BasePage extends TestSetUp {

	@FindBy(xpath = "//span[contains(text(),'Report')]")
	WebElement ClickReport;

	@FindBy(xpath = "//a[@href='#/trackpayout/report/all']")
	WebElement AllInvoice;

	@FindBy(xpath = "//a[@href ='#/trackpayout/invoice/create' and @class='nav-link']")
	WebElement Invoice;

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

	public BasePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnInvoice() {

		TestHelpers.clickelement(Invoice);

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

		TestHelpers.clickelement(AllInvoice);

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

	public void Click15days() {

		TestHelpers.clickelement(Days_15);

	}

	public void Click30days() {

		TestHelpers.clickelement(Days_30);

	}

	public void Click60days() {

		TestHelpers.clickelement(Days_60);
	}

	public void Click90days() {

		TestHelpers.clickelement(Days_90);

	}

	public void ClickTooFar() {

		TestHelpers.clickelement(TooFar);

	}

}
