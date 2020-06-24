package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;

public class PreparedMainExample3 {
	public static void main(String[] args) throws SQLException {
		// 입력문
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		String sql = "insert into department values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 60);
		pstmt.setString(2, "SALES");
		pstmt.setString(3, "L.A");
		// 출력문
		int result = pstmt.executeUpdate();
		if(result>0) System.out.println("입력성공");
		else System.out.println("입력실패");
		//결과출력
		pstmt=con.prepareStatement("select dno,dname,loc from department");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		//자원해제
		rs.close();
		pstmt.close();
		con.close();
	}
}