package kr.or.ddit.passenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

		public void insertPassenger(PassengerDTO dto) throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java");
			Statement statement = connection.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append(" INSERT INTO PASSENGER ");
			builder.append(" (PA_NAME, PA_REGNO1, PA_REGNO2, PA_HP, PA_EMAIL)");
			builder.append(" VALUES ");
			builder.append(" ('" + dto.getPaName() + "', '" + dto.getPaRegno1() + "', '" + dto.getPaRegno2() + "', '" + dto.getPaHp()  + "', '" + dto.getPaEmail() + "')");
			int result = statement.executeUpdate(builder.toString());
			if (result > 0) {
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("잘못된 정보를 입력하셨습니다.");
			}
			statement.close();
			connection.close();
			
		
	}
		
		public List<PassengerDTO> selectPassengerList() throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //JDBC 드라이버 로딩
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java"); // 데이터베이스 접속
			Statement statement = connection.createStatement(); //SQL명령 수행하는 statement 객체 생성
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT pa_name, pa_regno1, pa_email, pa_hp");
			builder.append("  FROM Passenger");
			List<PassengerDTO> list = new ArrayList<PassengerDTO>();
			ResultSet resultSet = statement.executeQuery(builder.toString()); // execteQuery(db에 명령)로 명령하면 ResultSet(명령에 대한 반환값)이라는 객체를 돌려줌
																			  // ResultSet : SELECT의 결과를 저장하는 객체
			while (resultSet.next()) { //resultSet.next - 커서의 다음 행이 존재할 경우 true를 리턴			
				String paName = resultSet.getString("PA_NAME"); //컬럼의 이름을 지정해서 값을 가져옴
				String paRegno1 = resultSet.getString("PA_REGNO1");
				String paEmail = resultSet.getString("PA_EMAIL");
				String paHp = resultSet.getString("PA_HP");
				list.add(new PassengerDTO(paName, paRegno1, paEmail, paHp));
			}	//DTO 객체에 위 변수에 저장한 컬럼값을 저장
			resultSet.close();
			statement.close();
			connection.close();
			
			return list;
		}
}
