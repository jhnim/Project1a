package project1.ver04;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String companyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	public void showCompanyInfo() {
		
		showPhoneInfo();
		System.out.println("회사:"+companyName);
		
	}
}
