package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class UnpaidInvoicesPage extends TestSetUp {

	@FindBy(xpath = "//input[@placeholder='From Date']")
	WebElement From_dt;

	@FindBy(xpath = "//input[@placeholder='To Date']")
	WebElement To_dt;

	@FindBy(xpath = "//input[@placeholder='Search here']")
	WebElement searchbtn;

	@FindBy(xpath = "//td[@class='expired-date']/ancestor::tbody")
	WebElement DueDt;

	@FindBy(xpath = "//a[@title='View']/i[@class='feather icon-eye']")
	WebElement viewbtn;

	@FindBy(xpath = "//button[@class='close']")
	WebElement closebtn;

	@FindBy(xpath = "//a[@title='Download Attachments']/i")
	List<WebElement> downatts;

	@FindBy(xpath = "//a[@title='Cancel Invoice']")
	List<WebElement> CancelInv;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement RemInv;

	@FindBy(xpath = "//tbody/tr[1]/td[11]/a[2]")
	WebElement Editbutton;

	@FindBy(id = "invoice_amount")
	WebElement Inv_amount;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Submit')]")
	WebElement Edisubmit;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkAlert;

	public UnpaidInvoicesPage() {

		PageFactory.initElements(driver, this);
	}

	public void searchUnpaidinvoice(String invno) {

		TestHelpers.enterdate(From_dt, props.getProperty("Fromdt"));

		TestHelpers.enterdate(To_dt, props.getProperty("Todt"));

		TestHelpers.addtext(searchbtn, invno);

	}

	public void invisibilityofinvoice(String invno) {
		TestHelpers.addtext(searchbtn, invno);
		try {
			driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));

		} catch (Exception e) {
			System.out.println(" No such Invoice no. present");
		}

	}

	public void view_Edit_Delete_UnPaidinvoice() {

		TestHelpers.clickelement(viewbtn);

		logger.info("View paid invoice");

		TestHelpers.clickelement(closebtn);

		logger.info("close paid invoice");

		try {
			TestHelpers.clickelement(Editbutton);

		} catch (Exception e) {
			TestHelpers.clickelement(Editbutton);
		}

		TestHelpers.addtext(Inv_amount, "79328");

		// TestHelpers.addtext(PayDescription, "Test");

		TestHelpers.clickelement(Edisubmit);

		TestHelpers.clickelement(OkAlert);

		try {

			TestHelpers.clickelement(downatts.get(0));

		} catch (Exception e) {

			TestHelpers.clickelement(downatts.get(0));
		}

		logger.info("download attachment");

		try {
			TestHelpers.clickelement(CancelInv.get(0));

		} catch (Exception e) {
			TestHelpers.clickelement(CancelInv.get(0));
		}

		TestHelpers.clickelement(RemInv);

		logger.info("Invoice has been removed successfully!");
	}

	public void invcancel(String invno) {

		boolean hasNextPage = true;

		while (hasNextPage) {
			List<WebElement> enabled_next_page_btn = driver
					.findElements(By.xpath("//li[@class='pagination-next ng-star-inserted']/a"));
			List<WebElement> disabled_next_page_btn = driver
					.findElements(By.xpath("//li[@class='pagination-next ng-star-inserted disabled']"));

			if (enabled_next_page_btn.size() > 0) {
				enabled_next_page_btn.get(0).click();
				hasNextPage = true;
				List<WebElement> element = driver.findElements(By.xpath(
						"//body[1]/app-root[1]/app-admin[1]/div[1]/div[1]/app-canceled[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr/td[5]"));
				for (int i = 0; i < element.size(); i++) {
					String temp = element.get(i).getText();
					if (temp.equals(invno)) {

						element.get(i).getText();
						System.out.println("The expected text is same as actual text --- " + temp);
						break;
					}

					else {
						System.out.println("The expected text doesn't match the actual text --- " + temp);
					}
				}
			} else if (disabled_next_page_btn.size() > 0) {
				System.out.println("No more Pages Available");
				break;
			}
		}

		logger.info("Cancel Invoice searched ");

	}

}
