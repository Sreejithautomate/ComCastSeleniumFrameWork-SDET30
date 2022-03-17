package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2Practice {

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj= new Object[6][2];
		
		obj[0][0]="S1";
		obj[0][1]="1";
	
     	obj[1][0]="s2";
		obj[1][1]="2";
		
		obj[2][0]="s3";
		obj[2][1]="3";
		
		obj[3][0]="s4";
		obj[3][1]="4";
		
		obj[4][0]="s5";
		obj[4][1]="5";
		
		obj[5][0]="s6";
		obj[5][1]="6";
	
		
		return obj;
	}
	
	@Test(dataProvider="getData")
	public void  readData(String series,String qty)
	{
		System.out.println(series +" "+ qty);
	}
	
}
