package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstGoogle {
	
	public static void main(String args[]) {
	
		//WebDriver driver=new chromedriver();//
		WebDriver driver=new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		driver.manage().window().maximize();
		driver.close();
		
	}
}
