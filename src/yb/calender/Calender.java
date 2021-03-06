package yb.calender;


import java.util.Date;
import java.util.HashMap;

public class Calender {
	
	private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	private HashMap <Date, planItem> planMap;
	
	public Calender() {
		planMap = new HashMap<Date, planItem>();
	}
	
	public void registerPlan(String strDate, String plan) {
		
		planItem p = new planItem(strDate, plan);
		planMap.put(p.getDate(), p);
	}
	
	public planItem searchPlan(String strDate) {
		Date date = planItem.getDatefromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
			return MAX_DAYS[month];
			
		}
	}
	
	public void printCalender(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" 일  월  화  수 목  금 토");
		System.out.println("------------------------");
		
		// get weekday automatically
		int weekday = getWeekDay(year, month, 1);
		// pring blank space
		for( int i = 0; i< weekday; i ++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		if(isLeapYear(year)) {
			
		}
		
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		if(count <7) {
			delim =count;
		}else {
			delim =0;
		}
		// print first line
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		// print from second line to last
		count++;
		for(int i = count; i<= maxDay; i++) {
			System.out.printf("%3d",i);
			if(i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();

		
	}
	private int getWeekDay(int year, int month, int day) {
		// 
		int syear = 1970;
		
		final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thrusday
		
		int count = 0;
		
		for(int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		//System.out.println(count);
		for(int i = 1; i< month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}

}
