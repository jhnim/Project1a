package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.AutoSaveT;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;



public class PhoneBookVer08 extends MenuSelectException {

	public static void main(String[] args) throws MenuSelectException{
		
		PhoneBookManager manager = new PhoneBookManager(100);
		manager.exitRead();
		AutoSaveT t = new AutoSaveT(manager);
		
		while(true) {
			
			manager.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			
			try {
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
					
				case MenuItem.AUTOOPTION:
					
					manager.autoOption(t);
					
					break;
					
				case MenuItem.EXIT:
					
					manager.exitSave();
					System.err.println("프로그램을 종료합니다.");
					return;
				}
				
				if(choice<1 || choice>6) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			}
			catch (MenuSelectException e) {
				System.err.println("1~6사이의 정수를 입력하세요.");
			}
			catch (InputMismatchException e) {
				System.err.println("숫자를 입력하세요.");
			}
			catch (Exception e) {
				System.err.println("에러발생");
				
			}
		}
	}
	
	
}
