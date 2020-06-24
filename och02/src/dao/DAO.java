package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DAO {
	//초기화 블럭
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	  //자신 타입의 static 필드
      private static DAO instance=new DAO();
      //생성자 캡슐화
      private DAO() {}
      //외부에서 자신의 instance를 접근할 수 있는 get메소드
	public static DAO getInstance() {
		return instance;
	}
	//연결맺기 메소드
	//메소드에서 throws Exception() 처리하면
	//호출하는 메소드에서 예외 처리해줘야함.
	public Connection getConnection() throws SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String password="hr";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
