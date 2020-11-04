package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void menuInfo() {

		
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		
	}
	
	
	public static void main(String[] args) {
		
		PhoneInfo phoneInfo = new PhoneInfo();
		
		while(true) {
			
			menuInfo();
			
			Scanner scanner = new Scanner(System.in);
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			
			case 1:
				
				String iName, iPhone, iBirth;
				
				System.out.println("이름:"); iName = scanner.nextLine();
				System.out.println("전화번호:"); iPhone = scanner.nextLine();
				System.out.println("생년월일:"); iBirth = scanner.nextLine();
				
				System.out.println("입력된 정보출력...");
				System.out.println("name:"+iName);
				System.out.println("phone:"+iPhone);
				System.out.println("birth:"+iBirth);
				System.out.println();
				
				break;
				
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
	}
}
