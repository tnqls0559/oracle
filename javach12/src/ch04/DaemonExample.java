package ch04;

public class DaemonExample {

	public static void main(String[] args) {
		//Thread 객체 생성
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		//start()실행 전 설정
		autoSaveThread.setDaemon(true);
		System.out.println("메인 스레드 시작");
		//실행요청
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {}
		System.out.println("메인 스레드 종료");
	}
}
