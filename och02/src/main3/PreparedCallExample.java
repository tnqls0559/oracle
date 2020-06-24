package main3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DAO;

public class PreparedCallExample {
	public static void main(String[] args) throws SQLException {
		//connection 객체 생성
		DAO dao = DAO.getInstance();
		//연결맺기
		Connection con = dao.getConnection();
		//프로시져실행 객체 생성
		//"{call 프로시져명(?)}";
		String sql = "{call pr_emp_upSal(?)}";
		//프로시져 문 실행
		CallableStatement cstmt = con.prepareCall(sql);
		//출력용 변수 설정 registerOutParameter(index, sql타입);
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);//출력용 변수
		cstmt.execute();//프로시져 실행
		System.out.println("인상 후 급여 총액:"+cstmt.getInt(1));
	} 
}