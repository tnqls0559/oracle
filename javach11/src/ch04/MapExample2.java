package ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample2 {

	public static void main(String[] args) {
		Map<String, Integer> cities = new HashMap<>();
		cities.put("seoul", new Integer(25));
		cities.put("beijing", new Integer(30));
		cities.put("bangkok", 35);
		
		System.out.println("기온을  알고싶은 도시명을 입력하세요>");
		Scanner scanner = new Scanner(System.in);
		String city = scanner.next();
		System.out.println(city+"의 현재 온도는:"+cities.get(city));
	}
}
