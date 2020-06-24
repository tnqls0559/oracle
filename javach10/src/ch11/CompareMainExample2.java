package ch11;

import java.util.Comparator;
import java.util.Objects;

public class CompareMainExample2 {
	public static void main(String[] args) {
		//결과 양수 첫 번째 객체 순서적으로 나중
		System.out.println(Objects.compare(new Member("홍길동"), 
				                           new Member("일지매"), 
				                           new MemberCompare()));
	}
}
class Member{
	String name;
	public Member(String name) {
		this.name = name;
	}
}
//순서비교, 첫 번쟤 객체와 두 번째 객체의 순서 비교 음수면 첫 번째가 먼저, 양수면 첫 번째가 나중, 0이면 같은 순서
class MemberCompare implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		return o1.name.hashCode()-o2.name.hashCode();
	}
}