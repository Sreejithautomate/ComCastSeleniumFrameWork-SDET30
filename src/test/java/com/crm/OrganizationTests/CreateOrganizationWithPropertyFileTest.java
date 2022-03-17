package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationWithPropertyFileTest {
	
	@Test
	public void createOrganizationTest() throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pOBJ = new Properties();
		 pOBJ.load(fis);
		 String BROWSER = pOBJ.getProperty("Browser");
		 String URL = pOBJ.getProperty("Url");
		 String USERNAME = pOBJ.getProperty("Username");
		 String PASSWORD = pOBJ.getProperty("Password");
		 WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invalid browser");
		 }
		 
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("ABC124");
      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      Thread.sleep(2000);
      driver.close();
		

		
		
	}

}
