package main3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DAO;

public class PreparedCallExample2 {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		//"{?=call 함수명(매개변수)}";
		String sql ="{?=call fn_salary_ename(?)}";//첫번째?는 결과, 두번째?는 조건입력
		CallableStatement cstmt = con.prepareCall(sql);
		//바인딩 변수 설정
		//출력용 변수 설정 registerOutParameter(index, 타입);
		cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
		//입력용 변수 설정 set타입(index, 값);
		cstmt.setString(2, "ALLEN");
		//실행
		cstmt.execute();
		//결과출력
		System.out.println("salary:"+cstmt.getInt(1));
	}
}