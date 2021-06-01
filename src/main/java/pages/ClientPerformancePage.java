package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ClientPerformancePage extends TestSetUp {
	@FindBy(xpath = "//div[contains(text(),'Below Average Performance (60%)')]")
	WebElement belowavg;
	
	@FindBy(xpath = "//div[contains(text(),'Good Performance (40%)')]")
	WebElement Goodperf;
	
	
	@FindBy(xpath = "//a[@id='tab2']")
	WebElement Outstanding;
	
	
	public ClientPerformancePage() {

		PageFactory.initElements(driver, this);

	}
	
	public void clientbelowavg() {
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
