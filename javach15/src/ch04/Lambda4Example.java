package ch04;

public class Lambda4Example {

	public static void main(String[] args) {
		MyFunctionalInterface mf = new MyFunctionalInterface() {
			@Override
			public int method(int x, int y) {
				return sum(x,y);//다른 함수 호출가능
			}
		};
		int result = mf.method(10,20);//다른 함수 호출
		System.out.println(result);
		
		mf = (x,y)-> sum(x,y);
		result = mf.method(30, 40);
		System.out.println(result);
}
	//사용자 정의 메소드
   public static int sum(int x,int y) {
	   return x+y;
   }
}