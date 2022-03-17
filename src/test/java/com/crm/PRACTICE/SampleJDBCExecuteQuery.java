package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		//Step1 :register the Database
		
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2 : Connect to  the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//Step3: issue create statement
		Statement stat = con.createStatement();
		
		//step4 : execute the query
		
		ResultSet result = stat.executeQuery("select * from student");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		con.close();
		}

}
