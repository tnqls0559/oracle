package verify;

public class Ex04MainExample {

	public static void main(String[] args) {
		Member member = new Member("blue","이파란");
		System.out.println(member);//member가 print문의 매개변수로 넘어가면 toString() 자동호출
	}
}
class Member{
	private String id;
	private String name;
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
}