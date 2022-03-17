package com.crm.OrganizationTests;

import java.io.IOException;

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

public class CreateOrganizationWithIndTypeAndTypeTest extends BaseClass{
	
	@Test
	public void createOrganizationWithIndTypeAndTypeTest() throws IOException
	{
	
	
	int random = jLib.getRandomNum();
	String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
	String indType = eLib.readDataFromExcel("Org", 1, 3);
	String typeName = eLib.readDataFromExcel("Org", 1, 4);
	System.out.println(typeName);

   
	/* Click on Organization link*/
    HomePage hp= new HomePage(driver);
	hp.clickonOrgLNK();
	Reporter.log("== Click On Org ==",true);
	
	
	/* Click on Create Organization img*/
	OrganizationPage orgp= new OrganizationPage(driver);
	orgp.clickOnCreateOrganzationLnk();
	Reporter.log("== Click Create  Org ==",true);
	
	/*  Create organization with mandatory fields (orgname,indtype, type) */ 
	CreateOrganizationPage corgp=new CreateOrganizationPage(driver);
	corgp.createNewOrganiza(orgName, indType,typeName);
	Reporter.log("== Create new Org ==",true);
		
	

/*Validating and confirming the organization creation*/
OrganizationInformationPage orginfp= new OrganizationInformationPage(driver);
String header = orginfp.verifyorganizationName();

if(header.contains(orgName))
{
	System.out.println(header + " -->"+ "Organization Created successfully");
}

else
{
	System.out.println(" Failed to create Organization");
}


}
}