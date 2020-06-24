package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;
public class SQL1MainExample {
	public static void main(String[] args) throws SQLException {
		//1.db연결객체 생성
		DAO dao = DAO.getInstance();
		//2.db연결맺기
		Connection con = dao.getConnection();
		//3.쿼리객체 생성
		//Statement stmt = con.createStatement();
		String ename="SMITH";
		//쿼리 템플릿 생성
		String sql="select job,salary,hiredate from employee where ename=?";
		//쿼리객체 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		//바인딩변수(?)에 값 세팅
		pstmt.setString(1, ename);
		//4.뭐리 실행 및 결과 처리
		ResultSet rs = pstmt.executeQuery();
		//select한 결과 행이 한 개인 경우 if(rs.next())로 확인
		if(rs.next()) {//SELECT한 결과가 존재하면 처리
			String job = rs.getString("job");
			int salary = rs.getInt("salary");
			String hiredate = rs.getString("hiredate");
			System.out.println(job+":"+salary+":"+hiredate);
		}
		//자원해제
		rs.close();
		pstmt.close();
		con.close();
	}
}
