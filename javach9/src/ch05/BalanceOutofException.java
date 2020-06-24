package ch05;

public class BalanceOutofException extends Exception {
	
	public BalanceOutofException() {
		this("잔고가 부족합니다.");
	}
	public BalanceOutofException(String message) {
		super(message);
		
	}
}
