package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		Connection con=null;
		
		try{
			Driver driverRef= new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		Statement stat = con.createStatement();
		int result = stat.executeUpdate("insert into student values('4','xyz','')");
		if(result==1)
		{
			System.out.println("date inserted successfully");
		}
		else
		{
			System.out.println("Insertion of date is failed");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			con.close();
			System.out.println("the connection is closed");
			
		}
	}

}
