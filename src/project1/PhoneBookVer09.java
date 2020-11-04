package project1;

import java.util.Scanner;

import project1.ver09.PhoneBookManager;
import project1.ver09.PhoneInfo;
import project1.ver09.phoneBookData;
import project1.ver09.searchData;

public class PhoneBookVer09{
	
	
	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager(100);
		phoneBookData pb = new phoneBookData();
		searchData sd = new searchData();
		
		while(true) {
			
			manager.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
	
			switch(choice) {
			
			case 1:
				
				pb.dataInput();
				break;
				
			case 2:
				
				pb.dataSearch();
				
				break;
				
			case 3:
				
				pb.dataDelete();
				break;
				
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

}
