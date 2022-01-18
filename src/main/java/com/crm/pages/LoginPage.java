package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{

	//Object repository or webobject or webelements
	//using findby
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(id = "continue")
	WebElement FirstClick;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement LoginInBtn;
	
	@FindBy(linkText="Privacy Notice")
	WebElement privacyLink;
	
	//initialization of webobjects/webelements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method or functions
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyPrivacyLink() {
		return privacyLink.isDisplayed();
	}
	
	public HomePage Login(String un,String pwd) throws InterruptedException {
		email.sendKeys(un);
		FirstClick.click();
		Thread.sleep(2000);
		
		password.sendKeys(pwd);
		LoginInBtn.click();
		Thread.sleep(2000);
		
		return new HomePage();
	}
}
