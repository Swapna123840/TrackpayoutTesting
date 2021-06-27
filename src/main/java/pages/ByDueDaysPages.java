package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ByDueDaysPages extends TestSetUp {

	@FindBy(xpath = "//a[@title='Edit']//i[@class='feather icon-edit']")
	List<WebElement> Editbtns;

	@FindBy(id = "invoice_amount")
	WebElement EdiInamt;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement Okbtn;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-duein15days[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/span[1]") // xpath
	WebElement download;

	@FindBy(xpath = "//tbody/tr[1]/td[12]/a[1]")
	WebElement views;

	@FindBy(xpath = "//strong[contains(text(),'Payment details')]")
	WebElement Paydetails;

	@FindBy(xpath = "//strong[contains(text(),'Payment Date details')]")
	WebElement Paydtdetails;

	@FindBy(xpath = "//button[@class='close']")
	WebElement close;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-duein30days[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	WebElement download30repo;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-duein60days[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	WebElement download60repo;

	@FindBy(xpath = "//textarea[@id='payment_type']")
	WebElement paydesc;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-duein90days[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	WebElement download90repo;

	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-toofar[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	WebElement downloadTooFarrepo;

	@FindBy(xpath = "//a[@title='Cancel Invoice' and @class='ng-star-inserted']")
	List<WebElement> CancelInv;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement Remove;

	
	public ByDueDaysPages() {

		PageFactory.initElements(driver, this);
	}

	public void TodaysPayment() {
		
		
		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
	
			
			TestHelpers.clickelement(views);
			logger.info("snbnd");

			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			TestHelpers.clickelement(download);

			logger.info("Download todays Report");

			TestHelpers.clickelement(Editbtns.get(0));

			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");
	
		} 

		
	}
		
	public void Click15days() {

		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
				
			TestHelpers.clickelement(views);
			logger.info("snbnd");

			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			try {
				TestHelpers.clickelement(download);

			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				TestHelpers.clickelement(download);

			}

			logger.info("Download todays Report");

			TestHelpers.clickelement(Editbtns.get(0));

			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");
			
			
			
			
		} 
	}

	

	public void Click30days() {

		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
			TestHelpers.clickelement(views);

			logger.info("sbdn");
			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			TestHelpers.clickelement(download30repo);

			logger.info("Download 30days Report");

			TestHelpers.clickelement(Editbtns.get(0));

			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");
		}

	}

	public void Click60days() {

		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
			TestHelpers.clickelement(views);

			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			TestHelpers.clickelement(download60repo);

			logger.info("Download 60days Report");

			TestHelpers.clickelement(Editbtns.get(0));

			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");

		}

		
	}

	public void Click90days() {

		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
			TestHelpers.clickelement(views);

			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			TestHelpers.clickelement(download90repo);

			logger.info("Download 90days Report");

			TestHelpers.clickelement(Editbtns.get(0));

			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");
		}
	}

	public void ClickTooFardays() {

		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
			TestHelpers.clickelement(views);

			TestHelpers.clickelement(Paydetails);

			TestHelpers.clickelement(Paydtdetails);

			TestHelpers.clickelement(close);

			logger.info("View Invoice");

			TestHelpers.clickelement(downloadTooFarrepo);

			logger.info("Download TooFar Report");

			try {
				TestHelpers.clickelement(Editbtns.get(0));

			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				TestHelpers.clickelement(Editbtns.get(0));

			}
			
			TestHelpers.addtext(EdiInamt, "889898");

			TestHelpers.clickelement(submit);

			TestHelpers.clickelement(Okbtn);

			logger.info("Invoice Updated");
			
			TestHelpers.clickele(CancelInv.get(0));
				
			TestHelpers.clickelement(Remove);
		}
	}
}
