package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePtactice {
	
@DataProvider

public Object[][] getData()
{
	Object[][] obj = new Object[4][3];
	
	obj[0][0]="mi";
	obj[0][1]="1000";
	obj[0][2]=30;
	
	obj[1][0]="Lg";
	obj[1][1]="1001";
	obj[1][2]=10;
	
	obj[2][0]="Nokia";
	obj[2][1]="2000";
	obj[2][2]=20;
	
	obj[3][0]="Moto";
	obj[3][1]="1001";
	obj[3][2]=11;
	
	return obj;
			
}

@Test(dataProvider="getData")
public void readData(String model,String price,int qty)
{
	System.out.println(model + " "+ price+ " "+ qty);
	}

}
