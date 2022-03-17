package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgTest {

	@Test
	public void createOrgTest() throws IOException
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestDataORg.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheetName = wb.getSheet("Org");
		Row rown = sheetName.getRow(1);
	    Cell celln = rown.getCell(2);
	    String OrgName = celln.getStringCellValue();
	    
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else if (BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver= new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("Invalid Broswer");
	    }
	    
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.get(URL);
	   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();
	   driver.findElement(By.linkText("Organizations")).click();
	   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	   driver.findElement(By.name("accountname")).sendKeys(OrgName+" "+random);
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  Actions action= new Actions(driver);
	  action.moveToElement(hover).perform();
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  
	   }
}
