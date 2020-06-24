package ch01_02;
//static 멤버로 선언된 내부 클래스
public class A {//static멤버
	static class B{
		B(){}
		int field1;//인스턴스 멤버
		static int field2;//static멤버
		void method1() {}//인스턴스 멤버
		static void method2() {};//static멤버
	}

}
