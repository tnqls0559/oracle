package ch01_01_01;

import java.awt.Toolkit;

public class ThreadExample {

	public static void main(String[] args) {
		//Thread 클래스 생성 실행
		//Thread 클래스를 상속받은 자식 클래스 생성 new 클래스명()
		SoundThread soundThread = new SoundThread("soundThread");
		System.out.println(soundThread.getPriority());//스레드 우선순위
		//생성시는 priority = 5, MIN_PRIORITY = 1, MAX_PRIORITY = 10
		soundThread.setPriority(Thread.MIN_PRIORITY);//1~10,
		System.out.println(soundThread.getName());
		soundThread.start();//실행 -> 실행요청(jvm)
		//soundThread.run();//스레드 실행이 아님.
		
		Thread th = Thread.currentThread();
		System.out.println(th.getName());
		
		//Runnable 인터페이스로 구현한 클래스로 Thread생성
		// -> new Thread(new 구현클래스());
		Thread printThread = new Thread(new PrintThread());
		System.out.println(printThread.getName());
		printThread.start();//실행요청(jvm)
		//printThread.run();//스레드 실행이 아님 직접 호출
	}
}
//Thread클래스 상속
class SoundThread extends Thread{
	
	public SoundThread(String name) {
		super(name);
	}
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	@Override
	public void run() {
		//사운드
		for(int i=1;i<=5;i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);//500밀리초 = 0.5초간 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
  }
}	
//Runnable 인터페이스 구현
class PrintThread implements Runnable{

	@Override
	public void run() {
		//출력
				for(int i=1;i<=5;i++) {
					System.out.println("띵");
					try {
						Thread.sleep(500);//500밀리초 = 0.5초간 정지
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	}
	
}