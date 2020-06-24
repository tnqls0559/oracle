package ch03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetMainExample3 {

	public static void main(String[] args) {
		//로또 프로그램
		Random random = new Random();
		Set<Integer> lotto = new HashSet<>();
		
	/*	while(lotto.size()<6) {
			int ran = random.nextInt(45)+1;
			lotto.add(ran);//1~45까지의 정수 랜덤 추출
			System.out.println(ran);
		}
		*/
		//중복되지 않는 값 저장
		while(lotto.size()<6) {//객체가 저장되는 갯수
			int ran = (int)(Math.random()*45)+1;
			lotto.add(ran);
			System.out.println(ran);
		}
		//set의 객체를 하나씩 처리하는 객체 iterator인터페이스
		Iterator<Integer> itor = lotto.iterator();
		while(itor.hasNext()) {
			System.out.print(itor.next()+",");
		}
	}
}
