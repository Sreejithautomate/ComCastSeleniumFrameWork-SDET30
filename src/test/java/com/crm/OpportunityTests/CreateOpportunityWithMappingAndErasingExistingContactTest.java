package com.crm.OpportunityTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JList;

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

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOpportunityWithMappingAndErasingExistingContactTest extends BaseClass {
	
	@Test
	public void createOpportunityWithMappingAndErasingExistingContactTest() throws IOException, InterruptedException
	{
		int random = jLib.getRandomNum();
		
		String orgNameRan = eLib.readDataFromExcel("Org", 1, 2);
	
		String OpportNameran = eLib.readDataFromExcel("Opportunity", 1, 2)+random;
		String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
	  
		 HomePage hp = new HomePage(driver);
		 hp.clickonContactLNK();
		 
		 ContactsPage cp= new ContactsPage(driver);
		 cp.clickOncreatContactLookUpIMG();
		 
		  CreateContactsPage crcp= new CreateContactsPage(driver);
		  crcp.CreateContacts(lastName);
	   
	     hp.clickonOrgLNK();
	   	OrganizationPage op= new OrganizationPage(driver);
	   	op.clickOnCreateOrganzationLnk();
		
		
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrganiza(orgNameRan);
		 
		
		 //Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		 driver.findElement(By.name("potentialname")).sendKeys(OpportNameran);
		 WebElement relatedToDrop = driver.findElement(By.id("related_to_type"));
		  Select sel= new Select(relatedToDrop);
		  List<WebElement> relatedToOptn = sel.getOptions();
		  for(WebElement relat:relatedToOptn)
		  {
			 if( relat.getText().equals("Contacts"))
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
			 
		
			 driver.findElement(By.id("search_txt")).sendKeys(orgNameRan);
			 driver.findElement(By.name("search")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//a[contains(text(),'"+orgNameRan+"')]")).click();
			 
			 
			 Set<String> win1 = driver.getWindowHandles();
			 for(String wn1:win1)
			 {
				 driver.switchTo().window(wn1);
				 
			 }
			 
			 
			 driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::input[@type='image']")).click();
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 String alerttext = driver.switchTo().alert().getText();
			 if(alerttext.equals("Related To cannot be none"))
			 {
				 System.out.println("Opprotunity not created as contact details erased before creating opportunity");
			 }
	}

}
