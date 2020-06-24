package ch24;

import java.util.Calendar;

public class CalendarMainExample {

	public static void main(String[] args) {
		//컴퓨터의 timezone에 설정된 timezone값으로 달력정보객체 생성
		Calendar now = Calendar.getInstance();
		//get(Calendar.필드값)
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;//January가 0으로 설정되어있으므로
		int day = now.get(Calendar.DATE);//일
		
		System.out.println(year+"년"+month+"월"+day);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		switch(week) {
		case 1:System.out.println("일요일");break;
		case 2:System.out.println("월요일");break;
		case 3:System.out.println("화요일");break;
		case 4:System.out.println("수요일");break;
		case 5:System.out.println("목요일");break;
		case 6:System.out.println("금요일");break;
		case 7:System.out.println("토요일");break;
		}
		int ampm = now.get(Calendar.AM_PM);
		if(ampm==Calendar.AM) {
			System.out.println("오전");
		}else {
			System.out.println("오후");
		}
		
		System.out.println(now.get(Calendar.HOUR)+"시"
		                  +now.get(Calendar.MINUTE)+"분"
				          +now.get(Calendar.SECOND)+"초");
	}
}
