package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동"));
		list.add(new Student("일지매"));
		list.add(new Student("임꺽정"));
		
		Iterator<Student> itor = list.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		for(Student s:list) {
			System.out.println(s);
		}
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
}
