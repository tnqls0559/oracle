package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import dao.DAO;

public class SQL3MainExamaple {
	public static void main(String[] args) throws SQLException {
		  //1.db연결객체 생성
		  DAO dao = DAO.getInstance();
		  //2.db연결맺기
		  Connection con = dao.getConnection();
		  //3.쿼리객체 생성
		  Statement stmt = con.createStatement();
		  //4.뭐리 실행 및 결과 처리
		  int dno = 60;
		  String dname = "SALES"; String loc = "NEW YORK";
		  String sql ="insert into dept values("+dno+",'"+dname+"','"+loc+"')";//문자인 경우는 홑따옴표까지 붙여줘야함.
		  System.out.println("쿼리문:"+sql);
		  //executeUpdate()메소드는 실행 후 db에 반영된 행 수(건 수)를 리턴하는 함수
		  int result = stmt.executeUpdate(sql);
		  if(result>0)
			  System.out.println("입력성공");
		  else
			  System.out.println("입력실패");

	}
}
