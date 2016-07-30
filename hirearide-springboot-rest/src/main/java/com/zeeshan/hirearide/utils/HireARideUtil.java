package com.zeeshan.hirearide.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *<h1>HireARideUtil</h1>
 * added as the Utility class for application's some commmon needs
 * presently it has a method for calculating difference in days between two dates 
 * 
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category Utility Class
 * @since July 2016
 *
 */
public class HireARideUtil {
	
	//returns differnece between two dates in days. calculcates 24hours as a day.
	/**
	 * calculates the difference in days between two dates 
	 * it calculates the difference by subtracting the dates in long.
	 * thus calculates 24 hours as a day 
	 * 
	 * @param d1 - First Date
	 * @param d2 - Second Date
	 * @return no. of days 
	 */
	public  long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
