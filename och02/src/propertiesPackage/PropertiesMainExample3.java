package propertiesPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PropertiesMainExample3 {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInstance();
		Connection c = dao.getConnection();
		String sql ="select dno, dname, loc from dept where dno=?";
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setInt(1, 10);
		
		ResultSet rs = pstmt.executeQuery();
		//헤드부분 제외하고 데이터 부분만 출력
		//메타데이터 출력 rs.getMetaData()
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("칼럼 수:"+rsmd.getColumnCount());
		for(int i=1;i<=rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i)+"\t");
		}
		System.out.println("\n-------------------------------");
		if(rs.next()) {//if(rs.next()){} =rs.next();
		System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
	}
}