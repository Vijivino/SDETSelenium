package com.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PagenationTable {
	
	@Test
	public void pagenation() throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();

	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//get total no of pages
	int totalpages = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
	for(int i=1;i<=totalpages;i++) {

		
/*		//getting page no from the display at the bottom
		//showing 1 to 10 of 1909 (1909 pages)
		String text = driver.findElement(By.xpath("")).getText();
		String substring = text.substring(text.indexOf("(")+1, text.indexOf("p")-1);//getting substring 1909 only from "showing 1 to 10 of 1909 (1909 pages)" 
		int pages = Integer.parseInt(substring);
*/		
		//if(i>1) {
		driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
		Thread.sleep(1000);
		//}
		
		List<WebElement> rowlist = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr"));
		int totalrows = rowlist.size();
		//System.out.println(totalrows);
		for(int j=1;j<=totalrows;j++) {
			String price = driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[3]")).getText();
			String name = driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[2]")).getText();

			System.out.println(name +" \t "+price);
			
	                                  }
	
	                      }
	}
}
