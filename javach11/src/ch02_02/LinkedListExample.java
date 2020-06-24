package ch02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();		

		long startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			list1.add(0,String.valueOf(i));//중간삽입-arrayList 
		}
		long endTime =System.nanoTime();	

		System.out.println("걸린시간:"+(endTime-startTime));

		startTime =System.nanoTime();
		for(int i=0;i<100000;i++) {
			list2.add(0,String.valueOf(i));//중간삽입-linkedList
		}
		endTime = System.nanoTime();		

		System.out.println("걸린시간:"+(endTime-startTime));		

		System.out.println("------------------------");
		list1.clear();
		startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			list1.add(String.valueOf(i));//뒤에 이어어서 저장하기
		}
		endTime = System.nanoTime();
		System.out.println("추가작업걸린시간:"+(endTime-startTime));
		
		list2.clear();
		startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			list2.add(String.valueOf(i));//뒤에 이어어서 저장하기
		}
		endTime = System.nanoTime();
		System.out.println("추가작업걸린시간:"+(endTime-startTime));
	}
}