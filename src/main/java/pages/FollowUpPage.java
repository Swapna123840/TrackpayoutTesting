package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class FollowUpPage extends TestSetUp{
	

	@FindBy(id = "searchQuery")
	WebElement Search;
	
	@FindBy(xpath = "//div[contains(text(),'Automated Followups (95%)')]")
	WebElement automated;
	
	@FindBy(xpath = "//h5[@id='handledHeading']")
	WebElement handled;
	
	@FindBy(partialLinkText="Do More Followu")//xpath
	WebElement Domorefollowup;
	
	@FindBy(xpath = "//button[@class='btn btn-info btn-sm']//i[@class='feather icon-phone-call']")
	List<WebElement> Call;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement Reqmonreport;
	
	public FollowUpPage() {

		PageFactory.initElements(driver, this);
	}

	public void FollowUpHistory() {
		
		TestHelpers.addtext(Search,"balaji enterprisess");
		

	    TestHelpers.Actionclick(automated);
		logger.info("Automated Followup");
		
		try {
			TestHelpers.clickelement(handled);

		} catch (Exception e) {
			TestHelpers.clickelement(handled);
		}
		logger.info("Handled Followup");


	}
	
	public void DoMoreFollowUp() {
		
		try {
			TestHelpers.clickelement(Domorefollowup);
	
		} catch (Exception e) {
			TestHelpers.clickelement(Domorefollowup);
		}
		
	logger.info("do more followup");	

}
	public void RequestMonthlyReport() {
		
		TestHelpers.clickelement(Reqmonreport);
	}
	
	public void call() {
		
		TestHelpers.clickelement(Call.get(0));
	}
}
