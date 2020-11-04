package project1.ver04;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int grade;
	
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	public void showSchoolInfo() {
		
		showPhoneInfo();
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
	}
	
	
}
