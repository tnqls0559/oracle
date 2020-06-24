package ch01_03;

public class A {
	//메소드 안에 선언된 로컬 클래스
	void method() {
		class D{//로컬클래스
			D(){System.out.println("로컬클래스 생성");}
			int field1;//인스턴스 멤버
			//static int field2;//static멤버
			void method1(){System.out.println(field1);}//인스턴스 멤버
			//static void method2(){}//static멤버
		}//클래스 선언
		class E{}
		D d = new D();
		d.field1=3;
		d.method1();
	}
}
