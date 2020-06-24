package ch08;

import java.util.Stack;

public class StackExample2 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(50);
		stack.push(70);
		stack.push(90);
		stack.push(100);
		
		System.out.println(stack.peek());//가장 높은 값 보여주기
		System.out.println(stack.pop());//가장 높은 값 보여주고 삭제하기
		System.out.println(stack.peek());
	}
}
