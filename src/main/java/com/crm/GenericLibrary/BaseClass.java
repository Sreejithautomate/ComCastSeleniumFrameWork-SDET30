package com.crm.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class BaseClass {
	
	/* Create Object of all Utilities */
	public DataBaseUtility dbLib= new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeTest","regression"})
	public void ConnectDataBase()
	{
		//dbLib.connectToDataBase();
		Reporter.log("==== Db Connection Established successfully===",true);
	}
	
	@BeforeClass(groups = {"SmokeTest","regression"})
	//@BeforeTest
	public void launchBrowser() throws IOException
	{
      String BROWSER = pLib.readDateFromPropertyFile("Browser");
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
       Reporter.log("==Broswer Launch ==",true);
       sDriver=driver;
	}
	
	@BeforeMethod//(groups = {"SmokeTest","regression"})
	public void logintoApp() throws IOException
	{
		String USERNAME = pLib.readDateFromPropertyFile("Username");
		String PASSWORD = pLib.readDateFromPropertyFile("Password");
		String URL=pLib.readDateFromPropertyFile("Url");
		
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("====Login to Application Successfully == ", true);
	
	}
	
	@AfterMethod(groups = {"SmokeTest","regression"})
	public void logOutApp()
	{
		HomePage hp= new HomePage(driver);
		hp.signOut(driver);
		Reporter.log("====Log out of Application Successfully == ", true);
	}
	
	@AfterClass(groups = {"SmokeTest","regression"})
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("====Browser closed Successfully == ", true);
	}
	
	
	@AfterSuite(groups = {"SmokeTest","regression"})
	public void closeDB()
	{
		//dbLib.closeDbConnection();
		Reporter.log("====Data Base closed Successfully == ", true);
	}
	}
	
	
	
	
