package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[@aria-label='Amazon.ca']")
	WebElement AmazonLogo;
	
	@FindBy(name="url")
	WebElement AllDepart;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyLogo() {
		return AmazonLogo.isDisplayed();
	}
	
	public void SelectAllDeprt() throws InterruptedException {
		Select s = new Select(AllDepart);
		Thread.sleep(1000);
		s.selectByValue("search-alias=fashion-womens");
		Thread.sleep(1000);
		
		driver.findElement(By.name("field-keywords")).sendKeys("bra for women");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		driver.findElement(By.linkText("Women’s Push Up Bra Floral Lace Padded Underwire Bra Demi Plunge")).click();
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.linkText("Go to cart")).click();
		
	}
}
