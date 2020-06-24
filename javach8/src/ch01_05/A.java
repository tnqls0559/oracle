package ch01_05;

public class A {
	int field1;
	static int field2;
	
	void method1() {}
	static void method2() {}
	
	class B{//인스턴스 멤버로 선언된 클래스에서는
		void method() {
			field1=2;//바깥쪽 인스턴스 멤버
			field2=10;//static멤버에 모두 접근가능
			method1();
			method2();
		}
	}
}
