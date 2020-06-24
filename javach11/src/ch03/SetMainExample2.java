package ch03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMainExample2 {

	public static void main(String[] args) {
		Set<Integer> set1 = Collections.synchronizedSet(new HashSet<>());//Collections.synchronizedSet동기화
		set1.add(10); set1.add(20); set1.add(30);
		//iterator 반복자 얻기
		Iterator<Integer> itor = set1.iterator();
		while(itor.hasNext()) {
			int i=itor.next();
			System.out.println(i);
		}
		Set<String> set2 = new HashSet<>();
		set2.add("홍길동");set2.add("일지매");set2.add("임꺽정");
		Iterator<String> itor2 = set2.iterator();
		while(itor2.hasNext()) {
			System.out.println(itor2.next());
		}
		Set<Student> set3 = new HashSet<>();
		set3.add(new Student("홍길동"));
		set3.add(new Student("일지매"));
		set3.add(new Student("임꺽정"));
		
		Iterator<Student> itor3 = set3.iterator();
		while(itor3.hasNext()) {
			Student s = itor3.next();
			System.out.println(s.toString());
		}
	}
}
