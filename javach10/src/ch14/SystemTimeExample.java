package ch14;

public class SystemTimeExample {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		long time11 = System.currentTimeMillis();
		long time1 = System.nanoTime();
		
		int sum = 0;
		for(int i=1;i<=1000000;i++) {
			sum+=i;
		}
		long time22 = System.currentTimeMillis();
		long time2 = System.nanoTime();
		
		System.out.println("nano타입차:"+(time2-time1));
		System.out.println("1/1000초 차:"+(time22-time11));
	}
}
