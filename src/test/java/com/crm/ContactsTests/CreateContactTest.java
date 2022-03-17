package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactTest extends BaseClass {
	
	@Test//(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	public void createContactTest() throws EncryptedDocumentException, IOException
	{

		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
		
		
	  
	   
	   HomePage hp= new HomePage(driver);
	   hp.clickonContactLNK();
	   String ExpectedHdr = "Contacts";
	   String actualHDR = driver.findElement(By.linkText("Contacts")).getText();
	   Assert.assertEquals(actualHDR, ExpectedHdr);
	   Reporter.log("== Click On Contacts ==",true);
	   
	   ContactsPage cp = new ContactsPage(driver);
	   cp.clickOncreatContactLookUpIMG();
	   String ExpectedHdr1 = "Creating New Contact";
	   String actualHDR2 = driver.findElement(By.className("lvtHeaderText")).getText();
	   Assert.assertEquals(actualHDR2, ExpectedHdr1);
	   Reporter.log("== Click On Create Contacts ==",true);
	   
	   CreateContactsPage ccp=new CreateContactsPage(driver);
       ccp.CreateContacts(lastName);
       Reporter.log("== Create Contacts ==",true);
       
       ContactInfoPage cinp=new ContactInfoPage(driver);
       String hder = cinp.ValidateContactCtreation();
       if(hder.contains(lastName))
       {
    	   System.out.println(hder +"-->"+ "Contact is created successfully");
       }
       else 
       {System.out.println( "Contact not created");
    	   
       }
	   
	}

}
