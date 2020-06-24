package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpListMain {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("조회 할 입사연도를 입력하세요>");
		String year = scanner.next();//"19870101"
		//1.db연결객체얻기
		Dao dao = Dao.getInstance();
		//2.db연결
		Connection con = dao.getConnection();
		//3.쿼리객체생성
		Statement stmt = con.createStatement();
		//4.쿼리실행 및 결과 받기
		String sql = "select eno, ename, hiredate " +
				" from Employee " +
				" where hiredate>=to_date('"+year+"')";
		System.out.println("쿼리문:"+sql);
		ResultSet rs = stmt.executeQuery(sql);
		//5.결과처리
		while(rs.next()) {
			int eno = rs.getInt(1);//getInt("eno")
			String ename = rs.getString(2);//getString("ename")
			String hiredate = rs.getString(3);//getString("hiredate")
			System.out.println(eno+","+ename+","+hiredate);
		}
	}
}