package ch02;

public class TheadA extends Thread{
	private WorkObject workObject;

	public TheadA(WorkObject workObject) {
		this.workObject = workObject;//공유객체 설정
	}

	@Override
	public void run() {
	  for(int i=0;i<10;i++)
		  workObject.methodA(); //공유객체 의 methodA()를 10번반복
	}
}
class ThreadB extends Thread{
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;//공유객체 설정
	}

	@Override
	public void run() {
	  for(int i=0;i<10;i++)
		  workObject.methodB(); //공유객체 의 methodB()를 10번반복
	}
}

class WorkObject extends Object{
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA()작업 실행");
		notify();//일시정지상태의 ThreadB를 실행대기(RUNNABLE)상태로 만듦
		try {
			wait();//ThreadA를 일시 정지상태로 만듦
		}catch(Exception e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB()작업 실행");
		notify();//일시정지상태의 ThreadA를 실행대기(Runnable)상태로 만듦
		try {
			wait();//ThreadB를 일시 정지상태로 만듦
		}catch(Exception e) {}
	}
}
