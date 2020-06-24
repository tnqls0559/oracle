package ch03;

public class Lambda4Example {

	public static void main(String[] args) {
		MyFunctionalInterface mf 
		      = new MyFunctionalInterface() {
				
				@Override
				public int method(int x, int y) {
					return x+y;
				}
			};
			int result = mf.method(10, 20);
			System.out.println(result);
			
			//명령문 1개이면 {}제거, {}이 없으면 return도 제거
		MyFunctionalInterface mf2 = (x,y)-> x*y;
		int result2 = mf2.method(10, 20);
		System.out.println(result2);
	}
}
