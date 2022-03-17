package com.crm.OpportunityTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityUsingGenericUtility {

	@Test
	public void createOpportunityUsingGenericUtility() throws IOException, InterruptedException
	{
		   JavaUtility jLib= new JavaUtility();
		   WebDriverUtility wLib= new WebDriverUtility();
		   PropertyFileUtility pLib= new PropertyFileUtility();
		   ExcelFileUtility eLib = new ExcelFileUtility();
		   
				
		      /* Step 2 : Read data from External resource*/
		       int random = jLib.getRandomNum();
		       String BROWSER = pLib.readDateFromPropertyFile("Browser");
		       String URL = pLib.readDateFromPropertyFile("Url");
		        String USERNAME = pLib.readDateFromPropertyFile("Username");
		        String PASSWORD = pLib.readDateFromPropertyFile("Password");
		   
				
			 
		        String optyNameRan = eLib.readDataFromExcel("Opportunity", 1, 2)+random;
		        String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
			  
		        String orgNameRan = eLib.readDataFromExcel("Contact", 1, 2)+random;
			  
			
			    /* step 3 : Launch Browser*/
			  
			  WebDriver driver= null;
			  if(BROWSER.equalsIgnoreCase("chrome"))
			  {
				  driver= new ChromeDriver();
			  }
			  else if (BROWSER.equalsIgnoreCase("firefox"))
			  {
				  driver= new FirefoxDriver();
			  }
			  else
			  {
				  System.out.println("Invalid Broswer");
			  }
			  
			  
			  /* step 4: Login to application*/
			  wLib.maximizeWindow(driver);
			  wLib.waitForPageLoad(driver);
			  driver.get(URL);
			  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			  driver.findElement(By.id("submitButton")).click();
			  
			  /* Step 5: Create organization*/
			    driver.findElement(By.linkText("Organizations")).click();
			   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			   driver.findElement(By.name("accountname")).sendKeys(orgNameRan);
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			  
			  
			  
			  /* step 6 : navigate to opportunity link*/
			   Thread.sleep(2000);
			  
			  driver.findElement(By.linkText("Opportunities")).click();
			
			 
			  
			  /* step 7 : click on create Opportunity */
			  driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
			  
			 
			  /* Step 8 : Create Opportunity with mandatory Field*/
			  driver.findElement(By.name("potentialname")).sendKeys(optyNameRan);
			  driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@alt='Select']")).click();
			  
			    Thread.sleep(2000);
			    wLib.switchToWindow(driver,"Accounts" );
			  driver.findElement(By.id("search_txt")).sendKeys(orgNameRan);
			  driver.findElement(By.name("search")).click();
			  driver.findElement(By.xpath("//a[text()='"+orgNameRan+"']")).click();
			  
			    wLib.switchToWindow(driver, "Potentials");
				 driver.findElement(By.name("closingdate")).clear();
				 driver.findElement(By.name("closingdate")).sendKeys(""+expClosDate+"");
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 
				 /* step 9 : Logout From Applition */
	}
}
