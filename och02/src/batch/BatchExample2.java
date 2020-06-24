package batch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import propertiesPackage.ProDAO;

public class BatchExample2 {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInstance();
		Connection con = dao.getConnection();
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		//일괄처리 목록에 트랜잭션 작업 등록
		stmt.addBatch("update department set loc='엘에이' where dno=50");
		stmt.addBatch("update department set loc='달라스' where dno=20");
		stmt.addBatch("update department set loc='보스톤' where dno=40");
		//일괄처리 작업 실행
		int[] result = stmt.executeBatch();
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]>0?i+"번째 작업성공":i+"번째 작업실패");
	}
	//일괄작업이 모두 정상적으로 끝났는지 확인
	boolean isAllCompleted=false;
	for(int i=0;i<result.length;i++) {
		if(result[i]>0) isAllCompleted=true;
		else {
			isAllCompleted=false;
			break;
		}
	}
	//하나라도 비정상이명 rollback, 모두 정상이면 commit;
	if(isAllCompleted) con.commit();
	else con.rollback();
	//자동commit모드로 복귀
	con.setAutoCommit(true);
}
}
