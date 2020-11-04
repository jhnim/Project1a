package project1;

import java.util.Scanner;

import project1.ver03.PhoneBookManager;
import project1.ver03.PhoneInfo;

public class PhoneBookVer03 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			
			manager.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
	
			switch(choice) {
			
			case 1:
				
				manager.dataInput();
				break;
				
			case 2:
				
				manager.dataSearch();
				break;
				
			case 3:
				
				manager.dataDelete();
				break;
				
			case 4:
				
				manager.dataAllShow();
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
	}
	

}
