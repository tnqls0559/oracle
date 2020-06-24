package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;
public class SQL2MainExample {
	public static void main(String[] args) throws SQLException {
		//1.db연결객체 생성
		DAO dao = DAO.getInstance();
		//2.db연결맺기
		Connection con = dao.getConnection();
		//3.쿼리객체 생성
		String sql="select ename,job,salary,hiredate from employee where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 10);
		//4.뭐리 실행 및 결과 처리
		ResultSet rs = pstmt.executeQuery();
		//select한 결과 행이 여러건인 경우 while(rs.next())로 확인
		while(rs.next()) {//SELECT한 결과가 존재하면 처리
			String name = rs.getString("ename");
			String job = rs.getString("job");
			int salary = rs.getInt("salary");
			String hiredate = rs.getString("hiredate");
			System.out.println(name+":"+job+":"+salary+":"+hiredate);
		}
	}
}
