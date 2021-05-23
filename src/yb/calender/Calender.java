package yb.calender;

import java.util.Scanner;

public class Calender {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1 ];
	}
	
	public void printSampleCalender() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9  10 11 12 13 14");
		System.out.println(" 15 16 17 18 19 20 21");
		System.out.println(" 22 23 24 25 26 27 28");
		
	}
	
	public static void main(String[] args) {
		
		String PROMPT ="cal> ";
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		
//		for(int i = 0; i< repeat; i++) {
//			System.out.println("달을 입력하세요");
//			int month = scanner.nextInt();
//			
//			System.out.printf("%d 월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));	
//		}
		int month = 1;
		while(true) {
			
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();			
			if(month == -1) {
				break;
			}
			else if(month > 12) {
				continue;
			}
			System.out.printf("%d 월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
			
		}
		System.out.println("종료합니다.");
		//cal.printSampleCalender();
		scanner.close();

	}

}
