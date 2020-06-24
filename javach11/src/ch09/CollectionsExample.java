package ch09;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsExample {
  static void printList(LinkedList<String> list) {
	  Iterator<String> itor = list.iterator();
	  while(itor.hasNext()) {
		  String e = itor.next();
		  String separtor;
		  if(itor.hasNext())
			  separtor="->";
		  else
			  separtor="\n";
		  System.out.print(e+separtor);
	  }
  }
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0,"터미네이터");
		myList.add(2,"아바타");
		printList(myList);
		
		Collections.sort(myList);//오름차순 정렬
		printList(myList);
		
		Collections.reverse(myList);//내림차순으로 배치
		printList(myList);
		
		int index = Collections.binarySearch(myList,"아바타");
		System.out.println("아바타는 "+(index+1)+"번째 요소입니다.");
	}
}
