package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods related to read and write datas from ExcelFile
 * @author sreej
 *
 */
public class ExcelFileUtility {
	/**
	 * This Method will read data from Excel sheet and return the value when sheetName rowNo and cellNo from user
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sheet = wb.getSheet(sheetName);
		Row rown = Sheet.getRow(rowNo);
		Cell celln = rown.getCell(cellNo);
		String value = celln.getStringCellValue();
		return value;
		
	}
	
	
	
	/** This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * */
	public  Object[][] readDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for (int j=0;j<cellcount;j++)
				
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();			
				}
		}
		
		return data;
	}
/**
 * This Method will write data to Excel sheet when sheetName rowNo  cellNo and value from user
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public void WriteDataToExcel(String sheetName,int rowNo,int cellNo,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row rown = sheet.getRow(rowNo);
		Cell celln = rown.createCell(cellNo);
		celln.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
		
		
	}
	
	/**
	 * This method will return the count of row in as sheet based on the sheetname 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int rownCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		return rowNum;
	}
	
}
    
