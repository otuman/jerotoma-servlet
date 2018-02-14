package com.jerotoma.helpers;

import java.sql.Date;

public class DateProcessor {

	
	public static java.sql.Date getCurrentSQLDate(){
		return new Date(new java.util.Date().getTime());
		
	}
}
