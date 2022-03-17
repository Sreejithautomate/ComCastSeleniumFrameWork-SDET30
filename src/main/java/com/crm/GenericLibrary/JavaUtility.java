package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This Class contain Generic Methods realted to Java
 * @author sreej
 *
 */

public class JavaUtility {
	/**
	 * This method will generate random number and return it to the user
	 * @return int 
	 */
	
	public int getRandomNum()
	{
		Random ran = new Random();
		int random = ran.nextInt();
		return random;
	}

	/**
	 * this method will generate System date and return the system date to user.
	 * @return String
	 */
	
	public String getsystemDate()
	{
		Date d = new Date(); // imported from java.util
		String date = d.toString();
		return date;
		
	}
	/**
	 *  This method will generate system date in a day-Mon-Year format and return to user
	 * @return string
	 */
	public String getSystemDateFormat()
	{
		 Date d = new Date();
		 String date = d.toString();
		 System.out.println(date);
		 String[] d1 = date.split(" ");
		 
		String day = d1[2];
		String mon = d1[1];
		String time = d1[3].replace(":", "-");
		String year = d1[5];
		
		String dateformat = day+" "+mon+" "+year+" "+time;
		return dateformat;
	}
	public String getSystemMonthAndYear()
	{
		Date d = new Date();
		 String date = d.toString();
	
	   String[] d1 = date.split(" ");
	   String mon = d1[1];
	   String year = d1[5];
	   
	  if (mon.contains("Mar"))
	  mon="March";
	   
	   String monthAndYear=mon+" "+year;
	   return monthAndYear;
		
	}
	
	public String getSystemDay()
	{
		Date d= new Date();
		String date = d.toString();
		
		
		 String[] d1 = date.split(" ");
		 String day = d1[2];
		 return day;
	}
}
