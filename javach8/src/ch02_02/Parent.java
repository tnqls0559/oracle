package ch02_02;
//추상메소드가 있는 클래스는 추상클래스
//추상클래스
public abstract class Parent {
	int field1;
	void method1() {System.out.println("부모클래스의 메소드");}
	abstract void absMethod();//추상메소드
}
class Child extends Parent{
	int field2;//자식클래스에서 추가된 필드
	void method2() {}//자식클래스에서 추가된 메소드
	@Override
	void absMethod() {
		System.out.println("자식클래스에서 재정의된 메소드");
		field1=10;
		method1();
	}
}