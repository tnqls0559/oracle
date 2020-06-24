package verify;

public class EX07MainExample {

	public static void main(String[] args) {
		String str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		//indexOf('문자') 문자열내에 해당 문자의 index번호 return, 없으면 -1
		int index = str.indexOf('자');
		if(index==-1) {
			System.out.println("자바 문자열이 포함되어 있지 않습니다.");
		}else {
			System.out.println("자바 문자열이 포함되어 있습니다.");
			str = str.replace("자바", "java");
			System.out.println("->"+str);
		}
	}
}