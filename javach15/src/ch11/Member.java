package ch11;

public class Member {
	private String name;
	private String id;
	
	public Member(String id) {
		System.out.println("id 생성자 실행");
		this.id = id;
	}
	public Member(String name, String id) {
		System.out.println("name,id 생성자 실행");
		this.name = name;
		this.id = id;
	}

	public Member() {
		System.out.println("기본생성자 실행");
	}

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	}