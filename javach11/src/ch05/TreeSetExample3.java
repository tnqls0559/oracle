package ch05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f]사이의 단어 검색");//f가 안나오는 이유:f까지여서 ex)사전 -forever는 f다음
		NavigableSet<String> rangeSet = treeSet.subSet("c",true, "f",true);//subSet(시작,포함true,끝,포함true)
		for(String word:rangeSet)
			System.out.println(word);
	}
}
