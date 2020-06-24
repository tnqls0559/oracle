package ch24;

import java.util.TimeZone;

public class PrintTimeZone {

	public static void main(String[] args) {
		//타임존 리스트 얻기
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id:availableIDs) {
			System.out.println(id);
		}
	}
}
