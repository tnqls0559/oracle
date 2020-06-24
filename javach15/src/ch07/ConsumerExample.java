package ch07;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<Member> consumerA = new Consumer<Member>() {
			@Override
			public void accept(Member t) {//회원명 출력
				System.out.println(t.getName());
			}
		};
		
		Consumer<Member> consumerB = new Consumer<Member>() {
			@Override
			public void accept(Member t) {//회원 id출력
				System.out.println(t.getId());
			}
		};
		// A andThen B
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Member("홍길동","hong",null));
	} 
}
