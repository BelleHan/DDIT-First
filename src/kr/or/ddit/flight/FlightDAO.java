package kr.or.ddit.flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightDAO {
	public List<FlightDTO> selectFlightList() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //JDBC 드라이버 로딩
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java"); // 데이터베이스 접속
//		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.28", "HHS96", "java"); // 데이터베이스 접속
		Statement statement = connection.createStatement(); //SQL명령 수행하는 statement 객체 생성
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT *");
		builder.append("  FROM FLIGHT");
		List<FlightDTO> list = new ArrayList<FlightDTO>();
		ResultSet resultSet = statement.executeQuery(builder.toString()); // execteQuery(db에 명령)로 명령하면 ResultSet(명령에 대한 반환값)이라는 객체를 돌려줌
																		  // ResultSet : SELECT의 결과를 저장하는 객체
		while (resultSet.next()) { //resultSet.next - 커서의 다음 행이 존재할 경우 true를 리턴			
			String flightId = resultSet.getString("FLIGHT_ID"); //컬럼의 이름을 지정해서 값을 가져옴
			String depTime = resultSet.getString("DEP_TIME");
			String arrTime = resultSet.getString("ARR_TIME");
			String depAirport = resultSet.getString("DEP_AIRPORT");
			String arrAirport = resultSet.getString("ARR_AIRPORT");
			String airlineId = resultSet.getString("AIRLINE_ID");
			String airlineName = resultSet.getString("AIRLINE_NAME");
			int	price = resultSet.getInt("PRICE");
			list.add(new FlightDTO(flightId, depTime, arrTime, depAirport, arrAirport, airlineId, airlineName, price));
		}	//DTO 객체에 위 변수에 저장한 컬럼값을 저장
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
	
	public List<FlightDTO> selectFlight(FlightDTO dto) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java");		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT A.FLIGHT_ID,");
		builder.append("       A.DEP_TIME,");
		builder.append("       A.ARR_TIME,");
		builder.append("       A.DEP_AIRPORT,");
		builder.append("       A.ARR_AIRPORT,");
		builder.append("       A.AIRLINE_ID,");
		builder.append("       A.AIRLINE_NAME,");
		builder.append("       A.PRICE");
		builder.append("  FROM FLIGHT A, AIRPORT B, CITY C, (SELECT A.FLIGHT_ID AS FLID,");
		builder.append("                                            C.CITY_NAME AS DCIN");
		builder.append("                                       FROM FLIGHT A, AIRPORT B, CITY C");
		builder.append("                                      WHERE A.ARR_AIRPORT=B.AIRPORT_ID");
		builder.append("                                        AND B.CITY_ID=C.CITY_ID) D");
		builder.append(" WHERE A.DEP_AIRPORT=B.AIRPORT_ID");
		builder.append("   AND B.CITY_ID=C.CITY_ID");
		builder.append("   AND A.FLIGHT_ID=D.FLID");
		builder.append("   AND C.CITY_NAME = ?");
		builder.append("   AND D.DCIN = ?");
		builder.append("   AND SUBSTR(DEP_TIME,1,10) = ?");
		
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, dto.getDepAirport());	
		statement.setString(2, dto.getArrAirport());
		statement.setString(3, dto.getDepTime());
		ResultSet resultSet = statement.executeQuery();
		List<FlightDTO> list = new ArrayList<>();
				
		while (resultSet.next()) {
			String flightId = resultSet.getString("FLIGHT_ID");
			String depTime = resultSet.getString("DEP_TIME");
			String arrTime = resultSet.getString("ARR_TIME");
			String depAirport = resultSet.getString("DEP_AIRPORT");
			String arrAirport = resultSet.getString("ARR_AIRPORT");
			String airlineId = resultSet.getString("AIRLINE_ID");
			String airlineName = resultSet.getString("AIRLINE_NAME");
			int	price = resultSet.getInt("PRICE");
			list.add(new FlightDTO(flightId, depTime, arrTime, depAirport, arrAirport, airlineId, airlineName, price));
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
	
}
	
