package ch05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		//75 80 87 95 98
		
		//역순 정렬된 set - 98 95 87 80 75
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer score:descendingSet)
			System.out.print(score+"\t");
		
		//75 80 87 95 98
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		
		for(Integer s:ascendingSet)
			System.out.println(s);
	}
}
