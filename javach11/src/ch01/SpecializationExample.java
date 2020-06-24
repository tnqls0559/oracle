package ch01;

public class SpecializationExample {

	public static void main(String[] args) {
		//클래스명<타입> 변수 = new 클래스<타입>();
		//컴파일 시 T -> String타입으로 변환
		MyClass<String> s = new MyClass<String>();
		s.set(new String("hello"));
		System.out.println(s.get());
		
		MyClass<Integer> s2 = new MyClass<Integer>();
		s2.set(new Integer(10));
		System.out.println(s2.get());
		
		//제네릭클래스는 컴파일 시 타입체킹 가능
		//s2.set(new String("1"));
	}
}
