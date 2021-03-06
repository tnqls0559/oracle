package ch09;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateAndOrNegateExample {

	public static void main(String[] args) {
		//2의 배수 검사
		IntPredicate predicateA = value -> value%2==0;
		
		//3의 배수 검사
		IntPredicate predicateB = value -> value%3==0;
		
		IntPredicate predicateAB;
		boolean result;
		
		//and()
		predicateAB = predicateA.and(predicateB);
		result = predicateAB.test(9);
		System.out.println("9는 2와 3의 배수입니까? "+result);
		
		//or()
		predicateAB = predicateA.or(predicateB);
		result = predicateAB.test(9);
		System.out.println("9는 2나 3의 배수입니까? "+result);
		
		//negate()
		predicateAB = predicateA.negate();
		result = predicateAB.test(9);
		System.out.println("9는 홀수입니까? "+result);
		
		//isEqual()
		Predicate<String> predicate;
		
		//static메소드
		predicate = Predicate.isEqual(null);
		System.out.println("null,null"+predicate.test(null));
		
		predicate = Predicate.isEqual("Java8");
		System.out.println("null,Java8:"+predicate.test(null));
		
		predicate = Predicate.isEqual(null);
		System.out.println("Java8,null:"+predicate.test("Java8"));
		
		predicate = Predicate.isEqual("Java8");
		System.out.println("Java8,Java8:"+predicate.test("Java8"));
		
		//
	} 
}
