package ch12;

import java.util.Objects;

public class HashCodeExample {
	public static void main(String[] args) {
		//hash(필드1,필드2,...) hash코드 값 생성
		//hashCode(객체참조변조) hash코드 값 리턴
		Student s1 = new Student(1,"홍길동");
		Student s2 = new Student(1,"홍길동");
		System.out.println(s1.hashCode());
		System.out.println(Objects.hashCode(s2));
	}
}
class Student{
	int sno;
	String name;
	//생성자
	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sno,name);
	}
}