package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class DashboardPage extends TestSetUp {
	@FindBy(xpath = "//ul/li[1]/marquee/a")
	WebElement Note;
	
	@FindBy(xpath = "//select[@class='custom-select']")
	WebElement SelYr;
	
	@FindBy(xpath = "//a[@title='Search invoices' and @class='pop-search']/i")
	WebElement searchicon;
	
	@FindBy(xpath = "//a[@href=\"#/trackpayout/profile\"]")
	WebElement Proicon;
	
	@FindBy(xpath = "//a[@title='Logout']/i")
	WebElement LogoutIcon;
	
	@FindBy(xpath = "	//span[@title='DOWNLOAD']")
	WebElement SummDownload;
	
	@FindBy(xpath = "//a[@href=\"#/trackpayout/report/ageing\"]")
	List<WebElement> summary;
	
	@FindBy(xpath = "//*[@id=\"profileModal\"]/div/div/div[1]/div[2]/div[3]/div[1]/div/button")
	WebElement Changepswd;
	
	@FindBy(id = "newPassword")
	WebElement newpswd;
	
	@FindBy(id = "confirmPassword")
	WebElement Confirmpswd;
	
	@FindBy(xpath = "//button[contains(text(),'Change Passoword')]")
	WebElement Changepswdbtn;
	
	@FindBy(xpath = "//a[@href=\"#/auth/signin\"]")
	WebElement closebtn;
	
	@FindBy(xpath = "	//input[@placeholder='Search here']")
	WebElement searchhere;
	
	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void lagoutTrackpayout() {
		
		TestHelpers.clickele(LogoutIcon);
		driver.switchTo().alert().accept();		
		logger.info("Login page displayed");
	}
	
	public void profile() {
		
		TestHelpers.clickele(Proicon);
		TestHelpers.clickele(Changepswd);
		TestHelpers.addtext(newpswd, "");
		TestHelpers.addtext(Confirmpswd, "");
		TestHelpers.clickelement(Changepswdbtn);
		TestHelpers.clickele(closebtn);
		
		logger.info("smd");
	}
	
	
	public void searchicon(String text1) {
	
		TestHelpers.clickele(searchicon);
		logger.info("Search invoice");
		
		
		try {
			TestHelpers.addtext(searchhere, text1+"\n");

		} catch (Exception e) {
			TestHelpers.addtext(searchhere, text1+"\n");
		}
		
		logger.info("Search invoice");
	}
	public void Verify_searchInvoice(String text1) {

		String searchInv = driver.findElement(By.xpath("//app-card[@cardtitle='Searched Invoices']//tbody/tr/td[5]"))
				.getText();

		if (text1.equalsIgnoreCase(searchInv)) {

			System.out.println("Added Invoice no. matched with searched invoice");
		} else {
			System.out.println("Added Invoice no. not  matched with searched invoice");

		}
	}
}
