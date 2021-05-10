package yb.calender;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		
		// 입력 : 키보드로 두 수의 입력을 받는다
		System.out.println("두 수를 입력하세요 ex) a, b");
		// System.in = 키보드 입력 의미
		Scanner scanner = new Scanner(System.in);
		String num = scanner.nextLine();
		String [] splitedValue = num.split("\\s*,\\s*");
		int first = Integer.parseInt(splitedValue[0]);
		int second = Integer.parseInt(splitedValue[1]);
		
		// 방법 2
		/*
		 * int a,b;
		 * Scanner scanner - new Scanner(System.in);
		 * String s1, s2;
		 * System.out.println("두 수를 입력해 주세");
		 * s1 = scanner.next();
		 * s2 = scanner.next();
		 * a = Integer.parseInt(s1);
		 * b = Integer.parseInt(s2);
		 * System.out.printf("%d + %d = %d", a, b, a+b);
		 * */
		
		// 출력 : 화면에 두 수 의 합을 출력한다.
		System.out.printf("%d + %d = %d", first, second, first+second);
		
		//스캐너 사용후 종료를 선언해줘야 한다.
		scanner.close();
	}

}
