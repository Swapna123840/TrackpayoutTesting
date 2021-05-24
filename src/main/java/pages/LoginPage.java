package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.TestHelpers;
import SetUp.TestSetUp;

public class LoginPage extends TestSetUp {

	@FindBy(xpath = "//input[@type='text' and @placeholder='Company Id']")
	WebElement CompanyId;

	@FindBy(xpath = "//input[@type='email' and @placeholder='Email Address']")
	WebElement Email;

	@FindBy(xpath = "//input[@type='password' and @placeholder='Password']")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInBtn;

	@FindBy(className = "alert-danger")
	WebElement InvalidLoginAlert;

	public LoginPage() {

		PageFactory.initElements(driver, this);//// initialize webelements of loginpage class

		TestHelpers.waitforpageload(SignInBtn);
	}

	// Actions:
	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public void login() {

		CompanyId.sendKeys(props.getProperty("CompanyId"));

		Email.sendKeys(props.getProperty("Email"));

		Password.sendKeys(props.getProperty("Pwd"));

		SignInBtn.click();

		// return new Homepage();
	}

	public String invalidLogin() {

		CompanyId.sendKeys(props.getProperty("CompanyId"));

		Email.sendKeys(props.getProperty("Email"));

		Password.sendKeys("Password");

		SignInBtn.click();

		TestHelpers.waitforpageload(InvalidLoginAlert);

		return InvalidLoginAlert.getText();

	}

}
