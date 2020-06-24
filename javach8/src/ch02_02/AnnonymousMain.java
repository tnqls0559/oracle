package ch02_02;

public class AnnonymousMain {
	public static void main(String[] args) {
		AnnonymousExample anony = new AnnonymousExample();
		//익명 객체 필드
		anony.field.wake();
		//익명 객체 로컬변수
		anony.method1();
		//익명 객체 매개값
		anony.method2(new Person(){
			void study() {
				System.out.println("공부합니다.");
			}
			@Override
			void wake() {//부모클래스에 있던 메소드
				System.out.println("8시에 일어납니다.");
				study();//추가된 메소드
			}	
		});
	}
}