package com.crm.OpportunityTests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpprotunityWithCampaignTest {
	
	@Test
	public void createOpprotunityWithCampaignTest() throws IOException, InterruptedException
	{
		WebDriver driver = null;
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelFileUtility eLib= new ExcelFileUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		
		
		int random = jLib.getRandomNum();
		String BROWSER = pLib.readDateFromPropertyFile("Browser");
		String URL = pLib.readDateFromPropertyFile("Url");
		String USERNAME = pLib.readDateFromPropertyFile("Username");
		String PASSWORD = pLib.readDateFromPropertyFile("Password");
		
		String opprtNameRan = eLib.readDataFromExcel("Opportunity", 1, 2)+random;
		String exptCloseDate = eLib.readDataFromExcel("Opportunity", 1, 5);
		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
		String OrgnameRan = eLib.readDataFromExcel("Org", 1, 2)+random;
	    String CampaignName = eLib.readDataFromExcel("Campaign", 1, 2);
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		 else if (BROWSER.equalsIgnoreCase("firefox"))
		  {
			  driver= new FirefoxDriver();
		  }
		  else
		  {
			  System.out.println("Invalid Broswer");
		  }
		
		  wLib.maximizeWindow(driver);
		  wLib.waitForPageLoad(driver);
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  
		  
		  

		  
		  driver.findElement(By.linkText("Contacts")).click();
		  driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String cntHdr = driver.findElement(By.xpath("//span[contains(text(),'"+lastName+"')]")).getText();
		  if(cntHdr.contains(lastName))
		  {
			  System.out.println("Contact IS Created With Lastname"+" "+ lastName);
		  }
		  
	   

	     WebElement hver = driver.findElement(By.linkText("More"));
		wLib.mouseHover(driver, hver);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String camgHdr = driver.findElement(By.xpath("//span[contains(text(),'"+CampaignName+"')]")).getText();
		  if(camgHdr.contains(CampaignName))
		  {
			  System.out.println("Campaign IS Created "+" "+ CampaignName);
		  }
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
        driver.findElement(By.name("potentialname")).sendKeys(opprtNameRan);
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
		  
		  driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@alt='Select']")).click();
		  wLib.switchToWindow(driver,"Contacts");
		  driver.findElement(By.id("search_txt")).sendKeys(lastName);
		  driver.findElement(By.name("search")).click();
		      driver.findElement(By.xpath("//a[contains(text(),'"+lastName+"')]")).click();
			 
			 //Thread.sleep(3000);
			 
		   wLib.switchToWindow(driver,"Potentials");
		  WebElement leadSourceDrop = driver.findElement(By.name("leadsource"));
		  Select sel1= new Select(leadSourceDrop);
		  sel1.selectByValue("Employee");
		  
		  
		  
		
		
	}

}
