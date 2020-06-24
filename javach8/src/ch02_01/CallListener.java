package ch02_01;

//implements 바깥쪽클래스.내부인터페이스
public class CallListener implements Button.OnClickListener{

	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}

}
