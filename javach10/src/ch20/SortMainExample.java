package ch20;

import java.util.Arrays;

public class SortMainExample {

	public static void main(String[] args) {
		int[] scores = {99,97,98};
		Arrays.sort(scores);//기본타입값 배열 정렬
		System.out.println(Arrays.toString(scores));
		
		String[] names = {"홍길동","박동수","김민수"};
		Arrays.sort(names);//String타입의 값 배열 정렬
		System.out.println(Arrays.toString(names));
		
		Member[] members = {new Member("홍길동"),new Member("박동수"),new Member("김민수")};
		Arrays.sort(members);
		
		System.out.println(Arrays.toString(members));
	}
}
