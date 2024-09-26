package com.selenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Screenshot {
	
	@Test
	public void mouseactions() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//snap of full page		
	    File source=( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File desti=new File(".\\snaps\\picture1.png");
	    //FileUtils.copyFile(source, desti);
		source.renameTo(desti); //to copy the screenshot from system memory to the desired location
//snap of webelement
		WebElement element = driver.findElement(By.id(""));
		File src = element.getScreenshotAs(OutputType.FILE);//no need of typecasting it with takesreenshot interface
		
}
}
