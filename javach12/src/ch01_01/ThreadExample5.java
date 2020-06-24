package ch01_01;

public class ThreadExample5 {

	public static void main(String[] args) {
		//생성실행
		Thread th = new Thread(new Child());
		th.start();//JVM에게 실행요청 ->스케줄에 따라 run() 메소드를 실행
		th.run();//main에서 th의 run()를 직접호출
	}
}
class Parent{
}
class Child extends Parent implements Runnable{
	 @Override
	 public void run() {
		for(int i=1;i<=100;i++) {
	 int sum=0;
	 sum=+i;
	 System.out.println(sum);
	 try {
		Thread.sleep(100);//=0.1초
	 }catch (InterruptedException e) {
		e.printStackTrace();
     }
    }		
System.out.println("종료");
  }
}
