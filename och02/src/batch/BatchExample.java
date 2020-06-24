package batch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import propertiesPackage.DAO;

public class BatchExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//일괄처리
		//연결객체 생성
		DAO dao=DAO.getInstance();
		//연결맺기
		Connection con=dao.getConnection();
		//쿼리객체 생성
		Statement stmt = con.createStatement();
		//commit 수동처리
		con.setAutoCommit(false);
		//일괄작업 목록에 저장
		//stmt.addBatch(쿼리문)
		stmt.addBatch("insert into dept values(60,'SALES','DALLAS')");
		stmt.addBatch("insert into dept values(70,'OPERATION','L.A')");
		stmt.addBatch("insert into dept values(80,'RESEARCH','CHICAGO')");

		//일괄처리한 갯수만큼의 결과 리턴
		//executeBatch();
		int[] result = stmt.executeBatch();//[1][1][1]->정상처리 [1][0][1]->X
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]>0?(i+1)+"번째 성공":(i+1)+"번째 실패");
		}
		//db에 반영
		con.commit();
		
		con.setAutoCommit(true);
	}
}
