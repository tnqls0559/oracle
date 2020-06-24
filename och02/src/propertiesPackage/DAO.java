package propertiesPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//싱글톤
public class DAO {
	private static DAO instance = new DAO();
	private DAO() {}
	public static DAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		//jdbc.properties 파일과 이동통로설정(stream)
		FileInputStream fis = new FileInputStream("c:\\config\\jdbc.properties");
		//jdbc.properties 파일형태로 저장하기 위한 객체 생성
		Properties pro = new Properties();
		//키=값 형태로 객체에 저장 load(스트림)
		pro.load(fis);//driver=oracle.jdbc.driver.OracleDriver
		
		Class.forName(pro.getProperty("driver"));
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		System.out.println("url:"+url);
		System.out.println("user:"+user);
		System.out.println("password:"+password);
		
		Connection con = DriverManager.getConnection(url, user, password);
		return con; 
	}
}
