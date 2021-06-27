package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ByAgeingReportsPage extends TestSetUp {

	@FindBy(id = "ageing_type")
	WebElement SelAgeingtype;

	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/app-ageing/div/app-card/div/div[2]/div/div[1]/div[2]/span")
	WebElement Report;

	public ByAgeingReportsPage() {

		PageFactory.initElements(driver, this);
	}

	public void AgeingReportsByamount() {

		TestHelpers.selectByIndex(SelAgeingtype, 1);

		try {
			TestHelpers.clickelement(Report);

		} catch (Exception e) {
			TestHelpers.clickelement(Report);
		}
		
		logger.info("Ageing reports by Amount ");
	}

	public void AgeingReportsByInvoices() {

		TestHelpers.selectByIndex(SelAgeingtype, 2);

		TestHelpers.clickelement(Report);
		
		logger.info("Ageing reports by Invoices");
	}
}
