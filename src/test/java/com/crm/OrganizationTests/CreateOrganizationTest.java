package com.crm.OrganizationTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = {"SmokeTest","regression"})
	
	public void createOrganizationTest() throws IOException
	{
		
		
		int random = jLib.getRandomNum();
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
		
		
		HomePage hp= new HomePage(driver);
		hp.clickonOrgLNK();
		Reporter.log("=== Click On Organization Link ===",true);
		
		//step3 : Navigate to Organization link
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganzationLnk();
		Reporter.log("=== Click create On Organization Link ===",true);
		
		
		//Step 4 : Click on Create Organization link
		//step 5 : Create organization with mandatory field
		//step 6 : click on the save button
		CreateOrganizationPage cOrp= new CreateOrganizationPage(driver);
		cOrp.createNewOrganiza(orgName);
		Reporter.log("=== create organization  ===",true);
		
		
		OrganizationInformationPage orgInfopage= new OrganizationInformationPage(driver);
		String orghdr = orgInfopage.verifyorganizationName();
		if (orghdr.contains(orgName))
		{
			System.out.println(orgName +" "+ " Organization is created");
		}
		
		
		
		
	}
	
	

}
