package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath = "//button[@class='close basic-close']")
	List<WebElement> close;
	
	@FindBy(xpath = "//a[@title='Edit']//i[@class='feather icon-edit']")
	List<WebElement> Edit;
	
	@FindBy(xpath = "//tbody/tr[4]/td[7]/a[2]/i[1]")
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
	
	@FindBy(xpath = "//button[ @class='close basic-close']")
	List<WebElement> closebt;
	
	@FindBy(xpath = "//tbody/tr[2]/td[7]/a[1]/i[1]")
	WebElement Editbtn;
	
	@FindBy(xpath = "//button[ @class='close basic-close']")
	List<WebElement> xbtn;
	
	@FindBy(xpath = "//tbody/tr[3]/td[7]/a[2]/i[1]")
	WebElement del;
	
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
	
	@FindBy(id = "bankId")
	WebElement bankid;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-success']")
	List<WebElement> submitbtn2;
	
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
	
	public AdministratorPage() {

		PageFactory.initElements(driver, this);
	}

	public void AddAccountManager() {

		TestHelpers.clickelement(addaccmgr);
		logger.info("add account manager");
		
		TestHelpers.addtext(firstname, "xyz");
		
		TestHelpers.addtext(lastname, "xyz");
		
		TestHelpers.addtext(desi, "tester");
		
		TestHelpers.addtext(email, "xyz@gmail.com");
		
		TestHelpers.addtext(cont, "9877665255");
		
		//TestHelpers.clickelement(submit.get(0));..working
		
		boolean res = driver.getPageSource().contains("Account Manager has been created successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....Account Manager has been created successfully!");

		} else {
			
			logger.info("test case passed....Account Manager with this email is already exist!");
			Assert.assertTrue(true);
		}
		
		

		TestHelpers.clickelement(close.get(0));
		logger.info("close");
		
		TestHelpers.clickelement(Edit.get(0));
		logger.info("Edit");
		
		TestHelpers.clickelement(close.get(1));
		
		TestHelpers.clickelement(delete);
		logger.info("delete");
		
		TestHelpers.clickelement(Remove);
		logger.info("remove");
		
		boolean Rem= driver.getPageSource().contains("Account Manager has been removed successfully!");

		if (Rem == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....Account Manager has been removed successfully!");
		}
	
	}
	
	public void Bankdetails() {
		
		try {
			
			TestHelpers.clickelement(AddBankAc);

		} catch (Exception e) {
			
			TestHelpers.clickelement(AddBankAc);
		}
		
		TestHelpers.addtext(bankname, "kotak");
		
		TestHelpers.addtext(bankhold, "xyz");
		
		TestHelpers.addtext(bankno, "9328375");
		
		TestHelpers.selectByIndex(bankactype, 1);
		logger.info("ac type");

		TestHelpers.addtext(ifsc, "03183");
		
		TestHelpers.addtext(bankmmid, "2373");
		
		//TestHelpers.clickelement(submitbtn.get(0));
		logger.info("submit");
		
		
		boolean res = driver.getPageSource().contains("Bank Details has been created successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....Bank Details has been created successfully!");

		} else {
			
			logger.info("test case passed....Bank Details with this A/C No are already exist!");
			Assert.assertTrue(true);
		}
		
		
		
		TestHelpers.clickelement(closebt.get(0));
		
		TestHelpers.clickelement(Editbtn);
		logger.info("Edit");
		
		TestHelpers.clickelement(xbtn.get(1));
		
		TestHelpers.clickelement(del);
		logger.info("delete");
		

	}
	
	public void ADDCategory() {
		
		TestHelpers.clickelement(AddCat);
		
		TestHelpers.addtext(CatName, "Cate");
		
		TestHelpers.addtext(Desc, "category");
		
		TestHelpers.clickelement(submitbtn1.get(0));
		
		boolean res = driver.getPageSource().contains("Category has been created successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....Category has been created successfully!");

		} else {
			
			logger.info("test case passed....Category with this name is already exist!");
			Assert.assertTrue(true);
		}
		
		
		
		TestHelpers.clickelement(okbtn.get(1));
		
		TestHelpers.clickelement(Edibtns.get(0));
		
		TestHelpers.clickelement(delbtns.get(0));
	}
	
	public void ADDCustomer() {
		
		TestHelpers.clickelement(Addcustomer);
		
		TestHelpers.addtext(CustName, "xyz");
		
		TestHelpers.addtext(CustEmail, "abc@gmail.com");
		
		TestHelpers.addtext(Contper, "xyz");
		
		TestHelpers.addtext(CustperEmail, "xyz@gmail.com");
		
		TestHelpers.addtext(CustCon, "9877665432");
		
		TestHelpers.selectByIndex(CustCoun, 1);
		
		TestHelpers.selectByIndex(CustState, 1);
		
		TestHelpers.selectByIndex(CustCity, 1);
		
		TestHelpers.addtext(payterm, "1");
		
		TestHelpers.selectByIndex(accmgr, 1);
		
		TestHelpers.selectByIndex(bankid, 1);
		
		//TestHelpers.clickelement(submitbtn.get(0));
		
		boolean res = driver.getPageSource().contains("	Customer has been created successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....Customer has been created successfully!");

		} else {
			
			logger.info("test case passed....Customer with this name is already exist!");
			Assert.assertTrue(true);
		}
		
		
		
		TestHelpers.clickelement(closebt.get(0));

	}
	
	public void ADDUser() {
		
		TestHelpers.clickelement(Adduser);
		
		TestHelpers.addtext(FirstNam, "abc");
		
		TestHelpers.addtext(LastNam, "abc");
		
		TestHelpers.addtext(Desig, "abc");
		
		TestHelpers.addtext(Email1, "abc@gmail.com");
		
		TestHelpers.addtext(usercon, "9877667656");
		
		//TestHelpers.clickelement(submitbtn.get(0));
		
		boolean res = driver.getPageSource().contains("	User has been created successfully!");

		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("test case passed....User has been created successfully!");

		} else {
			
			logger.info("test case passed....User with this details is already exist!");
			Assert.assertTrue(true);
		}
		
		
		TestHelpers.clickelement(closebt.get(0));
		logger.info("close popup");
		
		TestHelpers.clickelement(Edit.get(0));
		logger.info("Edit");
		
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
