package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ByAgeingReportsPage extends TestSetUp {

	@FindBy(id = "ageing_type")
	WebElement SelAgeingtype;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-ageing[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")
	WebElement Report;

	public ByAgeingReportsPage() {

		PageFactory.initElements(driver, this);
	}

	public void AgeingReportsByamount() {

		TestHelpers.selectByIndex(SelAgeingtype, 1);

		TestHelpers.clickelement(Report);
		
		logger.info("Ageing reports by Amount ");
	}

	public void AgeingReportsByInvoices() {

		TestHelpers.selectByIndex(SelAgeingtype, 2);

		TestHelpers.clickelement(Report);
		
		logger.info("Ageing reports by Invoices");
	}
}
