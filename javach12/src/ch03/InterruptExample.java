package ch03;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();//실행요청
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
		}
		thread.interrupt();//intrrupt예외 발생
	}
}
class PrintThread extends Thread{

	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(1);
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("자원 정리");
			System.out.println("실행 종료");
		}
	}
	
