package ch04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapExample3 {

	public static void main(String[] args) {
		Map<String, Integer> cities = new HashMap<>();
		cities.put("seoul", new Integer(25));
		cities.put("beijing", new Integer(30));
		cities.put("bangkok", 35);
		cities.put("tokyo",30);//값이 중복저장가능
		cities.put("seoul",27);//키가 중복 -Map에 중복된 키(key)는 저장불가
		
		//키들만 Set에 저장하는 메소드
		Set<String> keys = cities.keySet();
		System.out.println(keys);
		//키들만 뽑아서 출력
		Iterator<String> itor = keys.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		itor = keys.iterator();
		//키를 이용하여 map에서  값 가져오기
		while(itor.hasNext()) {
			String city = itor.next();
			System.out.println(city+"의 온도는 :"+cities.get(city)+"도 입니다.");
		}
		
		/*System.out.println("기온을  알고싶은 도시명을 입력하세요>");
		Scanner scanner = new Scanner(System.in);
		String city = scanner.next();
		System.out.println(city+"의 현재 온도는:"+cities.get(city));*/
	}
}
