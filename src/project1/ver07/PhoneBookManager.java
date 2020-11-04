package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager{
	
	//hashset객체 생성
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>(); 
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
		
		
		
		//String iName, iPhone, iMajor, iCompanyName;
		//int iGrade;
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반 2.동창 3.회사");
		System.out.print("선택>> ");
		
		
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
			scanner.nextLine();
	
		System.out.print("이름:"); String iName = scanner.nextLine();
		System.out.print("전화번호:"); String iPhone = scanner.nextLine();
		
		switch(select) {
		
		case SubMenuItem.PHONEINFO:

			PhoneInfo phone = new PhoneInfo(iName,iPhone);
			
			if(!set.add(new PhoneInfo(iName, iPhone))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
					
					set.remove(phone);//기존데이터 삭제
					set.add(new PhoneInfo(iName, iPhone));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("데이터 입력이 완료되었습니다.");
				
			}
			break;
			
		case SubMenuItem.PHONESCHOOLINFO:
			
			System.out.print("전공:"); String iMajor = scanner.nextLine();
			System.out.print("학년:"); int iGrade = scanner.nextInt();
			
			PhoneSchoolInfo phoneSchoolInfo = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
			
			if(!set.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
					scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
					
					set.remove(phoneSchoolInfo);
					set.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			break;
			
		case SubMenuItem.PHONECOMPANYINFO:
			
			System.out.print("회사:"); String iCompanyName = scanner.nextLine();
			PhoneCompanyInfo phoneCompanyInfo = new PhoneCompanyInfo(iName, iPhone, iCompanyName);
			
			if(!set.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
						
					set.remove(phoneCompanyInfo);
					set.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			break;
		}
	}
	
	public void dataSearch() {
		
		//boolean isFind = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("데이터 검색을 시작합니다...\n");
		System.out.print("이름:");
		String searchName = scanner.nextLine();

		Iterator ir = set.iterator();
		
		for(PhoneInfo pi : set) // 순회
		{
			if(searchName.equals(pi.name)) {
				System.out.println("데이터 검색이 완료되었습니다.");
				pi.showPhoneInfo();
			}
		}
		
		if(phoneInfo.name.equals(searchName)==true) {
			System.out.println("찾는 정보가 없습니다.");
		}
	}
	
	public void dataDelete() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		Iterator ir = set.iterator();
			
		while(ir.hasNext()) { //객체를 불러옴 
			ir.next();//컬렉션에서 객체 하나를 가져와서
			
			
			if(deleteName.equals(phoneInfo.name)) { // 삭제할 이름이 객체안에 있으면
				ir.remove(); // 삭제한다.
				//set.remove(deleteName);
				System.out.println("데이터 삭제가 완료되었습니다.");
				
			}
			
			return;
		}
	}
	
	public void dataAllShow() {
		
		for(PhoneInfo pi : set)
		{
			pi.showPhoneInfo();		
		}

		System.out.println("주소록 정보가 출력되었습니다.");
	}
}
