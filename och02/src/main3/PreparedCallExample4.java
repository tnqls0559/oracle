package main3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import dao.DAO;

public class PreparedCallExample4 {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		//프로시져
		String sql="{?=call fn_hire_eno(?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		//출력용 바인딩 변수 타입 DATE
		cstmt.registerOutParameter(1,Types.DATE);
		cstmt.setInt(2, 7788);
		cstmt.execute();
		//출력 시 cstmt.getDate(인덱스);
		System.out.println("입사일자:"+cstmt.getDate(1));
	}

}
