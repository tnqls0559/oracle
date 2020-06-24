package propertiesPackage;

import java.util.Properties;

public class PropertiesMainExample2 {
	public static void main(String[] args) {
		Properties pro = new Properties();
		//setProperty(키,값)
		pro.setProperty("seoul", "28");
		pro.setProperty("beijing", "30");
		pro.setProperty("tokyo", "25");
		
		//서울의 현재 온도는 몇 도 입니까?
		// getProperty(키)하면 리턴값은 값
		String celcius = pro.getProperty("seoul");
		System.out.println("서울의 현재 온도는:"+celcius+"도 입니다.");
	}
}