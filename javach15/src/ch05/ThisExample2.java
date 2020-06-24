package ch05;

public class ThisExample2 {

	public int outterFiled = 10;
	
	class Inner{
		int innerFiled = 20;
		
		void method() {
			//람다식
			MyFunctionalInterface mf
			= () -> {
					System.out.println("outterFiled:"+outterFiled);
					System.out.println("outterFiled:"+ThisExample2.this.outterFiled);
					
					System.out.println("innerFiled:"+innerFiled);
					System.out.println("innerFiled:"+this.innerFiled+"\n");				
			};
		}
	}
}
