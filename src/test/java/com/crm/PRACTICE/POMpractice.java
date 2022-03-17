package com.crm.PRACTICE;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMpractice 
{
	@Test
	public void practice()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp("admin", "admin");
		
		HomePage hmpge=new HomePage(driver);
		hmpge.signOut(driver);
				
	}
}
 
