package verify;

public class Ex06MainExample {

	public static void main(String[] args) {
		byte[] bytes = {73,32,108,111,118,101,32,121,111,117};//byte값, ascii코드값
		//new String(배열)
		String str = new String(bytes);
		System.out.println(str);
	}
}
