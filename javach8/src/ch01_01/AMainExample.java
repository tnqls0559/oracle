package ch01_01;

public class AMainExample {

	public static void main(String[] args) {
		//바깥쪽 클래스 생성 후
		A a = new A();
		//안쪽 클래스 생성
		//A.B b = 변수.new 안쪽객체 생성자();
		A.B b = a.new B();
		//안쪽 클래스의 멤버에 접근
		b.field1=3;
		b.method1();

	}
}
