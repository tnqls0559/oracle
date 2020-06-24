package ch10;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		//정적 메소드 참조
		//operator = (a,b) -> Calculator.staticMethod(a, b);
		//System.out.println("결과:"+operator.applyAsInt(1, 2));
		
		//메소드 참조 - 객체기반 언어
		//static - 클래스명::static메소드
		operator = Calculator :: staticMethod;
		System.out.println("결과:"+operator.applyAsInt(1, 2));
		
		//인스턴스 메소드 참조
		Calculator obj = new Calculator();
		//operator = (a,b) -> obj.instanceMethod(a, b);
		//System.out.println("결과:"+operator.applyAsInt(5, 6));
		
		//참조
		//인스턴스
		//클래스 참조변수 = new 클래스();
		//참조변수::instance메소드;
		operator = obj::instanceMethod;
		System.out.println("결과:"+operator.applyAsInt(7, 8));
	}
}
class Calculator{
	//static메소드
	public static int staticMethod(int x, int y) {
		return x+y;
	}
	//인스턴스 메소드
	public int instanceMethod(int x, int y) {
		return x+y;
	}
}