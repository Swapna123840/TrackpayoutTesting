package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class UpdatePaymentPage extends TestSetUp {

	@FindBy(xpath = "//i[@class='feather icon-credit-card']/ancestor::tbody/child::tr[1]/child::td[6]/child::a[1]")
	WebElement collectamt;

	@FindBy(id = "paid_amount")
	WebElement Amount;

	@FindBy(id = "deduction_amount")
	WebElement DeductionAmt;

	@FindBy(id = "payment_date_updated")
	WebElement paymentdt;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement paynote;

	@FindBy(xpath = "//input[@type='checkbox']/ancestor::tbody")
	WebElement checkbox;

	@FindBy(id = "invoice")
	WebElement amtcheck;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelbtn;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitbtn;

	public UpdatePaymentPage() {

		PageFactory.initElements(driver, this);
	}

	public void collectAmount() {

		TestHelpers.clickelement(collectamt);

		TestHelpers.addtext(Amount, "54585");

		TestHelpers.addtext(DeductionAmt, "54585");

		TestHelpers.inputdates(paymentdt, props.getProperty("paymentdt"));

		TestHelpers.addtext(paynote, "Payment done");

		List<WebElement> check = driver.findElements(By.xpath("//input[@type='checkbox']"));
	
		for (int i = 0; i < check.size(); i++) {

			 check.get(i).click();//----for select all checkbox

			//check.get(i = 0).click();// -----for select single checkbox

			TestHelpers.addtext(amtcheck, "273737");
	
			break;

		}

		TestHelpers.clickelement(submitbtn);

		WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'Payment updated successfully!')]"));
        String text=msg.getText();
        String expectedText = "Payment updated successfully!";
        Assert.assertEquals(text,expectedText);

		
		
		TestHelpers.clickelement(cancelbtn);
		

		
	

	}
}
