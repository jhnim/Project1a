package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class phoneBookData extends IConnectImpl{

	
	public phoneBookData() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	@Override
	public void dataInput() {
		try {
			//1. 쿼리문 준비 : 값이 세팅이 필요한 부분을 ?(인파라미터)로 대체한다.
			String query = "INSERT INTO PHONEBOOK_TB VALUES (seq_phonebook.nextval,?, ?, ?)";
			
			//2. prepared객체생성 : 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);
			
			//3. DB에 입력할 값을 사용자로부터 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.println("이름:");
			String name = scan.nextLine();
			System.out.println("전화번호:");
			String phone = scan.nextLine();
			System.out.println("생년월일:");
			String birth = scan.nextLine();
			
			//4. 인파라미터 설정 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작
			psmt.setString(1, name);
			psmt.setString(2, phone);
			psmt.setString(3, birth);

			
			//5. 쿼리실행을 위해 prepared객체를 실행한다.
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	
	@Override
	public void dataDelete() {
		
		try {
			//1. 쿼리문준비
			String query = "DELETE FROM PHONEBOOK_TB WHERE name=? ";
			//2. prepared객체생성
			psmt = con.prepareStatement(query);
			//3. 사용자로부터 입력받은 값을 인파라미터로 설정
			psmt.setString(1, scanValue("삭제할 이름"));
			//4. 쿼리실행
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void dataSearch() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		
		try {
			if(searchName!=null) {
				
				stmt = con.createStatement();
				
				String query = "SELECT name, phone, birth FROM PHONEBOOK_TB WHERE name LIKE '%"+ searchName+"%'";
				
				rs= stmt.executeQuery(query);
				
				while(rs.next()) {
					
					String name = rs.getString("name"); //name컬럼
					String phone = rs.getString("phone");
					String birth = rs.getString("birth");
					
					
					System.out.printf("%s %s %s \n", name, phone, birth);
					
				}
			}
		} 
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
	}
}
