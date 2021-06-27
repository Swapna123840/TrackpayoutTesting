package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class InvCancelationReportPage extends TestSetUp{
	
@FindBy(xpath="/div/app-card/div/div[2]/div/div[1]/div[2]/span")
WebElement DownReport;

	public InvCancelationReportPage() {

		PageFactory.initElements(driver, this);


	}
	
	public void DownloadInvCancelReport() {
		
		try {
			TestHelpers.clickelement(DownReport);

		} catch (Exception e) {
			TestHelpers.clickelement(DownReport);
		}
	}

	
	
}
