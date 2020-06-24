package ch04;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String,String> dic1 = new HashMap<>();
		while(true) {
			System.out.println("단어를 입력하세요>");
			String key = scanner.next();
			System.out.println("설명을 입력하세요>");
			String value = scanner.next();
			//map에 키와 값 저장
			dic1.put(key, value);
			System.out.println("계속할까요?(y/n)");
			char yesno = scanner.next().charAt(0);
			if(yesno=='n'||yesno=='N')break;
			else continue;
		}
		System.out.println("설명을 보려는 단어를 입력하세요");
		String word = scanner.next();
		System.out.println(word+"의 설명:"+dic1.get(word));
	}
}
