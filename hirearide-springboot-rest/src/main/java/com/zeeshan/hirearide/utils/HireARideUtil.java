package com.zeeshan.hirearide.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HireARideUtil {
	
	//returns differnece between two dates in days. calculcates 24hours as a day.
	public  long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
