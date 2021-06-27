package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class AdministratorPage extends TestSetUp {

	@FindBy(xpath = "//button[contains(text(),'Add Account Manager')]")
	WebElement addaccmgr;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(id = "designation")
	WebElement desi;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "contact")
	WebElement cont;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	List<WebElement> submit;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-secondary']")
	List<WebElement> close;

	@FindBy(xpath = "//a[@title='Edit']//i[@class='feather icon-edit']")
	List<WebElement> Edit;

	@FindBy(xpath = "//tbody/tr[4]/td[7]/a[2]/i")
	WebElement delete;

	@FindBy(xpath = "//button[@class='btn btn-danger' and contains(text(),'Remove')]")
	WebElement Remove;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(),'Add Bank A/C')]")
	WebElement AddBankAc;

	@FindBy(id = "bankName")
	WebElement bankname;

	@FindBy(id = "bankAcHolder")
	WebElement bankhold;

	@FindBy(id = "bankAcNo")
	WebElement bankno;

	@FindBy(id = "bankIfscCode")
	WebElement ifsc;

	@FindBy(id = "bankMmid")
	WebElement bankmmid;

	@FindBy(id = "bankAcType")
	WebElement bankactype;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-success']")
	List<WebElement> submitbtn;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-secondary']")
	List<WebElement> Okbtn;

	@FindBy(xpath = "//button[ @class='close basic-close']")
	List<WebElement> closebt;

	@FindBy(xpath = "//tr[last()]/td[7]/a[1]/i")
	WebElement Editbtn;

	@FindBy(xpath = "//button[ @class='close basic-close']")
	List<WebElement> xbtn;

	@FindBy(xpath = "//tbody/tr[3]/td[7]/a[2]/i")
	List<WebElement> deletes;

	@FindBy(xpath = "//button[ @class='btn btn-primary' and contains(text(),'Add Category')]")
	WebElement AddCat;

	@FindBy(id = "categoryName")
	WebElement CatName;

	@FindBy(id = "description")
	WebElement Desc;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-success']")
	List<WebElement> submitbtn1;

	@FindBy(xpath = "//button[ @class='btn btn-secondary' ]")
	List<WebElement> okbtn;

	@FindBy(xpath = "//a[@title='Edit']/i[@class='feather icon-edit']")
	List<WebElement> Edibtns;

	@FindBy(xpath = "//a[@title='Delete']/i[@class='feather icon-trash-2']")
	List<WebElement> delbtns;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(),'Add Customer')]")
	WebElement Addcustomer;

	@FindBy(id = "customerName")
	WebElement CustName;

	@FindBy(id = "contactPerson")
	WebElement Contper;

	@FindBy(id = "customerEmail")
	WebElement CustEmail;

	@FindBy(id = "contactPersonEmail")
	WebElement CustperEmail;

	@FindBy(id = "customerContact")
	WebElement CustCon;

	@FindBy(id = "customerCountry")
	WebElement CustCoun;

	@FindBy(id = "customerState")
	WebElement CustState;

	@FindBy(id = "customerCity")
	WebElement CustCity;

	@FindBy(id = "paymentTerm")
	WebElement payterm;

	@FindBy(id = "accountManager")
	WebElement accmgr;

	@FindBy(id = "gstNo")
	WebElement GstNo;

	@FindBy(id = "bankId")
	WebElement bankid;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-success']")
	List<WebElement> submitbtn2;

	@FindBy(xpath = "//a[@title='Edit']//i")
	List<WebElement> EditsCust;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-danger']")
	List<WebElement> Removes;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(),'Add User')]")
	WebElement Adduser;

	@FindBy(id = "firstName")
	WebElement FirstNam;

	@FindBy(id = "lastName")
	WebElement LastNam;

	@FindBy(id = "designation")
	WebElement Desig;

	@FindBy(id = "userEmail")
	WebElement Email1;

	@FindBy(id = "userContact")
	WebElement usercon;

	@FindBy(xpath = "//button[@class='btn btn-warning' and contains(text(),'Change Password')]")
	WebElement Changepswd;

	@FindBy(id = "newPassword")
	WebElement newpswd;

	@FindBy(id = "confirmPassword")
	WebElement Conpswd;

	@FindBy(xpath = "//button[contains(text(),'Change Passoword')]")
	WebElement Changepaswd;

	@FindBy(xpath = "//tr[last()]/td[5]")
	WebElement a1;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-success']")
	List<WebElement> Editsubmt;
	
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/app-list/app-ui-modal[4]/div/div/div/div[3]/div/button")
	WebElement okcustedit;
	
	@FindBy(xpath="//app-card[@cardtitle='Account Managers']//tbody/tr")
	List<WebElement> ele;
	
	
	public AdministratorPage() {
		
		String textname=driver.findElement(By.xpath("//app-card[@cardtitle='Account Managers']//tbody/tr/td[2]")).getText();

		while(!textname.equals( "Pankaj")) {
		
		textname=driver.findElement(By.xpath("//app-card[@cardtitle='Account Managers']//tbody/tr/td[2]")).getText();
		
		}
		PageFactory.initElements(driver, this);
	}

	public void AddAccountManager() {


		List<WebElement> element = driver.findElements(By.xpath("//app-card[@cardtitle='Account Managers']//tbody/tr"));
		int accountmanagerCount=element.size();

		System.out.println(""+accountmanagerCount);
		
		
		TestHelpers.clickelement(addaccmgr);
		logger.info("add account manager");

		
		TestHelpers.addtext(firstname, props.getProperty("FirstName"));

		TestHelpers.addtext(lastname, props.getProperty("LastName"));

		TestHelpers.addtext(desi, props.getProperty("Designation1"));

		String texts = TestHelpers.UUID()+"@gmail.com";
		TestHelpers.addtext(email, texts);
		System.out.println(texts);

		logger.info("email generated");

		TestHelpers.addtext(cont, props.getProperty("Contact1"));

		TestHelpers.clickelement(submit.get(0));

		logger.info("acc manager submitted");

		try {
			TestHelpers.clickelement(close.get(0));
	
		} catch (Exception e) {
			TestHelpers.clickelement(close.get(0));
		}

		logger.info("close");
		List<WebElement> element1 = driver.findElements(By.xpath("//app-card[@cardtitle='Account Managers']//tbody/tr"));

		int elementcount=element1.size();
		 System.out.println(""+elementcount);

		
		while (accountmanagerCount==elementcount) {
			
		 element1 = driver.findElements(By.xpath("//app-card[@cardtitle='Account Managers']//tbody/tr"));
		 elementcount=element1.size();
		 System.out.println(""+elementcount);
		 
		}
	
		
	        String temp = 	driver.findElement(By.xpath("//tbody/tr[last()]/td[5]")).getText();
	        if(temp.contains(texts)) {
	        	
	        	
	    		System.out.println("The expected text is same as actual text --- " + temp);
	        }
	        
	        else {
	    		System.out.println("The expected text doesn't match the actual text --- " + temp);
	    	}
	        
	    }



	

	public  String Bankdetails() {

		try {

			TestHelpers.clickelement(AddBankAc);

		} catch (Exception e) {

			TestHelpers.clickelement(AddBankAc);
		}

		TestHelpers.addtext(bankname, props.getProperty("BankName"));

		TestHelpers.addtext(bankhold, props.getProperty("BankACholder"));

		String texts = TestHelpers.randomeNum();
		TestHelpers.addtext(bankno, texts);
		System.out.println(texts);

		TestHelpers.selectByIndex(bankactype, 1);
		logger.info("ac type");

		TestHelpers.addtext(ifsc, TestHelpers.randomeNum());

		TestHelpers.addtext(bankmmid, TestHelpers.randomeNum());

		TestHelpers.clickelement(submitbtn.get(0));
		logger.info("submit");

		try {
			TestHelpers.clickelement(Okbtn.get(1));

		} catch (Exception e) {
			TestHelpers.clickelement(Okbtn.get(1));
		}
		
		return texts;
	}

	public void Edit_Delete(String texts ) {
		String StrValue = driver.findElement(By.xpath("//tr[last()]/td[3]")).getText();

		if (texts.equalsIgnoreCase(StrValue)) {

			System.out.println("The expected text is same as actual text --- " + StrValue);

			int count1 = Edit.size();
			Edit.get(count1 - 1).click();
			logger.info("Edit");
			TestHelpers.clickelement(Editsubmt.get(1));
			TestHelpers.clickelement(Okbtn.get(3));
		//	TestHelpers.clickelement(close.get(1));

			driver.findElement(By.xpath("//tr[last()]/td[7]/a[2]/i[1]")).click();
			TestHelpers.clickelement(Remove);
			logger.info("gfgfh");

			
			WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'Bank Details has been removed successfully!')]"));
	        String text=msg.getText();
	        String expectedText = "Bank Details has been removed successfully!";
	        Assert.assertEquals(text,expectedText);
	        
		} else {
			System.out.println("The expected text doesn't match the actual text --- " + StrValue);
		}
		logger.info("bsbbbd");

	}
	


	public String ADDCategory() throws InterruptedException {
		try {
			TestHelpers.clickelement(AddCat);

		} catch (Exception e) {
			TestHelpers.clickelement(AddCat);
		}

		TestHelpers.addtext(CatName, TestHelpers.randomestring());

		String texts = TestHelpers.randomestring();
		TestHelpers.addtext(Desc, texts);
		System.out.println(texts);

		TestHelpers.clickelement(submitbtn1.get(0));
		
		try {
			TestHelpers.clickelement(okbtn.get(1));

		} catch (Exception e) {

			TestHelpers.clickelement(okbtn.get(1));
		}

		return texts;
	}
	
	public void Edit_Delete_Category(String texts) throws InterruptedException {
		
		Thread.sleep(2000);
		String StrValue = driver.findElement(By.xpath("//tr[last()]/td[3]")).getText();

		if (texts.equalsIgnoreCase(StrValue)) {

			System.out.println("The expected text is same as actual text --- " + StrValue);

			int count1 = Edit.size();
			Edit.get(count1 - 1).click();
			logger.info("sahsh");
			TestHelpers.clickelement(Editsubmt.get(1));
			TestHelpers.clickelement(okcustedit);
			
			driver.findElement(By.xpath("//tr[last()]/td[5]/a[2]/i[1]")).click();
			
			TestHelpers.clickelement(Removes.get(1));
			logger.info("gfgfh");

		

		} else {
			System.out.println("The expected text doesn't match the actual text --- " + StrValue);
		}

	}

	public String ADDCustomer() {

		try {
			TestHelpers.clickelement(Addcustomer);

		} catch (Exception e) {
			TestHelpers.clickelement(Addcustomer);
		}

		TestHelpers.addtext(CustName, TestHelpers.randomestring());

		String texts = TestHelpers.UUID()+"@gmail.com";
		TestHelpers.addtext(CustEmail, texts);
		System.out.println(texts);
		

		TestHelpers.addtext(Contper, TestHelpers.randomestring());

		TestHelpers.addtext(CustperEmail, TestHelpers.randomestring() + "@gmail.com");

		TestHelpers.addtext(CustCon, "9877665432");

		TestHelpers.selectByIndex(CustCoun, 1);

		TestHelpers.selectByIndex(CustState, 1);

		TestHelpers.selectByIndex(CustCity, 1);

		TestHelpers.addtext(payterm, "1");

		TestHelpers.selectByIndex(accmgr, 1);

		TestHelpers.addtext(GstNo, TestHelpers.randomeNum());

		TestHelpers.selectByIndex(bankid, 1);

		TestHelpers.clickelement(submitbtn.get(0));

		try {
			TestHelpers.clickelement(okbtn.get(1));

		} catch (Exception e) {

			TestHelpers.clickelement(okbtn.get(1));
		}


		// TestHelpers.clickelement(closebt.get(0));
		
		return texts;
	}
	
	public void Edit_Delete_Customer(String texts) {
		String StrValue = driver.findElement(By.xpath("//tr[last()]/td[3]")).getText();

		if (texts.equalsIgnoreCase(StrValue)) {

			System.out.println("The expected text is same as actual text --- " + StrValue);

			int count1 = EditsCust.size();
			EditsCust.get(count1 - 1).click();
			logger.info("sahsh");
			TestHelpers.clickelement(Editsubmt.get(1));
			TestHelpers.clickelement(okcustedit);
			
		
				driver.findElement(By.xpath("//tbody/tr[last()]/td[6]/a[2]/i")).click();
			

			TestHelpers.clickelement(Removes.get(1));
			logger.info("gfgfh");

			WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'Customer has been removed successfully!')]"));
	        String text=msg.getText();
	        String expectedText = "Customer has been removed successfully!";
	        Assert.assertEquals(text,expectedText);

			
		} else {
			System.out.println("The expected text doesn't match the actual text --- " + StrValue);
		}

	
	}


	
	public String ADDUser() {

		TestHelpers.clickelement(Adduser);

		TestHelpers.addtext(FirstNam, TestHelpers.randomestring());

		TestHelpers.addtext(LastNam, TestHelpers.randomestring());

		TestHelpers.addtext(Desig, "abc");
		
		String texts = TestHelpers.UUID()+"@gmail.com";
		TestHelpers.addtext(Email1, texts);
		System.out.println(texts);


		TestHelpers.addtext(usercon, TestHelpers.randomeNum());

		TestHelpers.clickelement(submitbtn.get(0));
		
		try {
			TestHelpers.clickelement(okbtn.get(1));

		} catch (Exception e) {

			TestHelpers.clickelement(okbtn.get(1));
		}
		
		return texts;
	}
	
	public void Edit_Delete_User(String texts) {
		
		String StrValue = driver.findElement(By.xpath("//tr[last()]/td[4]")).getText();

		if (texts.equalsIgnoreCase(StrValue)) {

			System.out.println("The expected text is same as actual text --- " + StrValue);

			int count1 = EditsCust.size();
			EditsCust.get(count1 - 1).click();
			logger.info("sahsh");
			TestHelpers.clickelement(okbtn.get(2));

			
			driver.findElement(By.xpath("//tbody/tr[last()]/td[8]/a[2]/i[1]")).click();

			TestHelpers.clickelement(Removes.get(1));
			logger.info("gfgfh");
			
			
			WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'User has been removed successfully!')]"));
	        String text=msg.getText();
	        String expectedText = "User has been removed successfully!";
	        Assert.assertEquals(text,expectedText);

		} else {
			System.out.println("The expected text doesn't match the actual text --- " + StrValue);
		}


		// TestHelpers.clickelement(closebt.get(0));
		// logger.info("close popup");

		
	}

	public void EditChangepswd() {

		TestHelpers.scrollheight(Changepswd);

		TestHelpers.clickelement(Changepswd);

		TestHelpers.addtext(newpswd, "zxbv");

		TestHelpers.addtext(Conpswd, "ahsgjgs");

		TestHelpers.clickelement(closebt.get(0));
		logger.info("change password");
	}
}
	
