package ch01_04;

public class MainThreadExample {
	public static void main(String[] args) {
		//공유객체
		Calculator calculator = new Calculator();
		User user1 = new User();
		user1.setCalculator(calculator);
		user1.start();//thread
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();//thread

}
}