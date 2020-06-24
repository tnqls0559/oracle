package ch01_03;

public class PriorityExample {

	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			Thread thread = new CalcThread("thread"+i);
			System.out.println("thread"+i+"생성 시 우선순위: "+thread.getPriority());
			if(i!=10) {
				thread.setPriority(Thread.MIN_PRIORITY);//1
			}else {
				thread.setPriority(Thread.MAX_PRIORITY);//10
			}
		  thread.start();//실행요청
		  //thread.run();
		}
	}
}
class CalcThread extends Thread{

	public CalcThread(String name) {
		setName(name);
	}
	@Override
	public void run() {
		for(int i=0;i<20000000;i++) {}
		System.out.println(getName());
	}
	
	
}