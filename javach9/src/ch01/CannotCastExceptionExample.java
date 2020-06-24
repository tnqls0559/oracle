package ch01;

public class CannotCastExceptionExample {
	public static void main(String[] args) {
		// 자식클래스 생성 후 부모타입으로 프로모션
		Animal animal = new Dog();
		//프로모션 된 부모타입에서 다른 타입의 자식클래스로 casting은 실제로 불가
		Cat cat = (Cat)animal;
	}
}
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}