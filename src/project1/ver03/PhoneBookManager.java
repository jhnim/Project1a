package project1.ver03;

import java.util.Scanner;

import project1.PhoneBookVer03;

public class PhoneBookManager {
	
	PhoneInfo phoneInfo = new PhoneInfo();
	
	private PhoneInfo[] myInfo;
	private int numOfInfo;

	
	public PhoneBookManager(int num) {
		myInfo = new PhoneInfo[num];
		numOfInfo = 0;
	}
	

	public void printMenu() {
		
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택:");
	}
	
	public void dataInput() {
			
		Scanner scanner = new Scanner(System.in);
		String iName, iPhone, iBirth;
		
		System.out.print("이름:"); iName = scanner.nextLine();
		System.out.print("전화번호:"); iPhone = scanner.nextLine();
		System.out.print("생년월일:"); iBirth = scanner.nextLine();
		
		System.out.println("\n입력된 정보출력...");
		System.out.println("name:"+iName);
		System.out.println("phone:"+iPhone);
		System.out.println("birth:"+iBirth);
		System.out.println();
			
		phoneInfo = new PhoneInfo(iName, iPhone, iBirth);
		myInfo[numOfInfo++] = phoneInfo;
			
		
		System.out.println("데이터 입력이 완료되었습니다.");
			
	}
	
	public void dataSearch() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("데이터 검색을 시작합니다...");
		System.out.println("이름:");
		String searchName = scan.nextLine();

		for(int i=0 ; i<numOfInfo ; i++) {			
			System.out.println("검색중인이름:"+ myInfo[i].name);
			
			if(searchName.compareTo(myInfo[i].name)==0) {
				myInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;
			}
		}
		
		if(isFind==false)
			System.out.println("찾는 정보가 없습니다.");
	}
	
	public void dataDelete() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfInfo ; i++) {
			if(deleteName.compareTo(myInfo[i].name)==0) {
				myInfo[i] = null;
				deleteIndex = i;
				numOfInfo--;
			}
		}

		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex ; i<numOfInfo ; i++) {
				myInfo[i] = myInfo[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	public void dataAllShow() {
		
		for(int i=0 ; i<numOfInfo ; i++) {
			myInfo[i].showPhoneInfo();;
		}
		System.out.println("주소록 정보가 출력되었습니다.");
	}
}
