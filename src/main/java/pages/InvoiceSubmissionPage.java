package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class InvoiceSubmissionPage extends TestSetUp {
	
	@FindBy(xpath = "//button[contains(text(),'Submit Invoice')]")
	WebElement SubmitInvoice_btn;

	@FindBy(id = "customer_id")
	WebElement Customer;
	
	@FindBy(xpath = "//span[contains(text(),'Select Invoice No')]")
			WebElement SelInvoiceno;

	@FindBy(xpath = "//input[@id='shipping_date']/ancestor::form/div[2]/div[2]/input[1]")//xpath
	WebElement shippingDate;
	
	
	@FindBy(id = "shippingMode")
	WebElement shipping_mode;
	
	@FindBy(id = "lastName")
	WebElement RefNo;
	
	@FindBy(id = "contactName")
	WebElement ConName;
	
	@FindBy(id = "contact")
	WebElement RefConNo;
	
	@FindBy(id = "description")
	WebElement Desc;
	
	@FindBy(id = "files")	
	WebElement AttachFile;
	
	@FindBy(xpath = "//button[contains(text(), 'Close') and @xpath='1']//preceding-sibling::button")//xpath
	WebElement Submitbtn;
	
//	@FindBy(xpath = "//button[contains(text(), 'Submit') and @xpath='1']//following-sibling::button")//xpath
	//WebElement closebtn;
	@FindBy(xpath = "//button[contains(text(), 'Submit') and @xpath='1']//following-sibling::button")//xpath
	WebElement closebtn;

	
	@FindBy(xpath = "//input[@placeholder='Enter Keyword for filter result']")//xpath
	WebElement Searchbtn;
	
	@FindBy(xpath = "//a[@title='Delete']//parent::td[@xpath='1']")//xpath
	WebElement Deletebtn;
	
	public InvoiceSubmissionPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickSubmitInvoicebtn() {
		
		TestHelpers.clickelement(SubmitInvoice_btn);
		
		
		TestHelpers.selectByIndex(Customer, 1);
	   
	
			WebElement dateBox = shippingDate;

				dateBox.sendKeys(props.getProperty("shipping_Date"));

				dateBox.sendKeys(Keys.TAB);
		
		//TestHelpers.inputdate("shippingDate", props.getProperty("shipping_Date"));

		
		TestHelpers.addtext(shipping_mode, props.getProperty("shippingMode"));

		
		TestHelpers.addtext(RefNo, TestHelpers.randomeNum());

		TestHelpers.addtext(ConName, props.getProperty("ConName"));


		TestHelpers.addtext(RefConNo, props.getProperty("RefConNo"));

		TestHelpers.addtext(Desc, props.getProperty("Desc"));

		
	//TestHelpers.addtext(AttachFile, System.getProperty("user.dir") + "/src/main/resources/Report.csv");

	AttachFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/Report.csv");
	//TestHelpers.clickelement(closebtn);

	//	TestHelpers.clickelement(Submitbtn);

	//	TestHelpers.addtext(Searchbtn, props.getProperty("Searchkey"));
		
	//	TestHelpers.clickelement(Deletebtn);
	   //     Thread.sleep(5000);

	}
	
	}



