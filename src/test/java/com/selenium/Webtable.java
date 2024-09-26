package com.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.spi.CurrencyNameProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//string to integer, table, xpath concatenation
public class Webtable {
	
	WebDriver driver=new ChromeDriver();
	
	@BeforeMethod
	public void openBrowser() {
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void Bookflight() {
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> col = driver.findElements(By.xpath("//table//tr/td[6]"));
		System.out.println(col.size());
		
		//to pick the least price flight ticket
		//List<Integer> list=new ArrayList<Integer>();
		List<String> list=new ArrayList<String>();
		for(int i=1;i<=col.size();i++) {
		
			String text = driver.findElement(By.xpath("//table//tr["+i+"]/td[6]")).getText();
			//System.out.println(text);

			//String replaceAll = text.replaceAll("[^0-9]", "");
		    //int price = Integer.parseInt(replaceAll);
			list.add(text);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
		System.out.println(row.size());
		for(int j=1;j<col.size();j++) {
		String least = driver.findElement(By.xpath("//table//tr["+j+"]/td[6]")).getText();
		if(least.equalsIgnoreCase("$200.98")) {
		
			String flight = driver.findElement(By.xpath("//table//tr["+j+"]/td[3]")).getText();
			System.out.println("Least price airline is "+flight);
			driver.findElement(By.xpath("//table//tr["+j+"]/td[1]")).click();
			break;
		}	
		
		}
	}

}
