package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.DAO;

public class SQL3MainExamaple {
	public static void main(String[] args) throws SQLException {
		  //1.db연결객체 생성
		  DAO dao = DAO.getInstance();
		  //2.db연결맺기
		  Connection con = dao.getConnection();
		  //3.쿼리객체 생성
		  int dno = 60;
		  String dname = "SALES"; String loc = "NEW YORK";
		   String sql ="insert into dept values(?,?,?)";//문자인 경우는 홑따옴표까지 붙여줘야함.
		  PreparedStatement pstmt = con.prepareStatement(sql);
		  //값 바인딩 처리
		  pstmt.setInt(1, dno);
		  pstmt.setString(2, dname);
		  pstmt.setString(3,loc);
		  //4.쿼리 실행 및 결과 처리 
		  System.out.println("쿼리문:"+sql);
		  //executeUpdate()메소드는 실행 후 db에 반영된 행 수(건 수)를 리턴하는 함수
		  int result = pstmt.executeUpdate();
		  if(result>0)
			  System.out.println("입력성공");
		  else
			  System.out.println("입력실패");

	}
}
