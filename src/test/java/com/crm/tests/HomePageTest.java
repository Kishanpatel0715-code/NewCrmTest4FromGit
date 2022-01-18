package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("Email"), prop.getProperty("password"));
	}
	
	@Test
	public void VerifyLogoTest() {
		Boolean b = homePage.VerifyLogo();
		Assert.assertTrue(b);
	}
	
	@Test
	public void SelectAllDepartTest() throws InterruptedException {
		homePage.SelectAllDeprt();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
