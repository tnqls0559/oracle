package scrollable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import propertiesPackage.ProDAO;

public class ScrollableMainExample {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInstance();
		Connection con = dao.getConnection();
		Statement stmt = 
				con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						            ResultSet.CONCUR_UPDATABLE);
		//쿼리문
		String sql = "select * from employee order by eno";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("eno:"+rs.getInt("eno")+",name:"+
		                       rs.getString("ename")+","+"job:"+rs.getString("job"));
		}
		System.out.println("-----------------------------------------------");
		//next() 함수의 역방향으로 진행 previous()
		while(rs.previous()) {
			System.out.println("eno:"+rs.getInt("eno")+",name:"
		                       +rs.getString("ename")+","+"job:"+rs.getString("job"));
		}
		System.out.println("first------------------------------------------------");
		//출력결과 set의 제일 처음 행으로 이동
		rs.first();//
		System.out.println("eno:"+rs.getInt("eno")+",name:"
                +rs.getString("ename")+","+"job:"+rs.getString("job"));
		
		//출력결괴 set의 제일 마지막 행으로 이동
		System.out.println("last-------------------------------------------------");
		rs.last();
		System.out.println("eno:"+rs.getInt("eno")+",name:"
                +rs.getString("ename")+","+"job:"+rs.getString("job"));
	    
	    //출력결과의 특정행으로 이동
		System.out.println("absolute---------------------------------------------");
		rs.absolute(3);//absolute(이동할 행 번호)
		System.out.println("eno:"+rs.getInt("eno")+",name:"
                +rs.getString("ename")+","+"job:"+rs.getString("job"));
	 }//main메소드 끝.
}
