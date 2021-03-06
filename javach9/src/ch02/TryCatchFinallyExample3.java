package ch02;

public class TryCatchFinallyExample3 {
	public static void main(String[] args) {
		try {
			String data = null;
			data="hello";
			//data="hello";//문자열로 값 대입
			System.out.println(data.length());//이 부분에서 예외발생하여 catch절로 이동
		    String[] strings = {"hello","hi"};
		    System.out.println(strings[1]);
		    double result = 5/0;
		}catch(NullPointerException e) {
			System.out.println("null포인트 예외발생");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 예외발생");
		}catch (Exception e) {
			//예외 처리부분
			System.out.println("예외 메세지:"+e.getMessage());
		}finally {
			//이 부분 실행됨.
			System.out.println("종료 시 예외 발생과 상관없이 반드시 처리해야하는 부분");
		}
	
}
}