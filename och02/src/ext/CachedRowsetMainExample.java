package ext;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetMainExample {
	public static void main(String[]args) throws SQLException{
		//CachedRowSet인터페이스에 url,user,password,command메소드 제공
		//CachedRowSet jdbcRs = new CachedRowSetImpl();
		// jdk 1.7 이후 번전에서는 RowSetProvider이용
		CachedRowSet jdbcRs = RowSetProvider.newFactory().createCachedRowSet();
		jdbcRs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jdbcRs.setUsername("hr");
		jdbcRs.setPassword("hr");
		jdbcRs.setCommand("select * from employee order by eno");
		//실행 
		jdbcRs.execute();
		//결과 출력
		while(jdbcRs.next()) {
			System.out.println(jdbcRs.getInt(1)+","+jdbcRs.getString(2)+","+jdbcRs.getString(3));
		}
		//자원해제
		jdbcRs.close();
	}//main메소드 끝.
}
