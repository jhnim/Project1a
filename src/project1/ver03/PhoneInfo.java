package project1.ver03;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo() {
		name="";
		phoneNumber="";
		birthday="";
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showPhoneInfo(){
		
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+phoneNumber);
		if(birthday != null) {
			System.out.println("생년월일:"+birthday);
		}
		else {
			System.out.println("입력되지 않음");
		}
		System.out.println();
	}
}

