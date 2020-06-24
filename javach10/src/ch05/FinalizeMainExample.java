package ch05;

public class FinalizeMainExample {
	public static void main(String[] args) {
		Counter counter = null;
		for(int i=1;i<=50;i++) {
			counter = new Counter(i);//객체 생성하여 counter변수에 대입
			counter=null;//counter에서 끊기 - 쓰레기
			System.gc();//쓰레기 수집기 실행요청, 스케줄에 따라 실행
		}
	}
}
