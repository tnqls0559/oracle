package ch06;

import java.util.function.IntBinaryOperator;

public class OPerationExample {
	private static int[] scores = {92,95,87};
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score:scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	public static void main(String[] args) {
		//최대값 얻기
		int max = maxOrMin(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				if(left>=right) return left;
				else return right;
			}
		});
		
		//최소값
		int min = maxOrMin(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return left<=right ? left : right;
			}
		});
		
		max = maxOrMin((left, right)-> left>=right ? left : right);
		min = maxOrMin((a,b)->a<=b?a:b);
		System.out.println(max);
		System.out.println(min);
	}
}
