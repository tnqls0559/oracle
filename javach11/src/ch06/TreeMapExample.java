package ch06;

import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<Integer,String> scores = new TreeMap<>();
		scores.put(new Integer(87),"홍길동");
		scores.put(new Integer(98),"일지매");
		scores.put(new Integer(75),"임꺽정");
		scores.put(new Integer(95),"이순신");
		scores.put(new Integer(80),"김길동");
		
		System.out.println(scores.firstEntry().getKey()+"="+scores.firstEntry().getValue());
		System.out.println(scores.lastEntry().getKey()+"="+scores.lastEntry().getValue());
		
		System.out.println(scores.lowerEntry(95).getKey()+"="+scores.lowerEntry(95).getValue());
		System.out.println(scores.higherEntry(95).getKey()+"="+scores.higherEntry(95).getValue());
		
		System.out.println(scores.floorEntry(95).getKey()+"="+scores.floorEntry(95).getValue());
		System.out.println(scores.ceilingEntry(95).getKey()+"="+scores.ceilingEntry(95).getValue());
		
	}
}
