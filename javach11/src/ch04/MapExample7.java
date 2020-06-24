package ch04;

import java.util.HashMap;
import java.util.Scanner;

public class MapExample7 {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in);){
		//
		HashMap<String,Student> map = new HashMap<>();
		//3명의 학생 저장
		map.put("홍길동",new Student(1,"010-111-1234"));
		map.put("일지매",new Student(2,"010-111-3333"));
		map.put("임꺽정",new Student(3,"010-111-1212"));
		//
		
		while(true) {
			System.out.println("검색할 이름:");
			String name = scanner.nextLine();
			if(name.equals("exit")) break;
			//if(!map.containsKey(name)) {
			Student student = map.get(name);
			if(student==null)
				System.out.println(name+"은 없는 사람입니다.");
			else
				System.out.println("id:"+student.getId()+",tel:"+student.getTel());
		}
		//scanner.close();
	}
	}
}
class Student{
	int id;
	String tel;
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public String getTel() {
		return tel;
	}
}