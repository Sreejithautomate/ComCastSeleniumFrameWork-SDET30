package com.crm.ObjectRepository;

import org.apache.commons.math3.primes.Primes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewOpportunityPage extends WebDriverUtility {
	
	@FindBy(name = "potentialname")
	private WebElement opprtNameEDIT;
	
	@FindBy(name ="related_to_type")
	private WebElement relatedToDropDwn;
	
	@FindBy(xpath ="//input[@id='related_to_display']/following-sibling::img[@alt='Select']")
	private WebElement relateToLokkUpIMG;
	
	@FindBy(id="search_txt")
	private WebElement searchEDIT;
	
	@FindBy(name ="search")
	private WebElement searchBTN;
	
	@FindBy(xpath =  "//input[@value='T']")
	private WebElement groupRaidoBTN;
	
	@FindBy(xpath = "//input[@value='U'] ")
	private WebElement userRadioBTN;
	
	
	@FindBy(name = "closingdate")
	private WebElement ExpCloseDateEDIT;
	
	@FindBy(name = "sales_stage")
	private WebElement salesStageDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	
	
	public CreatingNewOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewOpportnty(String optyNameRan,String relatedTo,String lastName,WebDriver driver,String expClosDate,String saleStage  )
	{
		opprtNameEDIT.sendKeys(optyNameRan);
		select(relatedTo, relatedToDropDwn);
		relateToLokkUpIMG.click();
		switchToWindow(driver,"Accounts");
		searchEDIT.sendKeys(lastName);
		searchBTN.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+ lastName+"')]")).click();
		switchToWindow(driver,"Potentials");
		userRadioBTN.click();
		ExpCloseDateEDIT.sendKeys(expClosDate);
		select(saleStage, salesStageDropDown);
		saveBTN.click();
		
	}
	
	
	
	
	
	
	
	

}
