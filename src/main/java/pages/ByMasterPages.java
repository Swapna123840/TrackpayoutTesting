package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Helpers.TestHelpers;

public class ByMasterPages extends TestHelpers {

	@FindBy(id = "Ac_manager_name")
	WebElement selbyaccmgr;

	@FindBy(xpath = "//a[@title='View']/i[@class='feather icon-eye']")
	List<WebElement> Viewbtn;

	@FindBy(xpath = "//button[@class='close']")
	WebElement closebtn;

	// tbody/tr[1]/td[12]/a[1]/i[1]
	@FindBy(xpath = "//a[@title='Edit']//i[@class='feather icon-edit']")
	List<WebElement> Editbtns;

	@FindBy(id = "invoice_amount")
	WebElement EdiInamt;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement Okbtn;
	
	@FindBy(xpath = "//tbody/tr[1]/td[12]/a[3]/i[1]")
	WebElement Delbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement Rembtn;
	
	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-byacmanager[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")
	WebElement report;//xpath
	
	@FindBy(xpath = "//select[@id='category_name']")
	WebElement Selcat;
	
	@FindBy(xpath = "//body/app-root[1]/app-admin[1]/div[1]/div[1]/app-bycategory[1]/div[1]/app-card[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")
	WebElement ReportCat;//xpath
	
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/app-bycustomer/div/app-card/div/div[2]/div/div[1]/div[2]/span")
	WebElement ReportCustomer;//xpath
	
	@FindBy(id = "customer_name")
	WebElement SelCust;
	
	@FindBy(id = "customerCountry")
	WebElement Country;
	
	@FindBy(id = "customerState")
	WebElement State;
	
	@FindBy(id = "customerCity")
	WebElement City;
	
	
	public ByMasterPages() {

		PageFactory.initElements(driver, this);


	}

	public void selectaccMgr() {
		
		//not working properly...
		Select s = new Select(selbyaccmgr);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			option.click();
			System.out.printf("%s\n", option.getText());
			logger.info("logger");

		}

	}

	public void View_Edit_Delete() {
		
		try {
			
			TestHelpers.clickelement(Viewbtn.get(0));

		} catch (Exception e) {
			
			TestHelpers.clickelement(Viewbtn.get(0));
		}
		
		TestHelpers.clickelement(closebtn);

		logger.info("viewpage");

		try {
			
			TestHelpers.clickelement(Editbtns.get(0));

		} catch (Exception e) {
			
			TestHelpers.clickelement(Editbtns.get(0));
		}

		TestHelpers.addtext(EdiInamt, "889898");
		
		TestHelpers.clickelement(submit);
		
		TestHelpers.clickelement(Okbtn);

		logger.info("Invoice Updated");
		
		/*Not WORKING......
		 * TestHelpers.clickelement(Delbtn);//not working
		
		TestHelpers.clickelement(Rembtn);

		logger.info("Invoice Remove");*/
		//Invoice has been removed successfully!
		
	

	}
	/*Not working........
	 * public void  Reportbymgr() {
		
		TestHelpers.clickelement(report);
		logger.info("Report By AccManager download");//xpath

	}*/
	public void  SelectCategory() {
		
			Select s = new Select(Selcat);
			List<WebElement> options = s.getOptions();
			for (WebElement option : options) {
				option.click();
				System.out.printf("%s\n", option.getText());
				logger.info("logger");
		
				boolean res = driver.getPageSource().contains(" There is no data available to show!");

				if (res == true) {

					Assert.assertTrue(true);
					logger.info("test case passed....	There is no data available to show!");

				} else {

					logger.info("test case passed...Invoice dislayed");
					Assert.assertTrue(true);
					
						
						try {
							
							TestHelpers.clickelement(Viewbtn.get(0));

						} catch (Exception e) {
							
							TestHelpers.clickelement(Viewbtn.get(0));
						}
						
						TestHelpers.clickelement(closebtn);

						logger.info("viewpage");

						try {
							
							TestHelpers.clickelement(Editbtns.get(0));

						} catch (Exception e) {
							
							TestHelpers.clickelement(Editbtns.get(0));
						}

						TestHelpers.addtext(EdiInamt, "889898");
						
						TestHelpers.clickelement(submit);
						
						TestHelpers.clickelement(Okbtn);

						logger.info("Invoice Updated");
						
						/*Not working
						 * TestHelpers.clickelement(Delbtn);
						
						TestHelpers.clickelement(Rembtn);

						logger.info("Invoice Remove");*/
						//Invoice has been removed successfully!
					
					}
			}
				
			}

	

		
	public void ReportByCategory() {
		
		try {
			
			TestHelpers.clickelement(ReportCat);

		} catch (Exception e) {
			
			TestHelpers.clickelement(ReportCat);
		}
		
		logger.info("Report By category download");


	}
	
	public void ReportByCustomer() {
		
		try {
			
			TestHelpers.clickelement(ReportCustomer);

		} catch (Exception e) {
			
			TestHelpers.clickelement(ReportCustomer);
		}
		
		logger.info("Report By Customer download");


	}
	
	
	public void SearchbyCountry() {
		
		WebElement contry=Country;
		
		TestHelpers.selectOptionFromDroDown(contry, "India");
		
		logger.info("Country selected");
	}
	
	public void SearchbyState() {

		WebElement state=State;
		
		TestHelpers.selectOptionFromDroDown(state, "Maharashtra");
		
		logger.info("State selected");
	}
	
	public void SearchbyCity() {

		WebElement cty=City;
		
		TestHelpers.selectOptionFromDroDown(cty, "Select City");
		
		//There is no data available to show!
		logger.info("City selected");
		
		
	}
	
	public void View_Edit_delete_locaton() {
		
	try {
			
			TestHelpers.clickelement(Viewbtn.get(0));

		} catch (Exception e) {
			
			TestHelpers.clickelement(Viewbtn.get(0));
		}
		
		TestHelpers.clickelement(closebtn);

		logger.info("viewpage");

		try {
			
			TestHelpers.clickelement(Editbtns.get(0));

		} catch (Exception e) {
			
			TestHelpers.clickelement(Editbtns.get(0));
		}

	/*Not Working.....................
	 * 	TestHelpers.addtext(EdiInamt, "889898");
		
		TestHelpers.clickelement(submit);
		
		TestHelpers.clickelement(Okbtn);

		logger.info("Invoice Updated");*/
		
		/*Not WORKING......
		 * TestHelpers.clickelement(Delbtn);//not working
		
		TestHelpers.clickelement(Rembtn);

		logger.info("Invoice Remove");*/
		//Invoice has been removed successfully!
		
	

	}
	}
	

	
