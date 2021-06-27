package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SetUp.TestSetUp;
import pages.Homepage;
import pages.LoginPage;

public class loginpagetest_001 extends TestSetUp {
	
	LoginPage loginPage;
	Homepage homePage;

	public loginpagetest_001() {

		super();

	}

	@BeforeMethod
	
	public void setUp() {

		initialization();// method from setup class

		loginPage = new LoginPage();// method from LoginPage class

	}

	@Test
	
	public void loginTest() {

		loginPage.login();
		logger.info("Login Successfully");

		homePage = new Homepage();

		String title = homePage.verifyHomePageTitle();

		Assert.assertEquals(title, "Standard | TARCKPAYOUT - The Powerfull Payment Tracker");

	}

	@Test

	public void invalidLoginTest() {

		String invalidLoginText = loginPage.invalidLogin();

		Assert.assertEquals(invalidLoginText, "Invalid credentials found!");

		logger.info("Invalid login  Credential found");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
}
