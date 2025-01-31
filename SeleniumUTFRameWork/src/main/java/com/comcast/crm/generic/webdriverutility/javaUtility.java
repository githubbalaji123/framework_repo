package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {

	public int getRandomNumber() {
		Random ranDom=new Random();
		int randomNumber=ranDom.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;	
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sdf.format(cal.getTime());
		return reqDate;
	}
	
}
