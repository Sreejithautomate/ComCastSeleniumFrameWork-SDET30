package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OpportunityInfoPage {

	@FindBy(xpath  ="//span[@class='dvHeaderText']")
	private WebElement opprtHDRtxt;
	
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpprtHDRtxt() {
		return opprtHDRtxt;
	}
	
	public String getOpprtHdr() {
		return opprtHDRtxt.getText();
		
	}
	
	
}
