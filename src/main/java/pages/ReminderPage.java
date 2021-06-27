package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class ReminderPage extends TestSetUp {

	@FindBy(xpath = "//a[@id='tab2']")
	WebElement enablereminder;

	@FindBy(xpath = "	//tbody/tr[1]/td[9]/a[1]/i[1]")
	WebElement DisReminder;

	@FindBy(xpath = "//a[@id='tab1']")
	WebElement DisabledReminder;


	public ReminderPage() {

		PageFactory.initElements(driver, this);

	}

	public String EnableReminder() {
		
		try {
			TestHelpers.clickelement(enablereminder);

		} catch (Exception e) {
			TestHelpers.clickelement(enablereminder);
		}
		logger.info("Enabled Reminder page display");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"tab2-panel\"]/div/table/tbody/tr/td[5]"));
		String strText = element.getText();
		System.out.println(""+strText);
		
		try {
			TestHelpers.clickelement(DisReminder);

		} catch (Exception e) {
			TestHelpers.clickelement(DisReminder);
		}

		TestHelpers.clickelement(DisabledReminder);
		logger.info("Disabled reminder page displayed");
		
		return strText;
	}

	public void reminderverify(String strText) {
		
	driver.navigate().refresh();
		List<WebElement> element1 = driver.findElements(By.xpath("//*[@id=\"tab1-panel\"]/div/table/tbody/tr/td[5]"));
		for (int i = 0; i < element1.size(); i++) {
			String temp = element1.get(i).getText();
			if (temp.equals(strText)) {

				element1.get(i).getText();
				System.out.println("The expected text is same as actual text --- " + temp);
				break;
			}

			else {
				System.out.println("The expected text doesn't match the actual text --- " + temp);
			}
		}
			
		}

	}
