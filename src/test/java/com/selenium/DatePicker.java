package com.selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {

	@Test(enabled=false)
	public void calendar() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.tripodeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//to get Today date from computer 
				DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy"); //can mention the format in which we want
				Date date = new Date();
				String Todaydate = dateFormat.format(date);
				System.out.println(Todaydate);

			            //String Todaydate="10-20-30-40";
				//split the string in year,month and day
				String splitter[] = Todaydate.split("-");
				
				String year=splitter[2]; //after 2nd dash is year
				String month = splitter[1]; //after 1st dash is month
				String day = splitter[0];
				System.out.println(year);
				System.out.println(month);
				System.out.println(day);
		//to get target date in string
				
				String targetyear="2025"; 
				String targetmonth = "march"; 
				String targetday ="10";
				System.out.println("target date "+targetmonth);
				
				
		//to get the displayed current date
				
				//driver.findElement(By.xpath("//input[@id='dateNew']")).click();
				
				WebElement cal=driver.findElement(By.xpath("//input[@id='dateNew']"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].value='19/09/2024'", cal);				
/*			
		//selecting	future date	
				while(true) {
					String currentyear = driver.findElement(By.xpath("//div[@class='picker__year']")).getText();
					String currentmonth = driver.findElement(By.xpath("//div[@class='picker__month']")).getText();
					//System.out.println("current date "+currentmonth);
				if(targetmonth.equalsIgnoreCase(currentmonth) && currentyear.equalsIgnoreCase(targetyear)) {
					
					
					break;	
				}

				else {
					driver.findElement(By.xpath("//div[@title='Next month']")).click();
					Thread.sleep(3000);
				}
				}
				driver.findElement(By.xpath("//table[@class='picker__table']//td/div[text()='"+targetday+"']")).click();
				Thread.sleep(3000);			
*/					
	}
	

	

	
	@Test
	public void datepicker() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String targetyear="2024"; 
		String targetmonth = "july"; 
		String targetday ="10";

		driver.findElement(By.id("second_date_picker")).click();
		
/*		
	//selecting	future date	
		while(true) {
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			//System.out.println("current date "+currentmonth);
		if(targetmonth.equalsIgnoreCase(currentmonth) && currentyear.equalsIgnoreCase(targetyear)) 
		{
			
			break;	
		}

		else 
		{
			driver.findElement(By.className("ui-datepicker-next")).click();
			Thread.sleep(3000);
		}
		         }
		
		driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+targetday+"']")).click();
		Thread.sleep(3000);	
*/		
	//selecting past date
		while(true) {
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			//System.out.println("current date "+currentmonth);
		if(targetmonth.equalsIgnoreCase(currentmonth) && currentyear.equalsIgnoreCase(targetyear)) 
		{
			
			break;	
		}

		else 
		{
			driver.findElement(By.className("ui-datepicker-prev")).click();
			Thread.sleep(3000);
		}
		         }
		
		driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+targetday+"']")).click();
		Thread.sleep(3000);	
		
	
	
	
	}







}
