package ch01;

import java.awt.Toolkit;

public class BeepprintExample {

	public static void main(String[] args) {
		//싱글쓰레드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();//비프음
			try {
				Thread.sleep(500);//sleep(밀리초)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}//main()끝.
}
