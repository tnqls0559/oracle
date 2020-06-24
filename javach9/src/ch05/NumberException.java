package ch05;

//Exception객체나 RuntimeException객체를 상속받아 선언
public class NumberException extends RuntimeException{

	public NumberException(String message) {
		super(message);
	}
 
}
