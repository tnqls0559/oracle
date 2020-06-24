package ch18;

import java.util.StringTokenizer;

public class StringTokenizerMainExample {

	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		StringTokenizer stk = new StringTokenizer(text, "/");
		int countTokens = stk.countTokens();//잘라진 토큰들의 갯수
		//토큰 저장 - nextToken() 소모
		for(int i=0;i<countTokens;i++) {
			System.out.println(stk.nextToken());
		}
		System.out.println("---------------------");
		stk = new StringTokenizer(text,"/");
		while(stk.hasMoreElements()) {
			System.out.println(stk.nextElement());
		}
		 // while(stk.hasMoreElements()) {
		 //  System.out.println(stk.nextElement());
		 //}
	}
}
