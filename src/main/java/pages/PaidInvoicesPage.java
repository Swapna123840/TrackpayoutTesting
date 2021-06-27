package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class PaidInvoicesPage extends TestSetUp {

	@FindBy(xpath = "//input[@placeholder='From Date']")
	WebElement From_dt;

	@FindBy(xpath = "//input[@placeholder='To Date']")
	WebElement To_dt;

	@FindBy(xpath = "//input[@placeholder='Search here']")
	WebElement searchbtn;

	@FindBy(xpath = "//a[@title='View']/i[@class='feather icon-eye']")
	WebElement viewbtn;

	@FindBy(xpath = "//button[@class='close']")
	WebElement closebtn;

	@FindBy(xpath = "//a[@title='Download Attachments']/i")
	List<WebElement> downatts;

	@FindBy(xpath = "//span[@title='DOWNLOAD']/parent::div")
	WebElement ReportDownload;

	public PaidInvoicesPage() {

		PageFactory.initElements(driver, this);
	}

	public void searchpaidinvoice(String invno) {

		TestHelpers.enterdate(From_dt, props.getProperty("Fromdt"));

		TestHelpers.enterdate(To_dt, props.getProperty("Todt"));

		TestHelpers.addtext(searchbtn, invno);

		logger.info("search paid invoice");

	}

	public void Verify_SearchInvoice(String invno) {

		String searchInv = driver.findElement(By.xpath("//app-card[@cardtitle='Paid Invoices']//tbody/tr/td[5]"))
				.getText();

		if (invno.equalsIgnoreCase(searchInv)) {

			System.out.println("Added Invoice no. matched with searched invoice");
		} else {
			System.out.println("Added Invoice no. not  matched with searched invoice");

		}
	}

	public void view_download_Paidinvoice() {

		TestHelpers.clickelement(viewbtn);

		logger.info("View paid invoice");

		TestHelpers.clickelement(closebtn);

		logger.info("close paid invoice");

		try {

			TestHelpers.clickelement(downatts.get(0));

		} catch (Exception e) {

			TestHelpers.clickelement(downatts.get(0));
		}

		logger.info("download attachment");

	}

	public void Report_Download() {

		try {

			TestHelpers.clickelement(ReportDownload);

		} catch (Exception e) {

			TestHelpers.clickelement(ReportDownload);
		}

		logger.info("Report download");

	}

}
