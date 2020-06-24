package ch01_02;

public class SpecializationExample {

	public static void main(String[] args) {
		MyClass s1 = new MyClass();
		s1.set(new String("hello"));//프로모션
		System.out.println(s1.get());//casting
		
		MyClass s2 = new MyClass();
		s2.set(new Integer(10));
		System.out.println(s2.get());
		
		s2.set(new String("hi"));
		System.out.println(s2.get());
		
		MyClass s3 = new MyClass();
		s3.set(new Integer(20));
		s2.set(new Integer(30));
		int i1 = (Integer) s3.get();
		int i2 = (Integer) s2.get();
		System.out.println(i1-i2);
		
		//타입체킹이 안됨 실행 시 오류 Integer-Object->String(x)
		s2.set(new String("1"));
		int i3 = (Integer)s2.get();
		System.out.println(i1-i3);
		
		
	}
}
