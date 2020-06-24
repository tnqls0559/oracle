package ch03;

import java.util.Scanner;
public class TryCatchwithResource2 {
	public static void main(String[] args) {
		//Closeable인터페이스나 AutoCloseable인터페이스를 구현한 객체인 경우
		try(Scanner scanner = new Scanner(System.in);) {
			String message = scanner.next();
			int intNum = Integer.parseInt(message);
			System.out.println(message);
		}catch(Exception e) {
			e.printStackTrace();
		}/*finally {
			scanner.close();//자원해제
			
		}*/
	}
}