package ch01_04;

public class Calculator {
   private int memory;
   public int getMemory() {
	   return memory;
   }
   //공유 영역 처리 메소드에 synchronized 추가
   public /*synchronized*/ void setMemory(int memory) {
	   synchronized(this) {
	   this.memory=memory;
	   try {
		   Thread.sleep(2000);//2초간 멈춤.
	   }catch(Exception e) {}
	   System.out.println(Thread.currentThread().getName()+":"+this.memory);
   }
}
}