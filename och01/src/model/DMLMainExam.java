package model;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLMainExam {

	public static void main(String[] args) {
		//1.db연결객체 생성
		DMLDao dao = DMLDao.getInstance();
		//2.db연결맺기
		Connection con = dao.getConnection();
		//3.쿼리전달객체 생성
		try {
		Statement stmt = con.createStatement();
		//4.쿼리실행
		String sql = "create table dt(dno number(2), "+"dname varchar2(14), loc varchar2(13))";
	    stmt.executeQuery(sql);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
  
	}

}
