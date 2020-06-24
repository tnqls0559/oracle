package ch01_01;

import java.awt.Toolkit;

//run()메소드를 가진 BeepTask클래스
public class BeepTask implements Runnable{
	@Override
	public void run() {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	for(int i=0;i<5;i++) {
		toolkit.beep();//비프음
		try {
			Thread.sleep(500);//sleep(밀리초)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }		
	}//run()메소드 끝.
}
