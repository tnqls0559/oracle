package ch11;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		Function<String, Member> function1 = new Function<String, Member>(){
		
		public Member apply(String t) {
			return new Member(t);
		}
		};
		
		Member member1 = function1.apply("hong");
		System.out.println(member1.getId());
		
		//람다식
		function1 = t -> new Member(t);
		member1 = function1.apply("kang");
		System.out.println(member1.getId());
		
		//생성자 참조
		function1 = Member::new;
	    member1 = function1.apply("hwang");
		System.out.println(member1.getId());
		
		BiFunction<String, String, Member>function2 
		  = new BiFunction<String, String, Member>() {
			@Override
			public Member apply(String t, String u) {
				return new Member(t,u);
			}
		};
		Member member2 = function2.apply("홍길동", "hong");
		System.out.println(member2.getId());
		
		//람다식
		function2 = (t,u) -> new Member(t,u);
        member2=function2.apply("홍길동", "hong");
        System.out.println(member2.getId());
        
        //생성자 참조
        function2 = Member::new;
	    member2 = function2.apply("홍길동", "hong");
		System.out.println(member2.getId());
	}
}
