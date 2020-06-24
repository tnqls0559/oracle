package ch15;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		String osName=System.getProperty("os.name");
		String useName=System.getProperty("user.name");
		String userHome=System.getProperty("user.home");
		
		System.out.println("운영체제:"+osName);
		System.out.println("사용자:"+useName);
		System.out.println("홈 디렉토리:"+userHome);
		
		//getProperties() 환경변수 값을 출력메소드
		//키(문자열)=값(문자열)
		Properties prop = System.getProperties();
		//키=값 -Set
		Set keys = prop.keySet();
		//향상된 for문
		for(Object objkey:keys) {
			String key = (String)objkey;
			String value = System.getProperty(key);
			System.out.println("["+key+"="+value+"]");
		}
	}
}
