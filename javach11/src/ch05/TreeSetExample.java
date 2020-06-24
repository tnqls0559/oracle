package ch05;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		//TreeSet객체 생성
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(new Integer(87));
		scores.add(98);
		scores.add(new Integer(75));
		scores.add(95);
		scores.add(80);
		
		System.out.println("가장 낮은 점수:"+scores.first());
		System.out.println("가장 높은 점수:"+scores.last());
		
		System.out.println("95점 아래 점수:"+scores.lower(95));
		System.out.println("95점 위의 점수:"+scores.higher(new Integer(95)));
		
		System.out.println("95점이거나 바로 아래 점수:"+scores.floor(95));
		System.out.println("85점이거나 바로 위 점수:"+scores.ceiling(85));
		/*
		while(!scores.isEmpty()) {
			Integer score = scores.pollFirst();//작은 것부터 출력
			System.out.println(score+"남은 객체 수: "+scores.size());
		}
		*/
		while(!scores.isEmpty()) {
			Integer score = scores.pollLast();//큰 것부터 출력
			System.out.println(score+"남은 객체 수: "+scores.size());
		}
	}
}
