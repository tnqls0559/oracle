package ch05;

public class ThisExample {

	public int outterFiled = 10;
	
	class Inner{
		int innerFiled = 20;
		
		void method() {
			//람다식
			MyFunctionalInterface mf = new MyFunctionalInterface() {
				int innerFiled = 10;
				@Override
				public void method() {
					System.out.println("outterFiled:"+outterFiled);
					System.out.println("outterFiled:"+ThisExample.this.outterFiled);
					
					System.out.println("innerFiled:"+innerFiled);
					System.out.println("innerFiled:"+this.innerFiled+"\n");
					
				}
			};
		}
	}
}
