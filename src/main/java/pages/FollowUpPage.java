package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class FollowUpPage extends TestSetUp{
	

	@FindBy(id = "searchQuery")
	WebElement Search;
	
	@FindBy(xpath = "//div[@id='automatedFollowUps']")
	WebElement automated;
	
	@FindBy(xpath = "//div[@id='handledFollowUps']")
	WebElement handled;
	
	@FindBy(xpath="//li[@class='nav-item ng-star-inserted'][2]")//xpath
	WebElement Domorefollowup;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/button[1]")
	WebElement Call;
	
	@FindBy(xpath = "//button[contains(text(),'REQUEST MONTHLY REPORT')]")
	WebElement Reqmonreport;
	
	@FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
	WebElement selinv;
	
	@FindBy(xpath = "//div[@class='ng-option ng-star-inserted'and @id]")
	WebElement selopt;
	
	@FindBy(xpath = "//textarea[@id='remark']")
	WebElement Remark;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement subbtn;
	
	@FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-call[1]/div[1]/button[1]")
	WebElement Canbtn;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/button[1]")
	WebElement sms;
	
	@FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-sms[1]/div[1]/button[1]")
	WebElement Cancelsms;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]/button[1]")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='cc']")
	WebElement CCmail;
	
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	WebElement sendbtn;
	
	@FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]/app-email[1]/div[1]/button[1]")
	WebElement cancelbtn;
	
	public FollowUpPage() {

		PageFactory.initElements(driver, this);
	}

	public void FollowUpHistory() {
		
		TestHelpers.addtext(Search,"balaji enterprisess");
		

	    TestHelpers.clickelement(automated);
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
	
	public void call() {
		
		TestHelpers.clickelement(Call);
		logger.info("call");
		
		try {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();

		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		}
		
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='ng-option ng-star-inserted'and @id]"));
	    for (int i = 0; i < element.size(); i++) {
	        String temp = element.get(i).getText();
	        element.get(i).click();
	    break;
	    }
		logger.info("select Invoice");
		driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		TestHelpers.addtext(Remark, TestHelpers.randomestring());
		TestHelpers.clickelement(subbtn);
		
		logger.info("Submit call");

		TestHelpers.clickelement(Canbtn);
		logger.info("Submit call");
		
	}
	
	public void SMS() {
		TestHelpers.clickelement(sms);
		logger.info("click sms");
		
		try {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();

		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		}
		
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='ng-option ng-star-inserted'and @id]"));
	    for (int i = 0; i < element.size(); i++) {
	        String temp = element.get(i).getText();
	        element.get(i).click();
	    break;
	    }
	   
		logger.info("select Invoice");
		
		driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		TestHelpers.addtext(Remark, TestHelpers.randomestring());
		TestHelpers.clickelement(subbtn);
		logger.info("Submit SMS");

		TestHelpers.clickelement(Cancelsms);
		logger.info("Cancel sms popup");
	}
	
	public void Email() {
		TestHelpers.clickelement(Email);
		logger.info("email");
		try {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();

		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		}
		
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='ng-option ng-star-inserted'and @id]"));
	    for (int i = 0; i < element.size(); i++) {
	        String temp = element.get(i).getText();
	        element.get(i).click();
	    break;
	    }
		logger.info("select Invoice");
		driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
		logger.info("select Invoice");
		TestHelpers.addtext(CCmail, TestHelpers.randomestring()+"@gmail.com");
		TestHelpers.addtext(Remark, TestHelpers.randomestring());
		TestHelpers.clickelement(sendbtn);
		TestHelpers.clickelement(cancelbtn);
		logger.info("Submit mail");
	}
	
	public void RequestMonthlyReport() {
		try {
			TestHelpers.clickelement(Reqmonreport);

		} catch (Exception e) {
			TestHelpers.clickelement(Reqmonreport);
		}
		WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'Mail Sent successfully!')]"));
        String text=msg.getText();
        String expectedText = "Mail Sent successfully!";
        Assert.assertEquals(text,expectedText);

		logger.info("Request Monthly Report");
	}
	
}
