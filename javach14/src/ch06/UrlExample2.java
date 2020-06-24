package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

public class UrlExample2 {

	public static void main(String[] args)  throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("소스를 보고싶은 url주소는?");
		String str = scanner.nextLine();
		//URL정보 객체 생성
		URL url = new URL(str);
		//해당 URK 연결
		URLConnection uc = url.openConnection();//url접속하기
		//입력스트림 얻기 getInputStream();
		java.io.InputStream is = uc.getInputStream();//입력스트림 객체 얻기
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String data = "";
		//읽어들인 정보 출력
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}
		is.close();
		isr.close();
		br.close();
	}
}
