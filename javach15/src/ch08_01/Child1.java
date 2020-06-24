package ch08_01;

public class Child1 implements MyInterface{

	@Override
	public void method1() {
		System.out.println("재정의");
	}
	/*
	@Override
	public void method2() {
		System.out.println("추가");
	}
	*/
}
