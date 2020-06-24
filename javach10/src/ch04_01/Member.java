package ch04_01;
import java.util.Arrays;

public class Member implements Cloneable{
	public String name;//String필드
	public int age;//기본타입필드
	public int[] score;//참조타입필드
	public Car car;//참조타입필드
	
	public Member(String name, int age, int[] score, Car car) {
		this.name = name;
		this.age = age;
		this.score = score;
		this.car = car;
	}
	/*
	 * @Override protected Object clone() throws CloneNotSupportedException { Member
	 * cloned=(Member)super.clone();
	 * cloned.score=Arrays.copyOf(this.score,this.score.length); cloned.car = new
	 * Car(this.car.model); return cloned; }
	 */

  //얕은 복제 기능의 clone()메소드를 깊은복제 기능으로 재정의
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned=(Member)super.clone();
		cloned.score=new int[this.score.length];
		for(int i=0;i<this.score.length;i++) {
			cloned.score[i]=this.score[i];
		}
		cloned.car = new Car(this.car.model);
		return cloned;
	}
	
	public Member getMember() {
		Member cloned=null;
		try {
		    cloned=(Member)clone();	//재정의한 clone()메소드 실행
		}catch(Exception e) {
		  System.out.println(e.getMessage());
		}
		return cloned;
	}//메소드끝
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", score=" + Arrays.toString(score) + ", car=" + car + "]";
	}		
}

class Car{
	String model;
	public Car(String model) {
		this.model = model;
	}

	@Override

	public String toString() {

		return "Car [model=" + model + "]";

	}
}