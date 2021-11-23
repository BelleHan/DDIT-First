package kr.or.ddit.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

import kr.or.ddit.mem.MemDTO;

//import project.LogInTest;

//import oracle.jdbc.driver.OracleDriver;

public class LogInDAO {

   // 로그인
   public MemDTO selectMemId(String userId, String userPass) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "HHS96", "java");
      String sql = "select mem_id from mem where mem_id = ? and mem_pass = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, userId);
      statement.setString(2, userPass);
      ResultSet resultSet = statement.executeQuery();
      MemDTO vo = null;
      if (resultSet.next()) {
         String memId = resultSet.getString("mem_id");
         vo = new MemDTO(memId);
      }
      resultSet.close();
      statement.close();
      connection.close();

      return vo;

   }
}