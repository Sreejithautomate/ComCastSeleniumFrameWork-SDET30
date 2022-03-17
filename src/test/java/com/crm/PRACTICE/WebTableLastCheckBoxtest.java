package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class WebTableLastCheckBoxtest extends BaseClass {
	
	@Test
	public void webTableLastCheckBoxtest()
	{

	HomePage hp = new HomePage(driver);
	hp.clickonContactLNK();
	
	wLib.scrollAction(driver);

	List<WebElement> checkboxes = sDriver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
	 
	int count = checkboxes.size();
	for(int i=count-1;;)
	{
		checkboxes.get(i).click();
		break;
		
	}
 }
}