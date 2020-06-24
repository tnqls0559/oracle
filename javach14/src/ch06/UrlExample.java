package ch06;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UrlExample {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("URL을 입력하세요.");
		String str = scanner.nextLine();
		URL url = new URL(str);
		System.out.println("프로토콜:"+url.getProtocol());
		System.out.println("파일:"+url.getFile());
		System.out.println("포트:"+url.getPort());
		System.out.println("Host:"+url.getHost());
		System.out.println("Content:"+url.getContent());
	}
}
