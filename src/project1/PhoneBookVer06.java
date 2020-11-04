package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;
import project1.ver06.PhoneInfo;



public class PhoneBookVer06 extends MenuSelectException {

	public static void main(String[] args) throws MenuSelectException{
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			
			manager.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			
			try {
				int choice = scanner.nextInt();

				if(choice<1 || choice>5) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
				
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
			catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
			}
			catch (Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
		}
	}
}
