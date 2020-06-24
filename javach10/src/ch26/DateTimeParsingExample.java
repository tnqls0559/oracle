package ch26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeParsingExample {

	public static void main(String[] args) {
		DateTimeFormatter formatter;
		LocalDate localDate;
		
		localDate = LocalDate.parse("2024-05-21");
		System.out.println(localDate);
		
		//입력된 문자열이 ISO_LOCAL_DATE현식이면 localDate타입으로 변환
		//ISO_LOCAL_DATE:"yyyy-MM-dd"
		formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		localDate = LocalDate.parse("2024-05-21",formatter);
		System.out.println(localDate);
		
		//
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		localDate = LocalDate.parse("2024/05/21",formatter);
		System.out.println(localDate);
		
		formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		localDate = localDate.parse("2024.05.21",formatter);
		System.out.println(localDate);
	}
}
