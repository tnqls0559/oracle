package ch02_02;

public class AnnonymousExample {
	//필드 초기값으로 대입-무명의 자식객체를 생성하여 부모타입에 대입한 형태
	Person field = new Person() {
		void work() {//자식클래스에서 추가된 메소드
			System.out.println("출근합니다.");
		}

		@Override//재정의
		void wake() {
			System.out.println("6시에 일어납니다.");
		}
	};
	
	void method1() {
		Person localVar = new Person() {//Person에는 없는 메소드
			void walk() {//자식클래스에서 추가된 메소드
				System.out.println("산책합니다.");
			}

			@Override//재정의 된 메소드
			void wake() {
				System.out.println("7시에 일어납니다.");
			}			
		};
		//로컬변수 사용
		localVar.wake();//
		//localVar.walk();//접근불가능
		field.wake();//
		//field.walk();//접근불가
		}
		void method2(Person person) {
			person.wake();
	}
}