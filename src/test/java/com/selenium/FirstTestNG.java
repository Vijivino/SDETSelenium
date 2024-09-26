package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestNG {
	
	@Test
	public void opengoogle() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		driver.manage().window().maximize();
		System.out.println("running TestNg");
		driver.close();
	}

}
