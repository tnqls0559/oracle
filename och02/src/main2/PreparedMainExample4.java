package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;

public class PreparedMainExample4 {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		//preparedStatement
		String sql="select eno,ename,a.dno,dname " + 
				   "   from employee a, department b " + 
				   "  where a.dno=b.dno " + 
				   "   and a.job = ? " + 
				   "   and a.dno = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//바인딩 변수 값 처리
		pstmt.setString(1, "CLERK");
		pstmt.setInt(2, 20);
		//결과처리
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int index=0;//증감연산자를 이용 //0에서 증감되어 1,2,3,4출력
			System.out.println(rs.getInt(++index)+","
		                      +rs.getString(++index)+","
					          +rs.getInt(++index)+","
		                      +rs.getString(++index));
		}
	}
}
