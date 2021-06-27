package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.BasePage;
import pages.ByMasterPages;
import pages.InvoicePage;
import pages.LoginPage;

public class ByMasterTest_008 extends TestSetUp {
	
	LoginPage loginPage;
	InvoicePage invoicepage;
	BasePage basepage;
	ByMasterPages bymasterpages;

	ByMasterTest_008() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();

		loginPage = new LoginPage();

		loginPage.login();

		basepage = new BasePage();

		basepage.clickonReport();

		basepage.ByMastersdrop();
		


	}

	@Test
	public void ByAccManager() {

		basepage.ByAccMgr();
		
		bymasterpages = new ByMasterPages();

		bymasterpages.selectaccMgr();


		try {
			String element=driver.findElement(By.xpath("//div[contains(text(),'There is no data available to show!')]")).getText();	
				System.out.println(""+element);
			}
			catch (Exception e) {
				
		bymasterpages.View();
		
		bymasterpages.Edit();
		
		bymasterpages.Delete();
		
		bymasterpages.DownloadReportbymgr();
			}
	}

	@Test
	public void ByCategory() {

		basepage.ByCategory();
		
		bymasterpages = new ByMasterPages();

		bymasterpages.SelectCategory();
		
		bymasterpages.View();
		
		bymasterpages.downloadAttachments();
		
		bymasterpages.Edit();
		
		bymasterpages.Delete();
		
		bymasterpages.ReportByCategory();
		
		
	}

	@Test
	public void ByCustomer() {

		basepage.ByCustomer();
		
		bymasterpages = new ByMasterPages();
		
		bymasterpages.View();
		
		bymasterpages.Edit();
		
		bymasterpages.Delete();
				
		bymasterpages.ReportByCategory();
	}

	@Test
	public void ByLocation_Country() {

		basepage.ByLocation();
		
		bymasterpages = new ByMasterPages();
		
		bymasterpages.SearchbyCountry();
		
		bymasterpages.SearchbyState();
		
		bymasterpages.SearchbyCity();
		
		bymasterpages.View();
		
		bymasterpages.Edit();
		
		bymasterpages.Delete();
		
		bymasterpages.ReportByLocation();

	
	}
	
	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
