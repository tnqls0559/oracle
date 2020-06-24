package ch02;

public class TryCatchFinallyExample2 {
	public static void main(String[] args) {
		try {
			String data = null;
			//data="hello";//문자열로 값 대입
			System.out.println(data.length());//이 부분에서 예외발생하여 catch절로 이동
			System.out.println(data.toString());//이 부분 실행안됨
			System.out.println("여기까지 실행");//이 부분 실행안됨
		} catch (Exception e) {
			//예외 처리부분
			System.out.println("예외 메세지:"+e.getMessage());
		}finally {
			//이 부분 실행됨.
			System.out.println("종료 시 예외 발생과 상관없이 반드시 처리해야하는 부분");
		}
	}
}
