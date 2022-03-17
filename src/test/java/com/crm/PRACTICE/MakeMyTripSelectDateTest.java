package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTripSelectDateTest {
	
	@Test
	public void makeMyTripSelectDateTest() 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		/* */
		Actions actions = new Actions(driver);
		actions.moveByOffset(15,15).click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='11']")).click();
		
		}
	
	@Test
	public void makeMyTripSelecRandomtDateTest()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(15,15).click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		for(;;)
		{
		try {
			driver.findElement(By.xpath("//div[text()='May 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='11']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
		}
		
		
		
		
		
		
		
	}
	

}
