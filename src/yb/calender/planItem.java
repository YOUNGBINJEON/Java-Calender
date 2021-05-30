package yb.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class planItem {

	public Date planDate;
	public String detail;
	public String peoples = "";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}
	
	public planItem(String date, String detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	public void addPeople(String name) {
		peoples += name + ",";
	}
}
