package com.crm.PRACTICE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoibiboCalanderTest {
	
	@Test
	public void goibiboCalanderTest()
	{
		String day="10";
		String monthAndYear="May 2022";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(15,15).click().perform();
		
		 driver.findElement(By.xpath("//div[@class='sc-bkkeKt gAqCbJ fswFld ']/span[text()='From']")).click();
         driver.findElement(By.xpath("//input[@type='text']")).sendKeys("banglore");
		 List<WebElement> fromflights = driver.findElements(By.xpath("//img[@alt='flight Icon']"));
		 int fromflightCount = fromflights.size();
		 for(int i=0;i<fromflightCount;i++)
		 {
			 fromflights.get(i).click();
			 break;
			 
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/span[text()='To']")).click();
         driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Kochi");
		 List<WebElement> toflights = driver.findElements(By.xpath("//img[@alt='flight Icon']"));
		 int toflightCount = toflights.size();
		 for(int j=0;j<toflightCount;j++)
		 {
			 toflights.get(j).click();
			 break;
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='11']")).click();
			driver.findElement(By.xpath("//span[text()='Done']")).click();
			break;
		} 
		
		catch (Exception e) 
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		

	}
	}}
