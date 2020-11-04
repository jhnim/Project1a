package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager extends Thread{
	
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
		
		
		System.out.println("============ 메뉴를 선택하세요 =============");
		System.out.println("1.주소록 입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("======================================");
		
		System.out.print("메뉴선택:");
	}
	
	public void dataInput() {	
		
		System.out.println("===주소록을 입력함===");
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
				System.out.print("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
					
					set.remove(phone);//기존데이터 삭제
					set.add(new PhoneInfo(iName, iPhone));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("===입력이 완료되었습니다===");
				
			}
			break;
			
		case SubMenuItem.PHONESCHOOLINFO:
			
			System.out.print("전공:"); String iMajor = scanner.nextLine();
			System.out.print("학년:"); int iGrade = scanner.nextInt();
			
			PhoneSchoolInfo phoneSchoolInfo = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
			
			if(!set.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.print("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
					scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
					
					set.remove(phoneSchoolInfo);
					set.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("===입력이 완료되었습니다===");
			}
			break;
			
		case SubMenuItem.PHONECOMPANYINFO:
			
			System.out.print("회사:"); String iCompanyName = scanner.nextLine();
			PhoneCompanyInfo phoneCompanyInfo = new PhoneCompanyInfo(iName, iPhone, iCompanyName);
			
			if(!set.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.print("덮어쓸까요? Y(y)/N(n)");
				String yn = scanner.nextLine();
				
				if(yn.equals("Y") || yn.equals("y")) {
						
					set.remove(phoneCompanyInfo);
					set.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName));
				}
				else if (yn.equals("N")||yn.equals("n")) {
					return;
				}
				System.out.println("===입력이 완료되었습니다===");
			}
			break;
		}
	}
	
	public void dataSearch() {
		
		//boolean isFind = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("찾을 이름을 검색하세요.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();

		Iterator ir = set.iterator();
		
		for(PhoneInfo pi : set) // 순회
		{
			if(searchName.equals(pi.name)) {
				System.out.println("==주소록을 출력함==");
				pi.showPhoneInfo();
				System.out.println("===주소록 출력이 완료되었습니다===");
			}
		}
		
		if(phoneInfo.name.equals(searchName)==true) {
			System.out.println("==찾는 정보가 없습니다==");
		}
		
	}
	
	public void dataDelete() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		boolean deleteFlag = false;
		
		Iterator<PhoneInfo> ir = set.iterator();
		while(ir.hasNext()) { //객체를 불러옴 
			PhoneInfo pi= ir.next();
			if(pi.name.equals(deleteName)) {
				ir.remove();
				deleteFlag=true;	
			}
		}
		if(deleteFlag==false) {
			System.out.println("===데이터 삭제 실패===");
		}
		else {
			System.out.println("===데이터 삭제 완료===");
		}
	}
	
	public void dataAllShow() {
		
		for(PhoneInfo pi : set)
		{
			pi.showPhoneInfo();		
		}
		
		System.out.println("주소록 정보가 출력되었습니다.");
	}
	
	
	public void autoOption(AutoSaveT t) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("===저장옵션을 선택===");
		System.out.println("1.자동저장On 2.자동저장Off");
		System.out.print("선택:");
		int pn = scanner.nextInt();
		
		switch (pn) {
		case 1: //자동저장
			if(t.getState()==Thread.State.NEW){
				
				System.out.println("자동저장을 시작합니다.");
				t.start();//시작
			}
			else {
				System.err.println("이미 자동저장이 실행중입니다.");
			}
			break;
			
		case 2:
			t.interrupt();//중지
			System.err.println("자동저장OFF");
			break;
		}
	}
	
	
	public void write() {
		
		try {
			Iterator<PhoneInfo> ir = set.iterator();
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			while(ir.hasNext()) {
				PhoneInfo pi = ir.next();
				if(pi instanceof PhoneSchoolInfo) {
					out.printf("이름:%s, 전화번호:%s, 전공:%s, 학년:%d\n", pi.name, pi.phoneNumber, ((PhoneSchoolInfo) pi).major, ((PhoneSchoolInfo) pi).grade );
				}
				if(pi instanceof PhoneCompanyInfo) {
					out.printf("이름:%s, 전화번호:%s, 회사:%s\n", pi.name, pi.phoneNumber, ((PhoneCompanyInfo) pi).companyName);
				}
				if(pi instanceof PhoneInfo) {
					out.printf("이름:%s, 전화번호:%s\n", pi.name, pi.phoneNumber);
				}
			}
			out.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	}
	
	public void exitRead() {
		
		try {
			ObjectInputStream in =
					new ObjectInputStream(
						new FileInputStream("src/project1/ver08/PhoneBook.obj")
					);
			
				set = (HashSet<PhoneInfo>)in.readObject();
				in.close();
				
		} catch (Exception e) {
			System.out.println("복원시 예외발생");
		}
	
	}
	
	//친구정보를 파일로 저장하기
	public void exitSave(){
		
		try {
			
			//파일저장을 위한 스트림 생성
			ObjectOutputStream out =	
					new ObjectOutputStream(
							new FileOutputStream("src/project1/ver08/PhoneBook.obj")
							);
			
			out.writeObject(set);
			out.close();
			System.out.println("obj파일로 저장되었습니다.");
		}
		catch (Exception e) {
			System.out.println("파일저장시 예외발생");
		}	
	}
}



 
	
