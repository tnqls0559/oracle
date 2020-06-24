package propertiesPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertiesMainExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//연결객체 생성
		DAO dao=DAO.getInstance();
		//연결맺기
		Connection con=dao.getConnection();
		//쿼리객체 생성
		String sql="select eno,ename, salary from employee where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 10);
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3));
		}
	}
}
