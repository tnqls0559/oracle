package ch01_04;

public class User extends Thread{
	//공유객체
   private Calculator calculator;

  public void setCalculator(Calculator calculator) {
	  this.setName("User1");
	  this.calculator = calculator;
}

@Override
public void run() {
	calculator.setMemory(100);
}
   
   
}
