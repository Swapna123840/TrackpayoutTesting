package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class LogPage extends TestSetUp {
	@FindBy(id = "log_date")
	WebElement logdt;
	
	@FindBy(id = "user_id")
	WebElement userid;
	
	@FindBy(id = "log_date")
	WebElement log_dt;
	
	
	public LogPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void logbydt() {
		TestHelpers.addtext(logdt, "05/15/2021");
	}
	
	public void logbyuser() {
		TestHelpers.selectByIndex(userid, 1);
		TestHelpers.addtext(log_dt, "05/15/2021");

	}
}
