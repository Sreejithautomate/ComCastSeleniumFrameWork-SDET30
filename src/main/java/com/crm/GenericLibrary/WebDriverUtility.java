package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

/**
 * this class consists all generic method related to WebdriverActions
 * @author sreej
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window 
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * This Method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 * This Method Will Wait For 20 Sec for an Element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This Method will wait for the element to be visible 
	 * @param driver
	 * @param element
	 * @return
	 */
	public void waitElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	/**
	 * This Method will select data from dropdown list using value
	 * @param value
	 * @param element
	 */
	
	public void select(String value, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 *  This Method will select data from dropdown list using visible text
	 * @param element
	 * @param value
	 */
	public void select( WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	
	
	/**
	 * This Method will Perform Mouse Hover Action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This Method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dradAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method is used to perfom doble click action on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	/**
	 * This Method will perform double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This Method perform right click on Webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{ 
		Actions act = new Actions(driver);
	    act.contextClick().perform();
		
	}
	
	/**
	 * This Method Perform right click on webelemnt
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This Method will schitch To Frame based on Index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This  Method will schitch To Frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * 
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	
	/**
	 * This Method will accept alert popup
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This Method will cancel the  alert popup
	 */
	public void canceltAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This Method will switch to window depeding on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> winHnd = driver.getWindowHandles();
		
		
		for(String win:winHnd)
		{
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if(title.contains(partialWinTitle))
				{
				break;
			    }
		}
	}
	
	
	/** 
	 * This Method will perform random Scroll
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver) 
	{
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,500)");
	}
	
	
	/**
	 * This Method will scroll until a specific element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 int y = element.getLocation().getY();
		 js.executeScript("window.scrollBy(0,"+y+")", element);
		 
	}
	

	/**
	 * This method will take screenshot and save it in a destination folder
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	
	public void getScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc= new File("./screenshot/"+screenShotName+".png");
		FileUtils.copyFile(src, desc);
		
	}
	
	
}

