package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.DAO;

public class SQL5MainExamaple2 {
	static DAO dao = null;
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static void main(String[] args) throws SQLException {
		  //1.db연결객체 생성
		  dao = DAO.getInstance();
		  //2.db연결맺기
		  con = dao.getConnection();
		  //3.쿼리객체 생성
		  stmt = con.createStatement();
		  //4.쿼리 실행 및 결과 처리
		  int dno=10;
		  String sql = "select * from dept where dno="+dno;
		  System.out.println("쿼리문:"+sql);
		  //executeUpdate()메소드는 실행 후 db에 반영된 행 수(건 수)를 리턴하는 함수
		  boolean isTrue=myExecute(sql);
		  System.out.println(isTrue);
		  //자원해제
		  rs.close();
		  stmt.close();
		  con.close();
	}

	private static boolean myExecute(String sql) {
		if(sql.substring(0,6).equals("select")) {
			try {
				rs = stmt.executeQuery(sql);
				if(rs.next()) return true;
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}else {
			try {
			int result = stmt.executeUpdate(sql);
			if(result>0)return false;
		}catch (SQLException e) {
		}
		}
		return false;
	}
}
