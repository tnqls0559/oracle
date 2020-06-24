package ch01_01;

public class BeepPrintExample {

	public static void main(String[] args) {
		//인터페이스 변수 = new 구현클래스()
		Runnable beepTask = new BeepTask();
		//Thread클래스의 생성자의 매개변수로 Runnable인터페이스 전달
		Thread thread = new Thread(beepTask);
		//쓰레드 실행요청(JVM)
		thread.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
}
