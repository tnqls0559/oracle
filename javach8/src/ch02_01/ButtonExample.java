package ch02_01;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		
		//구현체인 CallListener가 OnClickListener타입으로 프로모션되어 대입
		//매개변수의 다형성
		btn.setOnClickListener(new CallListener());
		btn.touch();//구현체의 재정의된 메소드 실행
		//구현체인 MwssageListener가 OnClickListener타입으로 프로모션되어 대입
		//매개변수의 다형성
		btn.setOnClickListener(new MessageListener());
		btn.touch();//구현체의 재정의된 메소드 실행
		
		btn.setOnClickListener(new Button.OnClickListener() {
			
			//메소드 매개변수로 사용
			@Override
			public void onClick() {
				System.out.println("인터페이스 객체의 메소드 실행");
			}
		});
       btn.touch();
	}

}
