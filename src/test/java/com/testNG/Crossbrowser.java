package com.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void launch(String br,String url) {
		
		switch(br.toLowerCase()) 
		{
		
		case"chrome": 	driver=new ChromeDriver(); break;
		case"edge": 	driver=new EdgeDriver(); break;
		default:System.out.println("Invalid browser"); return;//return stment to exit from the testcase,no need to run further
	
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test(dataProvider = "logindata")//,invocationCount = 2,threadPoolSize = 2)
	
	public void login(String email,String pw) throws InterruptedException{//String name,String password) {
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pw);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(2000);
		
	}
	
	

	@AfterMethod()
	public void close(){
		
		driver.quit();
	}

	
	@DataProvider(name="logindata")
	
	 Object[][] getdata(){
		
		Object[][] data= {{"vijiraja@gmail.com", "viji123"}, 
		                  {"viji@gmail.com", "viji"} 
		                 };
		return data;
		
		
	}
	
}
