package ch19;

//StringBuilder와 StringBuffer는 같음
//차이는
public class StringBufferMainExample {
	public static void main(String[] args) {
		//StringBffer객체 생성
		StringBuffer sb = new StringBuffer();
		//이어붙이기 append()
		sb.append("Java ");
		sb.append("Programming");
		System.out.println(sb);
		System.out.println(sb.toString());
		
		//중간 삽입 insert(index번호, 값)
		sb.insert(4, "2");
		System.out.println(sb);
		
		//수정 setCharAt(index번호, 수정 할 문자)
		sb.setCharAt(4, '8');
		System.out.println(sb);
		
		//부분 수정 replace(시작 index, 끝 index)
		sb.replace(6, 13, "Book");//6<=범위<13
		System.out.println(sb);
		
		//부분 삭제 delete(시작index, 끝index)
		sb.delete(4, 5);//범위 4<=범위<5;
		System.out.println(sb);
		
		System.out.println("문자 수:"+sb.length());
		
		//내용을 String타입으로 변환
		String result = sb.toString();
		System.out.println(result);
	
	}
}
