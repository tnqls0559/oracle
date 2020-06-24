package ch18;

public class StringEqualsExample {

	public static void main(String[] args) {
		String str1 = new String("홍길동");
		String str2 = "홍길동";
		System.out.println(str1==str2?"같은 객체 참조":"다른 객체 참조");
		System.out.println(str1.equals(str2)?"같은내용":"다른내용");
	}
}
