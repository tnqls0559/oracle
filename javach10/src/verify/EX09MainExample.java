package verify;

public class EX09MainExample {

	public static void main(String[] args) {
		String str = "";
		for(int i=1;i<=100;i++) {
			str+=i;
			System.out.println(str);//1,12,123,1234,12345,...
		}
		//최종 생선된 String 객체의 갯수 100개
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=100;i++) {
				sb.append(i);
		}
		//최종 생성된 StringBuilder 객체의 갯수 1개
		System.out.println(sb.toString());
	}
}
