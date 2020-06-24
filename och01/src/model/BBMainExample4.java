package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BBMainExample4 {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		//1.DB객체 얻기
		Dao dao = Dao.getInstance();
		//2.db연결
		Connection con = dao.getConnection();
		//3.조회 객체 얻기
		while(true){
		String sql = "select * from bb order by seq";
		Statement stmt = con.createStatement();
		//4.결과처리
		//쿼리 실행 후 결과 받기
		sql="select * from bb order by seq";
		   //쿼리 실행 후 결과 받기
		   ResultSet rs = stmt.executeQuery(sql);
		   System.out.println("순번\t| 타이틀\t|조회수\t|등록일\t\t|좋아요\t|싫어요");
		   System.out.println("-----------------------------------------------------");
		   while(rs.next()) {
			   int seq = rs.getInt(1);//1번
			   String title = rs.getString("title");//칼럼명
			  // String content = rs.getString(3);//순번 3번
			   int cnt = rs.getInt(4);//순번 4번
			   String regdate = rs.getString(5);//순번 5번
			   int good = rs.getInt(6);
			   int bad = rs.getInt(7);
			   System.out.println(seq+"\t|"+title+"\t|"+cnt+"\t|"+regdate.substring(0,10)+"\t|"+good+"\t|"+bad);
		   }
		   //좋아요/싫어요 처리
		   System.out.println("추천/비추천 글 번호를 입력하세요>");
		   int seq = scanner.nextInt();
		   System.out.println("추천1/비추천2로 입력하세요>");
		   int gb = scanner.nextInt();
		   //추천/비추천 건수 추가
		   if(gb==1)
			 sql="update bb set good = good+1 where seq="+seq;
		   else if(gb==2)
			 sql="update bb set bad = bad+1 where seq="+seq;
		   //쿼리문 실행
		    stmt.executeUpdate(sql);  
		    System.out.println("계속할까요?");
		    char yesNo=scanner.next().charAt(0);
		    if(yesNo!='y') break;
	   }
	}
	}


