package ch01;

public class HashCodeMainExample2 {
	public static void main(String[] args) {
		Student1 s1 = new Student1("홍길동");
		Student1 s2 = new Student1("홍길동");
		
		//hashCode()리턴값 조작
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1==s2);
		//equals()리턴값 조작
		System.out.println(s1.equals(s2));

	}

}
class Student1 extends Object{
	String name;
	//생성자
	public Student1(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {//Student -> Object로 프로모션
		return name.equals(((Student1)obj).name);//필드 name과 매개변수값 obj 내용이 같으면 true
	}
}