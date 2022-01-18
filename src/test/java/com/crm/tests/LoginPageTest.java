package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void LoginPageTitleTest() {
		String LoginTitle = loginPage.LoginPageTitle();
		Assert.assertEquals(LoginTitle, "Amazon Sign In");
	}
	
	@Test
	public void verifyPrivacyLinkTest() {
		Boolean b = loginPage.verifyPrivacyLink();
		Assert.assertTrue(b);
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		homePage = loginPage.Login(prop.getProperty("Email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
