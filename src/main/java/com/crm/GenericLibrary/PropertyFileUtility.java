package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class will read data from property file and return value to the user
 * @return
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file for the key given by the user
	 * @return
	 * @throws IOException 
	 */
	public String readDateFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pOBJ= new Properties();
		pOBJ.load(fis);
		String value = pOBJ.getProperty(key);
		return value;
		
	}

} 
