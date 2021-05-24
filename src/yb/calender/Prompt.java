package yb.calender;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT ="cal> ";
	
	public int parseDay(String week) {
		if(week.equals("일")) {
			return 0;
		}
		else if(week.equals("월")) {
			return 1;
		}
		else if(week.equals("화")) {
			return 2;
		}
		else if(week.equals("수")) {
			return 3;
		}
		else if(week.equals("목")) {
			return 4;
		}
		else if(week.equals("금")) {
			return 5;
		}
		else if(week.equals("토")) {
			return 6;
		}
		else
			return 0;
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = 1;
		int year = 0;
		int weekday = 0; 
		while(true) {
			
			System.out.println("년도를 입력하세요(exit:-1)");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			if(year == -1) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();

			System.out.println("첫째 날의 요일을 입력하세요(일, 월, 화, 수, 목, 금, 토)");
			System.out.print(PROMPT);
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			
			
			if(month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			cal.printCalender(year, month, weekday);
			
		}
		System.out.println("종료합니다.");
		
		scanner.close();
	}

	public static void main(String[] args) {
		
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
		
	

	}

}
