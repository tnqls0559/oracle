package ch04;

//Cloneable인터페이스로 구현
public class Member implements Cloneable{
  public String id;
  public String name;
  public String password;
  public int age;
  public boolean adult;
public Member(String id, String name, String password, int age, boolean adult) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.age = age;
	this.adult = adult;
}
public Member getMember() {
	Member cloned=null;
	try {
		cloned=(Member)clone();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return cloned;
}//메소드끝.
}
