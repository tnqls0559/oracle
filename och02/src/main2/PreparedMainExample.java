package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAO;

public class PreparedMainExample {
	public static void main(String[] args) throws SQLException {
		 DAO dao = DAO.getInstance();
		 Connection con = dao.getConnection();
		 //insert into employee values(7999,'홍길동','CLERK',7788,sysdate,1500,null,20)
		 
		 String sql ="insert into employee values(?,?,?,?,sysdate,?,null,?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, 7999);
		 pstmt.setString(2, "홍길동");
		 pstmt.setString(3, "CLERK");
		 pstmt.setInt(4, 7788);
		 pstmt.setInt(5, 1500);
		 pstmt.setInt(6,20);
		 
		 int result = pstmt.executeUpdate();
		 if(result>0)System.out.println("성공");
		 else System.out.println("실패");

	}

}
