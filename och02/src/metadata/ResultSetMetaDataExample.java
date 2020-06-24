package metadata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import propertiesPackage.DAO;

public class ResultSetMetaDataExample {
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
		//메타데이터 정보 객체 얻기
		ResultSetMetaData rsmd = rs.getMetaData();
		//조회된 칼럼 갯수
		int cols =rsmd.getColumnCount();
		//칼럼 목록보기
		for(int i=1;i<=cols;i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println("\n---------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
	}
	}

