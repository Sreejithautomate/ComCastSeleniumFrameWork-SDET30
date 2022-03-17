package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

public class MakeMyTripWithSystemDateTest {
	
	@Test
	public void makeMyTripWithSystemDateTest()
	{
		JavaUtility jLib= new JavaUtility();
		String monthAndYear = jLib.getSystemMonthAndYear();
		String date = jLib.getSystemDay();
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
			driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
			break;
		} 
		catch (Exception e)
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
	}

	}}
