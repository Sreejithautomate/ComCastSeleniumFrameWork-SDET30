package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTablePracticetest extends BaseClass {
	
	@Test
	public void webTablePracticetest()
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickonContactLNK();
		wLib.scrollAction(driver);
	
		 List<WebElement> checkboxes = sDriver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		 for(WebElement ch:checkboxes)
		 {
			 ch.click();
		 }
			

	}

}
