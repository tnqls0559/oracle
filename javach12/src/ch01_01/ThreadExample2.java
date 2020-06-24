package ch01_01;

import java.awt.Toolkit;

public class ThreadExample2 {

	public static void main(String[] args) {
		WorkerThread wt = new WorkerThread();
		wt.start();
	}
}
//Thread클래스 살속받아 생성
class WorkerThread extends Thread{

	@Override
	public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for(int i=0;i<5;i++) {
				toolkit.beep();
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			}
	}
	
}