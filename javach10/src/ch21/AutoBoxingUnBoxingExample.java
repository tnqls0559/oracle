package ch21;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUnBoxingExample {

	public static void main(String[] args) {
		//자동 boxing
		Integer obj = 100;//래퍼 변수 = 기본타입 값
		System.out.println("value:"+obj.intValue());
		
		//자동unboxing
		int result = obj;//기본타입 변수 = 래퍼;
		System.out.println("value:"+result);
		
		//리스트 자료저장 객체
		//인터페이스
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));//래퍼
		list.add(new Integer("200"));//래퍼
		list.add(300);//기본타입 값 ->autoBoxing해서 Wrapper타입으로 변신 저장
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		    //Integer(100),Integer(200),Integer(300)
		    //100,200,300 -> autounBoxing
	}
}
