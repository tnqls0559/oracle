package ch01_02;

public class ThreadNameExample {

	public static void main(String[] args) {
		//실행 중 thread 정보얻기 currentThread()
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 명:"+mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름:"+threadA.getName());
		threadA.start();//실행요청
		
		//이름없이 생성 Thread-1,Thread-2,...로 이름 부여됨.
		ThreadB threadB = new ThreadB();
		System.out.println("작업 스레드 이름:"+threadB.getName());
		threadB.start();//실행요청
		
		ThreadB threadB2 = new ThreadB();
		System.out.println("작업 스레드 이름:"+threadB2.getName());
		threadB2.start();//실행요청
		
		ThreadA threadA2 = new ThreadA();
		System.out.println("작업 스레드 이름:"+threadA2.getName());
		threadA2.start();//실행요청
	}
}
class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
	}
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println(getName()+"가 출력한 내용");
	}
	}
}
class ThreadB extends Thread{
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println(getName()+"가 출력한 내용");
	}
	}
}