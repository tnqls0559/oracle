package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SaleMainExam {
        static Dao dao = Dao.getInstance();
		static Connection con = dao.getConnection();
		static Scanner scanner = new Scanner(System.in);
	//java프로그램은 db연동 시 commit이 자동으로 설정되어있음.	
	//java프로그램은 autocommit모드(autocommit=true)
	public static void main(String[] args) throws SQLException {
		//commit모드를 수동처리
		con.setAutoCommit(false);//commit수동처리
		//재고등록
		insertStock();
		//장바구니등록
		bucketProc();
		//구매
		saleProc();
		System.out.println("구매확정하시겠습니까?");
		String yesNo =scanner.next();
		if("yes".equals(yesNo))
			con.commit();//db에 영구저장 메소드 commit();
		else if("no".equals(yesNo))
			con.rollback();//이전 상태로 되돌리기 메소드 rollback();
		//commit모드 자동으로 되돌리기
		con.setAutoCommit(true);//commit자동처리
	}
private static void saleProc() {
try {
	Statement stmt=con.createStatement();
	//매출등록
	stmt.executeUpdate("insert into sale values((select nvl(max(seq),0)+1 from sale),"
			         + " 'hong','mango', " + 
			"            (select qty from bucket where item='mango'), " + 
			"             sysdate)");
    //재고 처리
	 stmt.executeUpdate("update stock set "
	 		          + " qty=qty-(select qty from bucket where item='mango') "
	 		          + " where item='mango'");	
     //장바구니 비우기 
	 stmt.executeUpdate("delete from bucket");	  
	}catch(Exception e){}
}

private static void bucketProc() {
		 try {
				Statement stmt=con.createStatement();
				stmt.executeUpdate("insert into bucket values('mango',3)");
				stmt.executeUpdate("update bucket set qty=4 where item='mango'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

private static void insertStock() {
	//상품명,수량	
	  try {
		Statement stmt=con.createStatement();
		//'mango'재고있는지 여부확인
		ResultSet rs = stmt.executeQuery("select count(*) from stock where item='mango'");
		if(rs.next()) {
			if(rs.getInt(1)>0)
				stmt.executeUpdate("update stock set qty=10 where item='mango'");
			else
				stmt.executeUpdate("insert into stock values('mango',10)");
		}		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}
}

