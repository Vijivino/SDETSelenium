package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDom {

	@Test
	public static void shadowdom() {
		
    
		WebDriver driver=new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		//
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
	    shadow.findElement(By.cssSelector("#input")).sendKeys("Selenium");
	    shadow.findElement(By.cssSelector("#input")).clear();

	    
	    //access using nested shadow method
	    SearchContext shadow1 = shadow.findElement(By.cssSelector("")).getShadowRoot(); 
	    SearchContext shadow2 = shadow1.findElement(By.cssSelector("")).getShadowRoot();
	    shadow2.findElement(By.cssSelector(null)).sendKeys("");
	
	}
}
