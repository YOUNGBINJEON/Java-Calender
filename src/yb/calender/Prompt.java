package yb.calender;

import java.text.ParseException;
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
	
//	public int parseDay(String week) {
//		if(week.equals("일")) {
//			return 0;
//		}
//		else if(week.equals("월")) {
//			return 1;
//		}
//		else if(week.equals("화")) {
//			return 2;
//		}
//		else if(week.equals("수")) {
//			return 3;
//		}
//		else if(week.equals("목")) {
//			return 4;
//		}
//		else if(week.equals("금")) {
//			return 5;
//		}
//		else if(week.equals("토")) {
//			return 6;
//		}
//		else
//			return 0;
//	}
	
	// Switch문으로 변경
	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}
	
	public void runPrompt() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();	
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("명령(1,2,3,h,q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;

			}
			// if문으로 구현된 123hq 
//			if(cmd.equals("1")) {
//				cmdRegister(scanner, cal);
//			} else if(cmd.equals("2")) {
//				cmdSearch(scanner, cal);
//			} else if(cmd.equals("3")) {
//				cmdCal(scanner, cal);
//			} else if(cmd.equals("h")) {
//				printMenu();
//			} else if(cmd.equals("q")) {
//				break;
//			}
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
	

	private void cmdSearch(Scanner s, Calender c) {
		System.out.println("[검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String plan ="";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
		
	}

	private void cmdRegister(Scanner s, Calender c) throws ParseException {
		System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        s.nextLine(); //ignore one newline
        System.out.println("일정을 입력해 주세요.");
        text = s.nextLine();

        c.registerPlan(date, text);
		
	}

	public static void main(String[] args) throws ParseException {
		
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
		
	

	}

}
