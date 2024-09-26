package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Log in") WebElement loginlink;
	@FindBy(id = "Email") WebElement emailinputbox;
	@FindBy(name = "Password") WebElement pwinputbox;
	@FindBy(xpath = "//input[@value='Log in']") WebElement loginbtn;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void loginClick() {
		loginlink.click();
	}
	
	public void enterEmail() {
		emailinputbox.sendKeys("vijiraja@gmail.com");
	}
}
