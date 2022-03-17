package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

/**
 * This class contain generic 
 * @author sreej
 *
 */
public class DataBaseUtility {
	
	Connection con=null;

	/**
	 * This Method will establish connection to the particulat database
	 * @param driver
	 * @param Url
	 * @param Username
	 * @param Password
	 * @throws SQLException
	 */
	public void connectToDataBase() throws SQLException
	{
		Driver driver= new Driver();
		con=DriverManager.getConnection(IpathConstants.dBUrl,IpathConstants.dBUserName,IpathConstants.dbPassword);
	}
	
	
	/**
	 * This Method will close the Db connection
	 * @throws SQLException 
	 */
	public void closeDbConnection() throws SQLException
	{
		con.close();
	}

	
	/**
	 * This MEthod will read Data from
	 * @param driver
	 * @param co
	 * @param stat
	 * @param Statement
	 * @throws SQLException
	 */
	public String  ReadDataFromDataBase(String query,String expectData,int index) throws SQLException 
	{
		String data =null;
		boolean flag=false;
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
			data = result.getString(index);
			if(data.equalsIgnoreCase(expectData))
			{
				flag=true;
				break;
				
			}
			
		}
			if(flag)
			{
				System.out.println(data +" "+" Verified the data ");
				return expectData;
			}
			
			else
			{
				System.out.println(" Data not verified");
				return " ";
			}
			
			
			
			
				
				
		}
		
	}
	
