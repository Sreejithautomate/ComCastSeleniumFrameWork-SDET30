package com.crm.PRACTICE;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	public void practiceGenericUtils() throws IOException
	{
		JavaUtility jLib= new JavaUtility();
		int ranNum = jLib.getRandomNum();
		String Sysdate = jLib.getsystemDate();
		String sysdateFormat = jLib.getSystemDateFormat();
		System.out.println(ranNum);
		System.out.println(Sysdate);
		System.out.println(sysdateFormat);
		
		PropertyFileUtility  propLib = new PropertyFileUtility();
		String broWName = propLib.readDateFromPropertyFile("Browser");
		System.out.println(broWName);
	}

}
