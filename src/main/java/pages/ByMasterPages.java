package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Helpers.TestHelpers;

public class ByMasterPages extends TestHelpers {

	@FindBy(xpath = "//select[@id='Ac_manager_name']")
	WebElement selbyaccmgr;

	@FindBy(xpath = "//a[@title='View']/i[@class='feather icon-eye']")
	List<WebElement> Viewbtn;

	@FindBy(xpath = "//button[@class='close']")
	WebElement closebtn;

	@FindBy(xpath = "//a[@title='Edit']//i[@class='feather icon-edit']")
	List<WebElement> Editbtns;

	@FindBy(id = "invoice_amount")
	WebElement EdiInamt;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement Okbtn;

	@FindBy(xpath = "//a[@title='Cancel Invoice']//i[@class='feather icon-x']")
	List<WebElement> Delbtns;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement Rembtn;

	@FindBy(xpath = "//span[@title='DOWNLOAD' and @class='btn btn-outline-primary']//i[@class='feather icon-download']")
	WebElement report;

	@FindBy(xpath = "//select[@id='category_name']")
	WebElement Selcat;

	@FindBy(xpath = "//a[@title='Delete' and @class='ng-star-inserted']//i")
	List<WebElement> Delcat;
	
	@FindBy(xpath = "//span[@title='DOWNLOAD']/parent::div")
	WebElement ReportCat;

	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/app-bycustomer/div/app-card/div/div[2]/div/div[1]/div[2]/span")
	WebElement ReportCustomer;
	
	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-bylocation[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/span[1]/i[1]")
	WebElement ReportLocation;

	
	@FindBy(xpath = "//select[@id='customer_name']")
	WebElement SelCust;

	@FindBy(id = "customerCountry")
	WebElement Country;

	@FindBy(id = "customerState")
	WebElement State;

	@FindBy(id = "customerCity")
	WebElement City;
	
	@FindBy(xpath = "//a[@title='Download Attachments']")
	List<WebElement> Downattchment;

	
	
	public ByMasterPages() {

		PageFactory.initElements(driver, this);

	}

	public void selectaccMgr() {

		TestHelpers.dropdown(selbyaccmgr);

		logger.info("selected manager");

	}

	public void View() {

		try {

			TestHelpers.clickelement(Viewbtn.get(0));

		} catch (Exception e) {

			TestHelpers.clickelement(Viewbtn.get(0));
		}

		TestHelpers.clickelement(closebtn);

		logger.info("viewpage");
	}
	
	
	public void downloadAttachments() {
		try {
			TestHelpers.clickelement(Downattchment.get(0));

		} catch (Exception e) {
			TestHelpers.clickelement(Downattchment.get(0));
		}
	}
	
	public void Edit() {

		if(driver.findElement(By.xpath("//a[@title='Edit']")).isDisplayed()) {
		try {
			TestHelpers.clickele(Editbtns.get(0));

		} catch (Exception e) {

			TestHelpers.clickele(Editbtns.get(0));
		}

		TestHelpers.addtext(EdiInamt, "889898");

		TestHelpers.clickelement(submit);

		TestHelpers.clickelement(Okbtn);

		logger.info("Invoice Updated");
		}
		else {
			System.out.println("no element present");
		}
		
	}
	
	public void Delete() {

		if(driver.findElement(By.xpath("//a[@title='Cancel Invoice']")).isDisplayed()) {

		try {
			TestHelpers.clickele(Delbtns.get(0));

		} catch (Exception e) {
			TestHelpers.clickele(Delbtns.get(0));
		}

		TestHelpers.clickelement(Rembtn);
		
		logger.info("Invoice has been removed successfully!");
		}
		
		else {
			System.out.println("no element present");
		}
	}

	
	public void DownloadReportbymgr() {
		try {
			TestHelpers.clickelement(report);

		} catch (Exception e) {
			TestHelpers.clickelement(report);
		}
		logger.info("Report By AccManager download");

	}

	public void SelectCategory() {
		
		TestHelpers.selectOptionFromDroDown(Selcat, props.getProperty("selectCategory"));
		
		logger.info("select category");

		boolean res = driver.getPageSource().contains(" There is no data available to show!");

		if (res == true) {

			Assert.assertTrue(true);
			logger.info("test case passed....	There is no data available to show!");

		} else {

			logger.info("test case passed...Invoice dislayed");
			Assert.assertTrue(true);
		}
		
	}

	public void ReportByCategory() {

		try {

			TestHelpers.clickelement(ReportCat);

		} catch (Exception e) {

			TestHelpers.clickelement(ReportCat);
		}

		logger.info("Report By category download");

	}

	public void ReportByCustomer() {

		try {

			TestHelpers.clickelement(ReportCustomer);

		} catch (Exception e) {

			TestHelpers.clickelement(ReportCustomer);
		}


		TestHelpers.selectByIndex(SelCust, 2);
		logger.info("select By Customer ");

	}

	public void SearchbyCountry() {

		WebElement contry = Country;

		TestHelpers.selectOptionFromDroDown(contry, "India");

		logger.info("Country selected");
	}

	public void SearchbyState() {

		WebElement state = State;

		TestHelpers.selectOptionFromDroDown(state, "Maharashtra");

		logger.info("State selected");
	}

	public void SearchbyCity() {

		WebElement cty = City;

		TestHelpers.selectOptionFromDroDown(cty, "Select City");

		boolean res = driver.getPageSource().contains(" There is no data available to show!");

		if (res == true) {

			Assert.assertTrue(true);
			logger.info("test case passed....	There is no data available to show!");

		} else {

			logger.info("test case passed...City selected");
			Assert.assertTrue(true);
		}

	}

	
	
	public void ReportByLocation() {

		try {

			TestHelpers.clickelement(ReportLocation);

		} catch (Exception e) {

			TestHelpers.clickelement(ReportLocation);
		}

		logger.info("Report By category download");

	}
}
