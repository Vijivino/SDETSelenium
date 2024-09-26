package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Javascipt {

	@Test
	public static void jscript() {
	
		WebDriver driver=new ChromeDriver();
	    driver.get("https://demoqa.com/automation-practice-form");
	    driver.manage().window().maximize();

//send values	    
	    JavascriptExecutor js= (JavascriptExecutor) driver; //typecasting the driver since it is acting the driver 
	                                                           //from webdriver interface
	    WebElement fname = driver.findElement(By.id("firstName"));
	    js.executeScript("arguments[0].value='viji'", fname);
//scroll down 	    
	    System.out.println(js.executeScript("return window.pageYOffset;"));//will give the pixel number of the window
	    js.executeScript("window.scrollBy(0,500)");
	    System.out.println(js.executeScript("return window.pageYOffset;")); 
//scroll down till element visible
	    WebElement submit = driver.findElement(By.id("submit"));
	    js.executeScript("arguments[0].scrollIntoView();",submit);
	    System.out.println(js.executeScript("return window.pageYOffset;"));
//sroll till end of page
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    System.out.println(js.executeScript("return window.pageYOffset;"));
//scroll back to top
	    js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); //scrollWidth - for horizontal movement
	    System.out.println(js.executeScript("return window.pageYOffset;"));
	}
}
