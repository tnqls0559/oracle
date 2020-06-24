package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;

public class PreparedMainExample2 {
	public static void main(String[] args) throws SQLException {
		 DAO dao = DAO.getInstance();
		 Connection con = dao.getConnection();
		 
		 String sql ="select eno,ename,job,salary,dname" + 
		 		     "  from employee a, department b" + 
		 		     " where a.dno=b.dno" + 
		 		     " and hiredate > ?" + 
		 		     " and a.dno=?" + 
		 		     " and a.job like ?";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 //int index=0;
		 pstmt.setString(1, "87/05/05");//1->++index
		 pstmt.setInt(2, 20);//2->++index
		 pstmt.setString(3, "CLERK");//3->++index
		 
		 ResultSet rs = pstmt.executeQuery();
		 //결과출력
		
		 while(rs.next()) {//index사용 시 숫자를 다 ++index로 바꿔준다.
			 //index=0;
			 System.out.println(rs.getInt(1)+","
		                       +rs.getString(2)+","
					           +rs.getString(3)+","
		                       +rs.getInt(4)+","
					           +rs.getString(5));
		
		 }
	
	}

}
