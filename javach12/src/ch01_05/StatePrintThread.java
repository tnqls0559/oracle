package ch01_05;

public class StatePrintThread extends Thread{
	private Thread targetThread;
	public StatePrintThread(Thread targetThread) {
		this.targetThread=targetThread;
	}
	@Override
	public void run() {
		while(true) {
			//스레드 상태얻기 getState();
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상태:"+state);
			
			if(state == Thread.State.NEW) {//실행 전 상태
				targetThread.start();//RUNNABLE로 전환
			}
			if(state==Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	
}
