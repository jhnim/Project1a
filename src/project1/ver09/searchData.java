package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class searchData extends IConnectImpl{

	public searchData() {
		super();
	}
	
	@Override
	public void dataSearch() {
		try {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("데이터 검색을 시작합니다.");
			System.out.print("이름:");
			String searchName = scanner.nextLine();
			
			while(true) {
				
				stmt = con.createStatement();
				
				String query = "SELECT name, phone, birth FROM PHONEBOOK_TB WHERE name LIKE '%%' ";
				
				rs= stmt.executeQuery(query);
				
				while(rs.next()) {
					String name = rs.getString(1); //name컬럼
					String phone = rs.getString(2);
					String birth = rs.getString(3);
		
					
					System.out.printf("%s %s %s \n", name, phone, birth);
				}
				
				break;
			}

			
		} 
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); //DB 자원반납
		}
	}
	
	
}
