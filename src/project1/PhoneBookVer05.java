package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
import project1.ver05.PhoneInfo;

public class PhoneBookVer05 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			
			manager.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
	
			switch(choice) {
			
			case MenuItem.DATAINPUT:
				
				manager.dataInput();
				break;
				
			case MenuItem.DATASEARCH:
				
				manager.dataSearch();
				break;
				
			case MenuItem.DATADELETE:
				
				manager.dataDelete();
				break;
				
			case MenuItem.DATAALLSHOW:
				
				manager.dataAllShow();
				break;
				
			case MenuItem.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
	}
	

}
