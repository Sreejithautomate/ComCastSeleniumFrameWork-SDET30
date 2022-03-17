package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDb {
	
	@Test
	public void dataVerificationIndb() throws SQLException
	{    
		String excptResult="Ramesh";
		 Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		 Statement stat = con.createStatement();
		 ResultSet result = stat.executeQuery("select * from student");
		 while(result.next()) {
			 String actualResult = result.getString(2);
			 if(excptResult.equals(actualResult))
			 {
				 System.out.println(" Expected and Actual result is Ramesh");
				 break;
			  }
		 }
		 con.close();
		 
	

}}
