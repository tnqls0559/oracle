package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointExample {
	public static void main(String[] args) throws SQLException {
		//db연결객체 얻기
		Dao dao = Dao.getInstance();
		//db연결맺기
		Connection con = dao.getConnection();
		//commit 수동처리
		con.setAutoCommit(false);
		//쿼리실행,delete,savepoint 처리
		Statement stmt = con.createStatement();
		stmt.executeQuery("drop table dept");//commit명령어 없이 바로 db에 반영
		stmt.executeQuery("create table dept as select * from department");
		//데이터 조회
		ResultSet rs = stmt.executeQuery("select * from dept");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//삭제작업
		stmt.executeUpdate("delete from dept where dno=40");
		//commit;
		con.commit();
		//데이터 조회
		rs = stmt.executeQuery("select * from dept");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}		
		//savepoint s1지정
		Savepoint s1 = con.setSavepoint("s1");//savepoint s1;
		System.out.println("savepoint s1-----");
		//삭제작업
		stmt.executeUpdate("delete from dept where dno=30");
		//데이터 조회
		rs = stmt.executeQuery("select * from dept");		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//savepoint s2;--savepoint 세이브포인트명
		Savepoint s2 = con.setSavepoint("s2");
		System.out.println("savepoint s2-----");
		//삭제작업
		stmt.executeUpdate("delete from dept where dno=10");
		//데이터 조회
		rs = stmt.executeQuery("select * from dept");		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//rollback to s2;
		con.rollback(s2);
		System.out.println("savepoint s2까지 되돌리기---");
		
		//데이터 조회
		rs = stmt.executeQuery("select * from dept");		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//rollback to s1;
		con.rollback(s1);
		System.out.println("savepoint s1까지 되돌리기---");
		//데이터 조회
		rs = stmt.executeQuery("select * from dept");		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//rollback to commit
		con.rollback();
		System.out.println("이전 commit까지 되돌리기");
		//데이터 조회 
		rs = stmt.executeQuery("select * from dept");		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
		}
		//commit 자동모드로 되돌리기
		con.setAutoCommit(true);		
	}
}
