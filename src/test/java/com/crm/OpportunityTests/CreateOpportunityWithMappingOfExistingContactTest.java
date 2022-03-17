package com.crm.OpportunityTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOpportunityWithMappingOfExistingContactTest {

	@Test
	public void createreateOpportunityWithMappingOfExistingContactTest() throws IOException, InterruptedException 
	{
		/*  Step 1 : Generate Random */
		Random ran= new Random();
		int random = ran.nextInt();
		
		/* Step 2: Read Data from external Resource  */
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pOBJ=new Properties();
		pOBJ.load(fis);
		String BROWSER = pOBJ.getProperty("Browser");
		String URL = pOBJ.getProperty("Url");
		String USERNAME = pOBJ.getProperty("Username");
		String PASSWORD = pOBJ.getProperty("Password");

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OpportunityTC_01.xlsx");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Opportunity");
		Row row = sheet.getRow(1);
		String opportNameran = row.getCell(2).getStringCellValue()+random;
		 String expClosDate = row.getCell(5).getStringCellValue();

		
		Sheet sheet2 = wb.getSheet("Contact");
		Row rown2 = sheet2.getRow(1);
		String lastNameran = rown2.getCell(2).getStringCellValue();
		
		/* Step 3:Launch Browser */
		
		WebDriver driver = null;;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
				{
			       driver=new FirefoxDriver();
				}
		else
		{
			System.out.println("Invalid Broswer");
		}
		
		/* Step 4: Login to Application */
		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  /* Step 5 : Create Contacts  */
		  
		  driver.findElement(By.linkText("Contacts")).click();
		  driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		  driver.findElement(By.name("lastname")).sendKeys(lastNameran);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  /* Step 6 : Create Opportunity */
		  
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Opportunities")).click();
		  driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		  driver.findElement(By.name("potentialname")).sendKeys(opportNameran);
		   WebElement relatedToDrop = driver.findElement(By.id("related_to_type"));
		   Select sel= new Select(relatedToDrop);
		  List<WebElement> relatedToOptn = sel.getOptions();
		  for(WebElement relat:relatedToOptn)
		  {
			 if( relat.getText().equalsIgnoreCase("Contacts"))
					 {
				        sel.selectByValue(relat.getText());
					 }
		  }
		  
		  driver.findElement(By.xpath("//img[@alt='Select']")).click();
		 Set<String> win = driver.getWindowHandles();
		 for(String wn:win)
		 {
			 driver.switchTo().window(wn);
		 }
		 
	
		 driver.findElement(By.id("search_txt")).sendKeys(lastNameran);
		 driver.findElement(By.name("search")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[contains(text(),'"+lastNameran+"')]")).click();
		 
		 
		 Set<String> win1 = driver.getWindowHandles();
		 for(String wn1:win1)
		 {
			 driver.switchTo().window(wn1);
			 
		 }
		 
		 driver.findElement(By.name("closingdate")).clear();
		 driver.findElement(By.name("closingdate")).sendKeys(String.valueOf(expClosDate));
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 /* Step 7 : verifying the Opportunity header*/
		 
		 String opporthdr = driver.findElement(By.xpath("//span[contains(text(),'Opportunity Information')]")).getText();
		 
		 if(opporthdr.contains(lastNameran));
		 {
			 System.out.println("The Opportunity id created : "+""+"[ POT ]"+""+lastNameran+""+"-  Opportunity Information");
		 }
		  
		
		
		
		
		
		
		
		
	}
}
