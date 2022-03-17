package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDateFromExcelSheetTest {
	@Test
	public  void readDateFromExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		// Step 1 : load excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2: create a workbook
		Workbook wb= WorkbookFactory.create(fis);
		
		//step 3 : get the sheet
		Sheet sheetNAme = wb.getSheet("Name1");
		
		//step 4:  get the row
		 Row rown = sheetNAme.getRow(0);
		 
		 //step 5 : get the cell
		 
		Cell celln = rown.getCell(0);
		
		//step 6 : Read date from cell
		String cellvalue = celln.getStringCellValue();
		
	    System.out.println(cellvalue);
	   	
		
		
		
	}

}
