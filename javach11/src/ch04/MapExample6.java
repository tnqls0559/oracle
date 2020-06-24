package ch04;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample6 {

	public static void main(String[] args) {
		//thread safe한 map객체
		Map<String,Integer> map = new Hashtable<>();
		
		//객체저장
		map.put("홍길동", 95);
		map.put("일지매", 90);
		map.put("임꺽정", 80);
		map.put("이소룡", 95);
		
		System.out.println("총 Entry 수:"+map.size());
		
		//객체처리
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String,Integer> entry = entryIterator.next();
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("key:"+key+", value:"+value);
        }
		//향상된 for문
		for(Map.Entry<String, Integer> s:entrySet) {
			System.out.println(s.getKey()+"="+s.getValue());
		
		}
		//map의 내용삭제
		map.clear();
		System.out.println(map.isEmpty());
	}
}
