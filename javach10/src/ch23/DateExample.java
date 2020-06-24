package ch23;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date date = new Date();
		String strNow1 = date.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh시 mm분 ss초");
		String strNow2 = sdf.format(new Date());
		System.out.println(strNow2);
		sdf = new SimpleDateFormat("yyyy년 DD일");
		System.out.println(sdf.format(new Date()));
		
		sdf = new SimpleDateFormat("yyyy년 w주");
		System.out.println(sdf.format(new Date()));
		
		sdf = new SimpleDateFormat("yyyy년 MM월 w주");
		System.out.println(sdf.format(new Date()));
	}
}
