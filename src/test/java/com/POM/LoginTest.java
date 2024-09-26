package com.POM;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

	@Test
	public void login() {
		
		//LoginPage lo=PageFactory.initElements(driver,LoginPage.class);
		LoginPage lo=new LoginPage(driver);
		lo.loginClick();
		lo.enterEmail();
	}
	
}
