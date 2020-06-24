package ch01_01;

public class A {
	class B{//인스턴스 멤버
		B(){}//생성자
		int field1;//인스턴스
		//static int field2;--인스턴스 멤버 내부에는 static멤버 올 수 없음
		void method1() {}//인스턴스 메소드
		//static void method2() {}--인스턴스 멤버 내부에는 static멤버 올 수 없음
	}

}
