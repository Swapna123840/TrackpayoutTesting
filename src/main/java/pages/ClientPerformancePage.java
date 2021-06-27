package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ClientPerformancePage extends TestSetUp {
	@FindBy(xpath = "//div[@id='automatedFollowUps']")
	WebElement avgper;
	
	@FindBy(xpath = "//div[@id='allFollowUps']")
	WebElement Goodperf;
	
	@FindBy(xpath = "//h5[@id='handledHeading']")
	WebElement belowavg;
	
	
	@FindBy(xpath = "//a[@id='tab2']")
	WebElement Outstanding;
	
	
	public ClientPerformancePage() {

		PageFactory.initElements(driver, this);

	}
	
	public void clientbelowavg() {
		
		
		TestHelpers.clickelement(avgper);

		TestHelpers.clickelement(belowavg);
		logger.info("Below Average performance");
		
		TestHelpers.clickelement(Goodperf);
		logger.info("good performance");
	}
	
	public void outstanding() {
		TestHelpers.clickelement(Outstanding);
		logger.info("Outstanding");
	}
}
