package ch17;

import java.util.Scanner;

public class NewInstanceMainExample {
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.전송|2.수신>");
			int menu = scanner.nextInt();
			Class clazz=null;
			switch(menu) {
			case 1: 
				clazz = Class.forName("ch17.SendAction");
				break;
			case 2: 
				clazz = Class.forName("ch17.ReceiveAction");
				break;
			}
			//클래스 정보로 객체 생성 newInstance() -Object->부모타입으로 casting
			//Class clazz = Class.forName("ch17.ReceiveAction");
			Action action = (Action)clazz.newInstance();
			action.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
