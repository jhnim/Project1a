package project1.ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable {

	String name;
	String phoneNumber;
	
	public PhoneInfo() {
		name="";
		phoneNumber="";
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showPhoneInfo(){
		
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+phoneNumber);
	}
	
	
	@Override
	public int hashCode() {
		int hc = name.hashCode();
		return hc;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo phone = (PhoneInfo)obj;
		
		if(this.name.equals(phone.name)) {
			
			return true;
		}
		else {
			return false;
		}
	}
}



