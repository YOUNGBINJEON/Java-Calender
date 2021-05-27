package yb.calender;

import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록  ");		
		System.out.println("| 2. 일정 검색  ");		
		System.out.println("| 3. 달력 보기");		
		System.out.println("| h. 도움말 q. 종료");		
		System.out.println("+----------------------+");
				
	}
	
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
		
		while(true) {
			System.out.println("명령(1,2,3,h,q)");
			String cmd = scanner.next();
			if(cmd.equals("1")) {
				cmdRegister();
			} else if(cmd.equals("2")) {
				cmdSearch();
			} else if(cmd.equals("3")) {
				cmdCal(scanner, cal);
			} else if(cmd.equals("h")) {
				printMenu();
			} else if(cmd.equals("q")) {
				break;
			}
		}
			
			
		System.out.println("종료합니다.");
		
		scanner.close();
	}

	private void cmdCal(Scanner s, Calender c) {
		int month = 1;
		int year = 0;
		
		System.out.println("년도를 입력하세요");
		System.out.print(PROMPT);
		year = s.nextInt();

		System.out.println("달을 입력하세요");
		System.out.print(PROMPT);
		month = s.nextInt();
		
		
		if(month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		c.printCalender(year, month);
		
	}
	

	private void cmdSearch() {
		// TODO Auto-generated method stub
		
	}

	private void cmdRegister() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
		
	

	}

}
