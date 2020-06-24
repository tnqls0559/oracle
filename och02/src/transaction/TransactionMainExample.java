package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAO;

public class TransactionMainExample {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		//트랜잭션 수동처리
		//자동 커밋이 기본인데 수동처리 setAutocommit(false);
		con.setAutoCommit(false);
		String sql = "delete from department where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//바인딩변수 세팅
		pstmt.setInt(1, 60);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("삭제완료");
			con.commit();//db에 반영
		}else {
			System.out.println("삭제실패");
			con.rollback();//이전 상태로 되돌리기
		}
		//트랜잭션 자동처리
		con.setAutoCommit(true);
	}
}
