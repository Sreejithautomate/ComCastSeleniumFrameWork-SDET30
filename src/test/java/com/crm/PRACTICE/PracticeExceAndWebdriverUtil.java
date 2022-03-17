package com.crm.PRACTICE;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class PracticeExceAndWebdriverUtil {
	
	@Test
	public void practiceExceAndWebdriverUtil() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility exl= new ExcelFileUtility();
		String value = exl.readDataFromExcel("Contact", 1, 2);
		System.out.println(value);
		exl.WriteDataToExcel("Contact", 1, 6, "Sree");
		int count = exl.rownCount("Contact");
		System.out.println(count);
	}

}
