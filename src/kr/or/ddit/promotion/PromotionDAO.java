package kr.or.ddit.promotion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromotionDAO {
	public List<PromotionDTO> selectPromotionList() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //JDBC 드라이버 로딩
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java"); // 데이터베이스 접속
		Statement statement = connection.createStatement(); //SQL명령 수행하는 statement 객체 생성
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT PROMOTION_NAME, PROMOTION_DETAIL, PROMOTION_RATE");
		builder.append("  FROM PROMOTION");
		List<PromotionDTO> list = new ArrayList<PromotionDTO>();
		ResultSet resultSet = statement.executeQuery(builder.toString()); // execteQuery(db에 명령)로 명령하면 ResultSet(명령에 대한 반환값)이라는 객체를 돌려줌
																		  // ResultSet : SELECT의 결과를 저장하는 객체
		while (resultSet.next()) { //resultSet.next - 커서의 다음 행이 존재할 경우 true를 리턴	
			int promotionRate = resultSet.getInt("promotion_rate");
			String promotionName = resultSet.getString("PROMOTION_NAME");
			String promotionDetail = resultSet.getString("PROMOTION_DETAIL");
			list.add(new PromotionDTO(promotionName, promotionDetail, promotionRate));
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
	
	public PromotionDTO selectPromotionId(String promoId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java");
		String sql = "select promotion_id, promotion_rate from promotion where promotion_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promoId);	
		ResultSet resultSet = statement.executeQuery();
		PromotionDTO vo = null;
		if (resultSet.next()) {
			String promotionId = resultSet.getString("promotion_id");
			int promotionRate = resultSet.getInt("promotion_rate");
			vo = new PromotionDTO(promotionId, promotionRate);			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return vo;
	}
}
