package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointExample2 {
	public static void main(String[] args) throws SQLException {
		//1.db연결객체 얻기
		Dao dao = Dao.getInstance();
		//2.db연결맺기
		Connection con = dao.getConnection();
		con.setAutoCommit(false);//수동저장모드
		//3.쿼리객체 생성
		Statement stmt = con.createStatement();
		//4.쿼리실행
		stmt.executeUpdate("delete from dept where dno=40");
		//조회
		ResultSet rs = stmt.executeQuery("select * from test_save");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		//savepoint설정
		Savepoint s1 = con.setSavepoint("s1");
		System.out.println("savepoint s1지정---");
		stmt.executeUpdate("delete from dept where dno=30");
		//조회
		 rs = stmt.executeQuery("select * from test_save");
		 while(rs.next()) {
		 System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		con.rollback(s1);//savepoint까지 rollback; rollback(savepoint)
		System.out.println("savepoint s1까지 rollback---");
		//조회
		rs = stmt.executeQuery("select * from test_save");
		while(rs.next()) {
		System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		con.setAutoCommit(true);//자동모드로 복귀

	}

}
