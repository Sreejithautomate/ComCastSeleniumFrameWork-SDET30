package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTablefivContctTest extends BaseClass {
	
	@Test
	public void webTablefivContctTest() throws InterruptedException
	{

	HomePage hp = new HomePage(driver);
	hp.clickonContactLNK();
	
	wLib.scrollAction(driver);

    WebElement checkboxes = sDriver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td/input[@name='selected_id']"));
     WebElement del = sDriver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[10]/a[text()='del']"));
	checkboxes.click();
	Thread.sleep(2000);
    del.click(); 
    Alert alrt = sDriver.switchTo().alert();
    alrt.accept();
	}
	
	@Test
	public void webTableLastNAme1()
	{
		HomePage hp = new HomePage(driver);
		hp.clickonContactLNK();
		
		wLib.scrollAction(driver);

		 List<WebElement> lastname = sDriver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		for(WebElement ls:lastname)
		{
			String name = ls.getText();
			System.out.println(name);
		}
		 
	}

		
	}
