package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BBMainExam {
	public static void main(String[] args) throws SQLException {
        //1.값 입력 -- insert
		  //1.연결객체 생성- 1회.
		    Dao dao = Dao.getInstance();
		  //2.연결맺기- 1회
		    Connection con = dao.getConnection();
		  //3.쿼리객체 생성- 1회
		    Statement stmt = con.createStatement();
		  //4.입력처리
		    String sql = "insert into bb values(5,'제목2','내용2',5,'2012/05/07')";
		    //4-1.입력 후 처리
		    //executeUpdate(쿼리문)의 결과 처리된 데이터 건수(행:row)를 정수로 리턴
		    int result = stmt.executeUpdate(sql);
		    System.out.println("입력 된 건수:"+result);
		    
	    //2.확  인  -- select
		  //4.조회
		   if(result>0) {
			   sql="select * from bb order by seq";
			   //쿼리 실행 후 결과 받기
			   ResultSet rs = stmt.executeQuery(sql);
			   while(rs.next()) {
				   int seq = rs.getInt(1);//1번
				   String title = rs.getString("title");//칼럼명
				   String content = rs.getString(3);//순번 3번
				   int cnt = rs.getInt(4);//순번 4번
				   String regdate = rs.getString(5);//순번 5번
				   System.out.println(seq+"|"+title+"|"+content+"|"+cnt+"|"+regdate);
			   }
		   }
	}
}
